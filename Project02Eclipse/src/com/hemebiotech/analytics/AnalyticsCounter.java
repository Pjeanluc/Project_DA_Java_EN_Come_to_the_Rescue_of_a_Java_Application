package com.hemebiotech.analytics;

/**
 * 
 * @author jl Protois
 *
 */
public class AnalyticsCounter {
	
			
	public static void main(String args[]) throws Exception {
		
		// preparation gestionnaire d analyse de fichiers
		AnalyticsManager analyticsManager = new AnalyticsManager() ;
		analyticsManager.process(args[0], args[1]);
						
	}
		
}
