package oopfinals;

import OOPFinals.FileStream;
import OOPFinals.Question;
import OOPFinals.QuestionBank;
import OOPFinals.TopicEnum;
import javax.swing.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;
import java.util.Enumeration;

public class GUI {
    private static JLabel timerLabel;
    private static JFrame frame;
    private static QuestionBank questionBank;
    private static TopicEnum selectedTopic;
    private static List<Question> currentQuestions;
    private static int currentQuestionIndex = 0;
    private static double score = 0;
    private static Timer quizTimer;
    private static int timeLeft = 600; // 10 minutes in seconds

    public static void main(String[] args) {
        questionBank = new QuestionBank();
        frame = new JFrame("Object Oriented Programming Quiz");
        showTitleScreen();
    }

    private static void showTitleScreen() {
        JPanel panel = new JPanel();
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Object Oriented Programming Quiz", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(e -> showTopicSelection());
        frame.add(startButton, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

private static void showTopicSelection() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0, 1));
    frame.getContentPane().removeAll();

    JLabel chooseLabel = new JLabel("Choose a topic:");
    panel.add(chooseLabel);

    for (TopicEnum topic : TopicEnum.values()) {
        if(topic != TopicEnum.MIXED_TOPICS){
        JButton topicButton = new JButton(topic.getDisplayName());
        topicButton.addActionListener(e -> startRegularQuiz(topic));
        panel.add(topicButton);
        }
    }

    JButton mixedTopicsButton = new JButton("Mixed Topics");
    mixedTopicsButton.addActionListener(e -> startMixedTopicsQuiz());
    panel.add(mixedTopicsButton);

    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(e -> System.exit(0));
    panel.add(exitButton);

    frame.add(panel);
    frame.revalidate();
    frame.repaint();
}

private static void startRegularQuiz(TopicEnum topic) {
    selectedTopic = topic;
    currentQuestions = questionBank.getQuestionsForTopic(topic);
    currentQuestionIndex = 0;
    score = 0;
    startTimer();
    showNextQuestion();
}

private static void startMixedTopicsQuiz() {
    selectedTopic = TopicEnum.MIXED_TOPICS;
    List<Question> allQuestions = new ArrayList<>(questionBank.getQuestions().values());
    Collections.shuffle(allQuestions);
    currentQuestions = allQuestions.subList(0, Math.min(10, allQuestions.size())); // Adjust 10 based on the number of questions you want
    currentQuestionIndex = 0;
    score = 0;
    startTimer();
    showNextQuestion();
}

private static void startTimer() {
        timeLeft = 600; // Reset time for each quiz
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                SwingUtilities.invokeLater(() -> {
                    if (timeLeft <= 0) {
                        quizTimer.cancel();
                        endQuiz();
                        timeLeft=600;
                    } else {
                        timerLabel.setText("Time left: " + timeLeft + " seconds");
                    }
                });
            }
        }, 1000, 1000);
    }

    private static void showNextQuestion() {
       if (currentQuestionIndex >= currentQuestions.size()) {
        endQuiz();
        return;
    }

    Question currentQuestion = currentQuestions.get(currentQuestionIndex);
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    frame.getContentPane().removeAll();

    JLabel questionLabel = new JLabel("<html>" + currentQuestion.getQuestionText() + "</html>");
    panel.add(questionLabel);

    ButtonGroup optionsGroup = new ButtonGroup();
    for (String option : currentQuestion.getOptions()) {
        JRadioButton optionButton = new JRadioButton(option);
        optionsGroup.add(optionButton);
        panel.add(optionButton);
    }

    JButton nextButton = new JButton("Next");
    nextButton.addActionListener(e -> {
        String selectedAnswer = getSelectedButtonText(optionsGroup);
        if (selectedAnswer != null) {
            if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                score += 10; // Update score for correct answer
            }
            currentQuestionIndex++;
            showNextQuestion();
        } else {
            // No answer selected, handle as needed
            JOptionPane.showMessageDialog(frame, "Please select an answer.");
        }
    });

    panel.add(nextButton);

    // Timer display
    timerLabel = new JLabel("Time left: " + timeLeft + " seconds", SwingConstants.CENTER);
    panel.add(timerLabel);

    frame.add(panel);
    frame.revalidate();
    frame.repaint();
}

    private static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    private static void endQuiz() {
        JPanel panel = new JPanel();
        frame.getContentPane().removeAll();

        JLabel scoreLabel = new JLabel("Your score: " + score, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(scoreLabel, BorderLayout.NORTH);

        JButton returnButton = new JButton("Return to Menu");
        returnButton.addActionListener(e -> showTopicSelection());
        frame.add(returnButton, BorderLayout.CENTER);

        // Save result to file
        FileStream.saveResult(selectedTopic.getDisplayName(), score);

        frame.revalidate();
        frame.repaint();
    }
}