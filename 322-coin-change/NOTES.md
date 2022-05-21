Recurssive Approach: (Time Limit Exceeded)
​
****************Code**********************
class Solution {
public int coinChange(int[] coins, int amount) {
int result = coinChangeRecusrsive(coins, amount);
return result==Integer.MAX_VALUE?-1:result;
}
public int coinChangeRecusrsive(int[] coin, int amount) {
if(amount==0){
return 0;
} else if(amount<0){
return Integer.MAX_VALUE;
}
int min = Integer.MAX_VALUE;
for(int a : coin){
if(coinChangeRecusrsive(coin, amount - a)!=Integer.MAX_VALUE){
min = Math.min(min, coinChangeRecusrsive(coin, amount - a) + 1);
}
}
return min;
}
}
​
​
*****************************Code End************************************