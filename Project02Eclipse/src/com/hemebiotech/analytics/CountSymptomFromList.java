package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * @author jl Protois
 *
 */
public class CountSymptomFromList implements ISymptomsCount {

	private List<String> symptomsList;

	/**
	 * 
	 * @param symptomsList List of symptoms
	 */
	
	public CountSymptomFromList (List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}
	  
	@Override
	
	 public Map<String, Long> GetMap(){
		
		Map<String, Long> myMap = new TreeMap<String, Long>();

        for (String s : symptomsList) {
            myMap.put(s, myMap.getOrDefault(s,0L) + 1);
        }
        return myMap;
		
	}
}
