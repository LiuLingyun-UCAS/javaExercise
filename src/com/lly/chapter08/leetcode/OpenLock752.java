package com.lly.chapter08.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class OpenLock752 {
    public static void main(String[] args) {
        OpenLockSolution openLockSolution = new OpenLockSolution();
        System.out.println(openLockSolution.openLock(
                new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},
                "8888"));
    }
}

class OpenLockSolution {
    public int openLock(String[] deadends, String target) {
        return bfs(deadends, target);
    }

    public int bfs(String[] deadends, String target){
        Queue<String> queue = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        Set<String> deadendSet = new HashSet<>();
        queue.offer("0000");
        hashSet.add("0000");
        for(String s :  deadends){
            deadendSet.add(s);
        }
        if(deadendSet.contains("0000")) return -1;
        char[] arr = null;
        String tmp = null;
        int count = 0;
        while(!queue.isEmpty()){
            for(int i = queue.size() - 1; i >= 0; i--){
                String s = queue.poll();
                if(s.equals(target)){
                    return count;
                }
                for(int j = 0; j < 4; j++){
                    arr = s.toCharArray();
                    arr[j] += 1;
                    if(arr[j] > '9'){
                        arr[j] = '0';
                    }
                    tmp = new String(arr);
                    if(!(deadendSet.contains(tmp) || hashSet.contains(tmp))){
                        queue.offer(tmp);
                        hashSet.add(tmp);
                    }
                    arr = s.toCharArray();
                    arr[j] -= 1;
                    if(arr[j] < '0'){
                        arr[j] = '9';
                    }
                    tmp = new String(arr);
                    if(!(deadendSet.contains(tmp) || hashSet.contains(tmp))){
                        queue.offer(tmp);
                        hashSet.add(tmp);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
