package Control;

public class ChargeBattery {
	
	float minTemp = -20.0f;
	float maxTemp = 55.0f;
	
	float minCurrent = 20.0f;
	float maxCurrent = 100.0f;
	
	float minVoltage = 1.5f;
	float maxVoltage = 4.2f;
	
	Writer writerObject = new Writer("src/database.xml");
	
	public void shuntCharge(){
		//not sure what this should output etc
	}
	public void trickleCharging(){
		//not sure what this should output etc
	}
	
	public boolean writeChargeCell(boolean cellCharging[], String tagElement){
		boolean result = writerObject.writeBooleanArray(tagElement, cellCharging);
		return result;
	}//writechargecell
		
	public boolean valueCompare(String type, float actual){
		float max = 0;
		float min = 0;
		if (type.equals("voltage")){
			max = maxVoltage;
			min = minVoltage;
		}
		else if(type.equals("current")){
				min = minCurrent;
				max = maxCurrent;
			}
		else if(type.equals("temperature")){
			min = minTemp;
			max = maxTemp;
		}
		
		if (max > actual && actual > min){
			return true;
		}
		else{
			return false;
		}
	}
}