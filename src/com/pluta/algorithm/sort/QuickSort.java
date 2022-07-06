package com.pluta.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 32, 12, 54, 23, 34, 34, 43};
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);


        quickSortVer2(nums);
        System.out.println(Arrays.toString(nums));

        quickSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }



    // ========== quick sort version 2 ===============
    public static void quickSortVer2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSortInternalVer2(nums, 0, nums.length - 1);
    }

    private static void quickSortInternalVer2(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left + (int) (Math.random() * (right - left + 1)), right);
            int[] lastIndexes = partitionVer2(nums, left, right);
            quickSortInternalVer2(nums, left, lastIndexes[0]);
            quickSortInternalVer2(nums, lastIndexes[1], right);
        }
    }

    private static int[] partitionVer2(int[] nums, int left, int right) {
        int lastLeftIndex = left - 1;
        int lastRightIndex = right;
        while (left < lastRightIndex) {
            if (nums[left] < nums[right]) {
                swap(nums, ++lastLeftIndex, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, --lastRightIndex, left);
            } else {
                left++;
            }
        }
        swap(nums, lastRightIndex++, right);
        return new int[] {lastLeftIndex, lastRightIndex};
    }



    // ========== quick sort version 1 ===============
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSortInternal(nums, 0, nums.length - 1);
    }

    private static void quickSortInternal(int[] nums, int left, int right) {
        if (left < right) {
            int lastLessIndex = partition(nums, left, right);
            swap(nums, lastLessIndex + 1, right);
            quickSortInternal(nums, left, lastLessIndex);
            quickSortInternal(nums, lastLessIndex + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int cur = left; // 允许变量适当冗余，以更清晰地表达语义
        int lastLessIndex = left - 1;
        while (cur < right) {
            if (nums[cur] <= nums[right]) {
                swap(nums, ++lastLessIndex, cur++);
            } else {
                cur++;
            }
        }
        return lastLessIndex;
    }

    // ========== common ===========
    private static void swap(int[] nums, int index, int otherIndex) {
        int temp = nums[index];
        nums[index] = nums[otherIndex];
        nums[otherIndex] = temp;
    }
}
