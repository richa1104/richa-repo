package main.java.com.Gedcom.api;

import java.io.IOException;

public interface GedcomInterface {
	
	public void parseGedcomToXml(String inputFileName, String outputFileName) throws IOException;

}
