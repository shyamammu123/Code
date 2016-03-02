package Control;

public class SupplyPower {

	Reader SupplyPowerReader = new Reader();
	
	public boolean writeChargeCell(){
		//writes boolean array to storage
		boolean[] result = new boolean[100];
		return true;
	}
	
	public boolean writeIsolateBattery(){
		boolean result = true;
		return result;
	}
	
	public boolean[] writeLowSOCWarning()
	{
		int[] LowSOCArray = new int [8];
		LowSOCArray = SupplyPowerReader.readSOCLevel();
		boolean[] LowSOCWarning = new boolean[8];
		
		for(int i = 0; i < LowSOCArray.length; i++)
		{
			if(LowSOCArray[i] > 40)
			{
				LowSOCWarning[i] = false;
			}
			else if(LowSOCArray[i] <= 40)
			{
				LowSOCWarning[i] = true;
			}
		}
		return LowSOCWarning;
	}
	
	public boolean valueCompare(float val1, float val2){
		if (val1 > val2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean valueCompare(int val1, int val2){
		if (val1 > val2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean writeSafeSupplyRange(){
		//writes boolean array to storage
		boolean[] result = new boolean[100];
		return true;
	}
	
}
