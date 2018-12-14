package roguelike;

public abstract class Joueur implements ElementUnivers{
	private int x;
	private int y;
	private int PV;
	
	public Joueur(int x, int y) {
		this.x=x;
		this.y=y;
		
	}	
	
	
	public void SeDefendre() {
		
	}
	public void Interagir() {
		
	}
	public void attaquer(Monstre m) {
		
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getPV() {
		return PV;
	}


	public void setPV(int pV) {
		PV = pV;
	}
	
}
