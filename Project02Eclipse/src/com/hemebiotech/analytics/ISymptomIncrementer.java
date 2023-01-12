package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

public interface ISymptomIncrementer {
    Map<String, Integer> incrementSymptoms(ArrayList<String> result);

}
