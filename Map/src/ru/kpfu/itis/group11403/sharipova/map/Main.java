package ru.kpfu.itis.group11403.sharipova.map;

import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
       MyHashMap<Integer, String> map= new MyHashMap<Integer, String>(3);
       map.put("one", 1);
       map.put("two", 2);
       map.put("two", 22);
       map.put("three", 3);
       map.put("four", null);
       map.remove("two");
       map.remove("one");
      System.out.println(map.containsKey("1")); 
      System.out.println(map.get("for"));
      System.out.println(map.containsValue(null));
      Set<Entry<String, Integer>> set=map.entrySet();
	}

}
