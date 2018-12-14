package roguelike;

import java.awt.Color;

public class Univers {
	
    public ElementUnivers[][] elements;
    PJ pj;
    private int width;
    private int height;
    
    
    public Univers(ElementUnivers[][] elements){
        this.elements = elements;
        this.width = elements.length;
        this.height = elements[0].length;
    }
    
   
    /*
     * Cette fonction retour le symbole qui est à la case
     * [x][y] de la variable éléments
     */
	public char symbole(int x, int y){
	        return elements[x][y].symbole();
	    }
	
	/*
     * Cette fonction retour la couleur qui est à la case
     * [x][y] de la variable éléments
     */
	public Color color(int x, int y){
	        return elements[x][y].color();
    }
	
    
    /*
     * Ajoute des montres dans le tableau d'éléments
     */
    public void ajouterMonstre(){
		int x;
		int y;
		int count=1;
		for(int i=0;i<count;i++){
			do{
				x = (int)(Math.random() * this.width);
				y = (int)(Math.random() * this.height);
				
			}while(!((Objet) elements[x][y]).estRemplacable());// methode a probleme.
			elements[x][y]=new Golbin(x,y);
		}
		count++;
		
	}
	
	public void addPj(){
		int x;
		int y;
		
		do{
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
			
		}while(((Objet) elements[x][y]).symbole()!='.');
		pj=new PJ(x,y);
		elements[x][y]=pj;
		((PNJ)elements[x][y]).setPV(5);
			
	}
	
	public void addPnj(){
		int x;
		int y;
		int count =1;
		for(int i=0;i<count;i++){
			
			do{
				x = (int)(Math.random() * width);
				y = (int)(Math.random() * height);
				
			}while(!((Objet) elements[x][y]).estRemplacable());
			elements[x][y]=new PNJ(x,y);
			
		}
		
		count=(int)(Math.random() * width);
		
			
	}
	
	public int height() { return height; }
    public int width() { return width; }


}

