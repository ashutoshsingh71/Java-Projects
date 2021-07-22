package TrieImplementation;

import java.util.*;


class TrieNode {

    Map<Character, TrieNode> children;
    char c;
    boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
    }
    public TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }
    public TrieNode(char c,Map<Character,TrieNode> t){
        this.c = c;
        this.children = t;
    }
    public Map<Character, TrieNode> getNode(){
        return children;
    }
    public char getCharacter(){ return this.c; }
    public void setWord(boolean val){
        this.isWord = val;
    }

    public void insert(String word){
        if(word.isEmpty() || word == null){
            return;
        }
        int length = word.length();

        char letter = word.charAt(0);
        //TrieNode node = current.getNode().get(letter);
        TrieNode node = children.get(letter);
        if(node == null){
            node = new TrieNode(letter);
            children.put(letter,node);
        }
        if(length > 1){
            node.insert(word.substring(1));
        }else
            node.isWord = true;
    }
}

public class Trie {

    private TrieNode root;

    public Trie(List<String> words) {
        this.root = new TrieNode();
        for(String w : words){
            root.insert(w);
        }
    }



    public boolean search(String key){
        TrieNode current = root;
        int length = key.length();
        for(int i=0;i<length;i++){
            char letter = key.charAt(i);
            TrieNode node = current.getNode().get(letter);
            if(node == null)
                return false;
            current = node;
        }
        return current.isWord;
    }
    public boolean validPrefix(String key){
        TrieNode current = root;
        int length = key.length();
        for(int i=0;i<length;i++){
            char letter = key.charAt(i);
            TrieNode node = current.getNode().get(letter);
            if(node == null)
                return false;
            current = node;
        }
        return current != null;
    }
    public List<String> getAllStringWithGivenPrefix(String word){
        List<String> result = new ArrayList<>();
        int len = word.length();
        TrieNode current = root;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< len;i++){
          TrieNode node = current.getNode().get(word.charAt(i));
          if(node == null){
              return result;
          }else
              sb.append(node.getCharacter());
              current = node;
        }
        suggest(current,result,sb);
        return result;
    }
    public void suggest(TrieNode node,List<String> list,StringBuffer sb){
        if(node.isWord){
            list.add(sb.toString());
        }
        if(node == null || node.children.isEmpty()){
            return;
        }
        for(TrieNode child : node.children.values()){
            suggest(child,list,sb.append(child.getCharacter()));
            sb.setLength(sb.length()-1);
        }
    }
}

