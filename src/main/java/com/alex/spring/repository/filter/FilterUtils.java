package com.alex.spring.repository.filter;

import java.util.HashMap;
import java.util.Map;

public class FilterUtils {
	
	public static Map<String, Object> criteriaAsMap(Object... values) {
        if (values.length % 2 != 0)
            throw new RuntimeException("Usage - (key, value, key, value, ...)");
        Map<String, Object> result = new HashMap<String, Object>(values.length / 2);
        for (int i = 0; i < values.length; i += 2) {
            result.put(values[i].toString(), values[i + 1]);
        }
        return result;
    }
}
