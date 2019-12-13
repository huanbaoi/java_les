package common.tools.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtils {


    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                int temp;
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    public void test() {
        int[] arr = new int[] {
                2,45,9,56,54,8
        };
        System.out.println(Arrays.toString(sort(arr)));
    }
}
