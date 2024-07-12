package Assignment;

import java.util.*;

public class First {
    // Node class to represent each key-value pair in the cache
    class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    Node head = new Node(0, 0), tail = new Node(0, 0);  // Dummy head and tail nodes
    Map<Integer, Node> map = new HashMap<>();  // Map to store key and corresponding Node
    int capacity;  // Capacity of the cache

    // Constructor to initialize the cache with a given capacity
    public First(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    // Function to get the value of the given key if present in the cache
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);  // Remove the node from its current position
            insert(node);  // Insert the node at the head
            return node.value;
        } else {
            return -1;  // Return -1 if the key is not present in the cache
        }
    }

    // Function to insert or update a key-value pair in the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));  // Remove the existing node
        }
        if (map.size() == capacity) {
            remove(tail.prev);  // Remove the least recently used node
        }
        insert(new Node(key, value));  // Insert the new node at the head
    }

    // Function to remove a node from the doubly linked list
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Function to insert a node at the head of the doubly linked list
    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the capacity of the cache from the user
        System.out.print("Enter the capacity of the cache: ");
        int capacity = scanner.nextInt();

        First cache = new First(capacity);

        // Provide options to the user to interact with the cache
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Put a key-value pair");
            System.out.println("2. Get a value by key");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Take key-value pair input from the user
                System.out.print("Enter key: ");
                int key = scanner.nextInt();
                System.out.print("Enter value: ");
                int value = scanner.nextInt();
                cache.put(key, value);
                System.out.println("Key-value pair inserted/updated.");
            } else if (choice == 2) {
                // Take key input from the user and get the value
                System.out.print("Enter key: ");
                int key = scanner.nextInt();
                int value = cache.get(key);
                if (value == -1) {
                    System.out.println("Key not found.");
                } else {
                    System.out.println("Value: " + value);
                }
            } else if (choice == 3) {
                // Exit the loop
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
