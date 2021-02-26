package hw4;

/**
 * Implementation of an and-gate with two inputs and one output
 * 
 * @author hannahashley
 *
 */
public class AndGate extends AbstractComponent {

	/**
	 * Constructs an and-gate with two inputs and one output
	 */
	public AndGate() {
		super(2, 1);
	}

	/**
	 * Propagates and-gate by determining whether both values are true or not. Does
	 * nothing if not all inputs are valid.
	 */
	@Override
	public void propagate() {
		if (inputsValid()) {
			int newValue = 0;
			if (inputs()[0].getValue() == 1 && inputs()[1].getValue() == 1) {
				newValue = 1;
			}
			outputs()[0].set(newValue);
		}
	}
}
