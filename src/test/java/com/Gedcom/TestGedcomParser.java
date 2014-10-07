package test.java.com.Gedcom;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.java.com.Gedcom.api.GedcomInterface;
import main.java.com.Gedcom.impl.GedcomImpl;

import org.junit.Test;

public class TestGedcomParser {

	public static void executeConvert(String strInputFile, String strOutputFile)
			throws IOException {
		GedcomInterface gedcomToXml = new GedcomImpl();
		gedcomToXml.parseGedcomToXml(strInputFile, strOutputFile);
	}
	
	public boolean fileCompare(String strOutputFile, String strResultFile) throws IOException{
		BufferedReader output = new BufferedReader(new FileReader(strOutputFile));
		BufferedReader result = new BufferedReader(new FileReader(strResultFile));
		String strLine;
		try {
			while((strLine = output.readLine()) != null){
				if(!strLine.equals(result.readLine())){
					return false;
				}
			}
			if(result.readLine() != null) return false;
		} finally{
			output.close();
			result.close();
		}
	   return true;
	}
	//1. Input file not found
	@Test
	public void testInputFile() throws IOException{
		System.out.println("TestGedcomParser :: Running testInputFile()");
		String strInputFile = "";
		String strOutputFile = "src/resources/output/input_file_missing.xml";
		String strResultFile = "src/resources/output/file_missing_expected_output.xml";
		executeConvert(strInputFile, strOutputFile);
		assertTrue("Files should be same", 
				fileCompare(strOutputFile,strResultFile));
	}
	//2.Input file empty
	@Test
	public void testNullInput() throws IOException{
		System.out.println("TestGedcomParser :: Running testNullInput()");
		String strInputFile = "src/resources/input/no_input.txt";
		String strOutputFile = "src/resources/output/input_file_empty.xml";
		String strResultFile = "src/resources/output/empty_file_expected_output.xml";
		executeConvert(strInputFile, strOutputFile);
		assertTrue("Files should be same", 
				fileCompare(strOutputFile,strResultFile));
		
	}
	//3.junk data in input file
	@Test
	public void testJunkData() throws IOException{
		System.out.println("TestGedcomParser :: Running testJunkData()");
		String strInputFile = "src/resources/input/Junk_Input.txt";
		String strOutputFile = "src/resources/output/junk_output.xml";
		String strResultFile = "src/resources/output/junk_expected.xml";
		executeConvert(strInputFile, strOutputFile);
		assertTrue("Files should be same", 
				fileCompare(strOutputFile,strResultFile));
	}
	//4.Whitespace between tokens
	@Test
	public void testWhiteSpaces() throws IOException{
		System.out.println("TestGedcomParser :: Running testWhiteSpaces()");
		String strInputFile = "src/resources/input/whitespace_input.txt";
		String strOutputFile = "src/resources/output/whitespace_output.xml";
		String strResultFile = "src/resources/output/whitespace_expected.xml";
		executeConvert(strInputFile, strOutputFile);
		assertTrue("Files should be same", 
				fileCompare(strOutputFile,strResultFile));
	}
	//5.spaces between lines
	@Test
	public void testSpacesBetweenLines() throws IOException{
		System.out.println("TestGedcomParser :: Running testSpacesBetweenLines()");
		String strInputFile = "src/resources/input/spaces_between_lines_input.txt";
		String strOutputFile = "src/resources/output/spaces_between_lines_output.xml";
		String strResultFile = "src/resources/output/spaces_between_lines_expected.xml";
		executeConvert(strInputFile, strOutputFile);
		assertTrue("Files should be same", 
				fileCompare(strOutputFile,strResultFile));
	}
}
