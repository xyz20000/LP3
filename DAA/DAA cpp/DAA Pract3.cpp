//Fractional knapsack
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Item {
    int weight;
    int value;
    double ratio; // Value per weight ratio
};

// Comparator function to sort items based on value per weight ratio
bool compare(Item a, Item b) {
    return a.ratio > b.ratio;
}

double fractionalKnapsack(int capacity, vector<Item>& items) {
    // Sort items based on value per weight ratio
    sort(items.begin(), items.end(), compare);

    double totalValue = 0.0;

    for (auto& item : items) {
        if (capacity >= item.weight) {
            // If the whole item can be taken
            totalValue += item.value;
            capacity -= item.weight;
        } else {
            // Take the fraction of the item
            double fraction = (double)capacity / item.weight;
            totalValue += item.value * fraction;
            break;
        }
    }

    return totalValue;
}

int main() {
    int numItems, capacity;
    cout << "Enter the number of items: ";
    cin >> numItems;

    vector<Item> items(numItems);

    cout << "Enter the weight and value for each item:\n";
    for (int i = 0; i < numItems; ++i) {
        cout << "Item " << i + 1 << " Weight: ";
        cin >> items[i].weight;
        cout << "Item " << i + 1 << " Value: ";
        cin >> items[i].value;
        items[i].ratio = (double)items[i].value / items[i].weight;
    }

    cout << "Enter the capacity of the knapsack: ";
    cin >> capacity;

    double maxValue = fractionalKnapsack(capacity, items);

    cout << "The maximum value that can be obtained = " << maxValue << endl;

    return 0;
}
