import java.util.*;

class Solution {
    /**
     * Finds the maximum of each subarray of size k in the given array.
     * Uses a Deque (Double-ended Queue) to efficiently maintain the maximum in O(n) time.
     *
     * @param arr The input array
     * @param k   The size of the subarray
     * @return An ArrayList containing the maximum of each subarray of size k
     */
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        int n = arr.length; // Get the size of the array
        ArrayList<Integer> ans = new ArrayList<>(); // To store the maximums
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices of elements

        for (int i = 0; i < n; i++) {
            // Remove elements from the deque that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst(); // Remove the front element (oldest in the window)
            }

            // Remove elements from the back of deque if they are smaller than the current element
            // because they will never be the maximum
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast(); // Remove smaller elements from the back
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // Once we reach index (k-1) or greater, add the max of the current window to the answer
            if (i >= k - 1) {
                ans.add(arr[deque.peekFirst()]); // The element at deque's front is the max of the window
            }
        }
        return ans; // Return the list of maximums for each subarray
    }

    /**
     * Main method for testing the maxOfSubarrays function.
     */
    public static void main(String[] args) {
        Solution obj = new Solution(); // Create an instance of the Solution class

        // Sample input array
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // Window size

        // Call the function and store the result
        ArrayList<Integer> result = obj.maxOfSubarrays(arr, k);

        // Print the output
        System.out.println("Maximum of each subarray of size " + k + ": " + result);
    }
}
