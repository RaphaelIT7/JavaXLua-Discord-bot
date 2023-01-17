package de.Raphael.Discord.Utils;

import java.util.HashMap;

import de.Raphael.Lua.Main;
import de.Raphael.Discord.Base.CommandBase;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter{

	public static HashMap<String, CommandBase> Commands = new HashMap<String, CommandBase>();
	@SuppressWarnings("static-access")
	public CommandManager() {
		Main.Bot.jda.addEventListener(this);
	}
	
	@SuppressWarnings("static-access")
	public void AddCommand(String name, String description, CommandBase Command) {
		Main.Bot.jda.upsertCommand(name, description).queue();
		Commands.put(name, Command);
	}
	
	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		if(Commands.containsKey(event.getName())) {
			Commands.get(event.getName()).Command(event);
		}
	}
	
	/*public void RunCommand(MessageReceivedEvent event) {
		String[] cmds = event.getMessage().getContentRaw().split(" ");
		String cmd = cmds[0];
		if (cmd == null) { return; }
		cmd = cmd.substring(1, cmd.length());
		cmd = cmd.toLowerCase();
		if (Commands.containsKey(cmd)) {
			Commands.get(cmd).Command(event);
		}
	}*/
}
