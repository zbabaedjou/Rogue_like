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
	
	
	public void Interagir(Monstre m) {
		this.combattre(m);
	}
	public void Interagir(Objet o) {}
	public void Interagir(Joueur j) {}
	
	public void combattre(Vivant v) {
		if (this.get_attaque() > v.get_armure())
			v.set_PV_actuel(v.get_PV_actuel() - (this.get_attaque() - v.get_armure()));
		// ici on  suppose que les etres vivant rippostent toujours
		if (v.get_attaque() > this.get_armure())
			this.set_PV_actuel(this.get_PV_actuel() - (v.get_attaque() - this.get_armure()));
		
	}
	public void combattre(Objet o) {
		// il faut juste que la fonction existe afin de ne pas créer de bug lorsque 
		// on essaye de combattre un objet
		// alors par pitié ziadadh ne la suprime pas 
	}
	
	
	/// en gros : si le jouer se deplace vers du sol il y vas 
	/// il regarde dans cette dirrection de toute maniere 
	public void se_deplacer(int direction_x , int direction_y,
			ElementUnivers destination, Univers u) {
	
		this.direction_x=direction_x;
		this.direction_y=direction_y;
		
		//if(destination.get_char() == (char)250)
		if (destination == Objet.SOL )
		this.x=this.x+direction_x;//destination.x;
		this.y=this.y+direction_y;//destination.y;
		u.deplacer(this.x,this.y,this.x-direction_x,this.y-direction_y);
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
