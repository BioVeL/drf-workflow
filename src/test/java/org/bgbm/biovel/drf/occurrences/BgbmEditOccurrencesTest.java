package org.bgbm.biovel.drf.occurrences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bgbm.biovel.drf.checklist.DRFChecklistException;
import org.bgbm.biovel.drf.checklist.GBIFBackboneClient;
import org.bgbm.biovel.drf.input.DRFCSVInputParser;
import org.bgbm.biovel.drf.input.DRFInputException;
import org.bgbm.biovel.drf.occurrences.GBIFOccurrencesClient;
import org.bgbm.biovel.drf.rest.TaxoRESTClient.ServiceProviderInfo;
import org.bgbm.biovel.drf.tnr.msg.TnrMsg;
import org.bgbm.biovel.drf.utils.BiovelUtils;
import org.bgbm.biovel.drf.utils.JSONUtils;
import org.bgbm.biovel.drf.utils.TnrMsgException;
import org.bgbm.biovel.drf.utils.TnrMsgUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BgbmEditOccurrencesTest {
	private static DRFCSVInputParser parser;
	private static List<String> nameCompleteList;
	
	private static ServiceProviderInfo spi;
	
	@BeforeClass 
	public static void  setup() {				
		nameCompleteList = new ArrayList<String>();
		nameCompleteList.add("Chenopodium album");
		nameCompleteList.add("Chenopodium ambrosioides");
		nameCompleteList.add("Chenopodium vulvaria");
		
		
		spi = new ServiceProviderInfo(BgbmEditOccurrencesClient.ID,
				BgbmEditOccurrencesClient.LABEL,
				BgbmEditOccurrencesClient.URL,
				BgbmEditOccurrencesClient.DATA_AGR_URL);
		ServiceProviderInfo cpInfo = new ServiceProviderInfo("chenopodiumPilot",
				"Chenopodium (Pilot)",
				"http://wp5.e-taxonomy.eu/cdmlib/rest-api-name-catalogue.html",
				"",
				true);
		
		spi.addSubChecklist(cpInfo);		
			
	}
	
	@Test
	public void convertChecklistInfoToJson() throws DRFChecklistException {
		String checklistInfoJson = JSONUtils.convertObjectToJson(spi);
		System.out.println("Json : " + checklistInfoJson);
	}
	
	@Test
	public void occCSVHeader() throws DRFChecklistException {
		String csvHeader = BaseOccurrencesClient.getOccCSVHeader();
		System.out.println("header : " + csvHeader);
	}
	
	@Test
	public void getOccurrencesTest() throws DRFChecklistException, IOException {
		
		BgbmEditOccurrencesClient goc = new BgbmEditOccurrencesClient();

		goc.setChecklistInfo(spi);
				
		for(String name:nameCompleteList) {
			goc.getOccurrences(name);
		}


		System.out.println("Done");
		
	}
}
