package net.cbojar.gameoflife.rules;

public class UnderPopulationRule implements Rule {
	@Override
	public boolean applies(final Neighborhood neighborhood) {
		return neighborhood.cell() && neighborhood.countLivingNeighbors() < 2;
	}

	@Override
	public boolean apply(final Neighborhood neighborhood) {
		return false;
	}

	@Override
	public String toString() {
		return "Underpopulation rule";
	}
}
