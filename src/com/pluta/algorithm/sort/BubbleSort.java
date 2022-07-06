package com.pluta.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {23, 42, 82, 17, 14, 82, 64, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        bubbleSortInternal(nums);
    }

    // 时间复杂度：O(N*N)
    // 空间复杂度：O(1)
    private static void bubbleSortInternal(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换一个数据, 索引为index与anotherIndex的两个数
     * 注意：index不能与anotherIndex相等，否则会将这个位置上的数字洗为0。因为对于任意数字x， x ^ x = 0
     */
    public static void swap(int[] arr, int index, int anotherIndex) {
        if (index == anotherIndex) {
            return;
        }
        arr[index] = arr[index] ^ arr[anotherIndex];
        arr[anotherIndex] = arr[index] ^ arr[anotherIndex];
        arr[index] = arr[index] ^ arr[anotherIndex];
    }
}