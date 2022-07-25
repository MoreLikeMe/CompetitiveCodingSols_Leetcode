class Trie {
	
	boolean isWord;
	Trie[] ref;
	
    public Trie() {
        this.ref = new Trie[26];
        this.isWord = false;
    }
    
    public void insert(String word) {
        Trie cur = this;
        for(int i=0;i<word.length();i++){
        	if(cur.ref[word.charAt(i)-'a']==null){
        		cur.ref[word.charAt(i)-'a'] = new Trie();
        	}
        	cur = cur.ref[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
    	Trie cur = this;
    	for(int i=0;i<word.length();i++){
    		if(cur.ref[word.charAt(i)-'a']==null){
    			return false;
    		}
    		cur = cur.ref[word.charAt(i)-'a'];
    	}
    	return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
    	Trie cur = this;
    	for(int i=0;i<prefix.length();i++){
    		if(cur.ref[prefix.charAt(i)-'a']==null){
    			return false;
    		}
    		cur = cur.ref[prefix.charAt(i)-'a'];
    	}
    	return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */