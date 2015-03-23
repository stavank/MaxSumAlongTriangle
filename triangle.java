// Max sum across a path in a triangle
// Example :
// Input file contains :
//     5
//    9 6
//   4 6 8
//  0 7 1 5
// Output : 27
// Explanation : Sum is 27 and path is 5->9->6->7
// Approach : Bottom up with complexity of n^2 where n is the number of rows / height of triangle
// Assumption : Also I assume that the sum will not the surpass the capacity of an 'int' variable
// @uthor Stavan Karia
// 03/23/2015


// import all libraries/packages

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
// class to implement functionality of problem statement
public class triangle {
	// number of rows in the triangle / height of triangle
	private static final int triangleHeight = 100; 		
	// filename from which the triangle is taken as input
	private final String fileName = "src/triangle.txt"; 	
	// 2 D array to store the triangle
	private int[][] triangle; 							
	
	// function to find the maximum sum 
	public int maxSum() throws IOException {
		// function to read the triangle from a text file
		readTriangle(); 								
		// iterate across the triangle array
		for (int i = triangle.triangleHeight - 2; i >= 0; i--){ 		
			for (int j = 0; j <= i; j++){
				// choose the path with the maximum sum
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}		
		// return the found sum
		return triangle[0][0]; 							  
	}
 
	// function to read the triangle from the text file
	private void readTriangle() throws IOException {
		triangle = new int[triangle.triangleHeight][];
		// open a buffered reader 
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		// read the file line wise
		for (int i = 0; i < triangle.triangleHeight; i++) {
			triangle[i] = new int[i + 1];
			String[] values = bufferedReader.readLine().split(" ");
			for (int j = 0; j <= i; j++)
				triangle[i][j] = Integer.parseInt(values[j]);
		}
		// close the buffered reader
		bufferedReader.close();
	}
	
	// main function
	public static void main(String[] args) throws IOException {
		// find the maximum possible sum
		int foundSum = new triangle().maxSum();
		// display the found maximum sum 
		System.out.println(foundSum);
	}
}
