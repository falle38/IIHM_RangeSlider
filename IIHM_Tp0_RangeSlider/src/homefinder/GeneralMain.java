package homefinder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import slider.RangeSlider;



public class GeneralMain {
	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
        // TODO Auto-generated method stub

	JFrame frame = new JFrame ("Home Finder");
	frame.setSize(1000, 800);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	RangeSlider rangeSlider = new RangeSlider(1,20,60,0,300);
	RangeSlider rangeSlider2 = new RangeSlider(2,20,60,0,300);
	rangeSlider.setPreferredSize(new Dimension(400,100));
	rangeSlider2.setPreferredSize(new Dimension(400,100));
	

	Finder f = new Finder(100);
	rangeSlider.getBoundedSlider().addEventSliderListener(f);
	rangeSlider2.getBoundedSlider().addEventSliderListener(f);
	rangeSlider.setBorder(BorderFactory.createLineBorder(Color.black));
	rangeSlider2.setBorder(BorderFactory.createLineBorder(Color.black));
	f.setPreferredSize(new Dimension(1000,500));
	f.setBackground(Color.BLACK);
	
	
	JPanel panelPrincipal = new JPanel();
	panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
	panelPrincipal.add(f);
	
	
	JPanel dessous = new JPanel();
	dessous.setLayout(new BoxLayout(dessous, BoxLayout.X_AXIS));
	dessous.add(rangeSlider);
	JPanel separator = new JPanel();
	separator.setBackground(Color.LIGHT_GRAY);
	separator.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK)); 
	dessous.add(separator);
	dessous.add(rangeSlider2);


	panelPrincipal.add(dessous);
	frame.add(panelPrincipal);

	}


}
