package aOften.cReflectEnum.cArrayEnum;

import java.util.Arrays;

/**
 * 数组的排序
 */
public class TestArraySort {
    private int i;

    public static void main(String[] args) {
        int[] numbers = {10, 9, 8, 7, 6, 5, 4};
        selectedSort(numbers);
        //  insertSort(numbers);
        bubboSort(numbers);
    }

    /**
     * 选择排序
     * @param numbers
     */
    private static void selectedSort(int[] numbers) {
         int minVal=0;//定义存储最小值
        int minIndex=0;//存储最小值下标
        for (int i = 0; i < numbers.length; i++) {
            //假设第一个元素就是最小值
            minVal=numbers[i];
            //记录最小值下标
            minIndex=i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j]<minVal) {
                    minVal=numbers[j];
                    minIndex=j;
                }
            }
            if (minVal!=numbers[i]&&minIndex!=i) {
                numbers[minIndex]=numbers[i];
                numbers[i]=minVal;
            }
        }
        for (int el : numbers) {
            System.out.print(el + " ");
        }
        System.out.println("\n\r");
    }

    /**
     * 插入排序
     * @param numbers
     */
    private static void insertSort(int[] numbers) {
        //插入排序（将数列分为有序和无序两部分
        //每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较，找出插入位置，将该元素插入有序序列中）
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
        for (int el : numbers) {
            System.out.print(el + " ");
        }
        System.out.println("\n\r");
    }

    /**
     * 冒泡排序
     *
     * @param numbers
     */
    private static void bubboSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    //交换2个元素
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
            String ss = new String(Arrays.toString(numbers));
            System.out.println(ss);
        }
        for (int el : numbers) {
            System.out.print(el + " ");
        }
        System.out.println("\n\r");
    }
    
    private static int sum(int[] numbers) {
        int sum = 0;
        if (isNotEmpty(numbers)) {
            for (int number : numbers) {
                sum += number;
            }
        }
        return sum;
    }

    private static int max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }

    private static double avg(int[] numbers) {
        return sum(numbers) / numbers.length;
    }

    /**
     * 判断数组是否为空方法
     *
     * @param array
     * @return
     */
    private static boolean isNotEmpty(int[] array) {
        return array != null && array.length > 0;
    }
}
