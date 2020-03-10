package com.hemebiotech.analytics;

/**
 * 
 * @author jl Protois
 *
 */
public class AnalyticsCounter {
	
			
	public static void main(String args[]) throws Exception {
		
		System.out.println(args[0]);
			
		//Read entry file
		ISymptomReader symptoms = new SymptomDataFromFileReader(args[0]);
		
		//Count symptoms
		ISymptomsCounter listesCount = new SymptomCounter(symptoms.getSymptoms());
		
		//Write the list of symptoms with count
		ISymptomsWriter writeSymptoms = new ListSymptomsPrinter(listesCount.GetMap(), args[1]);
		writeSymptoms.writeResult ();
		
	}
		
}
