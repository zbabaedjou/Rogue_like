package roguelike;

public abstract class Vivant implements ElementUnivers{
	
	private int x;
	private int y;
	private int PV_actuel;
	private int attaque;
	private int armure;
	private int xp_value;
	private int direction_x; //la ou il regarde
	private int direction_y;// ={ -1 , 0 ou 1}
							// x ou y doit etre a 0 car pas de diagonale
	
	
	public String Interagir(Monstre m) {
		
		return this.combattre(m);
		
	}
	public String Interagir(Objet o) {
		
		String a_afficher ="";
		
		if(o == Objet.MUR) {
			return a_afficher = " c'est un MUR : "+o.get_symbole();
			
		}
		if(o == Objet.POMME) {
			this.set_PV_actuel(this.get_PV_actuel() + 15);
			return " c'est une POMME : "+o.get_symbole();
			 

		}
		if(o == Objet.PARCHEMIN_DE_FORCE) {
			this.set_attaque(get_attaque()+1);
			return " vous avez utiliser une PARCHEMIN_DE_FORCE : "+o.get_symbole()+"   HONTE A VOUS ne voulez vous donc aucun chalenge ?";
			 
		}
		if(o == Objet.SOL) {
			return " il n'y a rien devant vous";

		}
		
		if(o == Objet.ESCALIER) {
			return "Escalier";
			// creer une nouvelle map 
			// replacer le joueur 
		}
	return a_afficher;
//afficher(a_afficher);
	}
	public String Interagir(Joueur j) {
		String a_afficher = j.repondre();
		return a_afficher;
		//afficher(a_afficher);
	}
	
	public String combattreAll(ElementUnivers e){
		if (e instanceof Objet)
			return combattre((Objet)e);
		if (e instanceof Vivant)
			return combattre((Vivant)e);
		return "";
	}
	public String interagirAll(ElementUnivers e){
		if (e instanceof Objet)
			return Interagir((Objet)e);
		if (e instanceof Joueur)
			return Interagir((Joueur)e);
		if (e instanceof Monstre)
			return Interagir((Monstre)e);
		return "";
	}
	
	public String combattre(Vivant v) {
		String a_afficher ="";
		if(v.get_PV_actuel()>0) {
			if (this.get_attaque() > v.get_armure()) {
				v.set_PV_actuel(v.get_PV_actuel() -  (this.get_attaque() - v.get_armure()));
				a_afficher=this.get_symbole()+" dealt "+( (this.get_attaque() - v.get_armure()))+" to " + v.get_symbole()+"   ";
			}
				// ici on  suppose que les etres vivant rippostent toujours
			if (v.get_attaque() > this.get_armure()) {
				this.set_PV_actuel(this.get_PV_actuel() -  (v.get_attaque() - this.get_armure()));
				a_afficher=a_afficher+	v.get_symbole()+" dealt "+( (v.get_attaque() - this.get_armure()))+" to " + this.get_symbole();
					}
		}
		if(this.get_PV_actuel()<=0 && v.get_PV_actuel()<=0) {
			a_afficher="fin";
		}
		if(this.get_PV_actuel()<=0 && v.get_PV_actuel()> 0) {
			a_afficher="fin";
		}
		if(this.get_PV_actuel()>0 && v.get_PV_actuel()<=0) {
			a_afficher=v.get_symbole()+" est mort";
		}
		return a_afficher;
	}
	
	public String ramasser(Objet o){
		if(o == Objet.POMME) {
			o=Objet.SOL;
			return "YUMM vous venez de bouffer une POMME, vous gagnez : "+o.get_symbole()+" points";
			
		}
		else
			return "Ceci n'est pas un fruit.";
	}
	
	public String combattre(Objet o) {
		
		
		if(o == Objet.MUR) {
			return " c'est un MUR : "+o.get_symbole()+"  vous ne gagnerez pas contre lui";
		}
		
		if(o == Objet.POMME) {
			o=Objet.SOL;
			return "vous avez detruit une POMME : "+o.get_symbole();
			
		}
		if(o == Objet.PARCHEMIN_DE_FORCE) {
			o=Objet.SOL;
			return" vous avez detruit une PARCHEMIN_DE_FORCE : "+o.get_symbole()+"  HONTE A VOUS";

		}
		
		if(o == Objet.SOL) {
			return" il n'y a rien devan vous";

		}
		
		if(o == Objet.ESCALIER) {
			return " c'etait un ESCALIER : "+o.get_symbole()+" essayez d'interragir avec";
			// creer une nouvelle map 
			// replacer le joueur 
		}
	return "";
//afficher(a_afficher);
	}
	
	
	
	/// en gros : si le jouer se deplace vers du sol il y vas 
	/// il regarde dans cette dirrection de toute maniere 
	public String se_deplacer(int direction_x , int direction_y,
			ElementUnivers destination, Univers u) {
	
		this.direction_x=direction_x;
		this.direction_y=direction_y;
		
		//if(destination.get_char() == (char)250)
		if (destination == Objet.SOL ){			
		u.deplacer(this.x,this.y,this.x+direction_x,this.y+direction_y);
		this.x=this.x+direction_x;//destination.x;
		this.y=this.y+direction_y;//destination.y;
		
		return "";
		}
		else
			return "Oups! Vous ne pouvez pas aller la  ...";
		// sinon destination est un objet sur le quel on ne peut 
		// pas se deplacer : un monstre par ex
	}
	
	
	public int get_PV_actuel() {
		return this.PV_actuel;	
	}
	public int get_attaque  () {
		return this.attaque    ;
	}
	public int get_armure  () {
		return this.armure    ;
	}
	public int get_xp_value  () {
		return this.xp_value   ;
	}
	public int get_direction_x  () {
		return this.direction_x   ;
	}
	public int get_direction_y  () {
		return this.direction_y   ;
	}
	
	public void set_PV_actuel(int val) {
		 this.PV_actuel =val;	
	}
	public void set_attaque  (int val) {
		 this.attaque =val ;
	}
	public void set_armure  (int val) {
		 this.armure =val  ;
	}
	public void set_xp_value  (int val) {
		 this.xp_value =val ;
	}
	public void set_direction_x(int val) {
		 this.direction_x =val;	
	}
	public void set_direction_y(int val) {
		 this.direction_y =val;	
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPV() {
		return PV_actuel;
	}
	public void setPV(int pV) {
		PV_actuel = pV;
	}

}
