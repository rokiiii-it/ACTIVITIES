package hotdog.sorrynataolang;
import java.util.Scanner;

public class WEEK2 {
    public static void main(String[] args) {
        double total;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=====================================");
        
        System.out.print("ENTER FIRST NUMBER: ");
        double num1 = scanner.nextInt();
        System.out.print("ENTER SECOND NUMBER: ");
        double num2 = scanner.nextInt();
        
        System.out.print("CHOOSE AN OPERATION [1-4]: ");
        int choice = scanner.nextInt();
        
        switch(choice){
            case 1: //negative values work normally as intended
                total = num1 + num2;
                System.out.print("ADDITION: " + total);
                break;
                
            case 2: //negative values work normally as intended
                total = num1 - num2;
                System.out.print("SUBTRACTION: " + total);
                break;
                
            case 3: //negative values when dividing negative to positive makes it negative
                total = num1 / num2;
                System.out.print("DIVISION: " + total);
                break;
            
            case 4: //negative values when dividing negative to positive makes it negative as intended
                total = num1 * num2;
                System.out.print("MULTIPLICATION: " + total);
                break;
                
            default:
                System.out.print("INVALID INPUT");
        }
        
        System.out.println("=====================================");
        int average = 74, absences = 3;
        
        if(average >= 75 && absences <= 3 || average >= 90){
            System.out.println("\nSTUDENT PASSED, grades exceeded the minimum threshold");
        }
        else if(average < 75){
            System.out.println("\nSTUDENT FAILED, failed to meet minimum threshold");
        }
        else {
            System.out.println("\nAVERAGE CAN'T BE INVALID");
        }
        
        System.out.println("=====================================");
        
        double balance = 1000.00;
        System.out.println("INITIAL VALUE: " + balance);
        
        balance += 1.30;
        System.out.println("ADDING VALUE: " + balance);
        
        balance *= 67.67;
        System.out.println("MULTIPLYING VALUE: " + balance);
        
        balance += 420;
        System.out.println("FINAL VALUE: " + balance + "\n");
        
        int count = 10;
        
        System.out.println("===POSTFIXING VALUE===");
        
        System.out.println("COUNT++ VALUE: " + count++);
        System.out.println("WITHOUT COUNT++: " + count);
        
        System.out.println("==PREFIXING VALUES===");
        
        System.out.println("++COUNT VALUE: " + ++count);
        System.out.println("WITHOUT ++COUNT: " + count);
        
        /* count++ adds value to the next count, not in the line with count++.
        the change will only occur on the second time that the variable name count will appear
        */
        
        /* the difference between the count++ and ++count based on the output is
        in ++count, the increment process in the memory HAPPENS before the count leading to different outputs
        */
        
        System.out.println("=====================================");
        
        int num_1 = 50, num_2 = 67, num_3 = 90;
        
        System.out.println("===PRECEDENCE PUZZLE SOLVER===");
        
        boolean result_1 = ++num_1 + 25 > 10 && --num_1 * 2  > 0; //true 10:27PM 10/12/2026
        System.out.println("RESULT 1: " + result_1); //result evaluated to true
        
        boolean result_2 = num_2 + num_3 <= 150 || (num_3 - num_2)* 5 >= 300; //false 10:32PM 10/12/2026
        System.out.println("RESULT 2: "+ result_2); //result evaluated to true since either conditions weren't met
        
        boolean result_3 = (num_1 * 2) + (num_2 - num_1) >= 70 || (num_3 / num_2) % 100 <= 157; //true 10:52PM 10/12/2026
        System.out.println("RESULT 3: " +result_3); //result evaluated to true
    }
}
