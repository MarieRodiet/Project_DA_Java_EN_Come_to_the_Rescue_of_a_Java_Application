package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

public class AnalyticsCounter {
	/**
	 * Read symptoms and increment their counts from inputPath,
	 * Write it out in outputPath
	 */

	public static void main(String args[]) {
		final String inputPath = "Project02Eclipse/symptoms.txt";
		final String outputPath = "Project02Eclipse/result.out";


		ISymptomReader reader = new ReadSymptomFromFile(inputPath);
		ArrayList<String> result = reader.getSymptoms();

		ISymptomIncrementer incrementer = new IncrementSymptoms();
		Map<String, Integer> map = incrementer.incrementSymptoms(result);

		ISymptomWriter writer = new WriteSymptomToFile(outputPath);
		writer.writeSymptoms(map);
	}
}
