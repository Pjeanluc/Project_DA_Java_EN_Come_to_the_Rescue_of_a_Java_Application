package com.hemebiotech.analytics.counter;

import java.util.List;
import java.util.Map;

public interface ISymptomsCounter {
	
	/**
	 * @return a list of all Symptoms with counting for each symptoms
	 */
	
	    Map<String, Long> getSymptomsCounter(List<String> symptomsList);

}
