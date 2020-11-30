package environment;

import java.awt.Color;
import java.util.Random;

import util.Case;

import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	//attributs
	protected Game game;
	protected Case leftPosition;
	protected boolean leftToRight;
	protected int length;
	protected final Color colorLtR = Color.BLACK;
	protected final Color colorRtL = Color.BLUE;
	// Nous avons retiré l'attributs speed car nous l'utilisons pour Lane  

	//constructeur
	public Car(Game g, Case beforeFirst, boolean leftToRight) {
		this.game = new Game(g.getGraphic(), g.width,g.height,g.minSpeedInTimerLoops,g.defaultDensity);
		this.leftToRight = leftToRight;
		
		//Attribuer une taille aleatoirement entre 1 et 3 
		int rand = 0;
		Random random = new Random();
		rand = random.nextInt(3) + 1;
		this.length = rand;
		
		this.leftPosition = new Case(beforeFirst.absc, beforeFirst.ord);
		
	}
	
	//methodes
	
	public void move() {
		if (this.leftToRight) {
			Case newPos = new Case(this.leftPosition.absc +1, this.leftPosition.ord);
			this.leftPosition = newPos;
			
		}
		else {
			Case newPos = new Case(this.leftPosition.absc -1, this.leftPosition.ord);
			this.leftPosition = newPos;
			
			
		}
		this.addToGraphics();
	}
	 //Methode qui verifie si la voiture existe déjà à la case donnée
	public boolean exists(Case c) {
		return (c.ord == this.leftPosition.ord && c.absc == this.leftPosition.absc);
	}
	
	// Methode qui verifie si la voiture est visible à l'interieur des bordures de la fenetre
	
	public boolean visible(){
		return this.leftPosition.absc > 0 || this.leftPosition.absc < this.game.width;
	}
	
	
	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	protected void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
