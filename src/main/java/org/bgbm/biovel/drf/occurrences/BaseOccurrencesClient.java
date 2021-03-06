package org.bgbm.biovel.drf.occurrences;

import java.util.List;

import org.apache.http.HttpHost;
import org.bgbm.biovel.drf.checklist.DRFChecklistException;
import org.bgbm.biovel.drf.rest.TaxoRESTClient;
import org.bgbm.biovel.drf.utils.BiovelUtils;

public abstract class BaseOccurrencesClient extends TaxoRESTClient {

	
	private int maxOccurrences = Integer.MAX_VALUE;
	
	public int getMaxOccurrences() {
		return maxOccurrences;
	}

	public void setMaxOccurrences(int maxOccurrences) {
		this.maxOccurrences = maxOccurrences;
	}

	public String queryOccurrenceBank(List<String> nameids ) throws DRFChecklistException {
		StringBuilder sb = new StringBuilder();
		//String header = BiovelUtils.getResourceAsString("/org/bgbm/biovel/drf/occret/occ_csvHeader.txt","UTF-8");
		//sb.append(header);
		
		for(String nameid : nameids) {
			sb.append(getOccurrences(nameid));
		}
		
		return sb.toString();
	}
	
	public String queryOccurrenceBank(String nameid) throws DRFChecklistException {
		StringBuilder sb = new StringBuilder();
		//String header = BiovelUtils.getResourceAsString("/org/bgbm/biovel/drf/occret/occ_csvHeader.txt","UTF-8");
		//sb.append(header);	
		
		sb.append(getOccurrences(nameid.trim()));
		
		return sb.toString();
	}
	
	public abstract String getOccurrences(String nameid) throws DRFChecklistException;
	

	
	public static String getOccCSVHeader() {
		return BiovelUtils.getResourceAsString("/org/bgbm/biovel/drf/occret/occ_csvHeader.txt","UTF-8");
	}

}
