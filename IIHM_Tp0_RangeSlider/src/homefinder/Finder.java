package homefinder;

import homefinder.Home;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import slider.JBoundedSlider;


public class Finder extends JPanel implements EventSliderListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int prixMinimum = 0;
	private int prixMaximum = 300;
	private int nbpieceMin = 3;
	private int nbpieceMax = 10;

	public ArrayList<Home> houses;
	
	public Finder(int size){
		houses = new ArrayList<Home>();

		for(int i = 0; i < size; i++){
            //les coordonnées ainsi que les prix et le nombre de pièces sont générées aléatoirement de façon uniforme
			int cordX = getRandomInt(0,1000);
			int cordY = getRandomInt(0,1000);
			int price = getRandomInt(0,300);
			int rooms = getRandomInt(4,10);
			Home home = new Home(cordX, cordY, rooms, price);
			houses.add(home);

		}
	}

    //permet d'effectuer le filtrage des maisons	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < houses.size(); i++){
			if(ensure(houses.get(i).getValeurbien(),this.prixMinimum,this.prixMaximum) && ensure(houses.get(i).getNbpieces(),this.nbpieceMin,this.nbpieceMax)) 
				g.setColor(Color.WHITE);	
				g.drawOval(houses.get(i).getCordX(), houses.get(i).getCordY(), 10 , 10);
				g.fillOval(houses.get(i).getCordX(), houses.get(i).getCordY(), 10 , 10);
			}

		}
		
    //cette méthode permet de vérifier si la valeur du bien ou du nombre de pièces respecte les contraintes 
	public boolean ensure(int value,int limit1,int limit2 ) {
    	return (value >= limit1 && value <= limit2);
        }
	
	@Override
	public void SliderstateChange(JBoundedSlider slider) {
		if(slider.getID()==1){
			this.prixMinimum = slider.getLowerRange();
			this.prixMaximum = slider.getUpperRange();
			repaint();
		}else if(slider.getID()==2){
			this.nbpieceMin = slider.getLowerRange();
			this.nbpieceMax = slider.getUpperRange();
			repaint();
		}
	}
	
	//permet de génerer un nombre de façon uniformèment aléatoire entre min et max
	public int getRandomInt(int min, int max) {
		  return (int) Math.floor(Math.random() * (max - min + 1) + min);
		}
	

}