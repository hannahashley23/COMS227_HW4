package hw4;

import api.IStatefulComponent;

/**
 * Implementation of a register with an internal "state" consisting of a fixed
 * number of bits. If enabled, the tick() method causes the input bits to be
 * copied to the state (provided that the inputs are valid). Outputs are always
 * valid and equal to the state.
 * 
 * @author hannahashley
 *
 */
public class Register extends AbstractStatefulComponent implements IStatefulComponent {

	/**
	 * Constructs a register whose state consists of the given number of bits.
	 * 
	 * @param bits
	 */
	public Register(int bits) {
		// creates an input and output array with a length of number of bits
		super(bits, bits);
	}

	/**
	 * Updates the internal state, if any, provided that the component is enabled.
	 * if internal state is enabled, sets input values to output values
	 */
	@Override
	public void tick() {
		if (isEnabled()) {
			for (int i = 0; i < inputs().length; i++) {
				outputs()[i].set(inputs()[i].getValue());
			}
		}
	}
}
