package Control;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Reader
{

	public static String parseHolder [] = null;
	File inputFile = null;
	DocumentBuilder builder = null;
	Document doc = null;
	NodeList nameNodeList;
	
	public float[] readVoltage(){
		parse("vcell");//the parser is called, pass the relevant xml tag in
		float voltage[] = new float[8];
		for(int i = 0; i < voltage.length; i++){
			voltage[i] = Float.parseFloat(parseHolder[i]);
		}
		return voltage;
	}
		
	public float[] readCurrent(){
		parse("ccell");
		float current[] = new float[8];
		for(int i = 0; i < current.length; i++){
			current[i] = Float.parseFloat(parseHolder[i]);
		}
		return current;
	}
	
	public float[] readTemperature(){
		parse("tcell");
		float temperature[] = new float[8];
		for(int i = 0; i < temperature.length; i++){
			temperature[i] = Float.parseFloat(parseHolder[i]);
		}
		return temperature;
	}
	
	public float[] readLoad(){
		parse("cLoadCell");
		float load[] = new float[8];
		for(int i = 0; i < load.length; i++){
			load[i] = Float.parseFloat(parseHolder[i]);
		}
		return load;
	}
	
	public int[] readSOCLevel(){
		parse("chlCell");
		int SOCLevel[] = new int[8];
		for(int i = 0; i < SOCLevel.length; i++){
			SOCLevel[i] = Integer.parseInt(parseHolder[i]);
		}
		return SOCLevel;
	}
	
	public float[] readSOHLevel(){
		parse("SOH_Val");
		float SOHLevel[] = new float[8];
		for(int i = 0; i < SOHLevel.length; i++){
			SOHLevel[i] = Float.parseFloat(parseHolder[i]);
		}
		return SOHLevel;
	}
	
	public boolean readIsolateBattery(){
		parse("isolateBattery");
		boolean isolateBattery = Boolean.parseBoolean(parseHolder[0]);
		return isolateBattery;
	}
	
	public String[] parse(String tagElement)//This function reads data from the xml resource
	{
	    try
	    {
	        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        inputFile = new File("src/database.xml");
	        doc = builder.parse(inputFile);
	        nameNodeList = doc.getElementsByTagName(tagElement);
	        parseHolder = new String[nameNodeList.getLength()];
	        
	        for(int i = 0; i < parseHolder.length; i++)//Cycle through child elements
	        {
	        	parseHolder[i] = (
                nameNodeList.item(i).getFirstChild().getNodeValue());
	        }
	    }
	    catch(Exception e){}
		return parseHolder;
	}
}