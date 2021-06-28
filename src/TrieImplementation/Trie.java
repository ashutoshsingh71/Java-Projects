package TrieImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class TrieNode {

    Map<Character, TrieNode> node;
    boolean isWord;

    public TrieNode() {
        this.node = new HashMap<>();
    }
    public Map<Character, TrieNode> getNode(){
        return node;
    }
    public void setWord(boolean val){
        this.isWord = val;
    }
}

public class Trie {

    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        int length = word.length();
        for(int i=0;i<length;i++){
            char letter = word.charAt(i);
            TrieNode node = current.getNode().get(letter);
            if(node == null){
                node = new TrieNode();
                current.getNode().put(letter,node);
            }
            current = node;
        }
        current.setWord(true);
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

}

