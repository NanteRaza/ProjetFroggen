package frog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import environment.Environment;
import gameCommons.Game;
import gameCommons.IEnvironment;
import gameCommons.IFrog;
import givenEnvironment.GivenEnvironment;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;
 
import java.util.Random;
public class Main {

	public static void main(String[] args) {

		//Caractristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 100;
		int minSpeedInTimerLoops = 4;
		double defaultDensity = 0.03;
		
		//Creation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Creation de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
		//Creation et liason de la grenouille
		IFrog frog = new Frog(game);
		game.setFrog(frog);
		graphic.setFrog(frog);
		//Creation et liaison de l'environnement
		IEnvironment env = new Environment(game);
		game.setEnvironment(env);
				
		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.update();
				graphic.repaint();
			}
		});
		timer.setInitialDelay(0);
		timer.start();

	}
}