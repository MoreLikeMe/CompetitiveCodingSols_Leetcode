/*

32 can be represented as:
10
11
11

82734 can be represented as:
10000
10100
10100
10100
10101
10111
11111
11111

The no. of such binary numbers will be equal to the
highest digit present
*/


class Solution {
    public int minPartitions(String n) {
        int c = 0, ch = '0';
        int l = n.length();
        while(c<l){
            if(n.charAt(c)>ch){
                ch = n.charAt(c);
            }
            c++;
        }
        return ch-48;
    }
}