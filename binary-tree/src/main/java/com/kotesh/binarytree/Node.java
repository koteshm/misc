package com.kotesh.binarytree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
	private int value;
    private Node left;
    private Node right;
 
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
