package com.daily;


/**
 * This problem was asked by Stripe.
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3
 */
public class P4 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(missingPositiveUsingBruteForce(nums));
        nums = new int[]{1,2,0};
        System.out.println(missingPositiveUsingBruteForce(nums));
        nums = new int[]{7,8,9,11,12};
        System.out.println(missingPositiveUsingBruteForce(nums));
        nums = new int[]{1};
        System.out.println(missingPositiveUsingBruteForce(nums));

    }


    /**
     * Brute Force Approach
     * @param nums
     * @return first missing positive
     */

    private static int missingPositiveUsingBruteForce(int[] nums) {
        int missing = 1;
        int len = nums.length;
        for(int i = 0; i < len; ++i) {
            boolean isFound = false;
            for (int j = 0; j < len; j++) {
                if(missing == nums[j]){
                    isFound = true;
                    break;
                }
            }
            if(isFound) {
                missing++;
            }
            else return missing;
        }
        return missing ;
    }



    /**
     * Solution using Extra Space of Array (Hashing Technique)
     * @param nums
     * @return first missing positive value
     */
    private static int missingPositive(int[] nums) {
        int n = nums.length;
        int[] x = new int[n + 1];

        for(int num : nums){
            if(num < n + 1 && num >= 0)
                x[num]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if(x[i] == 0)
                return i;
        }
        return n + 1 ;
    }
}
