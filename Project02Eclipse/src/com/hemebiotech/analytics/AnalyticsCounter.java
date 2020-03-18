package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.counter.ISymptomsCounter;
import com.hemebiotech.analytics.counter.SymptomCounter;
import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.SymptomDataFromFileReader;
import com.hemebiotech.analytics.writer.ISymptomsWriter;
import com.hemebiotech.analytics.writer.ListSymptomsWriter;

/**
 * 
 * @author JL. Protois
 *
 */
public class AnalyticsCounter {

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

		ISymptomReader symptoms = new SymptomDataFromFileReader();
		return symptoms.getSymptoms(inputFilePath);

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
	 * @param outputFilePath the file where print the result
	 */
	public void printSympomsList(Map<String, Long> symptomsListwithCount, String outputFilePath) {

		ISymptomsWriter writeSymptoms = new ListSymptomsWriter();
		writeSymptoms.writeResult(symptomsListwithCount, outputFilePath);
	}

}
