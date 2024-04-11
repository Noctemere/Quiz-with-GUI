package OOPFinals;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Question {
    private String questionText;
    private ArrayList<String> options;
    private String correctAnswer;
    private TopicEnum topic;

    public Question(String questionText, ArrayList<String> options, String correctAnswer, TopicEnum topic) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.topic = topic;
    }

    public abstract void display();

    // Getters and Setters
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public TopicEnum getTopic() {
        return topic;
    }

    public void setTopic(TopicEnum topic) {
        this.topic = topic;
    }
}

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, ArrayList<String> options, String correctAnswer, TopicEnum topic) {
        super(questionText, options, correctAnswer, topic);
    }

   @Override
    public void display() {
        char option = 'A';
        for (String opt : getOptions()) {
            System.out.println(option + ". " + opt);
            option++;
        }
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer, TopicEnum topic) {
        super(questionText, new ArrayList<>(Arrays.asList("True", "False")), correctAnswer, topic);
    }

    @Override
    public void display() {
        System.out.println("True");
        System.out.println("False");
    }
}