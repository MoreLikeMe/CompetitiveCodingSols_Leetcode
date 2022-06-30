// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        int localMax = 1;
        for(int i=0;i<N;i++){
            if(localMax<=i){
                return 0;
            }
            while(localMax<N && (i+A[i])>=localMax && dp[localMax]==-1){
                dp[localMax] = dp[i]+1;
                localMax++;
            }
        }
        return dp[N-1]!=-1?1:0;
    }
};