package edu.cmu.cs.cs214.hw4.core.NormalBonusTile;



/**
 * The Class TripleLetter.
 */
public class TripleLetter extends NormalBonus {
	
	/** The Constant TRIPLE_LETTER. */
	private final static String TRIPLE_LETTER = "3LS";
	
	/** The Constant TIMES. */
	private final static int TIMES = 3;
	/**
	 * Instantiates a new triple letter.
	 */
	public TripleLetter(){
		super();
	}

	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getName()
	 */
	@Override
	public String getName() {
		return TRIPLE_LETTER;
	}

	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getTimes()
	 */
	public int getTimes(){
		return TIMES;
	}
}
