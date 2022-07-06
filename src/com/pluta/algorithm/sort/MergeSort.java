package com.pluta.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {14, 432, 21, 43, 43, 20, 56, 4, 324 ,23, 144, 2, 11, 54};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeSortInternal(nums, 0, nums.length - 1);
    }

    private static void mergeSortInternal(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        mergeSortInternal(nums, left, middle);
        mergeSortInternal(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    /**
     * nums数组以middle为界，左右两边都有序。将左右两边有序合并为一个有序的数组，放回原数组。
     */
    private static void merge(int[] nums, int left, int middle, int right) {
        int[] copyNums = new int[right - left + 1];
        int leftIndex = left, rightIndex = middle + 1;
        int cur = 0;
        while (leftIndex <= middle && rightIndex <= right) {
            copyNums[cur++] = nums[leftIndex] < nums[rightIndex] ? nums[leftIndex++] : nums[rightIndex++];
        }
        while (leftIndex <= middle) {
            copyNums[cur++] = nums[leftIndex++];
        }
        while (rightIndex <= right) {
            copyNums[cur++] = nums[rightIndex++];
        }
        System.arraycopy(copyNums, 0, nums, left, copyNums.length);
    }
}
