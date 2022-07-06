package com.pluta.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {43, 42, 82, 17, 14, 82, 64, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }
        insertionSortInternal(nums);
    }

    // 插入排序
    // 时间复杂度：O(N * N)
    // 空间复杂度：O(1)
    public static void insertionSortInternal(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] >= nums[j - 1]) {
                    break;
                }
                swap(nums, j, j - 1);
            }
        }
    }

    private static void swap(int[] nums, int index, int anotherIndex) {
        int temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }
}
