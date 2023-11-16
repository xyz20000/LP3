import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

//HuffmanNode class representing nodes in the Huffman tree.
//Implements the Comparable interface to enable sorting based on frequency.
class HuffmanNode implements Comparable<HuffmanNode> {
    //Each node has a data (character), frequency, and references to its left and right children.
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class Huffman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string to encode:");
        String inputString = scanner.nextLine();

        HashMap<Character, String> huffmanCodes = buildHuffmanCodes(inputString);

        System.out.println("Huffman Codes:");
        huffmanCodes.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static HashMap<Character, String> buildHuffmanCodes(String input) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        //Create a frequencyMap to store the frequency of each character in the input string.
        //Use a PriorityQueue to build the Huffman tree based on character frequencies.

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        frequencyMap.forEach((key, value) -> priorityQueue.add(new HuffmanNode(key, value)));
        //Iterate over the frequency map, adding nodes to the priority queue.
        //Build the Huffman tree by repeatedly combining the two least frequent nodes.
        //Generate Huffman codes for each character and store them in a HashMap.
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode internalNode = new HuffmanNode('\0', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            priorityQueue.add(internalNode);
        }

        HuffmanNode root = priorityQueue.poll();
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    //Define the method generateCodes to recursively traverse the Huffman tree and generate Huffman codes.
    //If the node is not null, add the code to the HashMap when reaching a leaf node.
    //Recursively traverse the left and right subtrees with updated codes.
    private static void generateCodes(HuffmanNode node, String code, HashMap<Character, String> huffmanCodes) {
        if (node != null) {
            if (node.data != '\0') {
                huffmanCodes.put(node.data, code);
            }

            generateCodes(node.left, code + "0", huffmanCodes);
            generateCodes(node.right, code + "1", huffmanCodes);
        }
    }
}
//Overall, this program takes an input string, builds a Huffman tree, 
//and generates Huffman codes for each character. The resulting codes are then printed.

//overall TC = O(NlogN),N=number of unique characters in the input string.
// if the input string has a relatively small number of unique characters, 
//such as in the case of English text, the algorithm's time complexity can be considered close to linear 
//O(N) for practical purposes.
//worst-case scenario where every character is unique, the time complexity is O(NlogN)