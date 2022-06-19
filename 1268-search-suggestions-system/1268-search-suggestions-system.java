class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> l = new ArrayList<>();
        Arrays.sort(products);
        for(int i=0;i<products.length;i++){
            while(i<products.length && products[i].startsWith(searchWord.charAt(0)+"")){
                l.add(products[i]);
                i++;
            }
            if(l.size()>0){
                break;
            }
        }
        res.add(l);
        int i=1;
        while(i<searchWord.length()){
            l = new ArrayList();
            for(String s: res.get(res.size()-1)){
                if(s.startsWith(searchWord.substring(0,i+1))){
                    l.add(s);
                }
            }
            res.add(l);
            i++;
        }
        
        for(i=0;i<res.size();i++){
            if(res.get(i).size()>3){
                res.set(i, res.get(i).subList(0,3));
            }
        }
        
        return res;
    }
}