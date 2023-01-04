package com.hemebiotech.analytics;

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
		Map<String, Integer> data = reader.readSymptomsFromFile();

		ISymptomWriter writer = new WriteSymptomToFile(outputPath);
		writer.writeSymptoms(data);
	}
}
