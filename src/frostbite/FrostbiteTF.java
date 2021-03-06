package frostbite;

import burlap.oomdp.core.Domain;
import burlap.oomdp.core.PropositionalFunction;
import burlap.oomdp.core.TerminalFunction;
import burlap.oomdp.core.states.State;

/**
 * @author Phillipe Morere
 */
public class FrostbiteTF implements TerminalFunction{

	private PropositionalFunction onIce;
	private PropositionalFunction inWater;
	private PropositionalFunction iglooBuilt;
	private PropositionalFunction touchEnemy;
	public FrostbiteTF(Domain domain) {
		this.inWater = domain.getPropFunction(FrostbiteDomain.PFINWATER);
		this.onIce = domain.getPropFunction(FrostbiteDomain.PFONICE);
		this.iglooBuilt = domain.getPropFunction(FrostbiteDomain.PFIGLOOBUILT);
		this.touchEnemy = domain.getPropFunction(FrostbiteDomain.PFONENEMY);
	}

	@Override
	public boolean isTerminal(State s) {
		if (inWater.somePFGroundingIsTrue(s))
			return true;
		if(touchEnemy.somePFGroundingIsTrue(s))
			return true;
		return iglooBuilt.somePFGroundingIsTrue(s) && onIce.somePFGroundingIsTrue(s);
	}

}
