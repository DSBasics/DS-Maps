package sorting;

import java.util.*;

public class SortingExample {

	public static void main(String[] args) {
		
		Map<String, Integer> unsortedMap = new HashMap();
		
		populateMap(unsortedMap, 10);
		
		sortMapByKey(unsortedMap);
		
		sortMapByValue(unsortedMap);

	}

	private static void sortMapByKey(Map<String, Integer> unsortedMap) {
		Map<String, Integer> sortedMap = new TreeMap<>();
		sortedMap.putAll(unsortedMap);
		printMap("Sorted By Key", sortedMap);
	}

	private static void sortMapByValue(Map<String, Integer> unsortedMap) {
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		printMap("Sorted By Value", sortedMap);
	}

	private static void populateMap(Map<String, Integer> unsortedMap, int numOfElements) {
		
		for(int i =0; i < numOfElements; ++i) {
			String key = getRandomString(5);
			int value = getRandomInteger(100);
			unsortedMap.put(key, value);
		}
		
		printMap("Un Sorted Map  ", unsortedMap);	
	}

	private static void printMap(String nameOfMap, Map<String, Integer> map) {
		System.out.print(nameOfMap + " = [ ");
		
		Iterator<?> it = map.entrySet().iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)it.next();
			System.out.print(pair.getKey() + ": " + pair.getValue() + ", ");
		}

		System.out.println(" ]");	
	}

	private static int getRandomInteger(int upperBound) {
		Random r = new Random();
		return r.nextInt(upperBound);
	}

	private static String getRandomString(int numChars) {
		String allAlphabets = "QWERTYUIOPASDFGHJKLZXCVBNM";
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		for(int i = 0; i < numChars; ++i) {
			sb.append(allAlphabets.charAt(r.nextInt(25)));
		}
		return sb.toString();
	}

}
