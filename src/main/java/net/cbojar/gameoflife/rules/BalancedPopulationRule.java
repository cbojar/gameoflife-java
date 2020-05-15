package net.cbojar.gameoflife.rules;

public class BalancedPopulationRule implements Rule {
	@Override
	public boolean applies(final Neighborhood neighborhood) {
		if (!neighborhood.cell()) {
			return false;
		}

		final int neighborCount = neighborhood.countLivingNeighbors();
		return neighborCount == 2 || neighborCount == 3;
	}

	@Override
	public boolean apply(final Neighborhood neighborhood) {
		return true;
	}

	@Override
	public String toString() {
		return "Balanced population rule";
	}
}
