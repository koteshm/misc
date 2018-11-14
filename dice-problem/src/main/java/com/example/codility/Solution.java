package com.example.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.util.Pair;

public class Solution {
	
	List<Pair<Integer, Integer>> oppositeCubeFacePairs = new ArrayList<>();

	
	Solution() {
		oppositeCubeFacePairs.add(new Pair<>(1, 6));
		oppositeCubeFacePairs.add(new Pair<>(6, 1));
		oppositeCubeFacePairs.add(new Pair<>(2, 5));
		oppositeCubeFacePairs.add(new Pair<>(5, 2));
		oppositeCubeFacePairs.add(new Pair<>(3, 4));
		oppositeCubeFacePairs.add(new Pair<>(4, 3));
	}
 
    public int solution(int[] givenFaces) {
    	int totalMovesNeeded = 0;        
    	
    	if(givenFaces.length<2 || checkIfInvalidFaces(givenFaces) || checkIfSameFaces(givenFaces)) {
        	return totalMovesNeeded;
        } 
    	
    	Set<Integer> duplicateFaces = getDuplicates(givenFaces);
    	int tempTotalMovesNeeded = totalMovesNeeded;
    	List<Integer> listOfAllTotalMoves = new ArrayList<>();
        
    	if(duplicateFaces.isEmpty()) {        	
        	for(int j=0; j<givenFaces.length;j++) {
        		tempTotalMovesNeeded = 0;
        	    int expected = givenFaces[j]; 
                for (int i =0; i< givenFaces.length ; i++) {
            	  if(i!=j) {
            		 tempTotalMovesNeeded += minNoOfMovesNeeded(givenFaces[i], expected);
            	  }
                }
                listOfAllTotalMoves.add(tempTotalMovesNeeded);
        	}
        } else {
             for(int duplicate : duplicateFaces) {
            	 tempTotalMovesNeeded = 0;
            	 for (int i =0; i< givenFaces.length ; i++) {
            		 if(duplicate != givenFaces[i])
            			 tempTotalMovesNeeded += minNoOfMovesNeeded(givenFaces[i], duplicate);
            	 	}
            	 listOfAllTotalMoves.add(tempTotalMovesNeeded);
             	}
        }
    	
    	Collections.sort(listOfAllTotalMoves);
    	totalMovesNeeded = listOfAllTotalMoves.get(0);
        return totalMovesNeeded;
    }
        
    private boolean checkIfInvalidFaces(int[] givenFaces) {
    	Arrays.sort(givenFaces);
    	return givenFaces[0]<1 || givenFaces[givenFaces.length-1]>6;
    }
    
    private boolean checkIfSameFaces(int[] givenFaces) {
    	Arrays.sort(givenFaces);
    	return givenFaces[0]==givenFaces[givenFaces.length-1];
    }
    
    private Set<Integer> getDuplicates(int[] givenFaces) {
        Set<Integer> uniqueFaces = new HashSet<>();
        Set<Integer> duplicateFaces = new HashSet<>();
	    
	    for (int i = 0; i< givenFaces.length ; i++) {
	            if(!uniqueFaces.add(givenFaces[i])) {	          
	                duplicateFaces.add(givenFaces[i]);
	            }
	        } 
	    
	    return duplicateFaces;
        
    }
    
    private int minNoOfMovesNeeded(int x, int y) {
        if(x == y) {
            return 0;
        } else if(oppositeCubeFacePairs.contains(new Pair<>(x, y))){
            return 2;
        } else {
        	return 1;
        }
    }
}
