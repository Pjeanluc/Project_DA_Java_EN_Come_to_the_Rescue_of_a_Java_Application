package com.hemebiotech.analytics;

/**
 * 
 * @author jl Protois
 *
 */
public class AnalyticsManager {
	
			
	public static void main(String args[]) throws Exception {
		
		// preparation gestionnaire d analyse de fichiers
		AnalyticsCounter analyticsManager = new AnalyticsCounter() ;
		analyticsManager.process(args[0], args[1]);
						
	}
		
}
