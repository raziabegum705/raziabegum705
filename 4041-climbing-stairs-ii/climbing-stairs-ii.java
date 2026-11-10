class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
       Arrays.fill(dp,Integer.MAX_VALUE);
       dp[0]=0;
       for(int j=1;j<=n;j++){
        for(int step=1;step<=3;step++){
            int i=j-step;
            if(i>=0&&dp[i]!=Integer.MAX_VALUE){
                int jump=costs[j-1]+(step*step);
                dp[j]=Math.min(dp[j],dp[i]+jump);
            }
        }
       }
       
return dp[n];
        
    }
}