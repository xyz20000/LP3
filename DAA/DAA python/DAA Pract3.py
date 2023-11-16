def fractional_knapsack(weights, values, capacity):
    n = len(weights)
    # Calculate the value-to-weight ratio for each item
    value_per_weight = [(values[i] / weights[i], weights[i], values[i]) for i in range(n)]
    # Sort items based on the value-to-weight ratio in descending order
    value_per_weight.sort(reverse=True)

    total_value = 0.0
    knapsack = [0.0] * n

    for i in range(n):
        if capacity == 0:
            break

        ratio, weight, value = value_per_weight[i]
        # Take the whole item if it fits
        if weight <= capacity:
            knapsack[i] = 1.0
            total_value += value
            capacity -= weight
        else:
            # Take a fraction of the item
            fraction = capacity / weight
            knapsack[i] = fraction
            total_value += fraction * value
            capacity = 0

    return total_value, knapsack

# Get user input
n = int(input("Enter the number of items: "))
weights = []
values = []

for i in range(n):
    weight = float(input(f"Enter the weight of item {i + 1}: "))
    value = float(input(f"Enter the value of item {i + 1}: "))
    weights.append(weight)
    values.append(value)

capacity = float(input("Enter the capacity of the knapsack: "))

# Calculate and display the result
max_value, knapsack_items = fractional_knapsack(weights, values, capacity)

print("\nMaximum value in the knapsack:", max_value)
print("Fraction of each item in the knapsack:", knapsack_items)
