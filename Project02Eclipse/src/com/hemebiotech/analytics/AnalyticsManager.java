package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author JL. Protois
 *
 */
public class AnalyticsManager {

	/**
	 * 
	 * @param inputFilePath FIle with the list of symptoms
	 * @param outPutFilePath File to print the list of each symptoms with a counter
	 */
	public void process(String inputFilePath, String outPutFilePath) {

		List<String> symptomsFromFile;
		Map<String, Long> symptomsListwithcount;

		// lecture fichier
		symptomsFromFile = readFile(inputFilePath);

		// comptage
		symptomsListwithcount = countSymptoms(symptomsFromFile);

		// Sortie analyse
		printSympomsList(symptomsListwithcount, outPutFilePath);

		
	}

	/**
	 * 
	 * @param inputFilePath file 
	 * @return list of symptoms (string) 
	 */
	public List<String> readFile(String inputFilePath) {

		ISymptomReader symptoms = new SymptomDataFromFileReader(inputFilePath);
		return symptoms.getSymptoms();

	}

	/**
	 * 
	 * @param listOfSymptoms
	 * @return MAP, with the number of each symptoms 
	 */
	public Map<String, Long> countSymptoms(List<String> listOfSymptoms) {

		ISymptomsCounter listesCount = new SymptomCounter(listOfSymptoms);
		return listesCount.GetMap();

	}

	/**
	 * 
	 * @param symptomsListwithCount MAP of each symptoms with the counter
	 * @param outputFilePath the file where print the result
	 */
	public static void printSympomsList(Map<String, Long> symptomsListwithCount, String outputFilePath) {

		ISymptomsWriter writeSymptoms = new ListSymptomsWriter(symptomsListwithCount, outputFilePath);
		writeSymptoms.writeResult();
	}

}
