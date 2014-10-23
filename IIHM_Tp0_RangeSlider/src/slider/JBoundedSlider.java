package slider;

import homefinder.EventSliderListener;



public interface JBoundedSlider {

	public int getExtent();
	public int getLowerRange();
	public int getUpperRange();
	public int getMax();
	public int getMin();
	public int getID();
	public void setLowerRange(int x);
	public void setUpperRange(int x);
	public void setMax(int x);
	public void setMin(int x);
	public void setExtent(int min, int max);
	public void setID(int iD);
	public void addEventSliderListener(EventSliderListener el);
	public EventSliderListener[] getEventSliderListener();
	public void fireEventSliderListenerChanged();
}
