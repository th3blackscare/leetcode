package org.osharif.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Midean {
    private static List<Integer> midean = new ArrayList<Integer>();
//    public double findMedianSortedArrayss(int[] nums1, int[] nums2) {
//        int[] result = new int[nums1.length + nums2.length];
//        System.arraycopy(nums1, 0, result, 0, nums1.length);
//        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
//
//        binarySearchWithoutTarget(result);
//        System.out.println(midean);
//        return midean.stream().mapToDouble(x -> x).sum() / (midean.size() % 2 == 0 ? 2 : 1);
//    }
//    private void binarySearchWithoutTarget(int[] nums){
//        int low = 0, high = nums.length - 1;
//        while ( low <= high){
//            int mid = low + (high - low) / 2;
//            if ( mid < nums.length && nums[mid] < nums[mid+1]){
//                midean.add(nums[mid]);
//                low = mid + 1;
////                int[] newNums = Arrays.stream(nums).skip(low).toArray();
////                if(newNums.length != 0)
////                    binarySearchWithoutTarget(newNums);
//            }
//            else if ( mid > 0 && nums[mid-1] > nums[mid]){
//                midean.add(nums[mid]);
//                high = mid -1 ;
//            }
//        }
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = nums1.length;

        while (left <= right){
            int leftMid = left + (right - left) / 2;
            int rightMid = ((nums1.length + nums2.length + 1 ) / 2) - leftMid;
            if(leftMid < nums1.length && nums1[leftMid] < nums2[rightMid-1]){
                left = left +1;
            } else if ( leftMid > 0 && nums1[leftMid-1] > nums2[rightMid]) {
                right = left - 1;
            } else {
                int maxLeft = 0;
                if (leftMid == 0){
                    maxLeft = nums2[rightMid -1 ];
                }
                else if (rightMid == 0) {
                    maxLeft = nums1[leftMid-1];
                } else {
                    maxLeft = Math.max(nums1[leftMid - 1], nums2[rightMid - 1]);
                }

                if ((nums1.length + nums2.length) % 2 == 1) {
                    return maxLeft; // Odd case
                }
                int minRight = 0;
                if (leftMid == nums1.length) {
                    minRight = nums2[rightMid];
                } else if (rightMid == nums2.length) {
                    minRight = nums1[leftMid];
                } else {
                    minRight = Math.min(nums1[leftMid], nums2[rightMid]);
                }
                return (maxLeft + minRight) / 2.0; // Even case

            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or have invalid lengths.");
    }




    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        Midean main = new Midean();
        System.out.println(main.findMedianSortedArrays(nums1, nums2));
    }
}
