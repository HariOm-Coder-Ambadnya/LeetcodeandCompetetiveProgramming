package Easy;
import java.util.HashSet;

public class Leetcode_219 {
     public boolean containsNearbyDuplicate(int[] nums, int k) {

        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1; j<=i+k && j<nums.length;j++){
        //         if( nums[i] == nums[j] ){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        HashSet <Integer> map = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(map.contains(nums[i])) return true;
            map.add(nums[i]);
            if(map.size() > k){
                map.remove(nums[i - k]);
            }

        }

return false;
    }

}
