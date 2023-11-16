def knapsack_dp(weights , values ,capacity):
    n=len(values)
    
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    for i in range(1 , n+1):
        for w in range(1, capacity+1):
            if weights[i-1] <=w:
                dp[i][w] = max(values[i-1] + dp[i-1] [w - weights[i-1]], dp[i-1][w])

            else: 
                dp[i][w] = dp[i-1][w]

    return dp[n][capacity]

n= int(input("Enter the number of items: "))
weights = [int(input(f"Enter the weight of item({i+1}: ")) for i in range(n)]
values = [int(input(f"Enter the value of item {i+1}: ")) for i in range(n)]
capacity = int(input("Enter the knapsack capacity: "))

result = knapsack_dp(weights , values , capacity)

print(f"The maximum value that can be obtained is: {result}")