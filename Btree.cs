using System;

public class BTreeNode
{
    public int n; // Mevcut anahtar sayısı
    public int[] keys; // Anahtar dizisi
    public BTreeNode[] children; // Alt düğüm dizisi
    public bool leaf; // Yaprak düğüm mü?

    public BTreeNode(int degree, bool leaf)
    {
        this.n = 0;
        this.keys = new int[2 * degree - 1];
        this.children = new BTreeNode[2 * degree];
        this.leaf = leaf;
    }
}

public class BTree
{
    private BTreeNode root;
    private int degree;

    public BTree(int degree)
    {
        this.root = null;
        this.degree = degree;
    }

    public void Insert(int key)
    {
        if (root == null)
        {
            root = new BTreeNode(degree, true);
            root.keys[0] = key;
            root.n = 1;
        }
        else
        {
            if (root.n == 2 * degree - 1)
            {
                BTreeNode newRoot = new BTreeNode(degree, false);
                newRoot.children[0] = root;
                SplitChild(newRoot, 0);
                int i = 0;
                if (newRoot.keys[0] < key)
                {
                    i++;
                }
                InsertNonFull(newRoot.children[i], key);
                root = newRoot;
            }
            else
            {
                InsertNonFull(root, key);
            }
        }
    }

    private void InsertNonFull(BTreeNode node, int key)
    {
        int i = node.n - 1;
        if (node.leaf)
        {
            while (i >= 0 && key < node.keys[i])
            {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.n = node.n + 1;
        }
        else
        {
            while (i >= 0 && key < node.keys[i])
            {
                i--;
            }
            i++;
            if (node.children[i].n == 2 * degree - 1)
            {
                SplitChild(node, i);
                if (key > node.keys[i])
                {
                    i++;
                }
            }
            InsertNonFull(node.children[i], key);
        }
    }

    private void SplitChild(BTreeNode parentNode, int childIndex)
    {
        BTreeNode newChild = new BTreeNode(degree, parentNode.children[childIndex].leaf);
        BTreeNode childNode = parentNode.children[childIndex];
        parentNode.n = parentNode.n + 1;
        for (int j = parentNode.n - 1; j > childIndex; j--)
        {
            parentNode.keys[j] = parentNode.keys[j - 1];
        }
        parentNode.keys[childIndex] = childNode.keys[degree - 1];
        for (int j = parentNode.n; j > childIndex + 1; j--)
        {
            parentNode.children[j] = parentNode.children[j - 1];
        }
        parentNode.children[childIndex + 1] = newChild;
        for (int j = 0; j < degree - 1; j++)
        {
            newChild.keys[j] = childNode.keys[j + degree];
        }
        childNode.n = degree - 1;
        newChild.n = degree - 1;
    }

    // Diğer B-Tree işlemleri buraya eklenebilir

    public void PrintTree()
    {
        PrintTree(root, 0);
    }

    private void PrintTree(BTreeNode node, int level)
    {
        if (node != null)
        {
            for (int i = 0; i < node.n; i++)
            {
                PrintTree(node.children[i], level + 1);
                Console.WriteLine($"Level {level}, Key: {node.keys[i]}");
            }
            PrintTree(node.children[node.n], level + 1);
        }
    }
}

class Program
{
    static void Main()
    {
        int[] keys = { 10, 20, 5, 6, 12, 30, 7, 17 };

        BTree bTree = new BTree(3);

        foreach (var key in keys)
        {
            bTree.Insert(key);
        }

        Console.WriteLine("B-Tree:");
        bTree.PrintTree();
    }
}
