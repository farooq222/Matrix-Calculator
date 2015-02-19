package matrix_multi;

public class Unit_test1 {

	public static void main(String[] args) {
		Matrix a =new Matrix();
		System.out.println("Reading from file... ");
		a.read_file();
		
		System.out.println("Adding first two matrices:");
		a.addition(0,1);
	}
}
