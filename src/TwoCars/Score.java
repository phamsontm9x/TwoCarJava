package TwoCars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Score {
	private int scoreX,scoreY,scoreStar,score;
	private boolean isShowScore;
	
	public boolean isShowScore() {
		return isShowScore;
	}

	public void setShowScore(boolean isShowScore) {
		this.isShowScore = isShowScore;
	}

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
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	public String CompareScore(int newScore) {
		String result = "";
		try {
			File file = new File("res/score.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			result = reader.readLine();
			int highScore = Integer.parseInt(result);
			reader.close();
			if( highScore < newScore) {
				BufferedWriter fileScore = new BufferedWriter(new FileWriter(file));
				result = Integer.toString(newScore);
				fileScore.write(result);
				fileScore.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
