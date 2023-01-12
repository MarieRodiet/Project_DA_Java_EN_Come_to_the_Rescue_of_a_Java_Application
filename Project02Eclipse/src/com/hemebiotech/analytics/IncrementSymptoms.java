package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class IncrementSymptoms implements ISymptomIncrementer{
    @Override
    public Map<String, Integer> incrementSymptoms(ArrayList<String> array) {
        Map<String, Integer> result = new TreeMap<>();
        for(String s: array){
            //if symptom found at line is already in map object
            if(result.containsKey(s)){
                // locate it by key and increment its value
                result.put(s, result.get(s) + 1);
            }
            else {
                //or add a new key/value pair with 1 for its first occurrence
                result.put(s, 1);
            }
        }
        return result;
    }
}
