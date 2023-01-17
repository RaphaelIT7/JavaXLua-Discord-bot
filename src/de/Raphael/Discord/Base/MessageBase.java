package de.Raphael.Discord.Base;

import java.util.ArrayList;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageBase {
	
	private static ArrayList<ChannelType> channels = new ArrayList<ChannelType>();
	
	public void SetChanneltype(ChannelType type) {
		channels.add(type);
	}
	
	public ArrayList<ChannelType> GetChannelTypes() {
		return channels;
	}

	public void Message(MessageReceivedEvent event, String msg) {
		
	}
	
}
