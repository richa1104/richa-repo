package main.java.com.Gedcom.impl;

import java.util.*;

public class Executor {  
        public List<String> getResource(){
		   List<String> list = new ArrayList<String>();
		   String str1 = getClass().getResource("/resources/input/GEDCOM_Parser_Challenge_sample_data.txt").toString().replaceAll("%20"," ").replace("file:","");
		   list.add(0,str1);
		   String str2 = getClass().getResource("/resources/output/GEDCOM_Parser_Challenge_Output.xml").toString().replaceAll("%20"," ").replace("file:","");
		   list.add(1,str2);
		   return list;
		}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Executor executor = new Executor();
		System.out.println("###############GEDCOM XML CONVERTOR###############");
		List<String> list = executor.getResource();
		long startTime = System.currentTimeMillis();
		String strInputFile = list.get(0);
		String strOutputFile = list.get(1);
		GedcomImpl g2x = new GedcomImpl();
		try{
			g2x.parseGedcomToXml(strInputFile, strOutputFile);
			System.out.println("################GEDCOM SUCCESSFUULY CONVERTED TO XML###############");
		    System.out.println("##Output file path## :: " +strOutputFile);
		}catch(Exception e){
			System.out.println("Exception caught");
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime -startTime;
		System.out.println("Executing completed. Time taken = "+executionTime+" ms");

	}

}
