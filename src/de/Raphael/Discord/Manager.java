package de.Raphael.Discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import de.Raphael.Discord.Base.CommandBase;
import de.Raphael.Discord.Base.MessageBase;
import de.Raphael.Discord.Utils.CommandManager;
import de.Raphael.Discord.Utils.MessageManager;

public class Manager {
	public static JDA jda = null;
	private static CommandManager CommandManager;
	private static MessageManager MessageManager;
	public Manager(String token) {
		jda = JDABuilder.createDefault(token).build();
		
		MessageManager = new MessageManager();
		CommandManager = new CommandManager();
	}
	
	public static void RegisterListener(MessageBase listener) {
		MessageManager.AddListener(listener);
	}
	
	public static void RegisterCommand(String name, String description, CommandBase Command) {
		CommandManager.AddCommand(name.toLowerCase(), description, Command);
	}
	
	public static MessageManager GetMessageManager() {
		return MessageManager;
	}
	
	public static CommandManager GetCommandManager() {
		return CommandManager;
	}
}
