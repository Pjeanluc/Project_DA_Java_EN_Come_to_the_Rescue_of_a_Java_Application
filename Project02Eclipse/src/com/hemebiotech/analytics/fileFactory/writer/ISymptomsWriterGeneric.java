package com.hemebiotech.analytics.fileFactory.writer;

import java.util.Map;

/**
 * interface to print the result of the count of symptoms 
 * 
 * @author JL Protois
 */
public interface ISymptomsWriterGeneric {
	
	/**
	 * 
	 * @param listCountingSymptoms
	 * @param filePath
	 * @return Boolean (true if ok)
	 */
	Boolean writeResult (Map<String, Long> listCountingSymptoms, String filePath);
}
