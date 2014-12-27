package human.model;

public class Human {
	String name;
	Psychopass psychoPass;
	
	public Human(String name, Psychopass psychopass) {
		this.name = name;
		this.psychoPass = psychopass;
	}

	public String getName() {
		return name;
	}
	
	public Psychopass getPsychoPass() {
		return psychoPass;
	}
}
