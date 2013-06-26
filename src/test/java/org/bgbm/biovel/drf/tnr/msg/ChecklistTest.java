package org.bgbm.biovel.drf.tnr.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bgbm.biovel.drf.checklist.BaseChecklistClient.ChecklistInfo;
import org.bgbm.biovel.drf.checklist.DRFChecklistException;
import org.bgbm.biovel.drf.input.DRFCSVInputParser;
import org.bgbm.biovel.drf.utils.ChecklistUtils;
import org.bgbm.biovel.drf.utils.JSONUtils;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChecklistTest {
	
	@BeforeClass 
	public static void  setup() {
	}
	
	@Test
	public void generateChecklistInfoList() throws DRFChecklistException {
		String checklistInfoListJson = ChecklistUtils.generateChecklistInfoList();
		System.out.println("Json : " + checklistInfoListJson);
	}
	
	@Test
	public void generateChecklistInfoListFromStringArray() throws DRFChecklistException {
		List<String> ciList = new ArrayList<String>();
		ciList.add("species2000col;species2000col;Species2000 - Catalogue Of Life;http://www.catalogueoflife.org;http://www.catalogueoflife.org/col/info/copyright");
		ciList.add("edit;col;EDIT - Catalogue Of Life;http://wp5.e-taxonomy.eu/cdmlib/rest-api-name-catalogue.html;http://www.catalogueoflife.org/col/info/copyright");
		ciList.add("gbif;1028;Afromoths, online datbase of Afrotropical moth species (Lepidoptera);http://ecat-dev.gbif.org/checklist/1028;");
		
		List<ChecklistInfo> ciInfoList = ChecklistUtils.convertStringToChecklistInfo(ciList);
		Iterator<ChecklistInfo> ciInfoItr = ciInfoList.iterator();
		while(ciInfoItr.hasNext()) {
			System.out.println(JSONUtils.convertObjectToJson(ciInfoItr.next()));
		}
		
	}
	

}

