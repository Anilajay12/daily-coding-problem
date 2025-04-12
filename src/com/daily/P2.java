package com.daily;

import java.util.Arrays;


/**
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class P2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(productExceptItSelf(nums)));
        System.out.println(Arrays.toString(productSum(nums)));
        nums = new int[]{1,2,0,0};
        System.out.println(Arrays.toString(productExceptItSelf(nums)));
        System.out.println(Arrays.toString(productSum(nums)));
        nums = new int[]{1,2,0};
        System.out.println(Arrays.toString(productExceptItSelf(nums)));
        System.out.println(Arrays.toString(productSum(nums)));
    }

    private static int[] productExceptItSelf(int[] nums) {
        int zerosCount = 0;
        int zeroIndex = -1;
        int product = 1;
        for (int i = 0 ; i < nums.length; i++) {
            if(nums[i] == 0) {
                zerosCount++;
                zeroIndex = i;
            }
            else product *= nums[i];
        }

        int[] ans = new int[nums.length];
        if(zerosCount > 1) return ans;
        if(zerosCount == 1) {
            ans[zeroIndex] = product;
        }

        else{
            for (int i = 0; i < nums.length; i++) {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }


    private static int[] productSum(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int prod = 1;
        for(int j = n - 2; j >= 0; j--){
            prod *= nums[j + 1];
            ans[j] = ans[j] * prod;
        }
        return ans;
    }
}
