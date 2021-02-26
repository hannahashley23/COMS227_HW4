package hw4;

/**
 * Implementation of a not-gate with one input and one output
 * 
 * @author hannahashley
 *
 */
public class NotGate extends AbstractComponent {

	/**
	 * Constructs a NotGate with one input and one output
	 */
	public NotGate() {
		super(1, 1);
	}

	/**
	 * Propagates inputs to outputs. 
	 * Returns the opposite boolean value of what the current input value is. Does
	 * not propagate is inputs are not valid
	 */
	@Override
	public void propagate() {
		if (inputsValid()) {
			int newValue = 0;
			if (inputs()[0].getValue() == 0) {
				newValue = 1;
			}
			outputs()[0].set(newValue);
		}
	}

}
