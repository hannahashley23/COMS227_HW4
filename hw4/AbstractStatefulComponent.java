package hw4;

import api.IStatefulComponent;

/**
 * Abstract supertype for stateful components. implements IStatefulComponent
 * interface and extends AbsractComponent
 * Implements methods that non stateful components do not need
 * 
 * @author hannahashley
 *
 */
public abstract class AbstractStatefulComponent extends AbstractComponent implements IStatefulComponent {

	/**
	 * keeps track of whether the internal components of the stateful component have
	 * been enabled or not
	 */
	private boolean isEnabled;

	/**
	 * calls AbstractComponent constructor to create input and output pin arrays
	 * from the parameter values
	 * 
	 * @param numInputs
	 * @param numOutputs
	 */
	protected AbstractStatefulComponent(int numInputs, int numOutputs) {
		super(numInputs, numOutputs);
		invalidateInputs();
	}

	/**
	 * Updates the internal state, if any, provided that the component is enabled.
	 */
	public abstract void tick();

	/**
	 * Enables updates to the internal state, if any, when processing the tick()
	 * operation.
	 */
	public void setEnabled(boolean enabled) {
		if (enabled == true) {
			isEnabled = true;
		} else {
			isEnabled = false;
		}
	}
	
	/**
	 * Allows subtypes to access whether or not the internal components have been
	 * enabled or not
	 * 
	 * @return
	 */
	protected boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * Clears the internal state, if any (sets to all zeros).
	 */
	public void clear() {
		for (int i = 0; i < outputs().length; i++) {
			outputs()[i].set(0);
		}
	}
	
	/**
	 * Must be implemented even though register and counter can not be propagated
	 */
	public void propagate()
	{
		//does nothing
	}

}
