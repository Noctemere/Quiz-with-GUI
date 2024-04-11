package OOPFinals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileStream{
    private static final String FILE_PATH = "quiz_results.txt";

    public static void saveResult(String quizName, double score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println("Quiz: " + quizName);
            writer.println("Score: " + score);
            writer.println("-----------------------------");
        } catch (IOException e) {
            System.err.println("Error saving quiz result: " + e.getMessage());
        }
    }
}






