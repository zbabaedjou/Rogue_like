package roguelike;

public class Goblin extends Monstre{
	
	public void SeDefendre() {}
	public void Interagir() {}
	public void attaquer(Monstre m) {
		if (this.get_attaque() > m.get_armure())
		m.set_PV_actuel(m.get_PV_actuel() - (this.get_attaque() - m.get_armure()));
		// else 0 damage dealt
	}
	public void attaquer(Humain h) {
		if (this.get_attaque() > h.get_armure())
			h.set_PV_actuel(h.get_PV_actuel() - (this.get_attaque() - h.get_armure()));
		
	}

}
