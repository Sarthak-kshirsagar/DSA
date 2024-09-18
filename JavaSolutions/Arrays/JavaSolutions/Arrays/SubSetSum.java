package JavaSolutions.Arrays;

import java.util.*;

class SubSetSum {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ds = new ArrayList<Integer>();
        subSetSum(arr, 0, ds, ans);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    static void subSetSum(int[] arr, int index, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> answer) {

        if (index >= arr.length) {
            answer.add(new ArrayList(ds));
            return;
        }

        if (index < arr.length) {
            ds.add(arr[index]);
            subSetSum(arr, index + 1, ds, answer);
            ds.remove(ds.size() - 1);
        }
        subSetSum(arr, index + 1, ds, answer);
    }
}