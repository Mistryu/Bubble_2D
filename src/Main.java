import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test cases
//        int[][] arr = {{9, 8, 7, 6, 5, 4}, {19, 18, 17, 17, 15, 14}, {24, 25, 26, 27, 28, 29}, {0, 1, 2, 3, 30, 100}};
//        int[][] arr1 = {{1, 1, 1, 1}, {0, 0, 0, 0}};
//        int[][] arr2 = {{0, 0}, {0, 0}};
//        int[][] arr3 = {{-1, -10, -15}, {-82, -100, -20}, {20, 1, 0}};
//        int[][] arr4 = {{9, 8, 7, 6, 5}, {19, 18, 17, 16, 15, 14}, {24, 25, 26, 27, 28, 29}, {0, 1, 2, 3, 30, 100}};
//        System.out.println(Arrays.deepToString(bubble_2D(arr)));
//        System.out.println(Arrays.deepToString(bubble_2D(arr1)));
//        System.out.println(Arrays.deepToString(bubble_2D(arr2)));
//        System.out.println(Arrays.deepToString(bubble_2D(arr3)));
//        System.out.println(Arrays.deepToString(new int[2][2]));
//        System.out.println(Arrays.deepToString(bubble_2D(new int[1][1])));
//        System.out.println(Arrays.deepToString(bubble_2D(new int[2][1])));


//        //Tests that throw an exception
//        System.out.println(Arrays.deepToString(bubble_2D(arr4)));
//        System.out.println(Arrays.deepToString(bubble_2D(null)));
//        System.out.println(Arrays.deepToString(bubble_2D(new int[][]{{}, {}, {}})));
//        System.out.println(Arrays.deepToString(bubble_2D(new int[0][0])));
//        System.out.println(Arrays.deepToString(bubble_2D(new int[0][1])));
//        System.out.println(Arrays.deepToString(bubble_2D(new int[1][0])));
    }

    /* This method takes an int[][] array that cannot be null, have different length of sets or contain empty sets
     *  If any of the above cases happen than the method throws IllegalArgumentException
     *
     * This method works on a principle of Bubble sort and achieves O(n^2)
     * It treats the 2D array as 1D one
     * We iterate through it from [0][0] -> ending_point[x][y]
     * The ending point starts at the last element of the last set and goes to [0][0]
     * This is what allows us to achieve Bubble sort speed since we reduce the number of elements
     * When ending_point reaches [0][0] the method returns sorted array
     * The array is sorted from small -> big
     *
     * */

    private static int[][] bubble_2D(int[][] arr) {

        if (arr == null || Arrays.deepEquals(arr, new int[0][0])){
            throw new IllegalArgumentException("Array provided was null or contained no elements");
        }
        if (Arrays.deepEquals(arr, new int[1][1])) return arr;

        int length = arr.length;
        int length_of_el = arr[0].length;   //All elements have the same length
        int[] ending_point = {length - 1, length_of_el - 1};   //This is the place in arr we need to end at iterations

        if (length_of_el == 0) throw new IllegalArgumentException("Elements of the array cannot be null");

        for (int[] a : arr) {
            if (a.length != length_of_el) throw new IllegalArgumentException("Elements of the array cannot have different length");
        }

        while (true) {
            for (int i = 0; i <= ending_point[0]; i++) {
                for (int j = 0; j < length_of_el; j++) {
                    if (i == ending_point[0] && j == ending_point[1]) {
                        break;
                    }
                    //for cases where we need to switch between 2 rows (last item of arr[1] and first of arr[i+1])
                    if ((j + 1 == length_of_el) && (i + 1 != length) && arr[i][j] > arr[i + 1][0]) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i + 1][0];
                        arr[i + 1][0] = temp;
                        break;
                        // Checking the next element like in simple Bubble sort
                    } else if ((j + 1 != length_of_el) && arr[i][j] > arr[i][j + 1]) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][j + 1];
                        arr[i][j + 1] = temp;
                    }
                }
            }
            ending_point[1]--;

            if (ending_point[0] == 0 && ending_point[1] == 0) { // We went through the entire array and it's sorted
                return arr;
            }
            if (ending_point[1] < 0) {   // Changing the ending point to a smaller one
                ending_point[0]--;
                ending_point[1] = length_of_el;
            }
        }
    }

}