import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSlider rangeSlider = new RangeSlider(20,60,0,100);
		JFrame frame = new JFrame ("Range Slider");
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		frame.add(rangeSlider);
		System.out.println(rangeSlider.getBoundedSlider().getMin());
		System.out.println(rangeSlider.getBoundedSlider().getMax());
		System.out.println(rangeSlider.getBoundedSlider().getLowerRange());
		System.out.println(rangeSlider.getBoundedSlider().getUpperRange());
		
		
	}

}
