package liangsheng.music.dictionary;

public class Bean {
	public int id;
	public String english;
	public String chinese;
	public String status;
	
	public Bean(String english, String chinese) {
		this.english = english;
		this.chinese = chinese;
	}
	
	public Bean(int id, String english, String chinese, String status) {
		this.id = id;
		this.english = english;
		this.chinese = chinese;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bean [english=" + english + ", chinese=" + chinese + "]";
	}
}
