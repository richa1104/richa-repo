package main.java.com.Gedcom.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import main.java.com.Gedcom.api.GedcomInterface;
import main.java.com.Gedcom.api.GedcomRequest;

public class GedcomImpl implements GedcomInterface {

	private BufferedReader input;
	private XMLWriter xmlWriter;
	private Stack<GedcomRequest> tagStack = new Stack<GedcomRequest>();
	private Stack<GedcomRequest> requestStack = new Stack<GedcomRequest>();
	private final int ROOT_NODE = 0;

	public BufferedReader getInput() {
		return input;
	}

	public void setInput(BufferedReader input) {
		this.input = input;
	}

    public boolean validateInput(GedcomRequest request, String outputFileName) throws IOException{
    	try {
			request.getIntLevel();
		} catch (NumberFormatException e) {
			xmlWriter.junkInput(outputFileName);
			return false;
		}
    	return true;
    }
	@Override
	public void parseGedcomToXml(String inputFileName, String outputFileName)
			throws IOException {
		String strLine = null;
		GedcomRequest request = null;
		boolean done = false;
		boolean validation = false;

		try {
			xmlWriter = new XMLWriter(outputFileName);
			System.out.println(outputFileName);
			input = new BufferedReader(new FileReader(inputFileName));
		} catch (Exception e) {
			xmlWriter.inputFileMissing();
			return;
		}
		xmlWriter.header();
		while (true) {
			strLine = input.readLine();

			if (strLine != null && strLine.trim().compareTo("") == 0) {
				continue;
			}
			if (strLine != null) {
				request = convertTextToGedcomRequest(strLine);
				validation = validateInput(request, outputFileName);
				if(!validation) return;
			} else {
				request = null;
			}
			done = xmlParser(request, outputFileName);
			if (done) {
				xmlWriter.footer();
				break;
			}
		}
	}

	public GedcomRequest convertTextToGedcomRequest(String inputLine) {

		return new GedcomRequest(inputLine);

	}
	
	public boolean xmlParser(GedcomRequest request, String outputFileName)
			throws IOException {
		GedcomRequest curentRequest = null;
		GedcomRequest nextRequest = request;
		if (!requestStack.isEmpty())
			curentRequest = requestStack.pop();
		if (curentRequest == null && nextRequest == null)
			return true;
		if (!tagStack.isEmpty() && !(curentRequest == null)
				&& tagStack.peek().getIntLevel() == curentRequest.getIntLevel()) {
			xmlWriter.endNode(tagStack.pop());
		}
		if (hasChildren(nextRequest, curentRequest)) {
			xmlWriter.parentNode(curentRequest);
			tagStack.push(curentRequest);
		} else {
			if (curentRequest != null)
				xmlWriter.childNode(curentRequest);
		}
		requestStack.push(request);
		if ((nextRequest == null)
				|| (!(nextRequest == null) && nextRequest.getIntLevel() == ROOT_NODE)) {
			while (!tagStack.isEmpty())
				xmlWriter.endNode(tagStack.pop());
		}
		return false;
	}

	public boolean hasChildren(GedcomRequest next, GedcomRequest cur) {
		if (cur != null && next != null
				&& (next.getIntLevel() > cur.getIntLevel()))
			return true;
		else
			return false;
	}

}
