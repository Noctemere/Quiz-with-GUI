package OOPFinals;

public interface Result {
    public static void ScoreChecker(double score){
        try {
            checkScore(score);
            System.out.println("Score is valid: " + score);
            if (isPassing(score)) {
                System.out.println("You have Passed");
            } else {
                System.out.println("You have Failed");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid score: " + e.getMessage());
        }
    }
    public static void checkScore(double score) {
        assert (score >= 0 && score <= 100) : "Score is out of the accepted range (0-100)";

        if (score < 0) {
            throw new IllegalArgumentException("Negative scores are not allowed");
        }

        if (score > 100) {
            throw new IllegalArgumentException("Scores over 100 are not allowed");
        }
    }
    public static boolean isPassing(double score) {
        return (score >= 70.0 && score <= 100.0);
    }  
}   

