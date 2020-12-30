import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        // Reading from System.in
        Scanner reader = new Scanner(System.in);  
        
        System.out.println("Enter side 1: ");
        // Scans the next token of the input as an int.
        int side_1 = reader.nextInt();
        
        System.out.println("Enter side 2: ");
        // Scans the next token of the input as an int.
        int side_2 = reader.nextInt();
        
        System.out.println("Enter side 3: ");
        // Scans the next token of the input as an int.
        int side_3 = reader.nextInt();
        
        if (isTriangle(side_1, side_2, side_3)) {
            System.out.println("This is a triangle.");
        }
        else {
            System.out.println("This is not a triangle.");
        }
        
        reader.close();

    }
    
    public static boolean isTriangle(double a, double b, double c) {
        if ((a + b > c) &&
            (a + c > b) && // should be a + c > b
            (b + c > a)) {
            return true; 
        }
        return false;
    }

}
