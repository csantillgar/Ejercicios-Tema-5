public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Elegir el pivote (mediana de tres)
            int pivotIndex = getPivotIndex(arr, low, high);
            int pivotValue = arr[pivotIndex];

            // Colocar el pivote en su posición correcta en el arreglo
            int partitionIndex = partition(arr, low, high, pivotValue);

            // Ordenar recursivamente las sublistas
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];
        // Devolver el índice medio de los tres elementos
        if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return mid;
        } else if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return low;
        } else {
            return high;
        }
    }

    private static int partition(int[] arr, int low, int high, int pivotValue) {
        int left = low;
        int right = high - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivotValue) {
                left++;
            }
            while (left <= right && arr[right] > pivotValue) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, high);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        quickSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

