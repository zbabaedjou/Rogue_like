package roguelike;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class Golbin extends Monstre{
	
	final static char symbole=((char)71);
	final static Color color=AsciiPanel.red;
	
	
	public Golbin(int x, int y){
		super(x,y);
	}
	
	public char get_symbole() { return symbole; }
	
	
	public Color get_color() { return color; }
	

}
