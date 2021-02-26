package hw4;

import api.IComponent;

/**
 * Implementation of a standard full adder circuit. This version extends
 * CompoundComponent and uses two instances of HalfAdder as subcomponents.
 * 
 * @author hannahashley
 *
 */
public class FullAdder extends CompoundComponent {

	/**
	 * Constructs a FullAdder.
	 * This compound component has 3 inputs and 2 outputs
	 */
	public FullAdder() {
		super(3, 2);

		// create subcomponents
		// two half adders and an or-gate will be wired together 
		IComponent halfAdder1 = new HalfAdder();
		IComponent halfAdder2 = new HalfAdder();
		IComponent orGate = new OrGate();

		// add subcomponents to componentList in CompoundComponent
		addComponent(halfAdder1);
		addComponent(halfAdder2);
		addComponent(orGate);

		// wire inputs to first half adder
		inputs()[0].connectTo(halfAdder1.inputs()[0]);
		inputs()[1].connectTo(halfAdder1.inputs()[1]);

		// connect the subcomponents inputs/outputs to each other
		// wires 2 halfAdders together and connects the sum and carry out outputs to the 
		// or-gate or outputs array
		inputs()[2].connectTo(halfAdder2.inputs()[0]);
		halfAdder1.outputs()[0].connectTo(halfAdder2.inputs()[1]);
		halfAdder1.outputs()[1].connectTo(orGate.inputs()[1]);
		halfAdder2.outputs()[0].connectTo(outputs()[0]);
		halfAdder2.outputs()[1].connectTo(orGate.inputs()[0]);
		orGate.outputs()[0].connectTo(outputs()[1]);

	}

}
