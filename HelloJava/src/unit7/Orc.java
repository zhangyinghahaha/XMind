package unit7;

import static com.ying.util.Print.*;

class Villain {
	private String name;
	
	protected void set(String nm) {
		name = nm;
	}
	
	public Villain(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}

public class Orc extends Villain {
	
	private int orcNumber;
	
	public Orc(String name, int orcNumber) {
		super(name);
		this.orcNumber = orcNumber;
	}
	
	public void change(String name, int orcNumber) {
		set(name);
		this.orcNumber = orcNumber;
	}

}
