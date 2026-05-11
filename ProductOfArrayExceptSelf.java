public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
        int[] res1 = sol.productExceptSelf(new int[]{1,2,3,4});
        System.out.print("Test 1: ");
        for (int x : res1) System.out.print(x + " ");
        System.out.println();
        int[] res2 = sol.productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.print("Test 2: ");
        for (int x : res2) System.out.print(x + " ");
        System.out.println();
    }
}
