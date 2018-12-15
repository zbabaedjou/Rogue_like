package roguelike;

import java.awt.Color;
import java.util.Random;

import asciiPanel.AsciiPanel;

public enum Objet implements ElementUnivers{
    SOL((char)250, AsciiPanel.yellow),
    MUR((char)177, AsciiPanel.yellow);
    //ARBRE((char)5, AsciiPanel.yellow);
    //PIECES((char)233, AsciiPanel.red),
   // BOUNDS('x', AsciiPanel.brightBlack);
    
	private int x;
	private int y;
    private char symbole;
    private Color color;
    
    public char get_symbole() { return symbole; }

    public Color get_color() { return color; }

    Objet(char symbole, Color color){
        this.symbole = symbole;
        this.color = color;
    }
    
  
    public static Objet getRandomElement() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    
    public boolean estRemplacable() {
		return this.symbole == '.';
	}
}

