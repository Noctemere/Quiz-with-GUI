package OOPFinals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
        Scanner input = new Scanner(System.in);
        QuestionBank questionBank = new QuestionBank();

         // Display available topics
        System.out.println("Available Topics:");
        for (TopicEnum topic : TopicEnum.values()) {
            System.out.println(topic.ordinal() + 1 + ". " + topic);
        }

        // Get user's topic choice
        TopicEnum selectedTopic = takeTopicInput();

        // Take the quiz for the selected topic or mixed topics with a timer
        double userScore = (selectedTopic == TopicEnum.MIXED_TOPICS)
                ? TestSystem.takeMixedTopicsQuizWithTimer(questionBank)
                : TestSystem.takeQuizWithTimer(questionBank, selectedTopic);

        // Display and check the user's score
        Result.ScoreChecker(userScore);
       
        FileStream.saveResult(selectedTopic.getDisplayName(), userScore);
 
    }
    }
    
    public static TopicEnum takeTopicInput() {
        return TestSystem.chooseTopic();
    }
}
