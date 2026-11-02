package Easy;

public class Leetcode_1480 {
    public int[] runningSum(int[] nums) {
        
        int[] running = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++){
            if(i == 0){
                running[i] = nums[0];
            }else{
                running[i] = nums[i] + running[i-1];
            }
        }

        return running;

    }
}

