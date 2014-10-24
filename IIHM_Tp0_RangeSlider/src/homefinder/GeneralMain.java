package homefinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
//	ImagePanel img = new ImagePanel(new ImageIcon("pool.jpg").getImage());
//	frame.getContentPane().add(img);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	RangeSlider rangeSlider = new RangeSlider(1,20,60,0,300);
	RangeSlider rangeSlider2 = new RangeSlider(2,20,60,0,300);
	Finder f = new Finder(100);
	rangeSlider.getBoundedSlider().addEventSliderListener(f);
	rangeSlider2.getBoundedSlider().addEventSliderListener(f);
	f.setPreferredSize(new Dimension(1000,500));
	f.setBackground(Color.DARK_GRAY);
	
	
	
	rangeSlider.setPreferredSize(new Dimension(450,300));
	rangeSlider2.setPreferredSize(new Dimension(450,300));
	
	
	
	
	
	JPanel map = new JPanel();
	
	map.setLayout(new BoxLayout(map, BoxLayout.X_AXIS));
	map.add(f);
	
	
	JPanel controllers = new JPanel();
	controllers.setLayout(new BoxLayout(controllers, BoxLayout.Y_AXIS));
	controllers.add(rangeSlider);
	JPanel separator = new JPanel();
	separator.setBackground(Color.BLUE);
	
	controllers.add(separator);
	controllers.add(rangeSlider2);


	map.add(controllers);
	frame.add(map);

	}


}


