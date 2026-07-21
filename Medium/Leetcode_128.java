public class Leetcode_229{
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int lcs = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (nums.length == 0) {
            return 0;
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;
            while (current != Integer.MAX_VALUE && set.contains(current + 1)) {
                    current++;
                    length++;
                }
                lcs = Math.max(lcs, length);
            }

        }
        return lcs;
    }
}