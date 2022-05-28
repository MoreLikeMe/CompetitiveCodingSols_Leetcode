class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int[] arr = new int[s.length()];
        arr[0] = s.charAt(0)=='('?1:0;
        //all four combinations in which two adjacent brackets can occur
        // (( , (), )), )(
        //give it level by level values
        for(int i=1;i<arr.length;i++){
            if(s.charAt(i)=='(' && s.charAt(i-1)=='('){ 
                arr[i] = arr[i-1] + 1;
            } else if(s.charAt(i)=='(' && s.charAt(i-1)==')'){
                arr[i] = arr[i-1]==0?1:arr[i-1];
            } else if (s.charAt(i)==')' && s.charAt(i-1)==')'){
                arr[i] = arr[i-1]==0?0:arr[i-1]-1;
            } else if (s.charAt(i)==')' && s.charAt(i-1)=='('){
                arr[i] = arr[i-1];
            }
        }
       
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            //when its zero means all brackets processed till then
            //start a new hashMap
            if(arr[i]==0){
                map = new HashMap<Integer, Integer>();
                continue;
            }
            
            //remove the just larger element than current
            //as that level crosses
            map.remove(arr[i]+1);
            if(map.containsKey(arr[i])){
                //only if its a not ending with (... then the chunk can be valid parenthesis
                if(s.charAt(i)!='(' && max<(i - map.get(arr[i])))
                    max = i - map.get(arr[i]);
            } else {
                map.put(arr[i], i);
            }
        }
        return max==Integer.MIN_VALUE?0:(max+1);
    }
}