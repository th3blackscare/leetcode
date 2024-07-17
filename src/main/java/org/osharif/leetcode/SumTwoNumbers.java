package org.osharif.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class SumTwoNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
//        String[] parts = line.split(",\\s*"); // Split by comma and optional spaces
//        for (String part : parts) {
//            if (part.startsWith("nums")) {
//                nums = extractNumbers(part);
//            } else if (part.startsWith("target")) {
//                target = Integer.parseInt(part.split("=")[1].trim());
//            }
//        }
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                result = new int[]{i,map.get(x)};
                break;
            } else {
                map.put(nums[i], i);
                System.out.println(nums[i]+" "+i);
            }
        }

        return result;
    }

    public static int[] extractNumbers(String line) {
        String numsString = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
        return Arrays.stream(numsString.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
