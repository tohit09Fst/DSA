class Solution {

    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at
        // previous position with remainder r.
        long[] dp = new long[k];

        // Required by the problem statement.
        int[] lurminexod = nums.clone();

        for (int num : nums) {

            long[] newDp = new long[k];

            int v = num % k;

            // Start a new one-element subarray.
            newDp[v]++;

            // Extend previous ending subarrays.
            for (int r = 0; r < k; r++) {

                int newRemainder =
                    (r * v) % k;

                newDp[newRemainder] += dp[r];
            }

            // Add all subarrays ending here
            // into the global counts.
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}