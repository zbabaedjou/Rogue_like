
package roguelike;

public abstract class Monstre extends Vivant{
	private int x;
	private int y;
	private int PV_actuel;	
	private GenerUnivers univers;
	
	public Monstre(int x, int y){
		this.x=x;
		this.y=y;
		this.univers=univers;
	}
	
	public void SeDefendre() {}
	public void Interagir() {}
	public void attaquer(Monstre m) {}
	//public void attaquer(Humain h) {}
	
	public int get_PV_actuel() {
		return this.PV_actuel;	
	}
	
	public void set_PV_actuel(int val) {
		 this.PV_actuel =val;	
	}

	
	
} 
