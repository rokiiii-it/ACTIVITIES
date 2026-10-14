package hotdog.sorrynataolang;
import java.util.Scanner;

public class WEEK4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===NUMBER AND SQUARE PRINTER===");
        for(int i = 1; i <= 10; i++){
            System.out.println(i); // FOR LOOP FOR 1 TO 10
        }
        System.out.println("=============================");
        for(int a = 1; a <= 20; a++){
            System.out.println(a); // FOR LOOP FOR 1 TO 20
        }
        
        System.out.println("=============================");
        
        System.out.println("===SUM UNTIL SENTINEL VALUE===");
        
        System.out.println("ENTER NEGATIVE NUMBERS TO BREAK THE LOOP: ");
        int total = 0;
        
        while(true){
            int userinput = scanner.nextInt();
            
            if(userinput <= -1){ // used <= -1 instead of == -1 so that it can read values lesser than -1
                break;
            }
            
            total += userinput;
        }
        
        System.out.println("TOTAL: " + total);
        
        System.out.println("=============================");
        
        System.out.println("===PATTERN GENERATOR===");
        
        int table = 8;
        
        for (int column = 1; column <= table; column++){
  
            if (column == 3){
                break;
            }
            
            for(int row = 1; row <= table; row++){
                if(row == 5){
                    continue;
                }
                
                System.out.print("(" + row + "," + column + ") ");
            }
            
            System.out.println();
        }

        System.out.println("=============================");
        System.out.println("=== WAREHOUSE INVENTORY SCANNAH ===");

        int[][] grid = {
            {5,  2, -1},
            {-1, 12,  0},
            {8,  -1, 4}
        };
        
        int menuChoice;

        do {
            System.out.println("\n1. Total Sum | 2. Find First Low | 3. Update Slot | 4. Exit System");
            System.out.print("Enter selection: ");
            menuChoice = scanner.nextInt();

            if (menuChoice == 1) {

                int totalSum = 0;
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[r].length; c++) {
                        if (grid[r][c] == -1) {
                            continue; 
                        }
                        totalSum += grid[r][c];
                    }
                }
                System.out.println("Total Sum (skipping -1): " + totalSum);

            } else if (menuChoice == 2) {
               
                stopSearching:
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[r].length; c++) {
                        if (grid[r][c] >= 0 && grid[r][c] < 5) {
                            System.out.println("First low value found at: Row " + r + ", Col " + c);
                            break stopSearching; 
                        }
                    }
                }

            } else if (menuChoice == 3) {
            
                simulateRestock(grid, scanner);
            }

        } while (menuChoice != 4);
        
        System.out.println("Exiting system. Goodbye!");
        scanner.close(); 
    }

   
    public static void simulateRestock(int[][] grid, Scanner scanner) {
        while (true) {
            System.out.print("Enter target row and col indices: ");
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == -1) {
                System.out.println("Invalid bounds");
                continue;
            }

            System.out.print("Enter amount to add: ");
            grid[r][c] += scanner.nextInt();
            System.out.println("Slot successfully updated.");
            
            return;
        }
    }
}
