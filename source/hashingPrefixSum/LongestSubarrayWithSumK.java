package hashingPrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    public int longestSubarrayWithSumK(int[] arr, int k){
        int n = arr.length;
        int longestSubarrayWithSumK = 0;

        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,-1);

        int currentSum = 0;

        for(int i=0; i<n; i++){ // O(n) time
            currentSum = currentSum + arr[i];
            int complement = currentSum - k;

            Integer indexWherePrefixSumIsEqualToComplement = prefixSumMap.get(complement);

            if(indexWherePrefixSumIsEqualToComplement != null){
                longestSubarrayWithSumK = Math.max(longestSubarrayWithSumK, i - indexWherePrefixSumIsEqualToComplement);
            }

            if(!prefixSumMap.containsKey(currentSum)){
                prefixSumMap.put(currentSum,i);
            }
        }

        return longestSubarrayWithSumK;
    }
    // Space Complexity: O(n) as prefixSumMap will take max n+1 keys -- if prefixSum at each index is unique and 0 before beginning

    static void main(){

        LongestSubarrayWithSumK longestSubarrayWithSumK = new LongestSubarrayWithSumK();
        int testCases = 0;
        int passed = 0;

        // All Elements 0 and K = 0
        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{0,0,0},0) == 3){
            passed++;
        }

        // All Elements 0 and k!=0
        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{0,0,0},1) == 0){
            passed++;
        }

        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{0,0,0},-9) == 0){
            passed++;
        }

        //One Element and K != that Element
        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{1},2) == 0){
            passed++;
        }

        //One Element and K = that Element
        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{2},2) == 1){
            passed++;
        }

        // Sum = K comes earlier but short subarray
        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{1,2,1,1,1},3) == 3){
            passed++;
        }

        // Negative Numbers
        testCases++;
        if(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{1,2,-1,-2,3},3) == 5){
            passed++;
        }

        System.out.println(passed+"/"+testCases);
    }
}
