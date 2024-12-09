package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

import de.Raphael.Lua.Tables.LUA_UserData.LUA_Type;
import net.dv8tion.jda.api.entities.Role;

public class Discord_Role {
	private static Role role;
	@SuppressWarnings("static-access")
	public Discord_Role(Role role) {
		this.role = role;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		return tbl;
	}
	
	static class isPending extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue value) {
			LUA_UserData udata = LUA_UserData.Get(value);
			if (udata.IsType(LUA_Type.LUA_ROLE))
			{
				return valueOf(role.canInteract((Role)udata.GetData()));
			} else {
				return valueOf(false);
			}
		}
	}
}
