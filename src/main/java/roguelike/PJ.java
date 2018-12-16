package roguelike;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class PJ extends Joueur{

	final static char symbole=((char)72);
	final static Color color=AsciiPanel.blue;
	
	public PJ(int x,int y) {
		super(x,y);
		
	}
	
	public char get_symbole() { return symbole; }
	
	
	public Color get_color() { return color; }
	
	// seul le joueur interragit differament avec un escalier
	@Override
	public void Interagir(Objet o) {
		if (o == Objet.ESCALIER) {
			// genere un nouveau niveau
			
			/*
			
			univers.elements = genere univers
			replacer le joueur
			
			*/
			
		}
	}
	
}
