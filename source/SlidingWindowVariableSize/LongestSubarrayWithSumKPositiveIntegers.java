package SlidingWindowVariableSize;

public class LongestSubarrayWithSumKPositiveIntegers {

    public int longestSubarrayWithSumKPositiveIntegers(int[] arr, int k){
        int longestSubarray = 0;
        int n = arr.length;

        int left=0;
        int sum=0;

        for(int i=0; i<n; i++){
            sum = sum + arr[i];

            if(sum==k){
                longestSubarray = Math.max(longestSubarray, i-left+1);
            }

            while(sum>k){
                sum = sum - arr[left];
                left++;
            }
        }

        return longestSubarray;
    }

    static void main(){
        LongestSubarrayWithSumKPositiveIntegers longestSubarrayWithSumKPositiveIntegers = new LongestSubarrayWithSumKPositiveIntegers();
        int testCases = 0;
        int passed = 0;

        testCases++;
        if(longestSubarrayWithSumKPositiveIntegers.longestSubarrayWithSumKPositiveIntegers(new int[]{3,1,2},3)==2){
            passed++;
        }

        testCases++;
        if(longestSubarrayWithSumKPositiveIntegers.longestSubarrayWithSumKPositiveIntegers(new int[]{3,1,2,0},3)==3){
            passed++;
        }

        System.out.println(passed+"/"+testCases);
    }
}
