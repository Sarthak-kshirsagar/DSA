import java.util.*;

class SubSequencesWithTargetSum {
    public static void main(String[] args) {

        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        printSubSequencesWithTargetSum(arr, 8, 0, 0, ds, answer);
        // printing the answer
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

    }

    static void printSubSequencesWithTargetSum(int[] arr, int target, int sum, int index, ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        if (sum > target || index > arr.length - 1) {
            return;
        }
        if (sum < target) {
            sum = sum + arr[index];
            ds.add(arr[index]);
            printSubSequencesWithTargetSum(arr, target, sum, index + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }
        printSubSequencesWithTargetSum(arr, target, sum - arr[index], index + 1, ds, ans);

    }
}