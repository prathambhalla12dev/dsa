package hashingPrefixSum;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysWithSumK {

    public int numberOfSubarraysWithSumK(int[] arr, int k){
        int n = arr.length;
        int numberOfSubarraysWithSumK = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int currentSum = 0;
        prefixSumMap.put(currentSum,1);

        for(int i=0; i<n; i++){
            currentSum = currentSum + arr[i];

            int complement = currentSum - k;

            Integer numberOfIndexes = prefixSumMap.get(complement);

            if(numberOfIndexes != null){
                numberOfSubarraysWithSumK = numberOfSubarraysWithSumK + numberOfIndexes;
            }

            Integer totalNumberOfTimesCurrentSumAppeared = prefixSumMap.get(currentSum);
            prefixSumMap.put(currentSum, totalNumberOfTimesCurrentSumAppeared != null ? totalNumberOfTimesCurrentSumAppeared + 1 : 1);
        }

        return numberOfSubarraysWithSumK;
    }

    static void main(){
        NumberOfSubarraysWithSumK numberOfSubarraysWithSumK = new NumberOfSubarraysWithSumK();
        int testCases = 0;
        int passed = 0;

        // All Elements 0 and K = 0
        testCases++;
        if(numberOfSubarraysWithSumK.numberOfSubarraysWithSumK(new int[]{0,0,0,0},0) == 10){
            passed++;
        }

        // All Elements 0 and K = 1
        testCases++;
        if(numberOfSubarraysWithSumK.numberOfSubarraysWithSumK(new int[]{0,0,0,0},1) == 0){
            passed++;
        }

        testCases++;
        if(numberOfSubarraysWithSumK.numberOfSubarraysWithSumK(new int[]{1,2,3,-1,1},3) == 3){
            passed++;
        }

        testCases++;
        if(numberOfSubarraysWithSumK.numberOfSubarraysWithSumK(new int[]{1,2,2,-5,2,3,-5,5},5) == 6){
            passed++;
        }

        System.out.println(passed+"/"+testCases);
    }
}
