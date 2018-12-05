package roguelike;

public class Joueur extends Humain{
	
	public Joueur() {
		this.PV_actuel=100;
		this.PV_max=100;
		this.attaque=0;
		this.armure=0;
		this.xp_value=0;
		this.nom="inconnu";
		this.direction=0;
	}	
	
	public Joueur(String name) {
		this.PV_actuel=100;
		this.PV_max=100;
		this.attaque=0;
		this.armure=0;
		this.xp_value=0;
		this.nom=name;
		this.direction=0;
	}
	
	public void SeDefendre() {
		
	}
	public void Interagir() {
		
	}
	public void attaquer(Monstre m) {
		
	}
	public void attaquer(Humain h) {
		
	} 
}
