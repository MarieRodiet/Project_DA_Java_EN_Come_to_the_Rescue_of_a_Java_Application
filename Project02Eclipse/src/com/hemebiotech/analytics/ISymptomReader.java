package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

public interface ISymptomReader {
	Map<String, Integer> readSymptomsFromFile();
	ArrayList<String> getSymptoms();
}
