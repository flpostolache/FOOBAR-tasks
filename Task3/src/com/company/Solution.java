package com.company;

import java.util.HashMap;
import java.util.Map;

class Node{
    int data;
    Node left, right;

    public Node(){
        data = -1;
        left = right = null;
    }
}

class BinaryTree{
    Node root;
    int conto = 1;
    Map<Integer, Integer> parinti;

    BinaryTree(){
        this.root =new Node();
        this.parinti = new HashMap<>();
    }

    public void recursive_tree_construction(Node current_node, int current_height, int max_height){
        if(current_height != max_height){
            current_node.left = new Node();
            current_node.right = new Node();
            recursive_tree_construction(current_node.left, current_height + 1, max_height);
            current_node.left.data = conto;
            if(current_node.left.left != null)
                parinti.put(current_node.left.left.data, current_node.left.data);
            if(current_node.left.right != null)
                parinti.put(current_node.left.right.data,current_node.left.data);
            conto++;
            recursive_tree_construction(current_node.right, current_height + 1, max_height);
            current_node.right.data = conto;
            if(current_node.right.left != null)
                parinti.put(current_node.right.left.data, current_node.right.data);
            if(current_node.right.right != null)
                parinti.put(current_node.right.right.data,current_node.right.data);
            conto++;
        }
    }
}


public class Solution{
    public static int[] solution (int h, int[]q) {
        int[] rezultat = new int[q.length];
        BinaryTree tree = new BinaryTree();
        tree.recursive_tree_construction(tree.root, 1,h);
        tree.root.data = tree.conto;
        tree.parinti.put(tree.root.data, -1);
        if(h != 1){
            tree.parinti.put(tree.root.left.data, tree.root.data);
            tree.parinti.put(tree.root.right.data, tree.root.data);
        }
       for(int i=0; i < q.length; i++)
            rezultat[i] = tree.parinti.get(q[i]);
        return rezultat;
    }
}
