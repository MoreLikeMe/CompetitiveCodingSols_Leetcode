/*
First get the result for every substring starting with 0th position
ie: a,ab,aba,abac,abaca
After that, For subsequent Substrings staring from 1st, 2nd ... position
only calculate the distincts that are discarded

abaca

a
ab
aba
abac
abaca


b
ba
bac
baca


a
ac
aca


c
ca


a
*/

class Solution {
    public long appealSum(String s) {
        int len = s.length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        long tempSum = 0, totalSum = 0;
        for(int i=0;i<len;i++){
            map.put((s.charAt(i)+""),map.getOrDefault((s.charAt(i)+""),0)+1);
            tempSum += map.size();
        }
        
        totalSum=tempSum;
        for(int i=1;i<len;i++){
            if(map.containsKey(s.charAt(i-1)+"") && map.get(s.charAt(i-1)+"")>1){
                //get the next index of i-1 th character so that we can omit 
                //those substrings out of calculation which are from i to next index.
                //as They dot contain the i-1th character so those count should be omiited.
                tempSum = tempSum - (s.indexOf(s.charAt(i-1),i)-i+1);
                totalSum += tempSum;
                map.put(s.charAt(i-1)+"", map.get(s.charAt(i-1)+"")-1);
            } 
            else if(map.containsKey(s.charAt(i-1)+"") && map.get(s.charAt(i-1)+"")==1){
                //if i-1th character has only one occurence.. then while omitting it
                //we should reduce the count equal to the length of the left over string.
                tempSum = tempSum - (len-i+1);
                totalSum += tempSum;
                map.remove(s.charAt(i-1)+"");
            }
        }
        
        return totalSum;
    }
}