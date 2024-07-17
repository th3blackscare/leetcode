package org.osharif.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int[] lastSeen  = new int[128];
        Arrays.fill(lastSeen, -1);
        // we need to get each char position
        // check if it's in the list
        // if it's in the list check if it's in our substring
        // if it's in our substring save the String to a Map and move the pointer to a the new unique char and create a new sub string

        while (right < s.length()) {
            char c = s.charAt(right);
            if(lastSeen[c] >= left ) {
                left = lastSeen[c] + 1;
            }
            lastSeen[c] = right;
            max = Math.max(max, right - left + 1 );
            right ++;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
