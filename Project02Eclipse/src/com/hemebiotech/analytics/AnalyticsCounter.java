package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hemebiotech.analytics.counter.ISymptomsCounter;
import com.hemebiotech.analytics.counter.SymptomCounter;
import com.hemebiotech.analytics.exceptions.PersonalExceptions;
import com.hemebiotech.analytics.fileFactory.FileFactory;
import com.hemebiotech.analytics.fileFactory.reader.ISymptomReaderGeneric;
import com.hemebiotech.analytics.fileFactory.writer.ISymptomsWriterGeneric;
import io.vavr.control.Either;;

/**
 * 
 * @author JL. Protois
 *
 */
public class AnalyticsCounter {

	 private static final Logger logger = LogManager.getLogger("Analytics counter");
	/**
	 * 
	 * @param inputFilePath  FIle with the list of symptoms
	 * @param outPutFilePath File to print the list of each symptoms with a counter
	 */
	public void process(String inputFilePath, String outPutFilePath) {

		Either<Boolean, List<String>> symptomsFromFile;
		Map<String, Long> symptomsListwithcount;

		boolean result = false;

		// lecture fichier
		symptomsFromFile = readFile(inputFilePath);

		if (symptomsFromFile.isRight()) {

			// comptage
			symptomsListwithcount = countSymptoms(symptomsFromFile.get());

			// Sortie analyse
			result = printSympomsList(symptomsListwithcount, outPutFilePath);

			if (result) {
				logger.info("Correct treatment for file ");
			} else {

				logger.error("Error of treatment for File ");
			}

		} else {
			logger.error("problem with the file ");
			result = true;

		}

	}

	/**
	 * 
	 * @param inputFilePath file
	 * @return list of symptoms (string)
	 */
	public Either<Boolean, List<String>> readFile(String inputFilePath) {

		List<String> result = new ArrayList<String>();

		// get all symptoms in the input file
		FileFactory myFileFactory = new FileFactory();

		try {
			ISymptomReaderGeneric readerFile = myFileFactory.getReader(inputFilePath);

			if (readerFile != null) {

				try {
					result = readerFile.getSymptoms(inputFilePath);

				} catch (IOException e) {
					return Either.left(false);
				}
			}

		} catch (PersonalExceptions e) {
			return Either.left(false);
		}

		return Either.right(result);
	}

	/**
	 * 
	 * @param listOfSymptoms
	 * @return MAP, with the number of each symptoms
	 */
	public Map<String, Long> countSymptoms(List<String> listOfSymptoms) {

		ISymptomsCounter listesCount = new SymptomCounter();
		return listesCount.getSymptomsCounter(listOfSymptoms);

	}

	/**
	 * 
	 * @param symptomsListwithCount MAP of each symptoms with the counter
	 * @param outputFilePath        the file where print the result
	 */
	public Boolean printSympomsList(Map<String, Long> symptomsListwithCount, String outputFilePath) {

		FileFactory myFileFactory = new FileFactory();
		
		ISymptomsWriterGeneric writeSymptoms = myFileFactory.getWriter(outputFilePath);
		
		return writeSymptoms.writeResult(symptomsListwithCount, outputFilePath);
	
	}
}
