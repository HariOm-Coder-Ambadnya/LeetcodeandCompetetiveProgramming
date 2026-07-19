package Easy;

public class Leetcode_953 {

    public boolean isAlienSorted(String[] words, String order) {

        // Store rank of every character
        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Compare every adjacent pair
        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int j = 0;

            // Compare characters
            while (j < first.length() && j < second.length()) {

                char c1 = first.charAt(j);
                char c2 = second.charAt(j);

                // Different character found
                if (c1 != c2) {

                    // Wrong order
                    if (rank[c1 - 'a'] > rank[c2 - 'a']) {
                        return false;
                    }

                    // Correct order, move to next pair
                    break;
                }

                j++;
            }

            // Prefix case
            if (j == second.length() && first.length() > second.length()) {
                return false;
            }
        }

        return true;
    }

}
