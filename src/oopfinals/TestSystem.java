// QuizApp.java
package OOPFinals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TestSystem{
    private static final int TIME_LIMIT_MINUTES = 10;
    
    public static void main(String[] args) {
        // Create a QuestionBank instance
        QuestionBank questionBank = new QuestionBank();

        // Display available topics
        System.out.println("Available Topics:");
        for (TopicEnum topic : TopicEnum.values()) {
            System.out.println(topic.ordinal() + 1 + ". " + topic);
        }

        // Get user's topic choice
        TopicEnum selectedTopic = chooseTopic();

        // Take the quiz for the selected topic or mixed topics with a timer
        double userScore = (selectedTopic == TopicEnum.MIXED_TOPICS)
                ? takeMixedTopicsQuizWithTimer(questionBank)
                : takeQuizWithTimer(questionBank, selectedTopic);

        // Display and check the user's score
        Result.ScoreChecker(userScore);
    }

    public static TopicEnum chooseTopic() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter the number corresponding to your chosen topic:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            if (choice < 1 || choice > TopicEnum.values().length + 1) {
                System.out.println("Invalid choice. Please enter a valid topic number.");
            }
        } while (choice < 1 || choice > TopicEnum.values().length + 1);

        return (choice == TopicEnum.values().length + 1) ? TopicEnum.MIXED_TOPICS : TopicEnum.values()[choice - 1];
    }


public static double takeQuizWithTimer(QuestionBank questionBank, TopicEnum selectedTopic) {
    final Scanner scanner = new Scanner(System.in);
    final double[] score = {0};

    // Convert minutes to seconds for timer
    int timeLimitSeconds = TIME_LIMIT_MINUTES * 60;

    // Iterate through questions
    for (Map.Entry<String, Question> entry : questionBank.getQuestions().entrySet()) {
        Question question = entry.getValue();

        // Check if the question belongs to the selected topic
        if (question.getTopic() != selectedTopic) {
            continue; // Skip this question if it's not the selected topic
        }

        // Display the question
        System.out.println("Question ID: " + entry.getKey());
        System.out.println(question.getQuestionText());
        question.display();

        // Print time left at the beginning
        System.out.println("\nTime left: " + timeLimitSeconds / 60 + " minutes");

        // Create a timer for the quiz
        Timer timer = new Timer();
        int[] secondsLeft = {timeLimitSeconds};

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (secondsLeft[0] <= 0) {
                    System.out.println("\nTime's up! Quiz completed.");
                    scanner.close();
                    timer.cancel();
                    timer.purge();
                } else {
                    // Update and display the timer occasionally
                    if (secondsLeft[0] % 60 == 0) {
                        System.out.println("\nTime left: " + secondsLeft[0] / 60 + " minutes");
                    }
                    secondsLeft[0]--;
                }
            }
        }, 1000, 1000); // Run the timer task every second

        // Get user input
        String userAnswer;
        do {
            System.out.println("Enter your answer:");
            userAnswer = scanner.nextLine().toUpperCase();
        } while (userAnswer.isEmpty());

        // Compare user's answer with the correct answer
        if (question instanceof TrueFalseQuestion) {
            String correctAnswer = ((TrueFalseQuestion) question).getCorrectAnswer();
            if (userAnswer.equals(correctAnswer.toUpperCase())) {
                System.out.println("Correct!");
                score[0] += 10;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswer);
            }
        } else if (userAnswer.equals(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score[0] += 10;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
        }

        // Shutdown the timer after each question
        timer.cancel();
        timer.purge();
        System.out.println();  // Add a line break for better readability
    }

    // Close the scanner after all questions are answered or time is up
    scanner.close();

    return score[0];
}


public static double takeMixedTopicsQuizWithTimer(QuestionBank questionBank) {
    final Scanner scanner = new Scanner(System.in);
    final double[] score = {0};

    // Convert minutes to seconds for timer
    int timeLimitSeconds = TIME_LIMIT_MINUTES * 60;

    // Create a timer for the quiz
    Timer timer = new Timer();
    int[] secondsLeft = {timeLimitSeconds};

    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            if (secondsLeft[0] <= 0) {
                System.out.println("\nTime's up! Quiz completed.");
                scanner.close();
                timer.cancel();
                timer.purge();
            } else {
                // Update and display the timer occasionally
                if (secondsLeft[0] % 60 == 0) {
                    System.out.println("\nTime left: " + secondsLeft[0] / 60 + " minutes");
                }
                secondsLeft[0]--;
            }
        }
    }, 1000, 1000); // Run the timer task every second

    // Get all questions from the QuestionBank
    List<Question> allQuestions = new ArrayList<>(questionBank.getQuestions().values());

    // Shuffle the questions
    Collections.shuffle(allQuestions);

    // Iterate through shuffled questions
    int questioncount = 0;
    for (Question question : allQuestions) {
        if(questioncount >= 10){
            break;
        }
        questioncount++;
        // Print time left at the beginning
        System.out.println("\nTime left: " + secondsLeft[0] / 60 + " minutes");

        // Display the question
        System.out.println("Question ID: " + questionBank.getQuestionId(question));
        System.out.println(question.getQuestionText());
        question.display();

        // Get user input
        String userAnswer;
        do {
            System.out.println("Enter your answer:");
            userAnswer = scanner.nextLine().toUpperCase();
        } while (userAnswer.isEmpty());

        // Compare user's answer with the correct answer
        if (question instanceof TrueFalseQuestion) {
            String correctAnswer = ((TrueFalseQuestion) question).getCorrectAnswer();
            if (userAnswer.equals(correctAnswer.toUpperCase())) {
                System.out.println("Correct!");
                score[0] += 10;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswer);
            }
        } else if (userAnswer.equals(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score[0] += 10;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
        }

        System.out.println();  // Add a line break for better readability
    }

    // Close the scanner after all questions are answered or time is up
    scanner.close();

    // Cancel the timer after the quiz is completed
    timer.cancel();
    timer.purge();

    return score[0];
}

    public void submitAnswer(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void startQuiz(TopicEnum topic) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
