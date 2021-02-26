package hw4;

import api.IStatefulComponent;
import api.Util;

/**
 * Implementation of a binary counter with a fixed number of bits.
 * 
 * @author hannahashley
 *
 */
public class Counter extends AbstractStatefulComponent implements IStatefulComponent {

	/**
	 * Constructs a counter with the given number of bits.
	 * 
	 * @param bits
	 */
	public Counter(int bits) {
		super(0, bits);

		for (int i = 0; i < bits; i++) {
			outputs()[i].set(0);
		}
	}

	/**
	 * Updates the internal state, if any, provided that the component is enabled.
	 * If the counter is enabled, this method will increase the binary value of the
	 * internal bits by 1
	 */
	@Override
	public void tick() {
		if (isEnabled()) {

			// get binary value for current bits
			int binaryValue = Util.toIntValue(outputs());

			binaryValue++;

			// convert this value to a string
			String s = Integer.toBinaryString(binaryValue);

			// fills in leading 0's that were lost in the calculations of the previous lines
			while (s.length() < outputs().length) {
				s = "0" + s;
			}

			// create int array to hold new binary values
			int[] intArray = Util.stringToIntArray(s);

			// sets new binary values into output array
			for (int i = 0; i <= outputs().length - 1; i++) {
				outputs()[i].set(intArray[i]);
			}
		}
	}
}
