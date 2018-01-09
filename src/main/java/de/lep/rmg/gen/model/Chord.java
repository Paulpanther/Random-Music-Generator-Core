package de.lep.rmg.gen.model;

/**
 * A Child of {@link SimpleNoteList} which also stores a base-Note
 * and the {@link Interval}s the notes form.
 *
 * @author paul
 * @since 02.01.18.
 */
public class Chord extends SimpleNoteList {

	public enum ChordType {
		MAJOR, MINOR
	}

	protected SimpleNote base;
	protected StepList steps;


	public Chord(SimpleNote base, ChordType type) {
		setBaseAndSteps(base, getChordTypeSteps(type));
	}

	public Chord(SimpleNote base, StepList steps) {
		super();
		setBaseAndSteps(base, steps);
	}

	private void setBaseAndSteps(SimpleNote base, StepList steps) {
		clear();
		this.base = base;
		this.steps = steps;

		SimpleNote last = base.cloneNote();
		for (Step step : steps) {
			last.add(step);
			add(last);
			last = last.cloneNote();
		}
	}

	public static StepList getChordTypeSteps(ChordType type) {
		switch (type) {
			case MAJOR:
				return new StepList(new Step[] {
						new Step(4),
						new Step(3)
				});
			case MINOR:
				return new StepList(new Step[] {
						new Step(3),
						new Step(4)
				});
			default:
				throw new EnumConstantNotPresentException(type.getClass(),
						"Illegal Enum value");
		}
	}

	public void setBase(SimpleNote base) {
		setBaseAndSteps(base, this.steps);
	}

	public void setSteps(StepList steps) {
		setBaseAndSteps(this.base, steps);
	}

	public void addStep(Step step) {
		SimpleNote last = get(size()-1).cloneNote();
		this.steps.add(step);
		last.add(step);
		add(last);
	}

	public SimpleNote getBase() {
		return base;
	}

	public StepList getSteps() {
		return steps;
	}

	@Override
	public String toString() {
		return "Chord{" +
				"base=" + base +
				", steps=" + steps +
				'}';
	}
}
