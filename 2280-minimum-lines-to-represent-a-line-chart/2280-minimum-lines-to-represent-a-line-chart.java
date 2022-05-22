import java.math.BigInteger;

class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        Arrays.sort(stockPrices, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
        
        double prevSlope = Integer.MAX_VALUE;
        double currSlope = 0;
        int count = 0;
        int prevX = Integer.MAX_VALUE, prevY = Integer.MAX_VALUE, currX = Integer.MAX_VALUE, currY=Integer.MAX_VALUE;
        for(int i=1;i<stockPrices.length;i++){
            currY = stockPrices[i][1]-stockPrices[i-1][1];
            currX = stockPrices[i][0]-stockPrices[i-1][0];
            
            BigInteger gcd = BigInteger.valueOf(currY).gcd(BigInteger.valueOf(currX));
            
            
            currY = currY / (gcd.intValue());
            currX = currX / (gcd.intValue());
            
            if(prevX!=currX || prevY!=currY){
                count++;
                prevX = currX;
                prevY = currY;
            }
            
        }
        return count;
    }
}