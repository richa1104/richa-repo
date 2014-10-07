package main.java.com.Gedcom.api;


public class GedcomRequest { 
	
	protected String strId;
	protected String strTag;
	protected String strValue;
	protected String strLevel;
	protected String strLine;

	public GedcomRequest(String str)
	{
		strLine = strId = strTag = strValue = null;
		if (str != null )
		{
			strLine = str ;
			init();
		}
	}
	
	protected void init()
	{
		String[] data = strLine.split("\\s+", 3);

		strLevel = data[0];
		if(data[1].startsWith("@") && data[1].endsWith("@"))
		{
			strId = data[1];
			strTag = data[2].toLowerCase();
		}
		else if(data.length == 3)
		{
			strTag = data[1].toLowerCase();
			strValue = data[2];
		}
		else
		{
			strTag = data[1].toLowerCase();
		}
	}
	
	public String getStrId()
	{
		return strId;
	}

	public String getStrLevel()
	{
		return strLevel;
	}

	public int getIntLevel()
	{
		return Integer.parseInt(strLevel);
	}

	public String getStrTag()
	{
		return strTag;
	}

	public String getStrValue()
	{
		return strValue;
	}

}
