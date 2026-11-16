package br.com.ajf.simplegamelibrary.model.inputs;

/**
 * The Class GameAction.
 *
 * @author Arlindo Jose Fossem . Date: Nov 16, 2026.
 * @version 1.2v.
 * @since 1.5v.
 */
public final class GameAction
{
	/** The Constant NORMAL. */
	public static final byte NORMAL = 0;
	
	/** The Constant DETECT_INITIAL_PRES_ONLY. */
	public static final byte DETECT_INITIAL_PRES_ONLY = 1;
	
	/** The Constant STATE_RELEASED. */
	public static final byte STATE_RELEASED = 0;
	
	/** The Constant STATE_PRESSED. */
	public static final byte STATE_PRESSED = 1;
	
	/** The Constant STATE_WAITING_FOR_RELEASED. */
	public static final byte STATE_WAITING_FOR_RELEASED = 2;
	
	/** The name. */
	private String name;
	
	/** The behavior. */
	private int behavior;
	
	/** The amount. */
	private int amount;
	
	/** The state. */
	private int state;
	
	/**
	 * Instantiates a new game action.
	 *
	 * @param name the name
	 */
	public GameAction(String name)
	{
		this(name,NORMAL);
	}

	/**
	 * Instantiates a new game action.
	 *
	 * @param name the name
	 * @param behavior the behavior
	 */
	public GameAction(String name, byte behavior)
	{
		this.name = name;
		this.behavior = behavior;
		reset();
	}
	
	/**
	 * Checks if is pressed.
	 *
	 * @return true, if is pressed
	 */
	public synchronized boolean ispressed()
	{
		return (getAmount() != STATE_RELEASED);
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public synchronized int getAmount()
	{
		final int retVal = amount;
		
		if(retVal != STATE_RELEASED)
		{
			if(state == STATE_RELEASED)
			{
				amount = STATE_RELEASED;
			}
			else if(behavior == DETECT_INITIAL_PRES_ONLY)
			{
				state = STATE_WAITING_FOR_RELEASED;
				amount = STATE_RELEASED;
			}
		}
		return retVal;
	}

	/**
	 * Reset.
	 */
	public void reset()
	{
		state = STATE_RELEASED;
		amount = STATE_RELEASED;
	}
	
	/**
	 * Tap.
	 */
	public synchronized void tap()
	{
		press();
		release();
	}
	
	/**
	 * Release.
	 */
	public synchronized void release()
	{
		state = STATE_RELEASED;
	}

	/**
	 * Press.
	 */
	public synchronized void press()
	{
		press(STATE_PRESSED);
	}

	/**
	 * Press.
	 *
	 * @param amount the amount
	 */
	public synchronized void press(byte amount)
	{
		if (state == STATE_WAITING_FOR_RELEASED)
		{
			return;
		}
		
		this.amount += amount;
		state = STATE_PRESSED;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
}