package Assignment;

import java.util.Scanner;

public class Eighth {

    // Method to find the kth largest element in the array
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    // Helper method to perform the QuickSelect algorithm
    static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // Partition the array around the pivot
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        int count = high - pivot + 1; // Count of elements greater than or equal to pivot

        if (count == k) return nums[pivot]; // Found the kth largest element
        if (count > k) return quickSelect(nums, pivot + 1, high, k); // Search in the right partition
        return quickSelect(nums, low, pivot - 1, k - count); // Search in the left partition
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of elements in the array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Taking input for the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking input for the value of k
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Finding and printing the kth largest element
        int ans = findKthLargest(arr, k);
        System.out.println("The " + k + "th largest element is: " + ans);

        scanner.close();
    }
}
