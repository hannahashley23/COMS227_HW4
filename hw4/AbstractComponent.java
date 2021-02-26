package hw4;

import api.IComponent;
import api.Pin;

/**
 * Abstract supertype with common code for all components.
 * 
 * @author hannahashley
 */
public abstract class AbstractComponent implements IComponent {

	/**
	 * Outputs for this component.
	 */
	private Pin[] outputs;
	/**
	 * Inputs for this component.
	 */
	private Pin[] inputs;

	/**
	 * Protected constructor for all abstract components uses integer parameters of
	 * numInputs and numOutputs to create input and output pin arrays
	 * 
	 * @param numInputs
	 * @param numOutputs
	 */
	protected AbstractComponent(int numInputs, int numOutputs) {
		this.inputs = new Pin[numInputs];
		this.outputs = new Pin[numOutputs];

		for (int i = 0; i < inputs.length; i += 1) {
			inputs[i] = new Pin(this);
		}
		for (int i = 0; i < outputs.length; i += 1) {
			outputs[i] = new Pin(this);
		}
	}

	/**
	 * Returns the array of Pins representing this component's inputs.
	 */
	public Pin[] inputs() {
		return inputs;
	}

	/**
	 * Returns the array of Pins representing this component's outputs.
	 */
	public Pin[] outputs() {
		return outputs;
	}

	/**
	 * Changes the state of all inputs to invalid.
	 */
	public void invalidateInputs() {
		for (Pin e : inputs) {
			e.invalidate();
		}
	}

	/**
	 * Changes the state of all outputs to invalid.
	 */
	public void invalidateOutputs() {
		for (Pin e : outputs) {
			e.invalidate();
		}
	}

	/**
	 * Returns whether all inputs are valid.
	 */
	public boolean inputsValid() {
		for (Pin e : inputs) {
			if (!e.isValid())
				return false;
		}
		return true;
	}

	/**
	 * Returns whether all outputs are valid.
	 */
	public boolean outputsValid() {
		for (Pin e : outputs) {
			if (!e.isValid())
				return false;
		}
		return true;
	}
}
