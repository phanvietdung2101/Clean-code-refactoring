public class TennisGame {
    final static String LOVE = "Love";
    final static String FIFTEEN = "Fifteen";
    final static String THIRTY = "Thirty";
    final static String FORTY = "Forty";
    final static String DEUCE = "Deuce";
    final static String SEPARATE_BETWEEN_SCORE = "-";
    final static String ALL = "All";

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {


        String score = "";
        boolean isEqualScore = m_score1 == m_score2;
        boolean isGotFourthPoint = m_score1 >= 4 || m_score2 >= 4;

        if (isEqualScore)
            score += getStringScore(m_score1) + SEPARATE_BETWEEN_SCORE + ALL;
        else if (isGotFourthPoint)
        {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1)
                score ="Advantage " + player1Name;
            else if (minusResult == -1)
                score ="Advantage " + player2Name;
            else if (minusResult >= 2)
                score = "Win for " + player1Name;
            else
                score ="Win for " + player2Name;
        }
        else
        {
            int tempScore = 0;
            for (int i = 1; i < 3; i++)
            {
                if (i == 1)
                    tempScore = m_score1;
                else {
                    score += SEPARATE_BETWEEN_SCORE;
                    tempScore = m_score2;
                }
                score += getStringScore(tempScore);
            }
        }
        return score;
    }

    private static String getStringScore(int score){
        switch(score)
        {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return DEUCE;
        }
    }
}
