package ordenamientoproyecto;

import java.util.Arrays;
import static ordenamientoproyecto.OrdenamientoProyecto.mergeSort;

public class OrdenamientoProyecto {

    //Ordenamineto por Insercion
    public static void insercion(int A[]) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j > 0 && A[j] < A[j - 1]) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j--;
            }
        }
    }

    //Intercambio ***OJO***
    public static void ordenarArray(int a[], int numero) {
        int i1 = 0;
        int i2;
        int auxiliar;
        while (i1 <= numero - 2) {
            i2 = i1 + 1;
            while (i2 <= numero - 1) {
                if (a[i2] < a[i1]) {
                    auxiliar = a[i2];
                    a[i2] = a[i1];
                    a[i1] = auxiliar;
                }
                i2++;
            }
            i1++;
        }
        i1 = 0;
    }

    //Ordenamiento por Merge Sort
    public static void mergeSort(Comparable[] a) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    private static void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left].compareTo(a[right]) <= 0) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }

        while (left <= leftEnd) // Copy rest of first half
        {
            tmp[k++] = a[left++];
        }

        while (right <= rightEnd) // Copy rest of right half
        {
            tmp[k++] = a[right++];
        }

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }

    //Heap Sort
    public static void heapify(int arr[], int size, int i) {
        int temp;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest);
        }
    }

    public static void heapSort(int arr[], int size) {
        int i;
        int temp;
        for (i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
        for (i = size - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    //Bin Sort
    public static void sort(int[] a, int maxVal) {
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
            }
        }
    }

    //Imprime todo el arreglo
    public static void Imprimir(int A[]) {
        for (int x = 0; x < A.length; x++) {
            System.out.print(A[x] + " ");
        }
    }

    public static void main(String[] args) {

        int A[] = {2, 5, 6, 7, 1, 3, 8, 10, 0, 1, 5, -2};

        System.out.println("Arreglo No Ordenado");
        Imprimir(A);
        System.out.println("");

        System.out.println("Arreglo Ordenado por Insercion");
        insercion(A);
        Imprimir(A);

        //HeapSort
        System.out.println("");
        System.out.println("Arreglo Ordenado por HeapSort");
        int tam = A.length;
        heapSort(A, tam);
        Imprimir(A);

        //MergeSort
        System.out.println("");
        Integer[] a = {2, 6, 3, 5, 1};
        System.out.println("Arreglo Ordenado por MergeSort");
        mergeSort(a);
        System.out.print(Arrays.toString(a));
        
        //BinSort
        int maxVal = 15;
        int[] data = {5, 3, 0, 2, 4, 1, 3, 1, 10, 11, 4, 7};
        System.out.println("");
        System.out.println("Arreglo Ordenado por MergeSort");
        System.out.println("Before: " + Arrays.toString(data));
        sort(data, maxVal);
        System.out.println("After:  " + Arrays.toString(data));

    }

}
