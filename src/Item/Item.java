package Item;


public class Item {
	private int cura;
	private boolean usado;
	
	public Item() {
		 this.cura = 40;
		 this.usado = true;
	}
	
	public int usarItem() {
		this.usado = false;
		return cura;
	}
	
	public boolean checkItem() {
		if(usado == true)
			return true;
		return false;
	}
	
	public int valorCura() {
		return cura;
	}
	
}
