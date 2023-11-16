// Java program to solve fractional Knapsack Problem
 
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;    //import scanner class
 
// Greedy approach
public class Fract_knapsack {     
    // Function to get maximum value
    private static double getMaxValue(ItemValue[] arr,int capacity) 
    //calculates the maximum value that can be obtained using a greedy approach for the Fractional Knapsack 
    //It takes an array of ItemValue objects (arr) and the capacity of the knapsack (capacity) as parameters.
    {
        // Sorting items by profit/weight ratio;
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1,ItemValue item2)
            {
                double cpr1 = Double.valueOf(item1.profit / item1.weight);
                double cpr2 = Double.valueOf(item2.profit / item2.weight);

                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });
 
        double totalValue = 0d;
 
        for (ItemValue i : arr) {
 
            int curWt = (int)i.weight;
            int curVal = (int)i.profit;
 
            if (capacity - curWt >= 0) {
 
                // This weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
 
                // Item cant be picked whole
                double fraction= ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity= (int)(capacity - (curWt * fraction));
                break;
            }
        }
 
        return totalValue;
    }
 
    // Item value class
    static class ItemValue {
 
        int profit, weight;
 
        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.profit = val;
        }
    }
 
    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of items:");
        int n = scanner.nextInt();

        ItemValue[] arr = new ItemValue[n];

        System.out.println("Enter the profit and weight for each item:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Profit: ");
            int profit = scanner.nextInt();

            System.out.print("Item " + (i + 1) + " - Weight: ");
            int weight = scanner.nextInt();

            arr[i] = new ItemValue(profit, weight);
        }

        System.out.println("Enter the knapsack capacity:");
        int capacity = scanner.nextInt();

        double maxValue = getMaxValue(arr, capacity);

        // Print the result
        System.out.println("Maximum value that can be obtained: " + maxValue);

        // Close the scanner
        scanner.close();
        //It then calculates and displays the maximum value that can be obtained using the provided inputs.
    }
}

//The output 240.0 indicates the maximum value that can be obtained with the given items and knapsack capacity.