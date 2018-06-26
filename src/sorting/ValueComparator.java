package sorting;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator {

	Map<String, Integer> map;
	public ValueComparator(Map<String, Integer> unsortedMap) {
		this.map = unsortedMap;
	}

	@Override
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueA.compareTo(valueB);
	}

}
