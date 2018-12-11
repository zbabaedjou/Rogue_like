package roguelike;

import java.awt.Color;

public class Univers {
    private ElementUnivers[][] elements;
    private int width;
    public int width() { return width; }

    private int height;
    public int height() { return height; }

    public Univers(ElementUnivers[][] elements){
        this.elements = elements;
        this.width = elements.length;
        this.height = elements[0].length;
    }
    
    public ElementUnivers tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Objet.BOUNDS;
        else
            return elements[x][y];
    }


	public char glyph(int x, int y){
	        return tile(x, y).symbole();
	    }
	
	
	public Color color(int x, int y){
	        return tile(x, y).color();
    }

}

