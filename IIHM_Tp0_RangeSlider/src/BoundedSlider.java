
public class BoundedSlider implements JBoundedSlider{

	private int min;
	private int max;
	private int lowerRange;
	private int upperRange;
	private int extent;

	public BoundedSlider(int lowerRange, int upperRange ){
		this.lowerRange = lowerRange;
		this.upperRange = upperRange;
		this.min= lowerRange;
		this.max = upperRange;
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
		this.lowerRange = x;
	}

	@Override
	public void setUpperRange(int x) {
		this.upperRange = x;
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
		return this.extent;
	}
	@Override
	public void setExtent(int min, int max) {
		this.extent = max - min;
	}

}
