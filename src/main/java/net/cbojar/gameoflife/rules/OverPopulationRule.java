package net.cbojar.gameoflife.rules;

public class OverPopulationRule implements Rule {
	@Override
	public boolean applies(final Neighborhood neighborhood) {
		return neighborhood.cell() && neighborhood.countLivingNeighbors() > 3;
	}

	@Override
	public boolean apply(final Neighborhood neighborhood) {
		return false;
	}

	@Override
	public String toString() {
		return "Overpopulation rule";
	}
}
