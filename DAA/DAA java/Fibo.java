import java.util.Scanner;
//FibonacciNonRecursive
public class Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.print(fibonacciNonRecursive(i)+" ");
        }
        System.out.println();
        System.out.println("Fibonacci(" + n + "): " + fibonacciNonRecursive(n));
    }

    static int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 0, prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }
        
        
        return fib;
    }
}

/*
//FibonacciRecursive
public class Fibo {
    public static void main(String[] args) {
        int n = 10; // You can change this value to calculate Fibonacci for a different number
        System.out.println("Fibonacci(" + n + "): " + fibonacciRecursive(n));
    }

    static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}

 */

/*
Time Complexity Analysis:

Non-Recursive (Iterative) Program:
Time Complexity: O(n)
The loop runs 'n' times, where 'n' is the input value.
Each iteration takes constant time.

Recursive Program:
Time Complexity: O(2^n) [exponential]
The recurrence relation is T(n) = T(n-1) + T(n-2), which leads to an exponential time complexity.
The recursive tree branches out exponentially, resulting in repeated calculations for the same Fibonacci numbers.
___________
Space Complexity Analysis:

Non-Recursive (Iterative) Program:
Space Complexity: O(1)
The iterative approach uses a constant amount of extra space regardless of the input.

Recursive Program:
Space Complexity: O(n) [for the call stack]
The recursive approach builds up a call stack, and in the worst case, the maximum depth of the stack is 'n'.
Each recursive call consumes space on the call stack.
**************************
The non-recursive (iterative) approach is more efficient in terms of both time and space complexity compared to the recursive approach, especially for larger values of 'n'.
The recursive approach has an exponential time complexity due to repeated calculations, making it less efficient.
Both programs have a linear space complexity in the worst case, but the recursive approach has a higher constant factor due to the call stack.
 */
