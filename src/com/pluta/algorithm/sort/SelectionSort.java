package com.pluta.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次将最小或最大的数放到未排序的序列的第一个位置
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {23, 42, 82, 17, 14, 82, 64, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    // 时间复杂度：O(N*N)
    // 空间复杂度：O(1) -- 只引入了几个有限的变量
    public static void selectionSort(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }
        selectionSortInternal(nums);
    }

    private static void selectionSortInternal(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i +1; j < nums.length; j++) {
                minIndex = nums[minIndex] > nums[j] ? j : minIndex;
            }
            if (minIndex != i) {
                swap(nums, minIndex, i);
            }
        }
    }

    /**
     * 交换数组nums在index与anotherIndex位置上的值
     */
    private static void swap(int[] nums, int index, int anotherIndex) {
        int temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }
}