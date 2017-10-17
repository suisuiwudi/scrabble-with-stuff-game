package edu.cmu.cs.cs214.hw4.core.NormalBonusTile;


/**
 * The Class OneWord.
 */
public class OneWord extends NormalBonus {
	
	/** The Constant ONE_WORD. */
	private final static String ONE_WORD = " . ";

	/**
	 * Instantiates a new one word.
	 */
	public OneWord(){
		super();
	}

	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getName()
	 */
	@Override
	public String getName() {
		return ONE_WORD;
	}
	public int getTimes(){
		return 1;
	}
}
