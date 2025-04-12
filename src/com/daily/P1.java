package com.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class P1 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 3, 7};
        System.out.println(isPossibleSum(nums, 17));
        System.out.println(isPossibleSum(nums, 21));
        System.out.println(isPossibleK(nums, 17));
        System.out.println(isPossibleK(nums, 21));
        System.out.println(isPossible(nums, 17));
        System.out.println(isPossible(nums, 21));
    }

    private static boolean isPossibleSum(int[] nums, int target) {

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target)
                    return true;
            }
        }

        return false;
    }


    private static boolean isPossible(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0, right = nums.length-1;

        while(left < right){
            if(nums[left] + nums[right] == target)
                return true;
            if(nums[left] + nums[right] < target)
                left = left + 1;
            else right = right - 1;
        }
        return false;

    }

    private static boolean isPossibleK(int[] nums, int target){
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            System.out.println(hashSet);
            if(hashSet.contains(target - num))
                return true;
            hashSet.add(num);
        }

        return false;
    }
}
