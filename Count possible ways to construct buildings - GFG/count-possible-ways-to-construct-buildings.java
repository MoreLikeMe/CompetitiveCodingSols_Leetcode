// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        if(N==1){
            return 4;
        }
        if(N==2){
            return 9;
        }
        
        long[] dp = new long[N];
        dp[0] = 2;
        dp[1] = 3;
        
        for(int i=2;i<N;i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
    
        int k = (int)((dp[N-1]*dp[N-1])%1000000007);
        return k;
    }
}