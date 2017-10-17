package edu.cmu.cs.cs214.hw4.core.NormalBonusTile;



/**
 * The Class DoubleWord.
 */
public class DoubleWord extends NormalBonus {
	
	/** The Constant DOUBLE_WORD. */
	private static final String DOUBLE_WORD = "2WS";
	private static final int TIMES = 2; 
	
	/**
	 * Instantiates a new double word.
	 */
	public DoubleWord(){
		super();
	}


	@Override
	public String getName() {
		return DOUBLE_WORD;
	}

	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getTimes()
	 */
	public int getTimes(){
		return TIMES;
	}
}
