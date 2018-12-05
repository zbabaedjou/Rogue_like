package roguelike;

public class Squelette extends Monstre{
	
	public void SeDefendre() {}
	public void Interagir() {}
	public void attaquer(Monstre m) {
		if (this.attaque > m.armure)
		m.PV_actuel=m.PV_actuel - (this.attaque - m.armure);
		// else 0 damage dealt
	}
	public void attaquer(Humain h) {
		if (this.attaque > h.armure)
			h.PV_actuel=h.PV_actuel - (this.attaque - h.armure);
		
	}

}
