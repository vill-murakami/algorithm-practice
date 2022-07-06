package com.pluta.algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 22, 32, 54, 12, 31};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    // 堆排序
    // 时间复杂度：O(N * logN)
    // 空间复杂度：O(1)
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    // 某个数现在处于index位置，往上继续移动
    public static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数在index位置，能否往下移动
    public static void heapify(int[] nums, int index, int heapSize) {
        int left = index * 2 + 1;
        // 有子节点（起码有左子节点）
        while (left < heapSize) {
            int largest = (left + 1 < heapSize && nums[left + 1] > nums[left]) ? left + 1 : left;
            largest = nums[index] > nums[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(nums, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] nums, int index, int anotherIndex) {
        int temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }
}
