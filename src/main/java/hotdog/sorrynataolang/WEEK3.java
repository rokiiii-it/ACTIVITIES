package hotdog.sorrynataolang;

import java.util.Scanner;

public class WEEK3 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===SIMPLE GRADE CLASSIFIER===");
        
        // FIRST TEST VALUE (FAILED)
        int testValue1 = 55, testValue2 = 90;
        if (testValue1 >= 60) {
            System.out.println("REMARKS: PASSED");
        } else {
            System.out.println("REMARKS: FAILED");
        }
        
        // SECOND TEST VALUE (PASSED)
        if (testValue2 >= 60) {
            System.out.println("REMARKS: PASSED");
        } else {
            System.out.println("REMARKS: FAILED");
        }
        
        System.out.println("\n===MULTI-TIER DISCOUNT SYSTEM===");
        
        double purchaseAmount = 27763.63;
        
        if (purchaseAmount >= 25000) {
            double discount = purchaseAmount * 0.15;
            double subtotal = purchaseAmount - discount;
            System.out.println("DISCOUNT PROVIDED: " + discount);
            System.out.println("SUBTOTAL: " + subtotal);
        } else if (purchaseAmount >= 15000) {
            double discount = purchaseAmount * 0.10;
            double subtotal = purchaseAmount - discount;
            System.out.println("DISCOUNT PROVIDED: " + discount);
            System.out.println("SUBTOTAL: " + subtotal);
        } else if (purchaseAmount <= 10000) {
            double discount = purchaseAmount * 0.05;
            double subtotal = purchaseAmount - discount;
            System.out.println("DISCOUNT PROVIDED: " + discount);
            System.out.println("SUBTOTAL: " + subtotal);
        } else {
            double discount = purchaseAmount * 0;
            double subtotal = purchaseAmount - discount;
            System.out.println("DISCOUNT PROVIDED: " + discount);
            System.out.println("SUBTOTAL: " + subtotal);
        }
        
        System.out.println("\n===NESTED LOGIN VALIDATOR===");
        
        String username = "admin";
        String password = "javadeveloper2025";
        
        String sampleUsername = "admin";
        String samplePassword = "javadeveloper";
        
        if (sampleUsername.equals(username)) {
            System.out.println("USERNAME CORRECT. NOW VALIDATING");
            if (samplePassword.equals(password)) {
                if (sampleUsername.equals(username) && samplePassword.equals(password)) {
                    System.out.println("ACCOUNT IS UNLOCKED");
                } else {
                    System.out.println("WRONG CREDENTIALS - ACCOUNT LOCKED");
                }
            } else {
                System.out.println("INCORRECT PASSWORD");
            } 
        } else {
            System.out.println("INVALID USERNAME");
        }
    
        System.out.println("\n===ATM TRANSACTION AUTHORIZER===");

        String user = "karl";
        String fourDigit = "0527";
        double accountBalance = 50000;

        System.out.print("ENTER YOUR USERNAME: ");
        String inputUser = scanner.nextLine();
        
        System.out.print("ENTER YOUR PASSWORD: ");
        String inputPass = scanner.nextLine();
        
        // 1. Nested if for Username and PIN verification
        if (inputUser.equals(user)) {
            if (inputPass.equals(fourDigit)) {

                // 2. Else-if ladder to determine Account Tier
                String accTier = "";
                if (accountBalance >= 100000) {
                    accTier = "PLATINUM";
                } else if (accountBalance >= 75000) {
                    accTier = "GOLD";
                } else if (accountBalance >= 50000) {
                    accTier = "SILVER";
                } else {
                    accTier = "BRONZE";
                }
                System.out.println("ACCOUNT TIER: " + accTier);
                
                // 3. Switch statement to set daily limit and fee rate
                double dailyLimit = 0;
                double fee = 0;
                
                switch (accTier) {
                    case "PLATINUM":
                        dailyLimit = 10000.0;
                        fee = 0.05;
                        break;
                    case "GOLD":
                        dailyLimit = 5000.0;
                        fee = 0.04;
                        break;
                    case "SILVER":
                        dailyLimit = 2000.0;
                        fee = 0.03;
                        break;
                    case "BRONZE":
                        dailyLimit = 500.0;
                        fee = 0.01;
                        break;
                }
                
                System.out.print("ENTER WITHDRAWAL AMOUNT: ");
                double withdraw = scanner.nextDouble();
                
                double transacFee = withdraw * fee;
                double totalDeduction = withdraw + transacFee;
                
                // 4. Nested if to check daily limit and account balance
                if (withdraw <= dailyLimit) {
                    if (totalDeduction <= accountBalance) {
                        accountBalance -= totalDeduction;
                        System.out.println("\nSTATUS: APPROVED");
                        System.out.println("WITHDRAWAL AMOUNT: " + withdraw);
                        System.out.println("TRANSACTION FEE: " + transacFee);
                        System.out.println("TOTAL DEDUCTED: " + totalDeduction);
                        System.out.println("REMAINING BALANCE: " + accountBalance);
                    } else {
                        System.out.println("\nSTATUS: DENIED");
                        System.out.println("REASON: Insufficient funds (balance cannot cover amount plus fee).");
                    }
                } else {
                    System.out.println("\nSTATUS: DENIED");
                    System.out.println("REASON: Withdrawal amount exceeds daily limit of " + dailyLimit + " for tier " + accTier + ".");
                }
                
            } else {
                System.out.println("\nSTATUS: DENIED");
                System.out.println("REASON: Incorrect PIN.");
            }
        } else {
            System.out.println("\nSTATUS: DENIED");
            System.out.println("REASON: Invalid username.");
        }
    }
}