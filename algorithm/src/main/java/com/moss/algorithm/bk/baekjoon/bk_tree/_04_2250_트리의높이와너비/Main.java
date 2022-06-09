package com.moss.algorithm.bk.baekjoon.bk_tree._04_2250_트리의높이와너비;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int MAX_LENGTH = 10000;
    static int[] tree = new int[MAX_LENGTH];
    static int LENGTH;
    static int LEFT = 0;
    static int RIGHT = 1;
    public static class Vertex {
        public int vertex;
        public int index;
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        LENGTH = scanner.nextInt();
        int[][] inputs = new int[LENGTH+1][2];
        boolean[] isChild = new boolean[LENGTH + 1];
        
        for (int i = 1; i <= LENGTH; i++) {
            int parent = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            inputs[parent][LEFT] = left;
            inputs[parent][RIGHT] = right;
            if (left != -1) {
                isChild[left] = true;
            }
            if (right != -1) {
                isChild[right] = true;
            }
        }
        
        int root = 0;
        for (int i = 1; i < LENGTH; i++) {
            if (!isChild[i]) {
                root = i;
                break;
            }
        }
        
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = new Vertex();
        vertex.vertex = root;
        vertex.index = 0;
        queue.offer(vertex);
        tree[0] = root;
        while(!queue.isEmpty()) {
            Vertex parent = queue.poll();
            if (inputs[parent.vertex][LEFT] != -1) {
                tree[parent.index*2 + 1] = inputs[parent.vertex][LEFT];
                Vertex leftVertex = new Vertex();
                leftVertex.vertex = inputs[parent.vertex][LEFT];
                leftVertex.index = parent.index*2 + 1;
                queue.offer(leftVertex);
            }
            
            if (inputs[parent.vertex][RIGHT] != -1) {
                tree[parent.index*2 + 2] = inputs[parent.vertex][RIGHT];
                Vertex rightVertex = new Vertex();
                rightVertex.vertex = inputs[parent.vertex][RIGHT];
                rightVertex.index = parent.index*2 + 2;
                queue.offer(rightVertex);
            }
        }
    }
    
    // 중위순회
    private static void inorder(char[] tree, int index) {
        if (tree.length >= index*2 + 1) {
            if (tree[index*2 + 1] != 0) {
                inorder(tree, index*2 + 1);
            }
        }
        System.out.print(tree[index]);
        if (tree.length >= index*2 + 2) {
            if (tree[index*2 + 2] != 0) {
                inorder(tree, index*2 + 2);
            }
        }
    }

}
