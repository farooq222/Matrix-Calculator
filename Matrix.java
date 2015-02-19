package matrix_multi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Matrix {

	static ArrayList<int[][]> listmatrix = new ArrayList<int[][]>(); //an arraylist created to store matrices
	static int row_array[]=new int[1000]; //each index contains num of rows for matrix at that index
	static int column_array[]=new int[1000]; //each index contains num of rows for matrix at that index
	static int list_count=0;
	static int k=0;

	/*this function will read matrices from the file and save each matrix in a 
	2d array then that array is stored in the arraylist
	*/
	public static void read_file(){ 
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Farooq Arshad\\workspace\\matrix_multi\\src\\matrix_multi\\sample.txt")))
		{
			String CurrentLine;
			int column=0,rows=0,i=0;

			//this will read file line by line and line is then stored in currentline
			while ((CurrentLine = br.readLine()) != null){
				String[] row_tokens = CurrentLine.split(","); //line is tokenized whenever it sees a comma in it
	
				int array1[][]=new int[50][50];
				rows=0;
				for (String token : row_tokens)
				{
					String[] tokens1 = token.split(" "); //line is tokenized whenever it sees a space in it
					column=0;
					i=0;
					for (String token1 : tokens1)
					{
						int x = Integer.parseInt(token1); //string is converted into integer
						array1[rows][i]= x; //now the integer is stored in array1
						i++;
						column++;
					}
					rows++;
				}
				column_array[k]=column;
				row_array[k]=rows;
				k++;

				listmatrix.add(array1); //now a 2d array is stored in a lisr
				list_count++;
				
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void addition(int matrix1,int matrix2){

		int temp_array[][] = listmatrix.get(matrix1); //geting the desired matrix from list and storing it in a 2d array
		int no_rows = row_array[matrix1];  //getting num of rows of that matrix
		int no_column = column_array[matrix1]; //getting number of column of that matrix
	
		//the following loop will print the entire matrix
		System.out.println("Matrix "+ matrix1);
		for (int i = 0 ; i <no_rows ; i++) {
			for (int j = 0 ; j < no_column ; j++) {
				System.out.print(temp_array[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

		int temp_array1[][] = listmatrix.get(matrix2);
		int no_rows1 = row_array[matrix2];
		int no_column1 = column_array[matrix2];
	
		System.out.println("Matrix "+ matrix2);
	
		for (int i = 0 ; i <no_rows1 ; i++) {
			for (int j = 0 ; j < no_column1 ; j++) {
				System.out.print(temp_array1[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

		if(no_rows != no_rows1 || no_column != no_column1){
			System.out.println("Error: Incorrect Order.");
		}

		else{
			int sum[][] = new int[no_rows][no_column];
			int c,d;
			for ( c = 0 ; c < no_rows ; c++ ){
				for ( d = 0 ; d < no_column ; d++ ){
					sum[c][d] = temp_array[c][d] + temp_array1[c][d];  
				}
			}
			column_array[k]=no_column;
			row_array[k]=no_rows;
			listmatrix.add(sum); //the result is saved in the last position of the arraylist
			System.out.println("Addition:");
			// result of addition is being printed
			for ( c = 0 ; c < no_rows ; c++ )
			{
				for ( d = 0 ; d < no_column ; d++ )
					System.out.print(sum[c][d]+"\t");

				System.out.println();
			}
			
		}
	}

	public static void subtraction(int matrix1,int matrix2){

		int temp_array[][] = listmatrix.get(matrix1);
		int no_rows = row_array[matrix1];
		int no_column = column_array[matrix1];
		
		System.out.println("Matrix "+ matrix1);
		for (int i = 0 ; i <no_rows ; i++) {
			for (int j = 0 ; j < no_column ; j++) {
				System.out.print(temp_array[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

		int temp_array1[][] = listmatrix.get(matrix2);
		int no_rows1 = row_array[matrix2];
		int no_column1 = column_array[matrix2];
		
		System.out.println("Matrix "+ matrix2);
		for (int i = 0 ; i <no_rows1 ; i++) {
			for (int j = 0 ; j < no_column1 ; j++) {
				System.out.print(temp_array1[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

		if(no_rows != no_rows1 || no_column != no_column1){ // this is checking the order of matrix
			System.out.println("Error: Incorrect Order.");
		}

		else{
			int subtract[][] = new int[no_rows][no_column];
			int c,d;
			for ( c = 0 ; c < no_rows ; c++ )
				for ( d = 0 ; d < no_column ; d++ )
					subtract[c][d] = temp_array[c][d] - temp_array1[c][d];  
			
			listmatrix.add(subtract); //adding the result to the list
			column_array[k]=no_column;
			row_array[k]=no_rows;

			System.out.println("Subtraction:");

			for ( c = 0 ; c < no_rows ; c++ )
			{
				for ( d = 0 ; d < no_column ; d++ )
					System.out.print(subtract[c][d]+"\t");

				System.out.println();
			}
		}

	}

	public static void multiplication(int matrix1,int matrix2){

		int temp_array[][] = listmatrix.get(matrix1);
		int no_rows = row_array[matrix1];
		int no_column = column_array[matrix1];

		System.out.println("Matrix "+ matrix1);
		for (int i = 0 ; i <no_rows ; i++) {
			for (int j = 0 ; j < no_column ; j++) {
				System.out.print(temp_array[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

		int temp_array1[][] = listmatrix.get(matrix2);
		int no_rows1 = row_array[matrix2];
		int no_column1 = column_array[matrix2];
		
		System.out.println("Matrix "+ matrix2);
		for (int i = 0 ; i <no_rows1 ; i++) {
			for (int j = 0 ; j < no_column1 ; j++) {
				System.out.print(temp_array1[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

		if(no_column != no_rows1){ //this is checking the order of matrix
			System.out.println("Error: Incorrect Order.");	
		}

		else{
			int[][] result = new int[no_rows][no_column1];
			for (int i=0; i< no_rows; i++){
				for (int j=0; j< no_column1; j++){
					for (int k=0; k< no_rows1; k++){
						result[i][j] += temp_array1[i][k] * temp_array[k][j];	              
					}
				}
			}
			
			listmatrix.add(result);
			column_array[k]=no_column;
			row_array[k]=no_rows;
			
			System.out.println("Multiplication:");
			for ( int e = 0 ; e < no_rows ; e++ )
			{
				for ( int d = 0 ; d < no_column1 ; d++ )
					System.out.print(result[e][d]+"\t");

				System.out.println();
			}
		}
	}
}

