import java.util.Scanner;

public class QuizGame {
    // calculate the percent
    public static int calculatePercent (int score, int questionsNumber) {
        return (score * 100) / questionsNumber;
    }

    // printlnText prints a new line of output
    public static void printlnText(String text) {
        System.out.println(text);
    }
    // printText prints an output
    public static void printText(String text) {
        System.out.print(text);
    }

    public static void main(String[] args) {
        // initiate scanner to get prompt from user
        Scanner scanner = new Scanner(System.in);

        // Create the list of questions
        String[] questions = {
                "1. Which of the following are planets of the solar system",
                "2. What is the first letter of the word 'Java'",
                "3. What is the second letter of the word 'Java'",
                "4. What is the third letter of the word 'Java'",
                "5. What is the fourth letter of the word 'Java'",
        };

        // Create the list of answers
        String[][] options = {
                {"A. Earth", "B. New York", "C. Moon", "D. Sun"},
                {"A. J", "B. K", "C. D", "D. I don't know"},
                {"A. J", "B. A", "C. D", "D. I don't know"},
                {"A. V", "B. K", "C. D", "D. I don't know"},
                {"A. J", "B. K", "C. A", "D. I don't know"},
        };

        // Create the list of correct answers
        char[] correctAnswers = {'a', 'a', 'b', 'a', 'c'};

        // Create variable that stores the number of question
        // it is created, because it is used more than two times in a code
        int questionsNum = questions.length;
        // The store from user's answers with a length of questions
        char[] userAnswers = new char[questionsNum];
        // Initiation of user's score
        int score = 0;

        // For every question we:
        for (int i = 0; i < questionsNum; i++) {
            // print the question
            printlnText(questions[i]);

            //print the answer's options
            for (String option : options[i]) {
                printlnText(option);
            }

            // ask user to insert the answer
            printText("Enter your answer (A, B, C, D): ");
            // the input is saved in lower case
            char answer = scanner.next().toLowerCase().charAt(0);

            // While user don't insert the answer that consists only of letters a,b,c or d
            while (answer != 'a' && answer != 'b' && answer != 'c' && answer != 'd') {
                // user will receive a message
                printText("Invalid input. Please enter A, B, C, D: ");
                // and forced to insert the answer
                answer = scanner.next().toLowerCase().charAt(0);
            }

            // the answer is written to the list of user's answers
            userAnswers[i] = answer;

            // if the answer is correct, then the score rose
            if (answer == correctAnswers[i]) {
                score++;
            }
        }

        // After all the questions a re passed, user receives messages related to score and percent of write answers
        printlnText("\nQuiz Complete!");
        printlnText("Your score: " + score + "/" + questionsNum + " (" + calculatePercent(score, questionsNum) + "%)");

        // The correct and user's answers are demonstrated for each question
        System.out.println("\nCorrect Answers and Your Responses:");
        for (int i = 0; i < questionsNum; i++) {
            printlnText(questions[i]);
            printlnText("Correct Answer: " + correctAnswers[i]);
            printlnText("Your Answer: " + userAnswers[i]);
            printlnText("----------------------------");
        }

        // The program question if the user wants to reattempt the quiz
        printText("Do you want to try again? (y/n) ");
        char reattempt = scanner.next().toLowerCase().charAt(0);
        // If yes the program runs again, if no, the program exits
        // the text of the exercise told to use both if and switch
        // however, I think that switch is redundant in this code
        switch (reattempt) {
            case 'y': {
                main(null);
                break;
            }
            default: {
                System.exit(0);
                break;
            }
        }

        scanner.close();
    }
}
