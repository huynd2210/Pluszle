package solver.perfectsum;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumSolver {
    private boolean dp[][] ;

    private List<List<ObjectWithInteger>> solution;

    public List<List<ObjectWithInteger>> getSolution(){
        return this.solution;
    }

    public SubsetSumSolver(List<ObjectWithInteger> list, int sum){
        this.solution = new ArrayList<>();
        getAllSubset(list, list.size(), sum);
    }

    private void getSubset(List<ObjectWithInteger> list, int index, int sum, List<ObjectWithInteger> partialResult){
        if (index == 0 && sum != 0 && dp[0][sum])
        {
            partialResult.add(list.get(index));
            solution.add(partialResult);
            return;
        }

        // If sum becomes 0
        if (index == 0 && sum == 0)
        {
            solution.add(partialResult);
            return;
        }

        // If given sum can be achieved after ignoring
        // current element.
        if (dp[index-1][sum])
        {
            // Create a new vector to store path
            List<ObjectWithInteger> b = new ArrayList<>();
            b.addAll(partialResult);
            getSubset(list, index-1, sum, b);
        }

        // If given sum can be achieved after considering
        // current element.
        if (sum >= list.get(index).getInteger() && dp[index-1][sum-list.get(index).getInteger()])
        {
            partialResult.add(list.get(index));
            getSubset(list, index-1, sum-list.get(index).getInteger(), partialResult);
        }
    }

    private void getAllSubset(List<ObjectWithInteger> list, int index, int sum){
        if (index == 0 || sum < 0)
            return;
        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[index][sum + 1];
        for (int i=0; i<index; ++i) {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (list.get(0).getInteger() <= sum)
            dp[0][list.get(0).getInteger()] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < index; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (list.get(i).getInteger() <= j) ? (dp[i-1][j] ||
                        dp[i-1][j-list.get(i).getInteger()])
                        : dp[i - 1][j];


        if (!dp[index - 1][sum]) {
            System.out.println("There are no subsets with" +
                    " sum "+ sum);
            return;
        }

        // Now recursively traverse dp[][] to find all
        // paths from dp[n-1][sum]
        List<ObjectWithInteger> p = new ArrayList<>();
        getSubset(list, index-1, sum, p);
    }
}
