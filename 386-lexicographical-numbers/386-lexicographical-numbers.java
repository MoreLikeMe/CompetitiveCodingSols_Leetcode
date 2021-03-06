class Solution {
    public List<Integer> lexicalOrder(int n) {
        Trie obj = new Trie();
        obj.insert(n);
        return obj.countLexographicalNumbers(obj, 0, new ArrayList<Integer>());
    }
}

class Trie{
    Trie[] ref;
    Trie(){
        this.ref = new Trie[10];
    }
    
    public void insert(int n){
        int ind = 0;
        while(ind<=n){
            Trie cur = this;
            int temp = ind;
            Stack<Integer> st = new Stack<>();
            while(temp!=0){
                st.push(temp%10);
                temp = temp/10;
            }
            while(!st.isEmpty()){
                int digit = st.pop();
                if(cur.ref[digit]==null){
                    cur.ref[digit] = new Trie();
                }
                cur = cur.ref[digit];
            }
            ind++;
        }
    }
    
    public List<Integer> countLexographicalNumbers(Trie cur, int partial, List<Integer> res){
        Trie[] r = cur.ref;
        if(partial!=0){
            res.add(partial);
        }
        for(int i=0;i<10;i++){
            if(r[i]!=null){
                countLexographicalNumbers(r[i], (partial*10 + i), res);
            }
        }
        return res;
    }
}