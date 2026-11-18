package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Gatherer.Integrator;

public class Leetcode_1929 {
    public int[] getConcatenation(int[] nums) {

// HashSet<Integer> set = new HashSet<>();
// set.si
    
    int n = nums.length;

    int[] ans = new int[n*2];

    for(int i = 0 ; i < nums.length ; i++){
        ans[i] = nums[i];
        ans[i+n] = nums[i];
    }

    return ans;

    }
}
