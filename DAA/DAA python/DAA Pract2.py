from collections import Counter

class Node:
    def __init__(self, freq, symbol):
        self.left = None
        self.right = None
        self.freq = freq
        self.symbol = symbol

def huffman_encoding(data):
    freq = Counter(data)
    priority_queue = [Node(f, s) for s, f in freq.items()]
    while len(priority_queue) > 1:
        priority_queue = sorted(priority_queue, key=lambda x: x.freq)
        left = priority_queue.pop(0)
        right = priority_queue.pop(0)
        new_node = Node(left.freq + right.freq, None)
        new_node.left = left
        new_node.right = right
        priority_queue.append(new_node)
    
    root = priority_queue[0]
    codes = {}
    def generate_codes(node, code=''):
        if node:
            if node.symbol:
                codes[node.symbol] = code
            generate_codes(node.left, code + '0')
            generate_codes(node.right, code + '1')
    
    generate_codes(root)
    
    encoded_data = ''.join([codes[s] for s in data])
    
    return encoded_data, codes

def huffman_decoding(encoded_data, codes):
    reverse_codes = {v: k for k, v in codes.items()}
    decoded_data = ''
    code = ''
    for bit in encoded_data:
        code += bit
        if code in reverse_codes:
            decoded_data += reverse_codes[code]
            code = ''
    
    return decoded_data

# Example usage:
data = str (input("Enter the string: "))
#data = "huffman_encoding_example"
encoded_data, codes = huffman_encoding(data)
print("Encoded data:", encoded_data)
decoded_data = huffman_decoding(encoded_data, codes)
print("Decoded data:", decoded_data)
