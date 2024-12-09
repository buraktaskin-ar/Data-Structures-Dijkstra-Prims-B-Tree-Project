using System;
using System.Collections.Generic;

public class TrieNode
{
    public char Value { get; set; }
    public Dictionary<char, TrieNode> Children { get; set; }

    public TrieNode(char value)
    {
        Value = value;
        Children = new Dictionary<char, TrieNode>();
    }
}

public class Trie
{
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode('\0');
    }

    public void Insert(string word)
    {
        TrieNode currentNode = root;

        foreach (char c in word)
        {
            if (!currentNode.Children.ContainsKey(c))
            {
                currentNode.Children[c] = new TrieNode(c);
            }

            currentNode = currentNode.Children[c];
        }
    }

    public static void Main(string[] args)
    {
        Trie trie = new Trie();

        string[] words = { "ana", "ananas", "merhaba", "merhabalar" };

        foreach (string word in words)
        {
            trie.Insert(word);
        }

        Console.WriteLine("Kelimeler Trie'ye eklendi.");
    }
}
