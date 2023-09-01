class Solution {
    int median(int matrix[][], int R, int C) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum values in the matrix
        for (int i = 0; i < R; i++) {
            if (matrix[i][0] < min) {
                min = matrix[i][0];
            }
            if (matrix[i][C - 1] > max) {
                max = matrix[i][C - 1];
            }
        }

        // Binary search for the median
        int desired = (R * C + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;

            // Count the number of elements less than or equal to mid
            for (int i = 0; i < R; i++) {
                count += countSmallerOrEqual(matrix[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    // Helper function to count the number of elements less than or equal to target in a row
    private int countSmallerOrEqual(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

