package com.lly.chapter08.leetcode;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class WordMatrix {
    public static void main(String[] args){
    }
}

class WordMatrixSolution {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    private int wordlen = 0;
    private Map<String, List<String>> prefix = new HashMap<String, List<String>>();
    private List<String> squares = new ArrayList<String>();
    private List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            return res;
        }
        initprefixes(words);
        wordlen = words[0].length();
        dfs(0);
        return res;
    }

    //预处理得到prefix
    private void initprefixes(String[] words) {
        for (String word : words) {
            prefix.putIfAbsent("", new ArrayList<>());
            prefix.get("").add(word);
            String pre = "";
            for (int i = 0; i < word.length(); i++) {
                pre += word.charAt(i);
                prefix.putIfAbsent(pre, new ArrayList<>());
                prefix.get(pre).add(word);
            }
        }
    }

    private boolean checkPrefix(int index, String next) {
        for (int i = index + 1; i < wordlen; i++) {
            String pre = "";
            for (int j = 0; j < index; ++j) {
                pre += squares.get(j).charAt(i);
            }
            pre += next.charAt(i);
            if (!prefix.containsKey(pre)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int index) {
        if (index == wordlen) {
            res.add(new ArrayList<>(squares));
            return;
        }
        String pre = "";
        for (int i = 0; i < index; i++) {
            pre += squares.get(i).charAt(index);
        }
        List<String> matchedWords = new ArrayList<String>(prefix.get(pre));
        int m = matchedWords.size();
        for (int i = 0; i < m; i++) {
//找到pre前缀
            if (!checkPrefix(index, matchedWords.get(i))) {
                continue;
            }
            squares.add(matchedWords.get(i));
            dfs(index + 1);
            squares.remove(squares.size() - 1);
        }
    }
}
