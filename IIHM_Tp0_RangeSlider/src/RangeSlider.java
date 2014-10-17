import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class RangeSlider extends JComponent implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private Color rangeColor = Color.blue;
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
		this.addMouseListener(this);
		this.lowerThumbSelected = true;
		this.upperThumbSelected = true;
		this.lowerThumbDrag = true;
		this.upperThumbDrag = true;
		this.addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("min ", 20,10);
		g.drawString("max ", 80,10);
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

		if(distanceLowerThumb <= distanceUpperThumb && this.lowerThumbDrag && this.lowerThumbSelected){
			this.boundedSlider.setLowerRange(x);
			this.boundedSlider.setUpperRange(this.boundedSlider.getUpperRange() - distanceLowerThumb);
		}

		if(distanceLowerThumb > distanceUpperThumb && this.upperThumbDrag && this.upperThumbSelected){
			this.boundedSlider.setUpperRange(x);
			this.boundedSlider.setLowerRange(this.boundedSlider.getLowerRange() + distanceUpperThumb);
		}
		repaint();
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {}


	@Override
	public void mouseExited(MouseEvent arg0) {}


	@Override
	public void mousePressed(MouseEvent arg0) {}


	@Override
	public void mouseReleased(MouseEvent arg0) {}


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
