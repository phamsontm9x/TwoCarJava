package TwoCars;

public class Score {
	private int scoreX,scoreY,scoreStar;
	
	public Score (int x, int y, int score) {
		scoreX = x;
		scoreY = y;
		scoreStar = score;
	}

	public int getScoreStar() {
		return scoreStar;
	}

	public void setScoreStar(int scoreStar) {
		this.scoreStar = scoreStar;
	}

	public int getScoreX() {
		return scoreX;
	}

	public void setScoreX(int scoreX) {
		this.scoreX = scoreX;
	}

	public int getScoreY() {
		return scoreY;
	}

	public void setScoreY(int scoreY) {
		this.scoreY = scoreY;
	}
	
}
