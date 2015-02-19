package matrix_multi;

public class Unit_test3 {
	public static void main(String[] args) {
		Matrix a =new Matrix();
		System.out.println("Reading from file... ");
		
		a.read_file();
		int x=a.list_count;
		
		System.out.println("Multipling First two matrices:");
		a.multiplication(0,1);
		
		System.out.println("Adding the result to third matrix:");
		a.addition(2,x);

	}

}
