package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;

import net.dv8tion.jda.api.entities.Guild;

public class Discord_Guild {
	private static Guild guild;
	public Discord_Guild(Guild guild) {
		this.guild = guild;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		return tbl;
	}
}
