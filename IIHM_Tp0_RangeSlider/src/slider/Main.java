package slider;
import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int valeurmin = 0;
        int valeurmax = 300;
        int largeurpouce = 10; //d'après le paintcomponent dans RangeSlider.java
   
        RangeSlider rangeSlider = new RangeSlider(20,60,valeurmin,valeurmax);
        JFrame frame = new JFrame ("Range Slider");
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     
        frame.setBounds(100,100,valeurmax - valeurmin + largeurpouce,200);
     
        
        frame.setLocationRelativeTo(null);
        frame.add(rangeSlider);
        System.out.println(rangeSlider.getBoundedSlider().getMin());
        System.out.println(rangeSlider.getBoundedSlider().getMax());
        System.out.println(rangeSlider.getBoundedSlider().getLowerRange());
        System.out.println(rangeSlider.getBoundedSlider().getUpperRange());
        
        
    }
}
