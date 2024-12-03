public class QuickSort
{
    int partition(int[] arr, String[] keys, int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                String tempKey = keys[i];
                arr[i] = arr[j];
                keys[i] = keys[j];
                arr[j] = temp;
                keys[j] = tempKey;
            }
        }

        int temp = arr[i+1];
        String tempKey = keys[i+1];
        arr[i+1] = arr[high];
        keys[i+1] = keys[high];
        arr[high] = temp;
        keys[high] = tempKey;

        return i+1;
    }


    /* The main function that implements QuickSort()
      a[] --> Array to be sorted,
      l  --> Starting index,
      h  --> Ending index */
    void sort(int[] values, String[] keys, int l, int h)
    {
        if (l < h)
        {
            int pi = partition(values, keys, l, h);

            // Recursively sort elements before
            // partition and after partition
            sort(values, keys, l,pi-1);
            sort(values, keys,pi+1, h);
        }
    }
}