package hw4;

import api.IComponent;
import java.util.ArrayList;

/**
 * Implementation of IComponent that contains other components. Clients are
 * responsible for adding the subcomponents using the addComponent() method and
 * for creating all internal connections between components. This class is not
 * designed to be used for stateful components. extends AbstractComponent
 * 
 * @author hannahashley
 *
 */
public class CompoundComponent extends AbstractComponent {

	/**
	 * ArrayList of subcomponents that can be propagated individually through
	 * iteration Subcomponents will be added through each compound component's
	 * individual constructor
	 */
	private ArrayList<IComponent> componentList = new ArrayList<IComponent>();

	/**
	 * Constructs a CompoundComponent with the given number of inputs and number of
	 * outputs. Initially the subcomponent list is empty.
	 * 
	 * @param numInputs
	 * @param numOutputs
	 */
	public CompoundComponent(int numInputs, int numOutputs) {
		super(numInputs, numOutputs);
	}

	/**
	 * Adds the given component to the list of subcomponents.
	 * 
	 * @param c
	 */
	public void addComponent(IComponent c) {
		componentList.add(c);
	}

	/**
	 * Returns a reference to the list of subcomponents.
	 * 
	 * @return
	 */
	public ArrayList<IComponent> getComponents() {
		return componentList;
	}

	/**
	 * Universal process for propagate that all types of compound components can use
	 * Propagates inputs to outputs. Does nothing if not all inputs are valid.
	 */
	@Override
	public void propagate() {

		// invalidate inputs and outputs of each subcomponent
		for (int i = 0; i < componentList.size(); i++) {
			componentList.get(i).invalidateInputs();
			componentList.get(i).invalidateOutputs();
		}

		// invalidate the compound component's outputs
		for (int i = 0; i < outputs().length; i++) {
			outputs()[i].invalidate();
		}

		// sets and validates the respective number of inputs for each type of compound
		// component
		for (int i = 0; i < inputs().length; i++) {
			inputs()[i].set(inputs()[i].getValue());
		}

		// propagates each subcomponent
		for (int i = 0; i < componentList.size(); i++) {

			componentList.get(i).propagate();

			// check to see if all outputs are valid
			for (int j = 0; j < outputs().length; j++) {
				if (outputs()[j].isValid()) {
					continue;
				} else {
					break;
				}

			}
		}
	}
}
