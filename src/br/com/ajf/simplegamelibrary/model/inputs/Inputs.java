package br.com.ajf.simplegamelibrary.model.inputs;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;

/**
 * The Class Inputs.
 *
 * @author Arlindo Jose Fossem . Date: Nov 16, 2026.
 * @version 1.2v.
 * @since 1.5v.
 * {@link GameInput}
 */
public final class Inputs implements GameInput
{
	/** The Constant INVISIBLE_CURSOR. */
	public static final Cursor INVISIBLE_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(
			Toolkit.getDefaultToolkit().getImage(""), new Point(0, 0), "invisible");
	
	/** The Constant MOUSE_MOVE_LEFT. */
	public static final byte MOUSE_MOVE_LEFT = 0;
	
	/** The Constant MOUSE_MOVE_RIGHT. */
	public static final byte MOUSE_MOVE_RIGHT = 1;
	
	/** The Constant MOUSE_MOVE_UP. */
	public static final byte MOUSE_MOVE_UP = 2;
	
	/** The Constant MOUSE_MOVE_DOWN. */
	public static final byte MOUSE_MOVE_DOWN = 3;
	
	/** The Constant MOUSE_WHEEL_UP. */
	public static final byte MOUSE_WHEEL_UP = 4;
	
	/** The Constant MOUSE_WHEEL_DOWN. */
	public static final byte MOUSE_WHEEL_DOWN = 5;
	
	/** The Constant MOUSE_BUTTON_1. */
	public static final byte MOUSE_BUTTON_1 = 6;
	
	/** The Constant MOUSE_BUTTON_2. */
	public static final byte MOUSE_BUTTON_2 = 7;
	
	/** The Constant MOUSE_BUTTON_3. */
	public static final byte MOUSE_BUTTON_3 = 8;
	
	/** The Constant NUM_MOUSE_CODES. */
	public static final byte NUM_MOUSE_CODES = 9;
	
	/** The key actiuons. */
	private final Map<Integer,GameAction> keyActiuons = new HashMap<>();
	
	/** The mouse actions. */
	private final GameAction[] mouseActions = new GameAction[NUM_MOUSE_CODES];
	
	/** The mouse location. */
	private final Point mouseLocation;
	
	/** The center location. */
	private final Point centerLocation;
	
	/** The component. */
	private final Component component;
	
	/** The robot. */
	private Robot robot;
	
	/** The is recentering. */
	private boolean isRecentering;
	
	/**
	 * Instantiates a new inputs.
	 *
	 * @param component the component
	 */
	public Inputs(Component component)
	{
		this.component = component;
		mouseLocation = new Point();
		centerLocation = new Point();
	}
	
	/**
	 * Sets the cursor.
	 *
	 * @param cursor the new cursor
	 */
	public void setCursor(Cursor cursor)
	{
		component.setCursor(cursor);
	}
	
	/**
	 * Sets the relative mouse mode.
	 *
	 * @param mode the new relative mouse mode
	 */
	public void setRelativeMouseMode(boolean mode)
	{
		if(mode == isRelativeMouseMode())
		{
			return;
		}
		
		if(mode)
		{
			try
			{
				robot = new Robot();
				recenterMouse();
			}
			catch(AWTException exception)
			{
				robot = null;
			}
		}
		else
		{
			robot = null;
		}
	}
	
	/**
	 * Recenter mouse.
	 */
	private synchronized void recenterMouse()
	{
		if (!(robot != null && component.isShowing()))
		{
			return;
		}
		
		centerLocation.x = component.getWidth()/2;
		centerLocation.y = component.getHeight()/2;
		SwingUtilities.convertPointToScreen(centerLocation, component);
		isRecentering = true;
		robot.mouseMove(centerLocation.x, centerLocation.y);
	}

	/**
	 * Gets the maps.
	 *
	 * @param gameCode the game code
	 * @return the maps
	 */
	public List<String> getMaps(GameAction gameCode)
	{
		final List<String> list = new ArrayList<>();
		
		keyActiuons.keySet().stream().filter(id -> gameCode == keyActiuons.get(id)).forEach(id -> list.add(getKeyName(id)));
		
		for (int i = 0; i < mouseActions.length; i++)
		{
			if(mouseActions[i] == gameCode)
			{
				list.add(getMouseName(i));
			}
		}
		
		return list;
	}
	
	/**
	 * Gets the mouse name.
	 *
	 * @param mouseCode the mouse code
	 * @return the mouse name
	 */
	public String getMouseName(int mouseCode)
	{
		switch(mouseCode)
		{
			case MOUSE_MOVE_LEFT:
				return "Mouse Left";
			case MOUSE_MOVE_RIGHT:
				return "Mouse Right";
			case MOUSE_MOVE_UP:
				return "Mouse Up";
			case MOUSE_MOVE_DOWN:
				return "Mouse Down";
			case MOUSE_WHEEL_UP:
				return "Mouse Wheel Up";
			case MOUSE_WHEEL_DOWN:
				return "Mouse Wheel Down";
			case MOUSE_BUTTON_1:
				return "Mouse Button 1";
			case MOUSE_BUTTON_2:
				return "Mouse Button 2";
			case MOUSE_BUTTON_3:
				return "Mouse Button 3";
		}
		
		return "UNKNOWN MOUSE CODE";
	}
	
	/**
	 * Gets the mouse X.
	 *
	 * @return the mouse X
	 */
	public int getMouseX()
	{
		return mouseLocation.x;
	}
	
	/**
	 * Gets the mouse Y.
	 *
	 * @return the mouse Y
	 */
	public int getMouseY()
	{
		return mouseLocation.y;
	}

	/**
	 * Gets the key name.
	 *
	 * @param keyCode the key code
	 * @return the key name
	 */
	public String getKeyName(int keyCode)
	{
		return KeyEvent.getKeyText(keyCode);
	}

	/**
	 * Reset the all game actions.
	 */
	public void resetAllGameActions()
	{
		this.keyActiuons.values().stream().filter(keysAction -> keysAction != null).forEach(GameAction::reset);
		
		for (GameAction mouseAction : mouseActions)
		{
			if(mouseAction != null)
			{
				mouseAction.reset();
			}
		}
	}
	
	/**
	 * Clear map.
	 *
	 * @param gameAction the game action
	 */
	public void clearMap(GameAction gameAction)
	{
		this.keyActiuons.clear();
		
		for (int i = 0; i < mouseActions.length; i++)
		{
			if(mouseActions[i] == gameAction)
			{
				mouseActions[i] = null;
			}
		}
		
		gameAction.reset();
	}
	
	/**
	 * Map to mouse.
	 *
	 * @param GameAction the game action
	 * @param mouseCode the mouse code
	 */
	public void mapToMouse(GameAction GameAction,int mouseCode)
	{
		mouseActions[mouseCode] = GameAction;
	}
	
	/**
	 * Map to key.
	 *
	 * @param GameAction the game action
	 * @param keyCode the key code
	 */
	public void mapToKey(GameAction GameAction,int keyCode)
	{
		this.keyActiuons.put(keyCode, GameAction);
	}
	
	/**
	 * Checks if is relative mouse mode.
	 *
	 * @return true, if is relative mouse mode
	 */
	public boolean isRelativeMouseMode()
	{
		return (robot != null);
	}
	
	/**
	 * Gets the key action.
	 *
	 * @param event the event
	 * @return the key action
	 */
	private GameAction getKeyAction(KeyEvent event)
	{
		return this.keyActiuons.get(event.getKeyCode());
	}
	
	/**
	 * Gets the mouse button action.
	 *
	 * @param event the event
	 * @return the mouse button action
	 */
	private GameAction getMouseButtonAction(MouseEvent event)
	{
		final int mouse = getMouseButtonCode(event);
		
		return mouse != -1 ? mouseActions[mouse] : null;
	}
	
	/**
	 * Gets the mouse button code.
	 *
	 * @param event the event
	 * @return the mouse button code
	 */
	public static int getMouseButtonCode(MouseEvent event)
	{
		switch(event.getButton())
		{
			case MouseEvent.BUTTON1:
				return MOUSE_BUTTON_1;
			case MouseEvent.BUTTON2:
				return MOUSE_BUTTON_2;
			case MouseEvent.BUTTON3:
				return MOUSE_BUTTON_3;
		}
		
		return -1;
	}

	/**
	 * Key typed.
	 *
	 * @param event the event
	 */
	@Override
	public void keyTyped(KeyEvent event)
	{
		event.consume();
	}

	/**
	 * Key pressed.
	 *
	 * @param event the event
	 */
	@Override
	public void keyPressed(KeyEvent event)
	{
		final GameAction action = getKeyAction(event);
		if(action != null)
		{
			action.press();
		}
		
		event.consume();
	}

	/**
	 * Key released.
	 *
	 * @param event the event
	 */
	@Override
	public void keyReleased(KeyEvent event)
	{
		final GameAction action = getKeyAction(event);
		if(action != null)
		{
			action.release();
		}
		
		event.consume();
	}

	/**
	 * Mouse pressed.
	 *
	 * @param event the event
	 */
	@Override
	public void mousePressed(MouseEvent event)
	{
		final GameAction action = getMouseButtonAction(event);
		
		if(action != null)
		{
			action.press();
		}
	}

	/**
	 * Mouse released.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseReleased(MouseEvent event)
	{
		final GameAction action = getMouseButtonAction(event);
		
		if(action != null)
		{
			action.release();
		}
	}

	/**
	 * Mouse entered.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseEntered(MouseEvent event)
	{
		mouseMoved(event);
	}

	/**
	 * Mouse exited.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseExited(MouseEvent event)
	{
		mouseMoved(event);
	}

	/**
	 * Mouse dragged.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseDragged(MouseEvent event)
	{
		mouseMoved(event);
	}

	/**
	 * Mouse moved.
	 *
	 * @param event the event
	 */
	@Override
	public synchronized void mouseMoved(MouseEvent event)
	{
		if(isRecentering && centerLocation.x == event.getX() && centerLocation.y == event.getY())
		{
			isRecentering = false;
		}
		else
		{
			final int dx = event.getX()-mouseLocation.x;
			final int dy = event.getY()-mouseLocation.y;
			mouseHelper(MOUSE_MOVE_LEFT,MOUSE_MOVE_RIGHT,dx);
			mouseHelper(MOUSE_MOVE_UP,MOUSE_MOVE_DOWN,dy);
			
			if(isRelativeMouseMode())
			{
				recenterMouse();
			}
		}
	}

	/**
	 * Mouse helper.
	 *
	 * @param codeNegative the code negative
	 * @param codePositive the code positive
	 * @param amount the amount
	 */
	private void mouseHelper(byte codeNegative, byte codePositive, int amount)
	{
		GameAction action = null;
		
		if(amount < 0)
		{
			action = mouseActions[codeNegative];
		}
		else
		{
			action = mouseActions[codePositive];
		}
		
		if (action == null)
		{
			return;
		}
		
		action.press((byte) Math.abs(amount));
		action.release();
	}

	/**
	 * Mouse wheel moved.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent event)
	{
		mouseHelper(MOUSE_MOVE_UP,MOUSE_MOVE_DOWN,event.getWheelRotation());
	}	
}