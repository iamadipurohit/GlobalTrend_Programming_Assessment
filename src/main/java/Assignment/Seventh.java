package Assignment;

import java.util.*;

class Seventh {

    // Function to calculate the maximum area
    public static int maxArea(int A[], int len) {
        int l = 0;  // Initialize left pointer
        int r = len - 1;  // Initialize right pointer
        int area = 0;  // Initialize the maximum area

        // Loop until the left pointer is less than the right pointer
        while (l < r) {
            // Calculate the maximum area and update if the current area is larger
            area = Math.max(area, Math.min(A[l], A[r]) * (r - l));

            // Move the pointer pointing to the shorter line towards the center
            if (A[l] < A[r])
                l += 1;
            else
                r -= 1;
        }
        return area;  // Return the maximum area
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the first array
        System.out.println("Enter the number of elements in the first array:");
        int len1 = scanner.nextInt();
        int a[] = new int[len1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < len1; i++) {
            a[i] = scanner.nextInt();
        }

        // Taking input for the second array
        System.out.println("Enter the number of elements in the second array:");
        int len2 = scanner.nextInt();
        int b[] = new int[len2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < len2; i++) {
            b[i] = scanner.nextInt();
        }

        // Calculating and printing the maximum area for both arrays
        System.out.println("Maximum area for the first array: " + maxArea(a, len1));
        System.out.println("Maximum area for the second array: " + maxArea(b, len2));

        scanner.close();  // Close the scanner to avoid resource leaks
    }
}
