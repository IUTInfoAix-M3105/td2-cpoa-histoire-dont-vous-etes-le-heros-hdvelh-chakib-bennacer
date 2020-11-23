/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";

	private int id;
	private GUIManager gui;
	private Scanner reader;
	private String playerAnswer;
	private int chosenPath;
	static private int lastId = -1;

	//Constructor
	public Event(){
		this(new GUIManager(),null);
	}

	public Event(GUIManager gui,String data){
		super(data);
		chosenPath = -1;
		this.gui = gui;
		this.reader = gui.getInputReader();
		id = ++lastId;
	}


	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		/* TO BE COMPLETED */
		return playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		/* TO BE COMPLETED */
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		/* TO BE COMPLETED */
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		/* TO BE COMPLETED */
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		/* TO BE COMPLETED */
		return chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		/* TO BE COMPLETED */
		this.chosenPath = chosenPath;
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		/* TO BE COMPLETED */
		return super.getData().toString();
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		/* TO BE COMPLETED */
		super.setData(data);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		/* TO BE COMPLETED */
		return (Event) super.getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		/* TO BE COMPLETED */
		super.setDaughter(daughter,i);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		/* TO BE COMPLETED */
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		/* TO BE COMPLETED */
		this.gui = gui;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		/* TO BE COMPLETED */
		return id;
	}

	/* Methods */
	/* TO BE COMPLETED */
	public int interpretAnswer(String playerAnswer){
	    if (playerAnswer == null){ ErrorNaiveHandler.abort("null have been give as parameter" + "@" + getClass() + ".interpretAnswer");}
		int i = 0;
		while (!playerAnswer.matches("[1-9]") || !isInRange(Integer.parseInt(playerAnswer))|| playerAnswer.isEmpty() || Integer.parseInt(playerAnswer) <= 0 ){
			gui.output(WARNING_MSG_INTEGER_EXPECTED);
			playerAnswer = reader.next();
		}
		i = Integer.parseInt(playerAnswer);
		return --i;
	}
	//Run
	public Event run(){
		if(super.hasDaughters()) {
			gui.outputln(getData());
			gui.output(PROMPT_ANSWER);
			playerAnswer = reader.next();
			chosenPath = interpretAnswer(playerAnswer);
			return getDaughter(chosenPath);
		}
		else return this;
	}


}

// eof