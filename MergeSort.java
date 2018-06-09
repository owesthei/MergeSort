import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = createArray();

        showArray(nums);

        mergeSort(nums, 0, nums.length);
 
        showArray(nums);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (high - low < 2) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(nums, low, middle);
        mergeSort(nums, middle, high);

        merge(nums, low, middle, high);
    }

    private static void merge(int[] nums, int low, int middle, int high) {
        if (nums[middle - 1] <= nums[middle]) {
            return;
        }

        int i = low;
        int j = middle;
        int k = 0;

        int[] tmpArray = new int[high - low];

        while (i < middle && j < high) {
            tmpArray[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        int l = k;

        while (i < middle) {
            nums[low + l++] = nums[i++];
        }

        for (int m = 0; m < k; m++) {
            nums[low + m] = tmpArray[m];
        }

        // System.arraycopy(nums, i, nums, low + k, middle - i);
        // System.arraycopy(tmpArray, 0, nums, low, k);
    }

    private static int[] createArray() {
        Random random = new Random();

        int[] nums = new int[20];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000) - 500;
        }

        return nums;
    }

    private static void showArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}