package de.lep.rmg.gen.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author paul
 * @since 05.01.18.
 */
public class StepList extends ArrayList<Step> {

	public StepList() {}

	public StepList(ArrayList<Step> steps) {
		super(steps);
	}

	public StepList(Step[] steps) {
		super(Arrays.asList(steps));
	}
}
