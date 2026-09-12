import java.util.HashMap;

public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum = currentSum + num;

            int requiredSum = currentSum - k;

            if (map.containsKey(requiredSum)) {
                count = count + map.get(requiredSum);
            }

            // Store/update current prefix sum
            if (map.containsKey(currentSum)) {
                map.put(currentSum, map.get(currentSum) + 1);
            } else {
                map.put(currentSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}