package com.hemebiotech.analytics.counter;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * @author jl Protois
 *
 */
public class SymptomCounter implements ISymptomsCounter {

		  
	@Override
	
	 public Map<String, Long> getSymptomsCounter(List<String> symptomsList){
		
		Map<String, Long> myMap = new TreeMap<String, Long>();

        for (String s : symptomsList) {
            myMap.put(s, myMap.getOrDefault(s,0L) + 1);
        }
        return myMap;
		
	}
}
