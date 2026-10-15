package hotdog.sorrynataolang;

import java.util.Arrays;

public class WEEK5 {
    public static void main(String[] args) {
        System.out.println("===FAVORITE THINGS ARRAY===");
        String[] favThings = {"GUITAR", "GAMING", "WALKING", "BADMINTON", "TRAVELLING"};
        
        for (int i = 0; i < favThings.length; i++) {
            System.out.println((i + 1) + ". " + favThings[i]);
        }
        System.out.println("\n===CLASS STATISTICS CALCULATOR===");
        
        int[] studentScores = {85, 92, 78, 64, 95, 88, 73, 90};
        int sum = 0;
        int high = studentScores[0];
        int low = studentScores[0];
        
        for (int a = 0; a < studentScores.length; a++) {
            sum += studentScores[a];
            
            if (studentScores[a] > high) {
                high = studentScores[a];
            }
            
            if (studentScores[a] < low) {
                low = studentScores[a];
            }
        }
        
        double average = (double) sum / studentScores.length; // Casting from int to double
        
        System.out.println("===SUMMARY===");
        System.out.println("SUM OF SCORES: " + sum);
        System.out.printf("AVERAGE: %.2f%n", average);
        System.out.println("HIGHEST SCORE: " + high);
        System.out.println("LOWEST SCORE: " + low);
        System.out.println("===");

        System.out.println("\n===LINEAR SEARCH===");
        int target = 95;
        int foundIndex = -1;

        for (int i = 0; i < studentScores.length; i++) {
            if (studentScores[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Target " + target + " was found at index: " + foundIndex);
        } else {
            System.out.println("Target " + target + " was not found in the array.");
        }

        /*
          Why sorting a copy (rather than the original) matters:
          In real-world data like student grades, array indices often correspond to 
          specific student IDs or seating orders (e.g., studentScores[0] is Student 1).
          Sorting the original array would permanently scramble that connection. 
          By sorting a copy, we can view the rankings while preserving the original 
          relationship between students and their scores.
         */
        int[] sortedScores = Arrays.copyOf(studentScores, studentScores.length);
        Arrays.sort(sortedScores);

        System.out.println("\n===SORTED SCORES===");
        System.out.println("Original scores: " + Arrays.toString(studentScores));
        System.out.println("Sorted scores:   " + Arrays.toString(sortedScores));

        System.out.println("\n===CLASS RANKING SYSTEM===");


        String[] studentNames = {"Alice", "Bob", "Charlie", "Diana", "Ethan"}; //students
        int[][] rawQuizData = { //2d array
            {88, 92, 85, 95},  
            {70, 75, 80, 75},  
            {90, 85, 95, 90},  
            {98, 95, 97, 99}, 
            {82, 80, 85, 81}   
        };
        
        Student[] students = new Student[studentNames.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(studentNames[i], rawQuizData[i]);
        }

        // my replacement logic of arrays.sort()
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getAverage() < students[j + 1].getAverage()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        students[0].rank = 1;
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAverage() == students[i - 1].getAverage()) {
                students[i].rank = students[i - 1].rank;
            } else {
                students[i].rank = i + 1;
            }
        }
        //for representation
        System.out.println("--------------------------------------------------");
        System.out.printf("%-6s | %-12s | %-10s | %s%n", "Rank", "Name", "Average", "Quizzes");
        System.out.println("--------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-6d | %-12s | %-10.2f | %s%n", 
                s.rank, s.name, s.getAverage(), Arrays.toString(s.quizzes));
        }
        System.out.println("--------------------------------------------------");

        String searchTargetName = "Charlie";
        int studentRank = studentRank(students, searchTargetName);

        if (studentRank != -1) {
            System.out.println("Search Result: " + searchTargetName + " is ranked #" + studentRank);
        } else {
            System.out.println("Search Result: Student \"" + searchTargetName + "\" not found.");
        }
    }
    public static int studentRank(Student[] list, String targetName) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].name.equalsIgnoreCase(targetName)) {
                return list[i].rank;
            }
        }
        return -1;
    }
}

class Student {
    String name;
    int[] quizzes;
    int rank;

    public Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;
    }

    public double getAverage() {
        int sum = 0;
        for (int score : quizzes) {
            sum += score;
        }
        return (double) sum / quizzes.length;
    }
}