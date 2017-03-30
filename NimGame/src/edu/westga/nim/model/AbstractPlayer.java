package edu.westga.nim.model;
/**
 * class to implement player
 * @author cs6910
 * @version Summer Project
 *
 */
public abstract class AbstractPlayer implements Player {

	private String theName;
	private int sticksToTake;
	private Pile thePile;

	/**
	 * Creates a new AbstractPlayer with the specified name.
	 * 
	 * @requires: aName != null
	 * @ensures name().equals(aName)
	 * 
	 * @param aName the name 
	 */
	public AbstractPlayer(String aName) {
		if (aName == null) {
			throw new IllegalArgumentException("Null name");
		}
		this.theName = aName;
	}

	/**
	 * the take turn method
	 * @see Player#takeTurn(Pile) 
	 */
	public void takeTurn() {				
		this.thePile.remove(this.sticksOnThisTurn());
	}

	/**
	 * the set pile method
	 * @see Player#setPileForThisTurn(Pile)
	 * @param aPile the pile
	 */
	@Override
	public void setPileForThisTurn(Pile aPile) {
		this.thePile = aPile;
		
	}

	/**
	 * Implements Player's setNumberSticksToTake(int), but is not
	 * normally called by clients objects. Instead, clients usually
	 * call the 0-parameter version.
	 * @param number the number
	 * @see Player#setNumberSticksToTake(int)
	 */
	@Override
	public void setNumberSticksToTake(int number) {
		this.sticksToTake = number;
	}

	/**
	 * the set name method
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.theName = name;
	}

	/**
	 * the string method
	 * @see Player#name()
	 * @return theName
	 */
	@Override
	public String name() {
		return this.theName;
	}

	/**
	 * the stick method
	 * @see Player#sticksOnThisTurn()
	 * @return sticksToTake the sticks
	 */
	@Override
	public int sticksOnThisTurn() {
		return this.sticksToTake;
	}

	/**
	 * the pile turn 
	 * @see Player#pileForThisTurn()
	 * @return thePile the pile
	 */
	@Override
	public Pile pileForThisTurn() {
		return this.thePile;
	}

	
	
	// ************************************************************************
	// ************ abstract method for subclasses to implement ***************
	// ************************************************************************
	
	/**
	 * the abstract method
	 * @see Player#setNumberSticksToTake()
	 */
	@Override
	public abstract void setNumberSticksToTake();



}