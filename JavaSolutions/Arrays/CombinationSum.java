package JavaSolutions.Arrays;

import java.util.*;

class CombinationSum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        combinationSum(arr, 0, 0, ds, 7, ans);
        for (ArrayList<Integer> combination : ans) {
            System.out.println(combination);
        }
    }

    static void combinationSum(int[] arr, int sum, int index, ArrayList<Integer> ds, int target,
            ArrayList<ArrayList<Integer>> answer) {

        if (sum == target) {
            answer.add(new ArrayList<>(ds));
            return;
        }

        if (index >= arr.length) {
            return;
        }

        if (sum < target) {
            ds.add(arr[index]);
            combinationSum(arr, sum + arr[index], index, ds, target, answer);
            ds.remove(ds.size() - 1);
        }

        combinationSum(arr, sum, index + 1, ds, target, answer);
    }
}
