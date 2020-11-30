package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
	//attributs
	private Game game;
	ArrayList<Lane> road = new ArrayList<>();
	
	//Constructeur
	public Environment(Game g) {
		this.game = new Game(g.getGraphic(), g.width,g.height,g.minSpeedInTimerLoops,g.defaultDensity);
		road = new ArrayList<Lane>(g.height);
		for (int i = 0; i< g.height; i++) {
			road.add(new Lane(g, i,g.defaultDensity ));
		}
		
	}
	
	//Methodes
	
	

	
	
	public boolean isSafe(Case c) {
		return road.get(c.ord).isSafe(c);
	}
	
	public boolean isWinningPosition(Case c) {
		if (c.ord == game.height - 1)
			return true;
		return false;
	}
	
	public void update() {
		for (Lane l : this.road) {
			l.updateLane();
		}
	}
	
	
}
