package com.hemebiotech.analytics.fileFactory.reader;

import java.io.IOException;
import java.util.List;

/**
 *  @author Caroline HEDOT
 */


public interface ISymptomReaderGeneric {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @author Caroline HEDOT
	 *  
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 * @throws IOException
	 */
		
	List<String> getSymptoms (String filepath) throws IOException;
}
