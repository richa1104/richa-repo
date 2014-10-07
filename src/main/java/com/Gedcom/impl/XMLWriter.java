package main.java.com.Gedcom.impl;

import java.io.IOException;

import main.java.com.Gedcom.api.GedcomRequest;

public class XMLWriter extends Node
{
	public XMLWriter() throws IOException {
		super();
	}

	public XMLWriter(String outputFileName) throws IOException {
		super(outputFileName);
	}

	@Override
	public void parentNode(GedcomRequest request) throws IOException
	{
		indentation(request);
		out.write("<"+request.getStrTag());
		createNode(request);
		out.write(">\n");
	}
    
	@Override
	public void childNode(GedcomRequest request) throws IOException
	{
		indentation(request);
		out.write("<"+request.getStrTag());
		createNode(request);
		out.write(">");
		out.write("</"+request.getStrTag()+">\n");
		out.flush();
	}
	
	public void endNode(GedcomRequest request) throws IOException
	{
		indentation(request);
		out.write("</"+request.getStrTag()+">\n");
		out.flush();
	}
  
}
