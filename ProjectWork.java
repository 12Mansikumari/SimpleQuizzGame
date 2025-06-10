package COM.GQT.CORE_JAVA.String_PROGRAMS;

import java.util.Scanner;

public class ProjectWork {

    static final String GREEN = "\u001B[32m";   // Correct answer
    static final String RED = "\u001B[31m";     // Wrong answer
    static final String BLUE = "\u001B[34m";    // Lifelines
    static final String RESET = "\u001B[0m";    // Reset color
    static final String ORANGE = "\u001B[93m";  // Question text

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age < 18) {
            System.out.println(RED + "Sorry " + name + ", you must be 18 or older to play." + RESET);
            return;
        }

        System.out.println(BLUE + "Welcome, " + name + "! You get a free pass. Let's begin!\n" + RESET);

        String[] questions = {
            "1. What is the capital of India?",
            "2. Which planet is red?",
            "3. Java is developed by?",
            "4. Which is a programming language?",
            "5. What is 5*5?",
            "6. Fastest land animal?",
            "7. Which year did WW2 end?",
            "8. Sun rises in the?",
            "9. First Indian PM?",
            "10. Water freezes at?"
        };

        String[][] options = {
            {"Delhi", "Mumbai", "Kolkata", "Chennai", "Use Lifeline"},
            {"Earth", "Mars", "Jupiter", "Venus", "Use Lifeline"},
            {"Microsoft", "Google", "Sun Microsystems", "Apple", "Use Lifeline"},
            {"HTML", "CSS", "Python", "Excel", "Use Lifeline"},
            {"10", "15", "20", "25", "Use Lifeline"},
            {"Lion", "Cheetah", "Horse", "Tiger", "Use Lifeline"},
            {"1945", "1939", "1918", "1950", "Use Lifeline"},
            {"West", "North", "East", "South", "Use Lifeline"},
            {"Gandhi", "Ambedkar", "Patel", "Nehru", "Use Lifeline"},
            {"0°C", "10°C", "5°C", "100°C", "Use Lifeline"}
        };

        int[] correctAnswers = {1, 2, 3, 3, 4, 2, 1, 3, 4, 1}; // 1-based indexing
        boolean used5050 = false;
        boolean usedPoll = false;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(ORANGE + questions[i] + RESET);
            for (int j = 0; j < 5; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            boolean answered = false;
            while (!answered) {
                System.out.print("Your choice (1-5): ");
                int choice = sc.nextInt();

                if (choice == 5) {
                    if (!used5050 || !usedPoll) {
                        System.out.println(BLUE + "Available Lifelines:" + RESET);
                        if (!used5050) System.out.println("1. 50/50");
                        if (!usedPoll) System.out.println("2. Audience Poll");

                        System.out.print("Choose Lifeline (1/2): ");
                        int lifeline = sc.nextInt();

                        if (lifeline == 1 && !used5050) {
                            used5050 = true;
                            System.out.println(BLUE + "50/50 Lifeline Used" + RESET);
                            System.out.println("Remaining options:");
                            for (int j = 0; j < 4; j++) {
                                if (j == correctAnswers[i] - 1 || j == (correctAnswers[i] % 4)) {
                                    System.out.println((j + 1) + ". " + options[i][j]);
                                }
                            }
                        } else if (lifeline == 2 && !usedPoll) {
                            usedPoll = true;
                            System.out.println(BLUE + "Audience Poll Lifeline Used" + RESET);
                            System.out.println("Most audience chose option: " + correctAnswers[i]);
                        } else {
                            System.out.println(RED + "Invalid lifeline choice or already used!" + RESET);
                        }

                    } else {
                        System.out.println(RED + "No lifelines left!" + RESET);
                    }

                } else if (choice >= 1 && choice <= 4) {
                    if (choice == correctAnswers[i]) {
                        score += 1091;
                        System.out.println(GREEN + "Correct " + name + "! Your score: " + score + RESET);
                        answered = true;
                    } else {
                        System.out.println(RED + "Wrong answer, " + name + "! You lost." + RESET);
                        System.out.println("Final score: " + score);
                        return;
                    }
                } else {
                    System.out.println(RED + "Invalid input. Choose between 1-5." + RESET);
                }
            }
        }

        System.out.println(GREEN + "\n Congratulations " + name + "! You completed the quiz.");
        System.out.println("Your Final Score: " + score + RESET);
        sc.close();
    }
}
