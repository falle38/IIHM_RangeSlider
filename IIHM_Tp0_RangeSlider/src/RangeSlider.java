import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class RangeSlider extends JComponent implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private boolean lowerThumbSelected;
	private boolean upperThumbSelected;

	private transient boolean lowerThumbDrag;
	private transient boolean upperThumbDrag;

	private BoundedSlider boundedSlider;

	public BoundedSlider getBoundedSlider(){
		return this.boundedSlider;
	}

	public RangeSlider (int lowerRange, int upperRange, int min, int max){
		this.boundedSlider = new BoundedSlider(lowerRange, upperRange, min, max);
		this.lowerThumbSelected = true;
		this.upperThumbSelected = true;
		this.lowerThumbDrag = true;
		this.upperThumbDrag = true;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("lower range:", 20,10);
		g.drawString(Integer.toString(this.boundedSlider.getLowerRange()), 100, 10);
		g.drawString("upper range: ", 20,30);
		g.drawString(Integer.toString(this.boundedSlider.getUpperRange()), 100, 30);
		g.setColor(Color.GRAY);
		g.fillRect(this.boundedSlider.getMin(), (getHeight() / 2) - 10, getWidth()
				/*- (2 * this.boundedSlider.getMax())*/, 10);
		g.setColor(Color.BLUE);
		g.fillRect(this.boundedSlider.getLowerRange() + 10, (getHeight() / 2) - 10,
				this.boundedSlider.getExtent() - 10, 10);

		g.setColor(Color.RED);
		g.fillOval(this.boundedSlider.getLowerRange(), this.getHeight()/2 -10, 10, 10);
		g.setColor(Color.GREEN);
		g.fillOval(this.boundedSlider.getUpperRange(),  this.getHeight()/2 -10, 10, 10);
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int distanceLowerThumb = Math.abs(x - this.boundedSlider.getLowerRange());
		int distanceUpperThumb = Math.abs(x - this.boundedSlider.getUpperRange());

		if(x >= this.boundedSlider.getMin() && x <= this.boundedSlider.getLowerRange() ){
			this.boundedSlider.setLowerRange(x);
			this.boundedSlider.setUpperRange(this.boundedSlider.getUpperRange() - distanceLowerThumb);
		}
		if(x >= this.boundedSlider.getUpperRange() && x <=this.boundedSlider.getMax()){
			this.boundedSlider.setUpperRange(x);
			this.boundedSlider.setLowerRange(this.boundedSlider.getLowerRange() + distanceUpperThumb);
		}
		if(x>=this.boundedSlider.getLowerRange() && x < this.boundedSlider.getUpperRange()){
			int distLowerThumb = Math.abs(x - this.boundedSlider.getLowerRange());
			int distUpperThumb = Math.abs(x - this.boundedSlider.getUpperRange());
			if(distLowerThumb <= distUpperThumb && this.lowerThumbDrag && this.lowerThumbSelected){
				this.boundedSlider.setLowerRange(x);
				this.boundedSlider.setUpperRange(this.boundedSlider.getUpperRange() + distLowerThumb);
			}
			else{
				this.boundedSlider.setUpperRange(x);
				this.boundedSlider.setLowerRange(this.boundedSlider.getLowerRange() - distUpperThumb);
			}
		}
		repaint();
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {

	}


	@Override
	public void mouseExited(MouseEvent arg0) {}


	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		int distanceLowerThumb = Math.abs(x - this.boundedSlider.getLowerRange());
		int distanceUpperThumb = Math.abs(x - this.boundedSlider.getUpperRange());

		if (distanceLowerThumb <= distanceUpperThumb) {
			this.lowerThumbSelected = true;
		}
		else {
			this.upperThumbSelected=true;
		}
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		//this.lowerThumbDrag = false;
		//this.upperThumbDrag = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		int x = arg0.getX();
		int distanceLowerThumb = Math.abs(x - this.boundedSlider.getLowerRange());
		int distanceUpperThumb = Math.abs(x - this.boundedSlider.getUpperRange());

		if(distanceLowerThumb <= distanceUpperThumb && this.lowerThumbDrag && this.lowerThumbSelected){
			this.boundedSlider.setLowerRange(x);
		}

		if(distanceLowerThumb > distanceUpperThumb && this.upperThumbDrag && this.upperThumbSelected){
			this.boundedSlider.setUpperRange(x);
		}
		repaint();
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {}


}
