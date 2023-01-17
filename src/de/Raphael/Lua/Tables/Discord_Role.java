package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;

import net.dv8tion.jda.api.entities.Role;

public class Discord_Role {
	@SuppressWarnings("unused")
	private static Role role;
	@SuppressWarnings("static-access")
	public Discord_Role(Role role) {
		this.role = role;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		return tbl;
	}
}
