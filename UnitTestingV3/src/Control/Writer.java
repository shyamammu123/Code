package Control;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Writer {

	File inputFile = null;
	DocumentBuilder builder = null;
	Document doc = null;
	
	String databaseFile = null;
	
	public Writer(String targetFile){
		this.databaseFile = targetFile;
	}
	
	public boolean writeBooleanArray(String tagElement, boolean cellCharging[]){
	//changes to true if the edit operation is successful
		if (cellCharging.length == 8 && cellCharging != null){
		try{
			NodeList nodesToEdit = getNodesToEdit(tagElement);  
			modifyXMLBoolean(nodesToEdit, cellCharging);		      
			saveData(doc);		           
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		}
		else{
			return false;
		}
	}
	
	public boolean modifyXMLBoolean(NodeList nodesToEdit, boolean[] cellCharging){
		int arrayPositionCounter = 0;
		
	      //the way this xml library treats nodes is kind of funny. I only want
	      //the array counter to increment when we have nodes of type ELEMENT_NODE
	      //which is why i declared this extra counter. the loop counter is only
	      //used to identify the correct node in the xml to edit
	      for(int loopCounter = 0; loopCounter < nodesToEdit.getLength(); loopCounter ++){
	    	  
	          Node node = nodesToEdit.item(loopCounter);
	          if (node.getNodeType() == Node.ELEMENT_NODE) {
	        	if (cellCharging[arrayPositionCounter] == true){
	        		node.getFirstChild().setTextContent("true");  
	        	}
	        	else if (cellCharging[arrayPositionCounter] == false){
	        		node.getFirstChild().setTextContent("false");  
	        	}
	        	//still in the outer if -> only increment if the node is of type
	        	// ELEMENT_NODE
	        	arrayPositionCounter ++;
	         }//if
	      }//for
		return true;
	}
	
	
	public NodeList getNodesToEdit(String tagElement){
		NodeList nodesToEdit = null;
		try{
		  builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	      inputFile = new File(databaseFile);
	      doc = builder.parse(inputFile);
	      //get the higher level node which contains the items you wish to edit
	      // eg cellCharging or supplyPower
	      Node parentNode = doc.getElementsByTagName(tagElement).item(0);
	 
	      //get a list of the nodes contained within - we will edit these directly
	      nodesToEdit = parentNode.getChildNodes();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return nodesToEdit;
	}//getNodesToEdit
	
	public boolean saveData(Document docToSave){
		try{
		  Transformer transformer = TransformerFactory.newInstance().newTransformer();
	      DOMSource source = new DOMSource(docToSave);
	      StreamResult consoleResult = new StreamResult(databaseFile);
	      transformer.transform(source, consoleResult);
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
}
