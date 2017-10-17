package edu.cmu.cs.cs214.hw4.core.NormalBonusTile;

/**
 * 
 *  
 *
 */
public class DoubleLetter extends NormalBonus {
	
	/** The Constant DOUBLE_LETTER. */
	private final static String DOUBLE_LETTER = "2LS";
	
	/** The Constant TIMES. */
	private final static int TIMES = 2;
	/**
	 * Instantiates a new double letter.
	 */
	public DoubleLetter(){
		super();
	}

	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getName()
	 */
	@Override
	public String getName() {
		return DOUBLE_LETTER;
	}
	
	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getTimes()
	 */
	public int getTimes(){
		return TIMES;
	}
	
}
