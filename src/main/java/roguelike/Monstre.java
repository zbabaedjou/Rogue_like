

package roguelike;

public abstract class Monstre implements ElementUnivers{
	private int x;
	private int y;
	private int PV_actuel;	
	private int attaque;
	private int armure;
	private int xp_value;
	private int direction; //la ou le monstre regarde

	
	public void SeDefendre() {}
	public void Interagir() {}
	public void attaquer(Monstre m) {}
	//public void attaquer(Humain h) {}
	
	public int get_PV_actuel() {
		return this.PV_actuel;	
	}
	
	public int get_attaque  () {
		return this.attaque    ;
	}
	public int get_armure  () {
		return this.armure    ;
	}
	public int get_xp_value  () {
		return this.xp_value   ;
	}
	
	public void set_PV_actuel(int val) {
		 this.PV_actuel =val;	
	}

	public void set_attaque  (int val) {
		 this.attaque =val ;
	}
	public void set_armure  (int val) {
		 this.armure =val  ;
	}
	public void set_xp_value  (int val) {
		 this.xp_value =val ;
	}
} 