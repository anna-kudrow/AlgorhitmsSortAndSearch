import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int [] arr = new int [] {10,19,26,4,27,4,7,9,2,1,16};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int [] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,i,0);
        }
    }
    private static void heapify(int[]array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array,heapSize, largest);
        }


    }
}
