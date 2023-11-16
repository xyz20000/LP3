#include <iostream>
using namespace std;

int fibonacciRecursive(int n) {
    if (n <= 1)
        return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

int main() {
    cout<<"Enter the number";
    int n;// Change the value of n for different Fibonacci numbers
    cin>>n;
    cout << "Fibonacci(" << n << ") using recursion: " << fibonacciRecursive(n);
    return 0;
}

//Non Recursive
#include <iostream>
using namespace std;
int fibonacciNonRecursive(int n) {
    if (n <= 1)
        return n;

    int prev = 0, current = 1, next = 0;
    for (int i = 2; i <= n; ++i) {
        next = prev + current;
        prev = current;
        current = next;
    }
    return next;
}

int main() {
    cout<<"Enter the number";
    int n = 10; // Change the value of n for different Fibonacci numbers
    cin>>n;
    std::cout << "Fibonacci(" << n << ") using iteration: " << fibonacciNonRecursive(n);
    return 0;
}

