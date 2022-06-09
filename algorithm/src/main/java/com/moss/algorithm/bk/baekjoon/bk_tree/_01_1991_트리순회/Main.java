package com.moss.algorithm.bk.baekjoon.bk_tree._01_1991_트리순회;

import java.util.Scanner;

public class Main {
    
    static char[] tree = new char[2<<26];
    static char A = 'A';
    static char EMPTY = '.';
    static char[][] inputTree = new char[26][3];
    
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        tree[0] = A;
        for (int i = 0; i < length; i++) {
            char input = scanner.next().charAt(0);
            int index = input - A;
            inputTree[index][0] = input;
            inputTree[index][1] = scanner.next().charAt(0);
            inputTree[index][2] = scanner.next().charAt(0);
        }
        
        // 트리 생성
        makeTree(A, 0);
        
        // 전위순회
        preorder(tree, 0);
        System.out.println();
        // 중위순회
        inorder(tree, 0);
        System.out.println();
        // 후위순회
        postorder(tree, 0);
        
        scanner.close();
    }
    
    private static void makeTree(char c, int index) {
        char left = inputTree[c - A][1];
        char right = inputTree[c - A][2];
        if (left != EMPTY) {
            tree[index*2 + 1] = left;
            makeTree(left, index*2 + 1);
        }
        if (right != EMPTY) {
            tree[index*2 + 2] = right;
            makeTree(right, index*2 + 2);
        }
    }
    
    // 전위순회
    private static void preorder(char[] tree, int index) {
        System.out.print(tree[index]);
        if (tree.length < index*2 + 2) {
            return;
        }
        if (tree[index*2 + 1] != 0) {
            preorder(tree, index*2 + 1);
        }
        if (tree[index*2 + 2] != 0) {
            preorder(tree, index*2 + 2);
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
    
    // 후위순회
    private static void postorder(char[] tree, int index) {
        if (tree.length >= index*2 + 1) {
            if (tree[index*2 + 1] != 0) {
                postorder(tree, index*2 + 1);
            }
        }
        if (tree.length >= index*2 + 2) {
            if (tree[index*2 + 2] != 0) {
                postorder(tree, index*2 + 2);
            }
        }
        System.out.print(tree[index]);
    }

}
