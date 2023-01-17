package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;

import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;

public class Discord_GuildChannel {
	@SuppressWarnings("unused")
	private static GuildChannel guildchannel;
	@SuppressWarnings("static-access")
	public Discord_GuildChannel(GuildChannel guildchannel) {
		this.guildchannel = guildchannel;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		return tbl;
	}
}
