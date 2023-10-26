import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }

        long start = System.currentTimeMillis();
        bubbleSort2(array);
        System.out.print("For bubble sort: ");
        System.out.println(System.currentTimeMillis() - start);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        start = System.currentTimeMillis();
        quickSort(array,0, array.length-1);
        System.out.print("For quick sort: ");
        System.out.println( System.currentTimeMillis() - start);




        //for (int i = 0; i < array.length; i++) System.out.println(array[i] + " ");


    }

    public static void bubbleSort(int[] array){
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length -1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    finish = false;
                }
            }
        }while (!finish);
    }
    
    public static void bubbleSort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right){
        if(arr == null || arr.length == 0 || left >=right) return;
        int pivot = (right - left) /2 + left;
        int midPoint = arr[pivot];
        int l = left;
        int r = right;
        while (l <= r) {
                while (arr[l] < midPoint) l++;
                while (arr[r] > midPoint) r--;
                if (l <= r) {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++;
                    r--;
                }
        }
        if (left < r) quickSort(arr,left,r);
        if (l < right) quickSort(arr,l,right);
    }


    public static void directSort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }



    public static void insertSort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}



