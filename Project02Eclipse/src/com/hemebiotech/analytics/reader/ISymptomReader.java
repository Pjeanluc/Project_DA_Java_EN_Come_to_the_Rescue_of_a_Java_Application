package com.hemebiotech.analytics.reader;

import java.util.List;
import io.vavr.control.Either;

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
	
	Either<Boolean, List<String>> getSymptoms (String filepath);
}
