package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;
/**
 * Application Controller for the Chatbot String manipulation project.  Responsible for controlling the View and Model packages.
 * @author Cody Henrichsen
 * @version 1.2 10/1/14
 */
public class ChatbotAppController
{
	/**
	 * The GUI view for the application.
	 */
	private ChatbotView appView;
	/**
	 * The Chatbot Model instance.
	 */
	private Chatbot notSoCleverBot;
	
	/**
	 * The startup message for our chatbot application.
	 */
	private String startMessage;
	
	/**
	 * Creates a ChatbotAppController and initializes the associated View and Model objects.
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		notSoCleverBot = new Chatbot("Mr. not so clever");
		startMessage = "Welcome to the " + notSoCleverBot.getName() +" Chatbot, type in your name.";
	}
	
	
	/**
	 * Allows other objects access to the notSoCleverbot.
	 * @return The Chatbot for this app.
	 */
	public Chatbot getNotSoCleverBot()
	{
		return notSoCleverBot;
	}
	
	/**
	 * Starts the Chatbot Application.  
	 */
	public void start()
	{
		String message = appView.displayChatbotConversations(startMessage);
	
		while(!notSoCleverBot.quitChecker(message))
		{
			message = appView.displayChatbotConversations(message);
		}
		
		quit();
	}
	
	/**
	 * Quits the Chatbot application with a message to the user that the application is closing.
	 */
	private void quit()
	{
		appView.displayInformation("goodbye cruel user :(");
		System.exit(0);
	}
}
