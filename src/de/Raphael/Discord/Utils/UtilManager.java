package de.Raphael.Discord.Utils;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class UtilManager {
	
	public static void DeleteMessage(Message msg) {
		msg.delete().queue();
	}

	public static void SendMessage(MessageChannel channel, String value) {
		channel.sendMessage(value).queue();
	}
}
