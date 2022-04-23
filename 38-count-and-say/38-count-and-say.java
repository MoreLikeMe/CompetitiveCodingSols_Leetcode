class Solution {
    public String countAndSay(int n) {
        String string = "1";
        while(n-->1){
            String temp = "";
            for(int i=0;i<string.length();i++){
                int count = 1;
                while((i+1)<string.length() && string.charAt(i)==string.charAt(i+1)){
                    i++;
                    count++;
                }
                temp = temp + count + "" + string.charAt(i);
            }
            System.out.println(temp);
            string = temp;
        }
        return string;
    }
}