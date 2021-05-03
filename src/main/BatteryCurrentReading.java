package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BatteryCurrentReading {
	HashMap<String,Integer> currentValues = new HashMap<String,Integer>();
	
	

	public HashMap<String, Integer> checkCurrentRangeAndReadings(List<Integer> readings) {
		if(readings == null || readings.contains(null) || readings.isEmpty() || readings.size() == 1) {
			return null;
		}
		
		Collections.sort(readings);
		int count = 1;
		int	minRange = readings.get(0),maxRange = readings.get(0);
		
		 for (int i = 1; i < readings.size(); ++i) {
		      if ((readings.get(i) - readings.get(i-1)) < 2) {		        
		        ++count;
		      }
		      
		      else {		   
		    	currentValues.put(minRange+ "-"+maxRange, count);
		    	minRange = maxRange = readings.get(i);
		        count = 1;  
        
		      }
		      maxRange = readings.get(i);
		    }
	    	currentValues.put(minRange+ "-"+maxRange, count);
		return currentValues;
	}
	

}
