# Rogue_like
README ROGUE_lIKE

  L'expressionn RogueLike tire de son nom du jeu Rogue,donc similaire a Rogue .
  Chaque element du jeu y compris les noms vivants ,mais aussi les personnages et les ennemis,
  est donc représenté visuellement.
  Cela consiste a avoir des joueurs (H) qui peuvent se combattre avec un autre  joueur (H) 
  ou encombattant Une quantite de montres a chaque niveau.
  
 L'univers de jeu se présente sous la forme d'un tableau  dont chaque case correspond à un symbole ASCII.
 Ces symboles  (les elments de l'univers)  représentent le sol, les murs, ainsi que les objets et les etres vivants.
 Cet univers doit être généré aléatoirement à chaque début de partie: la disposition des différentes pièces, 
 ainsi que l'emplacement des objets des etres vivants  et des monstres.
  


GENERATION_UNIVERS
	pour fabriquer un en environement explorable il falais que chaque case SOL soit accessible par les joueur
	j'ai donc pour cela vu le problem comme de la generation de graph connex
	les sommets sont X les arc -- ou |
	le tableaau est comme ceci pour pouvoir implementer
	Maze Generation: Recursive Backtracking
	X--X--X--X			
	|  |  |  |			
	X--X--X--X		
	|  |  |  |			
	X--X--X--X	
		|
		|
		|
		V
	X--X  X--X			
	   |  |  |			
	X--X  X  X		
	|  |  |   			
	X  X--X--X			
	au debut tout le  tableau est composé de mur 
	je creuse le tableau
	generant anssi un graph connex (ma methode d'exploration etant aleatoire j'obtien un labyrinth)
	je fait enssuite des trou dans le tableau , que j'appelle salle
	et je place des monstres dans les salles
	je place l'escalier dans une salle
	
	
	
	
	
	
	
	
