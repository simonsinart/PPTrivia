package fri.pp.trivia;
public class TopScore {
	private int ID;
	private String name;
	private int score;
	
	public TopScore()
	{
		ID = 0;
		name="";
		score=0;
	}
	public TopScore(String name, int score) {
		
		this.name = name;
		this.score = score;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setID(int id)
	{
		ID=id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}

