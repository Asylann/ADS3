# Algorithms and Data Structures 3-Assignment

This repository showcases custom implementations of two fundamental data structures: **MyHashTable** and **Binary Search Tree (BST)**. The implementation focuses on efficient data storage, retrieval, and management.

---

## MyHashTable<K, V>

A custom hash table that stores key-value pairs using an array of chains (linked lists).

### Features:
- **Custom Hashing**: A custom `hash()` function to compute bucket indexes.
- **Core Methods**:
  - `put(K key, V value)` – Adds a key-value pair to the table.
  - `get(K key)` – Retrieves the value for a given key.
  - `remove(K key)` – Removes the key-value pair from the table.
  - `contains(K key)` – Checks if the key exists in the table.
  - `getKey(V value)` – Retrieves the key for the provided value.
  
### Testing:
- **MyTestingClass**: A class with an `id` field, specifically designed for generating random keys.
- **Uniform Distribution**: 10,000 random entries were used to test the bucket distribution, ensuring balanced key placement.

---

## MyTestingClass

A helper class designed to test the performance of the **MyHashTable**.

### Key Features:
- **Field**: Contains a simple `id` field for key generation.
- **Custom Hashing**: Implements its own `hashCode()` method to ensure a uniform distribution of keys (avoiding `Objects.hash()`).
- **Random ID Generation**: Random `id`s are used to create test keys for hash table operations.

---

## Binary Search Tree (BST) <K, V>

A non-recursive implementation of a binary search tree (BST), providing efficient data insertion, deletion, and retrieval.

### Features:
- **Core Methods**:
  - `put(K key, V value)` – Adds a key-value pair to the tree.
  - `get(K key)` – Retrieves the value associated with the key.
  - `delete(K key)` – Deletes a node with the specified key.
- **Traversal**:
  - **In-order Iterator**: Provides an iterator for in-order traversal of the tree (non-recursive).
  - **Size**: The `size()` method counts the total number of nodes in the tree.
  - During iteration, both the key and value can be accessed.

## Test Coverage

- 10,000 random entries were used to ensure the functionality of the hash table.
- The **BST** was tested for various operations such as putting, deleting, and in-order travelsal to ensure correctness and performance.
