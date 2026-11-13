import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        int r = n - 1;
        
        // Deque stores {value, count_of_elements_with_this_value}
        // Maintained in non-decreasing order from front to back
        Deque<long[]> dq = new ArrayDeque<>();
        
        for (int l = n - 1; l >= 0; l--) {
            long count = 1;
            
            // Merge smaller elements to the right up to nums[l]
            while (!dq.isEmpty() && dq.peekFirst()[0] < nums[l]) {
                long[] front = dq.pollFirst();
                cost += (nums[l] - front[0]) * front[1];
                count += front[1];
            }
            
            dq.offerFirst(new long[]{nums[l], count});
            
            // Shrink window from the right if operations exceed k
            while (cost > k) {
                long[] back = dq.peekLast();
                cost -= (back[0] - nums[r]);
                back[1]--;
                
                if (back[1] == 0) {
                    dq.pollLast();
                }
                r--;
            }
            
            // Every subarray [l..j] for l <= j <= r is valid
            ans += (r - l + 1);
        }
        
        return ans;
    }
}