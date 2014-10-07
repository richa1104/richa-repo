package main.java.com.Gedcom.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import main.java.com.Gedcom.api.GedcomRequest;

public abstract class Node {
	
	
	public Writer out;

	public Node() throws IOException
	{
		out = new BufferedWriter (new OutputStreamWriter(System.out));
	}

	public Node(String strFilename) throws IOException
	{
		if ( strFilename != null ) 
		{
			out = new BufferedWriter(new FileWriter(strFilename));
		}
	}
	
	public void header() throws IOException{
		out.write("<gedcom>\n");
		out.flush();
	}
	
	public void footer() throws IOException{
		out.write("</gedcom>");
		out.flush();
	}
	
	public void inputFileMissing() throws IOException{
		header();
		out.write("    <exception> Input file cannot be found! </exception> \n");
		footer();
		out.flush();
	}
	
	public void junkInput(String strFilename) throws IOException{
		out.close();
		out = new BufferedWriter(new FileWriter(strFilename));
		header();
		out.write("    <exception> File contains invalid data! </exception> \n");
		footer();
		out.flush();
	}
	
	public void indentation(GedcomRequest request) throws IOException
    {
            String separator = "     ";
            for ( int i = 0 ; i<=request.getIntLevel();i++ )
            {
                    out.write (separator);
            }
    }
	
	public void createNode(GedcomRequest request) throws IOException{
		if( request.getStrId() != null )
		{	
			out.write(" id=\""+request.getStrId()+"\"");
		}
		if( request.getStrValue() != null )
		{	
			out.write(" value=\""+request.getStrValue()+"\"");
		}
	}
	
	
	public abstract void parentNode(GedcomRequest request) throws IOException;
	
	public abstract void childNode(GedcomRequest request) throws IOException;
}

