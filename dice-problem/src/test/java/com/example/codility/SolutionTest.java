package com.example.codility;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class SolutionTest {
	
    private int[] inputArray;
    private int expected;

    public SolutionTest(int[] inputArray, int[] expected) {
        this.inputArray = inputArray;
        this.expected = expected[0];
    }

	
	@Parameterized.Parameters
    public static Collection<int[][]> data() {
    	return Arrays.asList(new int[][][]{
            {{}, {0}},
            {{6}, {0}},
            {{76}, {0}},
            {{1,1,2,2,3,4,3,4,6,5}, {9}},
            {{1,2,5,4,6,3}, {6}},
            {{1,1,1,1,1,1,1,1}, {0}},
            {{6,6,6,6,2,2,2,2,1,1,1,1}, {8}},
            {{1,1}, {0}},
            {{1,3,4}, {2}},
            {{1,6}, {2}},
            {{1,1,6}, {2}},
            {{1,1}, {0}},
            {{56,1},{0}},
            {{-56,1},{0}}
    });
    }
    
    @Test
    public void testSolution() {
        assertEquals(expected, new Solution().solution(inputArray));
    }
}
