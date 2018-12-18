package roguelike;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class Golbin extends Monstre{
	
	final static char symbole=((char)71);
	final static Color color=AsciiPanel.red;
	
	
	public Golbin(int x, int y){
		super(x,y);
		this.set_PV_actuel(100);
		this.set_attaque(10);
		this.set_armure(0);
		this.set_xp_value(1);
		this.set_direction_x(1);
		this.set_direction_y(0);
	
	}
	
	public char get_symbole() { return symbole; }
	
	
	public Color get_color() { return color; }

	
}
