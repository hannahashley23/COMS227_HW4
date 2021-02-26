package hw4;

import api.Util;

/**
 * Implementation of a single-output multiplexer.
 * 
 * @author hannahashley
 *
 */
public class Multiplexer extends AbstractComponent {

	/**
	 * keeps track of given number of bits for each constructed multiplexer
	 */
	private int k;

	/**
	 * Constructs a multiplexer that uses k bits to select from one of 2^k inputs.
	 * 
	 * @param givenK
	 */
	public Multiplexer(int givenK) {

		// constructs an input array with 2^k length and an output array with a length of 1
		super((int) Math.pow(2, givenK) + givenK, 1);

		k = givenK;
	}

	/**
	 * Propagates inputs to outputs. Finds binary value of last k inputs and returns
	 * the integer value of the pin stored at that index in the inputs array
	 */
	@Override
	public void propagate() {
		int lastKBinary = Util.toIntValue(inputs(), inputs().length - k, inputs().length);
		outputs()[0] = inputs()[lastKBinary];
	}

}
