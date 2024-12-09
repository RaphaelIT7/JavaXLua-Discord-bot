package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaValue;
public class LUA_UserData {
	enum LUA_Type {
		LUA_ROLE,
		LUA_CHANNEL,
		LUA_GUILD,
		LUA_GUILD_CHANNEL,
		LUA_COMMAND,
		LUA_TEXTCHANNEL,
		LUA_User,
	}

	private Object data;
	private LUA_Type type;
	void LUA_UserData(Object obj, LUA_Type type)
	{
		this.data = obj;
		this.type = type;
	}
	
	Object GetData()
	{
		return this.data;
	}
	
	boolean IsType(LUA_Type type)
	{
		return this.type == type;
	}
	
	void Push()
	{

	}
	
	static LUA_UserData Get(LuaValue value)
	{
		return (LUA_UserData)value.touserdata();
	}
}
