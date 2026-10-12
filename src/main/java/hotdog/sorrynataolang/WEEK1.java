package hotdog.sorrynataolang;
import java.util.Scanner;
import java.util.Arrays;

public class WEEK1 {
    public static void main(String[] args) {
        int age = 21;
        double height = 171.4;
        char initial = 'P';
        boolean status = true;
        
        String name= "Suaverdez, Karl Steven";
        
        System.out.println("Your name is: "+ name + " " + initial + "."); //prints name and initial
        System.out.println("Your age is: "+ age); //prints age
        System.out.println("Your height is: "+ height); //prints height
        System.out.println("Is the student enrolled? " + status); //prints student status
        
        System.out.println("=====================================");
        
        int quantity = 50;
        double unitPrice = 150.75;
        double totalCost = quantity * unitPrice;
        
        String storeName = "TINDAHAN NG ALA-ALA";
        System.out.println("----"+ storeName + "----");
        System.out.println("ITEM NAME: WALLET");
        System.out.println("QUANTITY: " + quantity);
        System.out.println("UNIT PRICE: " + unitPrice);
        System.out.println("TOTAL COST: " + totalCost);
        
        /*using int would render the illustration of 
        decimals useless due to int being limited to whole numbers only */
        
        System.out.println("=====================================");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ENTER CENTIMETER VALUE: ");
        double centimeter = scanner.nextDouble();
        
        int wholeM = (int)(centimeter / 100);
        double remaining = (centimeter % 100);
        
        System.out.println("RESULT IS " + wholeM + "m with a remainder of " + remaining + "cm");
        
        int sampleIntVal = 35;
        double convertedInt = sampleIntVal;
        
        System.out.println("THE VALUE " + sampleIntVal + " IS CONVERTED TO " + convertedInt);
        //no cast is needed since the int is already a whole number, making it double would only result to .0
        
        double sampleDoubleVal = 97.29;
        int convertedDouble = (int)sampleDoubleVal;
        
        System.out.println("THE VALUE " + sampleDoubleVal + " IS CONVERTED TO " + convertedDouble);
        //the value from of .29 from the 97.29 is lost due to conversion from decimal to whole number

        System.out.println("=====================================");
        
        byte maxVal = 127;
        System.out.println("Initial byte value before increment " + maxVal);
        
        maxVal++;
        System.out.println("Byte value after incerement " + maxVal);
        
        String first = new String("Java");
        String second = new String("Java");
        String third = "Java";
        
        System.out.println("is first == second? " + (first == second));
        System.out.println("first.equals(second)? " + first.equals(second));
        
        System.out.println("is second == third? " + (second == third));
        System.out.println("second.equals(third) " + second.equals(third));
        
        /*
        the == is different from the result of .equals is because == compares referential values
        while the .equals method compares the value itself.
        == compares from the exact memory address, while .equals can be compare despite the difference in the memory address
        */
        
        System.out.println("===ARRAY MODIFICATION===");
        int[] originalArray = {10, 20, 30};
        int[] sharedArray = originalArray;

        System.out.println("Before modification:");
        System.out.println("ORIGINAL ARRAY: " + Arrays.toString(originalArray));
        System.out.println("SHARED ARRAY FROM THE ORIGINAL:   " + Arrays.toString(sharedArray));
        
        sharedArray[0] = 30;
        sharedArray[1] = 20;
        
        System.out.println("After modification:");
        System.out.println("ORIGINAL ARRAY: " + Arrays.toString(originalArray));
        System.out.println("SHARED ARRAY FROM THE ORIGINAL:   " + Arrays.toString(sharedArray));
        //the variable sharedArray modified the elements from the originalArray by modifying different values from the index of each element
    }
}
