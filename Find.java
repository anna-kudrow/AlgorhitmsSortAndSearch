public class Find {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,5,7,9,10,11,12};
        System.out.println(binarySearch2(array,7));
    }


    public static int find(int [] array, int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int value, int min, int max){
        int midpoint;

        if(max < min){
            return -1;
        }else{
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value){
            return binarySearch(array, value, midpoint+1, max);
        }else{
            if(array[midpoint] > value){
                return binarySearch(array, value, min, midpoint-1);
            }else {
                return midpoint;
            }
        }
    }

    public static int binarySearch2(int[] arr, int number){
        int left = 0;
        int right = arr.length;
        int index = -1;
        while (left <= right){
            int pivot = (right - left) / 2 + left;
            if(arr[pivot] < number){
                left = pivot +1;
            }else if (arr[pivot] > number){
                right = pivot -1;
            } else if (arr[pivot] == number) {
                index = pivot;
                break;
            }
        }
        return index;
    }
}
