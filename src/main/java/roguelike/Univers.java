package roguelike;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class Univers {
	private int width;
    private int height;
    PJ pj;
    public ElementUnivers[][] elements;
   
 
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
     * Ajoute un joueur avec des paramettres spécifiques dans le tableau d'éléments
     * @param un PJ
     * @return une Personne Joueur
     */
	public PJ addPj(PJ j){
		int x;
		int y;
		
		do{
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
			
		}while(elements[x][y] != Objet.SOL);
		j.setX(x);
		j.setY(y);
		elements[x][y]=j;
		
		return j;
			
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
	
	public void save() throws IOException {
		String s="";
		
		String pj_x= Integer.toString(this.pj.getX());
		String pj_y= Integer.toString(this.pj.getY());
		String pj_pv= Integer.toString(this.pj.get_PV_actuel());
		String pj_attaque= Integer.toString(this.pj.get_attaque());
		String pj_armure= Integer.toString(this.pj.get_armure());
		String pj_xp_value=Integer.toString(this.pj.get_xp_value());
		String pj_dirrection_x= Integer.toString(this.pj.get_direction_x());
		String pj_dirrection_y= Integer.toString(this.pj.get_direction_y());
		
	    String _width=Integer.toString(this.width);
	    String _height=Integer.toString(this.height);

	      
	    
	      FileOutputStream fos = null;

	  	File f = new File("save.txt");
	  	System.out.println("le fichier save est ici  :  "+ f.getAbsolutePath());
		Charset charset = Charset.forName("UTF-8");
		Writer writer = new OutputStreamWriter(new FileOutputStream(f), charset);
		try {
			writer.write(_width+(char)13);
			writer.write(_height+(char)13);
			writer.write(pj_x+(char)13);
			writer.write(pj_y+(char)13);
			writer.write(pj_pv+(char)13);
			writer.write(pj_attaque+(char)13);
			writer.write(pj_armure+(char)13);
			writer.write(pj_xp_value+(char)13);
			writer.write(pj_dirrection_x+(char)13);
			writer.write(pj_dirrection_y+(char)13);
			int y;
			int x;
			for (x = 0; x < width; x++) {
				for (y = 0; y < height-1; y++) {
					s=s+elements[x][y].get_symbole()+" ";
					writer.write(s);
					s="";
				}
				System.out.println("x : "+ x+ "y : "+y);
				
				s=s+elements[x][y].get_symbole()+"\n";
				writer.write(s);
				s="";
			}
			
			
		} finally {
			writer.close();
		}
	}
	public void load() throws IOException {
		String s="";
		int int_actuel=50;
		

	  	File f = new File("save.txt");
	  	System.out.println("le fichier save est ici  :  "+ f.getAbsolutePath());

		Reader reader = new FileReader("save.txt");
		try {
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.width=int_actuel;
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.height=int_actuel;
			int_actuel=0;
			
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.setX(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.setY(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.set_PV_actuel(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.set_attaque(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.set_armure(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.set_xp_value(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.set_direction_x(int_actuel);
			int_actuel=0;
			
			while(int_actuel != (int)'\n') {
				int_actuel=int_actuel*10 +reader.read();
			}
			this.pj.set_direction_y(int_actuel);
			int_actuel=0;
			
	
			
			int y;
			int x;
			for (x = 0; x < width; x++) {
				for (y = 0; y < height-1; y++) {
					int_actuel=reader.read();
					if(int_actuel==250) {
						elements[x][y] =  Objet.SOL;
					}
					if(int_actuel==170) {
						elements[x][y] =  Objet.MUR;
					}
					if(int_actuel==233) {
						elements[x][y] =  Objet.POMME;
					}
					if(int_actuel==(int)'?') {
						elements[x][y] =  Objet.PARCHEMIN_DE_FORCE;
					}
					if(int_actuel==(int)'E') {
						elements[x][y] =  Objet.ESCALIER;
					}
					if(int_actuel==72) {
						elements[x][y] =  this.pj;
					}
					if(int_actuel==64) {
						elements[x][y]=  new PNJ( x,  y);
					}
					if(int_actuel==(int)'G') {
						elements[x][y] =  new Golbin( x,  y);
					}
					if(int_actuel==(int)'Z') {
						elements[x][y] =  new Zombie( x,  y);
					}
					reader.read();
				}
			
				s=s+elements[x][y].get_symbole()+"\n";
				//writer.write(s);
				s="";
			}
			
			
		} finally {
			reader.close();
		}
	}
	
	
    
}

