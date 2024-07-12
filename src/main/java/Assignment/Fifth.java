package Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TrieNodeCustom {
    TrieNodeCustom[] children;
    boolean isEndOfWord;

    TrieNodeCustom() {
        children = new TrieNodeCustom[26];
        isEndOfWord = false;
    }
}

class CustomTrie {
    TrieNodeCustom root;

    CustomTrie() {
        root = new TrieNodeCustom();
    }

    // Method to insert a word into the Trie
    void insertWord(String word) {
        TrieNodeCustom currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNodeCustom();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    // Method to search for a word in the Trie
    boolean searchWord(String word) {
        TrieNodeCustom currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }

    // Method to find all words starting with a given prefix
    List<String> startsWith(String prefix) {
        TrieNodeCustom currentNode = root;
        List<String> words = new ArrayList<>();

        // Traverse the Trie till the end of prefix
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return words; // Return empty list if prefix not found
            }
            currentNode = currentNode.children[index];
        }

        // Collect all words starting with the prefix
        collectWords(currentNode, prefix, words);
        return words;
    }

    // Helper method to collect words starting from a given Trie node
    private void collectWords(TrieNodeCustom node, String prefix, List<String> words) {
        if (node == null) {
            return;
        }
        if (node.isEndOfWord) {
            words.add(prefix);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            collectWords(node.children[c - 'a'], prefix + c, words);
        }
    }
}

public class Fifth {
    public static void main(String[] args) {
        CustomTrie customTrie = new CustomTrie();
        Scanner scanner = new Scanner(System.in);

        // Take input words from the user
        System.out.println("Enter the number of words to insert:");
        int numWords = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter the words:");
        for (int i = 0; i < numWords; i++) {
            String word = scanner.next();
            customTrie.insertWord(word);
        }

        // Take search queries from the user
        System.out.println("Enter the number of search queries:");
        int numSearchQueries = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter the search queries:");
        for (int i = 0; i < numSearchQueries; i++) {
            String searchQuery = scanner.next();
            System.out.println("Search Query: " + searchQuery);

            // Search for exact word
            if (customTrie.searchWord(searchQuery)) {
                System.out.println("The query string is present in the Trie");
            } else {
                System.out.println("The query string is not present in the Trie");
            }
            System.out.println();
        }

        // Take prefix queries from the user
        System.out.println("Enter the number of prefix queries:");
        int numPrefixQueries = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter the prefix queries:");
        for (int i = 0; i < numPrefixQueries; i++) {
            String prefixQuery = scanner.next();
            System.out.println("Prefix Query: " + prefixQuery);

            // Check if any word starts with the prefix
            List<String> words = customTrie.startsWith(prefixQuery);
            if (!words.isEmpty()) {
                System.out.println("Words in the Trie starting with the prefix:");
                for (String word : words) {
                    System.out.println(word);
                }
            } else {
                System.out.println("No words in the Trie start with the prefix");
            }
            System.out.println();
        }

        scanner.close();
    }
}
