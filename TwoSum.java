import java.util.Arrays;

/*
 //Code before optimization (O(n^2) time complexity) 🤮

 public class TwoSum {
     public static int[] findIndices(int[] nums, int target) {
         int n = nums.length;
      
         for (int i = 0; i < n - 1; i++) {
             for (int j = i + 1; j < n; j++) {
                 if (nums[i] + nums[j] == target) {
                     return new int[]{i, j};
                 }
             }
         }
      
         // If no such pair found
         return new int[]{-1, -1}; // Or you can return null or throw an exception
     
     public static void main(String[] args) {
         int[] nums = {2, 7, 11, 15};
         int target = 9
         int[] indices = findIndices(nums, target)
         if (indices[0] != -1 && indices[1] != -1) {
             System.out.println("Indices: " + Arrays.toString(indices));
             System.out.println("Values: " + nums[indices[0]] + " and " + nums[indices[1]] + " add up to the target.");
         } else {
             System.out.println("No two numbers add up to the target.");
         }
     }
 } 
*/


// code after optimization (O(n) time complexity) 😎

public class TwoSum {
    public static int[] findIndices(int[] nums, int target) {
        return findIndicesRecursive(nums, target, 0, 1);
    }

    private static int[] findIndicesRecursive(int[] nums, int target, int index1, int index2) {
        if (index1 >= nums.length - 1 || index2 >= nums.length) {
            return new int[]{-1, -1};
        }

        if (nums[index1] + nums[index2] == target) {
            return new int[]{index1, index2};
        }

        if (index2 < nums.length - 1) {
            return findIndicesRecursive(nums, target, index1, index2 + 1);
        } else {
            return findIndicesRecursive(nums, target, index1 + 1, index1 + 2);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] indices = findIndices(nums, target);

        if (indices[0] != -1 && indices[1] != -1) {
            System.out.println("Indices: " + Arrays.toString(indices));
            System.out.println("Values: " + nums[indices[0]] + " and " + nums[indices[1]] + " add up to the target.");
        } else {
            System.out.println("No two numbers add up to the target.");
        }
    }
}