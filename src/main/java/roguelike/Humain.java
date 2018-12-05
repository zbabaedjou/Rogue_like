package roguelike;

public abstract class Humain extends ElementDeJeu{
	private int PV_actuel;
	private int PV_max;
	private int attaque;
	private int armure;
	private int xp_value;
	private int direction; //lq ou le joueur regqrde
	private String nom;
	/*
	public liste <objet> inventaire 
	public liste <objet> equipement
	
	
	
	 */
	
	
	public void SeDefendre() {}
	public void Interagir() {}
	public void attaquer(Monstre m) {} // il attaque devan lui
	public void attaquer(Humain h) {} 
	
	
}
