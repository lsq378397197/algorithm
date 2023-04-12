package com.example.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] array = new int[]{6, 5, 4, 3, 2, 1};
        int[] array = new int[]{3, 4, 14, 1, 5, 6, 7, 8, 1, -1, 0, 9, 11};
//        bubbleSortV1(array);
//        bubbleSortV2(array);
//        bubbleSortV3(array);
        bubbleSortV4(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序原始版
     *
     * @param array 待排序数组
     */
    public static void bubbleSortV1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //每经过一次外层循环，都会有最大的一个数到数组末尾，所以减去i
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化1
     * 如果已经有序，不再循环，直接退出大循环
     *
     * @param array 待排序数组
     */
    public static void bubbleSortV2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有交换说明还是无序
                    isSorted = false;
                }
            }
            //没交换过，说明已经有序，直接退出
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序优化2
     * 处于无序边界之后的元素就不用再排序了
     *
     * @param array 待排序数组
     */
    public static void bubbleSortV3(int[] array) {
        //最后一次交换位置的索引
        int lastExchangeIndex = 0;
        //数组有序边界
        int sortedBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //每一轮初始是true
            boolean isSorted = true;
            for (int j = 0; j < sortedBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有交换说明还是无序
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortedBorder = lastExchangeIndex;
            //没交换过，说明已经有序，直接退出
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序优化3 鸡尾酒排序
     * 从左往右排序一次，再从右往左排序一次，如此往复
     * @param array 待排序数组
     */
    public static void bubbleSortV4(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            //奇数轮，从左往右进行比较交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有元素交换，所以为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //偶数轮之前，先标记为true
            isSorted = true;
            for (int j = array.length - i - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
