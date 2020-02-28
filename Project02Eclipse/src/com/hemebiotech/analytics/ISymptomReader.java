package com.hemebiotech.analytics;

import java.util.List;

/**
 *  @author Caroline HEDOT
 */


public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @author Caroline HEDOT
	 *  
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	
	List<String> GetSymptoms ();
}
