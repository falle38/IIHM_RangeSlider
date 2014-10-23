package slider;

import homefinder.EventSliderListener;

import javax.swing.event.EventListenerList;


public class BoundedSlider implements JBoundedSlider{

	private int min;
	private int max;
	private int lowerRange;
	private int upperRange;
	private int extent;
	private int ID;

	private final EventListenerList events = new EventListenerList();

	
	public BoundedSlider(int lowerRange, int upperRange, int min, int max ){
		if (ensure(lowerRange,upperRange,min,max)) {
		this.lowerRange = lowerRange;
		this.upperRange = upperRange;
		this.min= min;
		this.max = max;
		}
		else {
			System.out.println("warning on values");
		}
	}
	
	public BoundedSlider(int id,int lowerRange, int upperRange, int min, int max ){
		if (ensure(lowerRange,upperRange,min,max)) {
		this.ID=id;
		this.lowerRange = lowerRange;
		this.upperRange = upperRange;
		this.min= min;
		this.max = max;
		}
		else {
			System.out.println("warning on values");
		}
	}
	
	@Override
	public int getLowerRange() {
		return this.lowerRange;
	}

	@Override
	public int getUpperRange() {
		return this.upperRange;
	}

	@Override
	public int getMax() {
		return this.max;
	}

	@Override
	public int getMin() {
		return this.min;
	}

	@Override
	public void setLowerRange(int x) {
		if (ensureSet(x,this.min,this.max)) {
			this.lowerRange = x;
			fireEventSliderListenerChanged();
			System.out.println("changed in lower");
			
		} else {
			
		}
		
	}

	@Override
	public void setUpperRange(int x) {
		if (ensureSet(x,this.min,this.max)) {
			this.upperRange = x;
			fireEventSliderListenerChanged();
			System.out.println("changed in upper");
		} else {
			
		}
		
	}

	@Override
	public void setMax(int x) {
			this.max = x;
	}

	@Override
	public void setMin(int x) {
		this.min = x;
	}
	
	@Override
	public int getExtent() {
		return this.upperRange - this.lowerRange;
	}
	@Override
	public void setExtent(int min, int max) {
		this.extent = max - min;
	}
    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean ensure(int value1,int value2,int rangelimit1,int rangelimit2 ) {
	return (rangelimit1 < rangelimit2) && (value2 <= rangelimit2) && (value1 >= rangelimit1) &&  (value1 < value2);
    }
    
    public boolean ensureSet(int value,int rangelimit1,int rangelimit2 ) {
    	return (value >= rangelimit1 && value <= rangelimit2);
        }
    

	public void addEventSliderListener(EventSliderListener el) {
		this.events.add(EventSliderListener.class, el);
	}
	

	public EventSliderListener[] getEventSliderListener(){
		return events.getListeners(EventSliderListener.class);
	}
	

	public void fireEventSliderListenerChanged() {
		for (EventSliderListener esl : getEventSliderListener()) {
			esl.SliderstateChange(this);
		}
	}
    
}
