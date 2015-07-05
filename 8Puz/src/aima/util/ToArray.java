package aima.util;

import java.util.*;

public class ToArray {
	
	public static int[][] to2DArray(ArrayList<ArrayList<Integer>> list) {
		int[][] array = new int[list.size()][];
		int i=0, j=0;
		
		for(ArrayList<Integer> row : list) {
			array[i] = new int[row.size()];
			j=0;
			for (int in : row) {
				array[i][j] = in;
				j++;
			}
			i++;
		}
		
		return array;
	}
	
	public static int[] toArray(int[][] array2) {
		int[] array1 = new int[array2.length*array2[0].length];
		int k=0;
		for(int i=0; i<array2.length; i++) {
			for (int j=0; j<array2[0].length; j++) {
				array1[k] = array2[i][j];;
				k++;
			}
		}
		
		return array1;
	}

}
