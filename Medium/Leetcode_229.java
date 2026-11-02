// package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_229 {
    
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> lst = new ArrayList<>();

        for(int key : map.keySet()){
            if(map.get(key) > nums.length/3){
                lst.add(key);
            }
        }

        return lst;

    }

}
