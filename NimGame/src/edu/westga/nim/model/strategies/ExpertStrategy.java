package edu.westga.nim.model.strategies;

/**
 * class to make the computer play like an expert
 * @author Tamiko Williams
 * @version 07/10/2014
 *
 */
public class ExpertStrategy implements NumberOfSticksStrategy {

	@Override
	public int howManySticks(int pileSize) {
		//use modulus operator (%)
				
		if (pileSize % 4 == 1) {
			return 1;
		} else {
			int mult4 = pileSize - ((pileSize / 4) * 4);
			int result = ((mult4 - 1) + 4) % 4;
			return result;
		}

	}

}
