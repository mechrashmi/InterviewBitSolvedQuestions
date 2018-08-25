package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class MergeSortCountInversion {
    //int count;

    public static void main(String[] args) {

        //int[] in = {84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60 };
        Integer[] in = {84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60 };
        MergeSortCountInversion tester = new MergeSortCountInversion();
        System.out.println(tester.countInversions(new ArrayList<Integer>(Arrays.asList(in))));
        //System.out.println(mergeSort(in, in.length));
        //System.out.println("c:" + tester.count);
    }

    /* This method sorts the input array and returns the
       number of inversions in the array */
    static int mergeSort(int arr[], int array_size)
    {
        int temp[] = new int[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }

    public int countInversions(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();
        return countInversions(A, temp, 0, A.size() - 1);
    }

    public int countInversions(ArrayList<Integer> A, ArrayList<Integer> temp, int l, int r){
        int count = 0;
        if(r > l) {
            int mid = (l + r) / 2;

            count = countInversions(A, temp, l, mid);
            count += countInversions(A, temp, mid + 1, r);

            count += merge(A, temp, l,mid + 1, r);
        }

        return count;

    }


    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    static int _mergeSort(int arr[], int temp[], int left, int right)
    {
        int mid, inv_count = 0;
        if (right > left)
        {
        /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left)/2;

        /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
            inv_count  = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid+1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    public int merge(ArrayList<Integer> arr, ArrayList<Integer> temp, int left, int mid, int right){
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr.get(i) <= arr.get(j))
            {
                temp.add(arr.get(i++));
                k++;
            }
            else
            {
                temp.add(arr.get(j++));
                k++;

                inv_count = inv_count + (mid - i);
            }
        }

        while (i <= mid - 1) {
            temp.add(arr.get(i++));
            k++;
        }

        while (j <= right){
            temp.add(arr.get(j++));
            k++;
        }

        for (i=left; i <= right; i++)
            arr.set(i, temp.get(i));

        return inv_count;
    }







    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    static int merge(int arr[], int temp[], int left, int mid, int right)
    {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];

                /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

      /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

      /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }

    /*// Driver method to test the above function
    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 20, 6, 4, 5};
        System.out.println("Number of inversions are " + mergeSort(arr, 5));

    }*/
}
