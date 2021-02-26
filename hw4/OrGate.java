package hw4;

/**
 * Implementation of an or-gate with two inputs and two outputs
 * 
 * @author hannahashley
 *
 */
public class OrGate extends AbstractComponent {

	/**
	 * Constructs an OrGate with two inputs and two outputs
	 */
	public OrGate() {
		super(2, 1);
	}

	/**
	 * Propagates inputs to outputs. Does nothing if not all inputs are valid. Sets
	 * outputs to true if one or both of the inputs are true
	 *
	 */
	@Override
	public void propagate() {
		if (inputsValid()) {
			int newValue = 0;
			if (inputs()[0].getValue() == 1 || inputs()[1].getValue() == 1) {
				newValue = 1;
			}

			outputs()[0].set(newValue);
		}
	}
}
