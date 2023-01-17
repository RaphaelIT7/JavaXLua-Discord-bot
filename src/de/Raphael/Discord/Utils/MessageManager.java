package de.Raphael.Discord.Utils;

import java.util.ArrayList;

import de.Raphael.Discord.Base.MessageBase;
import de.Raphael.Lua.Main;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageManager extends ListenerAdapter{

	public ArrayList<MessageBase> Listeners = new ArrayList<MessageBase>();
	@SuppressWarnings("static-access")
	public MessageManager() {
		Main.Bot.jda.addEventListener(this);
	}
	
	public void AddListener(MessageBase Listener) {
		Listeners.add(Listener);
	}
	
    @SuppressWarnings("static-access")
	@Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
    	if(event.getAuthor() == Main.Bot.jda.getSelfUser()) {
    		return;
    	}
    	String msg = event.getMessage().getContentDisplay();
    	/*if(event.getMessage().getContentRaw().startsWith("/")) {
    		Main.Bot.GetCommandManager().RunCommand(event);
    		return;
    	}*/
    	
    	ChannelType activechannel = event.getChannelType();
    	for(MessageBase b : Listeners) {
    		for(ChannelType type : b.GetChannelTypes()) {
    			if(type == activechannel) {
    	    		b.Message(event, msg);
    	    		break;
    			}
    		}
    	}
    }
}
