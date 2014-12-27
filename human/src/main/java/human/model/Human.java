package human.model;

public class Human {
	String name;
	Status status;
	Psychopass psychoPass;
	
	public Human(String name, Psychopass psychopass) {
		this.name = name;
		this.status = Status.NORMAL;
		this.psychoPass = psychopass;
	}

	public String getName() {
		return name;
	}
	
	public Psychopass getPsychoPass() {
		return psychoPass;
	}
	
	public void paralize(){
		status = Status.PARALIZE;
	}
	public String image(){
		if(status.equals(Status.PARALIZE)){
			return "hoge-paralize.jpg";
		}
		return "hoge.jpg";
	}
}
