package edu.cmu.cs.cs214.hw4.core.NormalBonusTile;




/**
 * The Class TripleWord.
 */
public class TripleWord extends NormalBonus {
	
	/** The Constant TRIPLE_WORD. */
	private final static String TRIPLE_WORD= "3WS";
	private final static int TIMES = 3;
	/**
	 * Instantiates a new triple word.
	 */
	public TripleWord(){
		super();
	}

	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getName()
	 */
	@Override
	public String getName() {
		return TRIPLE_WORD;
	}
	
	/** (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus#getTimes()
	 */
	public int getTimes(){
		return TIMES;
	}
}
