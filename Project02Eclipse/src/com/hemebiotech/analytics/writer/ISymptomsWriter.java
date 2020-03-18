package com.hemebiotech.analytics.writer;

import java.util.Map;

/**
 * interface to print the result of the count of symptoms 
 * 
 * @author JL Protois
 */
public interface ISymptomsWriter {
	
	Boolean writeResult (Map<String, Long> listCountingSymptoms, String filePath);
}
