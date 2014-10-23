package homefinder;

import java.util.EventListener;

import slider.JBoundedSlider;

public interface EventSliderListener extends EventListener {
	  public void SliderstateChange(JBoundedSlider slider);
}
