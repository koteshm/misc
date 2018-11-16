package com.kotesh.binarytree;

import lombok.Getter;

@Getter
public class BinaryTree {
	private Node root;    
	
	public  BinaryTree(Node root) {
		this.root = root;
	}	

	public Node addNode(Node root, int value) {
		
		Node current = root;
		Node node = new Node(value);
		
		while(true) {
						
			if(value < current.getValue()) {
				
				if(current.getLeft()==null) {
					current.setLeft(node);
					System.out.println("left of "+current.getValue()+" is "+value);
					break;
				} else {
					current = current.getLeft();
				}
			} else {
				
				if(current.getRight()==null) {
					current.setRight(node);
					System.out.println("Right of "+current.getValue()+" is "+value);
					break;
				} else {
					current = current.getRight();
				}
					
			}
				
		}
		
		return current;
		
	}
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(new Node(2));
		 

	    binaryTree.addNode(binaryTree.getRoot(), 1);
	    binaryTree.addNode(binaryTree.getRoot(), 3);
	    binaryTree.addNode(binaryTree.getRoot(), 6);
	    binaryTree.addNode(binaryTree.getRoot(), 4);	 
	    
	}
	
	

}
