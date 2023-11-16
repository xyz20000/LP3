#include <iostream>
#include <queue>
#include <unordered_map>
using namespace std;

// Huffman tree node structure
struct HuffmanNode {
    char data;
    unsigned frequency;
    HuffmanNode *left, *right;

    HuffmanNode(char data, unsigned frequency) : data(data), frequency(frequency), left(nullptr), right(nullptr) {}
};

// Comparison function for the priority queue
struct CompareNodes {
    bool operator()(HuffmanNode* lhs, HuffmanNode* rhs) const {
        return lhs->frequency > rhs->frequency;
    }
};

// Function to generate Huffman codes for each character
void generateCodes(HuffmanNode* root, string code, unordered_map<char, string>& codes) {
    if (!root)
        return;

    if (root->data != '\0') {
        codes[root->data] = code;
    }

    generateCodes(root->left, code + "0", codes);
    generateCodes(root->right, code + "1", codes);
}

// Function to construct the Huffman tree and generate codes
void huffmanEncoding(const string& text) {
    unordered_map<char, unsigned> frequency;
    for (char ch : text) {
        frequency[ch]++;
    }

    priority_queue<HuffmanNode*, vector<HuffmanNode*>, CompareNodes> pq;

    for (const auto& pair : frequency) {
        pq.push(new HuffmanNode(pair.first, pair.second));
    }

    while (pq.size() != 1) {
        HuffmanNode *left = pq.top();
        pq.pop();

        HuffmanNode *right = pq.top();
        pq.pop();

        unsigned sumFreq = left->frequency + right->frequency;
        HuffmanNode* newNode = new HuffmanNode('\0', sumFreq);
        newNode->left = left;
        newNode->right = right;

        pq.push(newNode);
    }

    HuffmanNode* root = pq.top();

    unordered_map<char, string> codes;
    generateCodes(root, "", codes);

    cout << "Huffman Codes:" << endl;
    for (const auto& pair : codes) {
        cout << pair.first << " : " << pair.second << endl;
    }
}

int main() {
    string input;
    cout << "Enter a string: ";
    getline(cin, input);

    huffmanEncoding(input);

    return 0;
}
