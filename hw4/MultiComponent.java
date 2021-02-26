package hw4;

import api.IComponent;

/**
 * Implementation of a specialized CompoundComponent in which all subcomponents
 * are identical and have one output. For each i less than n, inputs i * m up to
 * (i + 1) * m are connected to the i-th subcomponent and the output of that
 * subcomponent is connected to output i.
 * 
 * @author hannahashley
 *
 */
public class MultiComponent extends CompoundComponent {

	/**
	 * number of subomponents
	 */
	private int m;

	/**
	 * number of inputs for each subcomponent
	 */
	private int n;

	/**
	 * Constructs a MultiComponent with the given array of subcomponents. inputs and
	 * outputs are initially invalid the constructor argument is an n-element array
	 * of identical components with m inputs and 1 output; the MultiComponent has n
	 * * m inputs and n outputs
	 * 
	 * @param components
	 */
	public MultiComponent(IComponent[] components) {
		
		// constructs an input array with m * n length and an output array with n length
		super(components.length * components[0].inputs().length, components.length);

		// private instance variables to make constructor calculations easier to read
		n = components.length;
		m = components[0].inputs().length;

		// add each component in given array to the componentList arrayList in
		// CompoundComponent
		for (int i = 0; i < n; i++) {
			addComponent(components[i]);
		}

		for (int i = 0; i < n; i++) {
			int counter = 0;

			for (int j = i * m; j < (i + 1) * m; j++) {
				{
					// connect each input pin to the respective component input pin
					inputs()[j].connectTo(components[i].inputs()[counter]);

					// set the value of each input pin to the values in the respective component
					// input pins
					inputs()[j].set(components[i].inputs()[counter].getValue());
					counter++;
				}
			}

			// set outputs of components to output pins for multicomponent
			components[i].outputs()[0].connectTo(outputs()[i]);
		}

	}

}
