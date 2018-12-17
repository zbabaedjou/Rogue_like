package roguelike;

import java.awt.Color;


public class Univers {
	
    public ElementUnivers[][] elements;
    PJ pj;
    private int width;
    private int height;
	//créer tableau monstres

    
    public Univers(ElementUnivers[][] elements){
        this.elements = elements;
        this.width = elements.length;
        this.height = elements[0].length;
    }
    
    
    /**
     * retourne le symbole qui est à la case (x,y) de elements
     * @param x
     * @param y
     * @return symbole
     */
	public char symbole(int x, int y){
	        return elements[x][y].get_symbole();
	    }
	
	/**
     * retourne la couleur de l'élément qui est à la case (x,y) de elements
     * @param x
     * @param y
     * @return Coulor
     */
	public Color color(int x, int y){
	        return elements[x][y].get_color();
    }
	
    
	/**
     * Ajoute des monstres dans le tableau d'éléments
     * @return le tableau de monstre
     */
    public void addMonstre(){
		int x;
		int y;
		int count=1;
		for(int i=0;i<count;i++){
			do{
				x = (int)(Math.random() * this.width);
				y = (int)(Math.random() * this.height);
				
			}while(!((Objet)elements[x][y]).estRemplacable());
			elements[x][y]=new Golbin(x,y);
		}
		count++;
		
	}
    
    
    /**
     * Ajoute un joueur dans le tableau d'éléments
     * @returnun Personne Joueur
     */
	public PJ addPj(){
		int x;
		int y;
		
		do{
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
			
		}while(elements[x][y] != Objet.SOL);
		pj=new PJ(x,y);
		elements[x][y]=pj;
		return pj;
			
	}
	
	/**
     * Ajoute un personnage non joueur dans le tableau d'éléments
     */
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
  
    
	public void deplacer(int x1, int y1,int x2,int y2){
		
		this.elements[x2][y2] = this.elements[x1][y1];
		this.elements[x1][y1]=Objet.SOL;

}
    
}

