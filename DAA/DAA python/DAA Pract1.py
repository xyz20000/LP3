'''def fibonacci_iterative(n):
    if n<=1:
        return n
    
    prev, current = 0,1
    for i in range(2, n+1):
        prev, current =current, prev + current

    return current

n=int(input("Enter the number: "))
print(f"The {n}th fibonacci number (iterative): {fibonacci_iterative(n)}")

'''
def fibonacci_recursive(n):
    if n <= 1:
        return n
    return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2)

n=int(input("Enter the number"))
print(f"The {n}th fibonacci number (recursive): {fibonacci_recursive(n)}")