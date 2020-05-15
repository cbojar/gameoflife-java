package net.cbojar.gameoflife.rules;

public interface Rule {
	boolean applies(Neighborhood neighborhood);
	boolean apply(Neighborhood neighborhood);
}
