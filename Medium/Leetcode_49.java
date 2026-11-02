// package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_49 {
        public List<List<String>> groupAnagrams(String[] strs) {

        int[] count = new int[26];
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            Arrays.fill(count, 0);

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
        

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(count[i]);
        }
        
        String key = sb.toString();

        if(!map.containsKey(key)){
            map.put(key,new ArrayList());
        }

        map.get(key).add(s);

    }

    return new ArrayList<>(map.values());
    }
}
