package Item;

import java.util.Random;

public class Item {
	Random rand = new Random();
	private int cura;
	private boolean usado;
	
	public Item() {
		 this.cura = rand.nextInt(50);
		 this.usado = true;
	}
	
	public int usarItem() {
		this.usado = false;
		return cura;
	}
	
	public boolean checkItem() {
		if(usado == true)
			return false;
		return true;
	}
	
	public int valorCura() {
		return cura;
	}
	
}
