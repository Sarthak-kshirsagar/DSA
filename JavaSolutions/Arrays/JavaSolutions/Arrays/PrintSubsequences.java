package JavaSolutions.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

class PrintSubSequences {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            array.add(temp);
        }
        sc.close();
        System.out.println("Array created");

        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        printSubSequences(0, array, ds, answer);
        System.out.println("");
        System.out.println("Printing the subsequences");
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    static void printSubSequences(int index, ArrayList<Integer> array, ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> answer) {
        // base case
        if (index >= array.size()) {
            // new ds is always added in the answer
            answer.add(new ArrayList<>(ds));
            return;
        }
        // pick a element
        ds.add(array.get(index));
        printSubSequences(index + 1, array, ds, answer);
        // do not pick a element
        ds.remove(array.get(index));
        printSubSequences(index + 1, array, ds, answer);
    }

}