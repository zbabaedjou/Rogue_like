package roguelike;


import java.awt.event.KeyEvent;
import java.util.Objects;

import asciiPanel.AsciiPanel;

public class EcranJeu implements InterfaceAffichage {
	
		private int screenWidth;
		private int screenHeight;
		private Univers univers;
		private PJ pj;
		private int niveau;
		private InterfaceAffichage subscreen;
		private String messages;
		
		//créer tableau monstres
		public EcranJeu(){
			this.screenWidth = 80;
			this.screenHeight = 30;
			this.createUnivers();
			this.niveau=1;
			this.messages = "";
		}
		
		/**Création de l'univers
		 * Instantiation de l'univers en faisant usage de la fonction 
		 * generer de GenerUniver
		 * @return void
		 */		
		public void createUnivers(){
			univers = new GenerUnivers(screenWidth, screenHeight).generer();
			
			if(this.pj==null)
				this.pj =univers.addPj();
			else
				this.pj=univers.addPj(this.pj);
			this.niveau++;
			
		}
		
		
		
		
		
		/**
		 * Achiche les elements de l'univer dans le terminal
		 * @param terminal 
		 * @param left marge du haut avec afichage de l'univers
		 * @param top marge de gauche avec afichage de l'univers
		 */
		private void afficherElements(AsciiPanel terminal,int left, int top) {
			int wy;
			int wx; 
			for (int x = 0; x < screenWidth; x++){
				for (int y = 0; y < screenHeight; y++){
					wx = x + left;
					wy = y + top;
					terminal.write(univers.symbole(x, y),wx, wy, univers.color(x, y));
				}
			}
		}

		
		/**
		 * Afichage du terminal
		 */
		public void displayOutput(AsciiPanel terminal) {
	    	int left = 10;
			int top = 5; 
								
			terminal.writeCenter("RogueLike Game " ,1,AsciiPanel.red);
	        afficherElements(terminal,left, top);
	        
	        if(this.messages.equals("Escalier")){
	        	createUnivers();
	        	afficherElements(terminal,left, top);
	        	this.messages="Bravo!!! Vous venez de franchire une étape.";
	        }
	        	
	        terminal.writeCenter(this.messages, 43);
	        
	       String stats = String.format(" Niveau: "+this.niveau+"  Points de vie: "+String.valueOf(pj.get_PV_actuel()));
	       terminal.write(stats, 1, 44);
			
			
	        if (subscreen != null)
				subscreen.displayOutput(terminal);	   
	     
		}
		
		
		
		public void action(int x, int y){
			
			this.messages=this.pj.se_deplacer(x, y, this.univers.elements[this.pj.getX()+x][this.pj.getY()+y], this.univers);
			
		}
		public void ramasser(){
			this.messages=this.pj.ramasser((Objet)this.univers.elements[this.pj.get_direction_x()+this.pj.getX()][this.pj.get_direction_y()+this.pj.getY()]);
			
			if(this.messages.contains("YUMM vous"))
					this.univers.elements[this.pj.get_direction_x()+this.pj.getX()][this.pj.get_direction_y()+this.pj.getY()]=Objet.SOL;
			
		}
		
		public void combattre(){
			this.messages=pj.combattreAll(this.univers.elements[pj.get_direction_x()+pj.getX()][pj.get_direction_y()+pj.getY()]);
			if(this.messages.contains(" est mort"))				
				this.univers.elements[pj.get_direction_x()+pj.getX()][pj.get_direction_y()+pj.getY()]=Objet.SOL;
			
		}
		
		/**
		 * Gerer les interactions entre le joueur et le programme
		 */
	    public InterfaceAffichage respondToUserInput(KeyEvent key) {
	        switch (key.getKeyCode()){
	        
	        case KeyEvent.VK_ESCAPE: return new EcranPerdu();
	        case KeyEvent.VK_ENTER: return new EcranGagnee();	        
	        case KeyEvent.VK_LEFT:  action(-1, 0); break;
			case KeyEvent.VK_RIGHT: action( 1, 0); break;
			case KeyEvent.VK_UP:    action( 0,-1); break;
			case KeyEvent.VK_DOWN:  action( 0, 1); break;
			case KeyEvent.VK_A:  this.combattre(); break;								  
			case KeyEvent.VK_Z:  this.messages=pj.interagirAll(this.univers.elements[pj.get_direction_x()+pj.getX()][pj.get_direction_y()+pj.getY()]); break;
			case KeyEvent.VK_R:  this.ramasser(); break; //Benjamin

	        }
	    
	        return this;
	    }
	


}
