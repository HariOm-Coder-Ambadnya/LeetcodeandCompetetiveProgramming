package Medium;

import java.util.Arrays;

public class Leetocde_238 {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result =  new int[nums.length];

        Arrays.fill(result,1);

        int prefix = 1 ;
        int postfix = 1 ;

        for(int i =1 ;i < nums.length ; i++){
            prefix = nums[i-1] * prefix;
            result[i] = prefix;
        }

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }

        return result;
    }
}
