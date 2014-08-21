package org.bgbm.biovel.drf.occurrences;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.http.HttpHost;
import org.bgbm.biovel.drf.checklist.DRFChecklistException;
import org.bgbm.biovel.drf.utils.CSVUtils;
import org.bgbm.biovel.drf.utils.JSONUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BgbmEditOccurrencesClient extends BaseOccurrencesClient {
	private static final Logger logger = Logger.getLogger(BgbmEditOccurrencesClient.class.getName()); 

	public static final String ID = "edit";
	public static final String LABEL = "EDIT Platform";
	public static final String URL = "http://wp5.e-taxonomy.eu/cdmlib/rest-api-name-catalogue.html";
	public static final String DATA_AGR_URL = "";	
	private static final String MAX_PAGING_LIMIT = "50";
	private static final String VERSION = "v0.1";
	private static final ServiceProviderInfo CINFO = new ServiceProviderInfo(ID,LABEL,URL,DATA_AGR_URL,VERSION,false);

	private final Map<String, JSONObject> datasetCacheMap = new HashMap<String, JSONObject>();
	private final Map<String, JSONObject> orgCacheMap = new HashMap<String, JSONObject>();
	public final static Set<String> taxonIdSet = new HashSet<String>();

	@Override
	public HttpHost getHost() {
		return new HttpHost("dev.e-taxonomy.eu",80);

	}

	@Override
	public int getMaxPageSize() {		
		return 0;
	}


	@Override
	public ServiceProviderInfo buildServiceProviderInfo() {
		ServiceProviderInfo checklistInfo = new ServiceProviderInfo(ID,LABEL,URL,DATA_AGR_URL);
		checklistInfo.addSubChecklist(new ServiceProviderInfo("chenopodiumPilot",
				"Chenopodium (Pilot)",
				"http://wp5.e-taxonomy.eu/cdmlib/rest-api-name-catalogue.html",
				""));

		setChecklistInfo(checklistInfo);
		return checklistInfo;
	}


	public Set<String> getTaxonUuids(String name, ServiceProviderInfo spInfo) throws DRFChecklistException {
		Set<String> taxonUuids = new HashSet<String>();
		URI namesUri = buildUriFromQueryString(name,
				"/cdmserver/" +				
						spInfo.getId() + "/name_catalogue.json",									
						"query",
						null);

		String response = processRESTService(namesUri);
		JSONArray taxa = (JSONArray) JSONUtils.parseJsonToArray(response);
		Iterator<JSONObject> taxaIterator = taxa.iterator();
		while(taxaIterator.hasNext()) {
			JSONObject taxon = taxaIterator.next();	
			JSONArray taxonResponses = (JSONArray)taxon.get("response");
			if(taxonResponses != null) {
				Iterator<JSONObject> trIterator = taxonResponses.iterator();
				while(trIterator.hasNext()) {
					JSONObject taxonResponse = (JSONObject)trIterator.next();
					JSONArray acceptedTaxonUuids = (JSONArray)taxonResponse.get("acceptedTaxonUuids");
					Iterator<String> atIterator = acceptedTaxonUuids.iterator();
					while(atIterator.hasNext()) {
						String acceptedTaxonUuid = atIterator.next();
						if(acceptedTaxonUuid != null && !acceptedTaxonUuid.isEmpty()) {
							taxonUuids.add(acceptedTaxonUuid);
							logger.warning("adding uuid : " + acceptedTaxonUuid);
							taxonUuids.add(acceptedTaxonUuid);
						}
					}
				}
			}
		}
		return taxonUuids;
	}

	@Override
	public String getOccurrences(String name) throws DRFChecklistException {
		StringBuilder occurrences = new StringBuilder();
		Iterator<ServiceProviderInfo> sps = getServiceProviderInfo().getSubChecklists().iterator();
		for(ServiceProviderInfo spInfo : getServiceProviderInfo().getSubChecklists()) {
			//if(spInfo.getUse()) {
			addToOccurrences(name, spInfo, occurrences);
			//}
		}
		return occurrences.toString();
	}


	public void addToOccurrences(String name, ServiceProviderInfo spInfo, StringBuilder occurrences) throws DRFChecklistException {

		Iterator<ServiceProviderInfo> sps = getServiceProviderInfo().getSubChecklists().iterator();
		if (spInfo == null) {
			return ;
		}
		Set<String> taxonUuids = getTaxonUuids(name, spInfo);
		for(String taxonUuid : taxonUuids) {
			if(!taxonIdSet.contains(taxonUuid)) {
				taxonIdSet.add(taxonUuid);
				//http://api.gbif.org/v0.9/occurrence/search?offset=100&limit=100&taxonKey=2818622
				Map<String, String> paramMap = new HashMap<String, String>();			
				paramMap.put("pageSize", MAX_PAGING_LIMIT);		

				int pageNumber = 0;
				long lastRecord = 0;
				long count = 0;
				do {					
					paramMap.put("pageNumber", String.valueOf(pageNumber));		
					URI occurrencesUri = buildUriFromQueryString(taxonUuid,
							"/cdmserver/" + 							
									spInfo.getId() + "/occurrence_catalogue.json",									
									"taxonUuid",
									paramMap);
					String occResponse = processRESTService(occurrencesUri);


					JSONObject jsonOccResponse = (JSONObject) JSONUtils.parseJsonToObject(occResponse);


					JSONArray results = (JSONArray) jsonOccResponse.get("records");		

					if(results != null) {				
						logger.info("actual results size : " + results.size());
						count = (Long) jsonOccResponse.get("count");
						Iterator<JSONObject> resIterator = results.iterator();

						while (resIterator.hasNext()) {
							JSONObject jsonOccurence = resIterator.next();					
							occurrences.append(",");

							occurrences.append(",");


							occurrences.append(",");


							occurrences.append(",");


							occurrences.append(",");

							if(jsonOccurence.get("acceptedTaxon") != null) {
								occurrences.append(CSVUtils.wrapWhenComma((String) jsonOccurence.get("acceptedTaxon")));
							} 
							occurrences.append(",");

							occurrences.append(",");

							if(jsonOccurence.get("acceptedTaxon") != null) {
								occurrences.append(CSVUtils.wrapWhenComma((String) jsonOccurence.get("acceptedTaxon"))); 
							} 
							occurrences.append(",");

							if(jsonOccurence.get("acceptedTaxonUuid") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("acceptedTaxonUuid")))); 
							} 
							occurrences.append(",");

							JSONObject jsonLocation = (JSONObject) jsonOccurence.get("location");

							if(jsonLocation != null && jsonLocation.get("decimalLatitude") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonLocation.get("decimalLatitude")))); 
							} 
							occurrences.append(",");

							if(jsonLocation != null && jsonLocation.get("decimalLongitude") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonLocation.get("decimalLongitude")))); 
							} 
							occurrences.append(",");


							if(jsonOccurence.get("startGatheringDate") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("startGatheringDate")))); 	
							}
							occurrences.append(",");


							if(jsonOccurence.get("endGatheringDate") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("endGatheringDate")))); 	
							}
							occurrences.append(",");


							if(jsonLocation != null && jsonLocation.get("errorRadius") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(Long.toString((Long) jsonLocation.get("errorRadius"))));
							} 
							occurrences.append(",");

							if(jsonLocation != null && jsonLocation.get("country") != null) {
								occurrences.append(CSVUtils.wrapWhenComma((String) jsonLocation.get("country")));
							} 
							occurrences.append(",");

							if(jsonOccurence.get("collector") != null) {
								occurrences.append(CSVUtils.wrapWhenComma((String) jsonOccurence.get("collector"))); 
							} 
							occurrences.append(",");

							occurrences.append(",");

							if(jsonLocation != null && jsonLocation.get("locality") != null) {
								occurrences.append(CSVUtils.wrapWhenComma((String) jsonLocation.get("locality"))); 
							} 
							occurrences.append(",");

							if(jsonOccurence.get("maxDepth") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("maxDepth")))); 
							} 
							occurrences.append(",");

							if(jsonOccurence.get("maxElevation") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("maxElevation")))); 
							} 
							occurrences.append(",");

							if(jsonOccurence.get("depth") != null) {
								String depth = CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("depth")));
								occurrences.append(depth); 
								logger.info("depth : " + depth);
							} 
							occurrences.append(",");

							if(jsonOccurence.get("elevation") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("elevation"))));  
							} 


							occurrences.append(",");

							if(jsonOccurence.get("institution") != null) {
								occurrences.append(CSVUtils.wrapWhenComma(String.valueOf(jsonOccurence.get("institution"))));
							}
							occurrences.append(",");

							occurrences.append(",");

							occurrences.append(",");

							occurrences.append(",");

							occurrences.append(System.getProperty("line.separator"));
						}

						lastRecord = (Long) jsonOccResponse.get("lastRecord");

						logger.info("usageKey : " + taxonUuid + 
								", count : " + String.valueOf(jsonOccResponse.get("count")) + 
								", pageNumber : " + pageNumber + ",  + occ count : " + count);
						pageNumber++;
						
					}
				} while((lastRecord < count) && (lastRecord < getMaxOccurrences()));					
			}
		}



	}




}
