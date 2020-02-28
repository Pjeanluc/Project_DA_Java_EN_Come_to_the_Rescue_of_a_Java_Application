package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomsCount {
	
	/**
	 * @return a list of all Symptoms with counting for each symptoms
	 */
	
	    Map<String, Long> GetMap();

}
