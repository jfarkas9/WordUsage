//Source for code: https://www.programcreek.com/2013/03/java-sort-map-by-value/
package com.farkas.wordusage;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator {
    Map map;

    public ValueComparator(Map map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}
