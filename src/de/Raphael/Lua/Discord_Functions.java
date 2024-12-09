package de.Raphael.Lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;

import de.Raphael.Discord.Manager;
import de.Raphael.Discord.Base.Lua_CommandBase;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Discord_Functions {
	private static Globals LUA;
	@SuppressWarnings("static-access")
	public Discord_Functions(Globals LUA) {
		this.LUA = LUA;
		
		LuaTable discord = new LuaTable();
		discord.set("Create", new create());
		
		LUA.set("discord", discord);
	}
	
	private static boolean Initialize(String token) {
		Main.Bot = new Manager(token);
		
		LuaTable discord = new LuaTable();
		discord.set("RegisterCommand", new registercommand());
		
		LUA.set("discord", discord);
		return Main.Bot != null;
	}
	
	static class create extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue value) {
			return valueOf(Initialize(value.toString()));
		}
	}
	
	static class registercommand extends ThreeArgFunction {
		@Override
		public LuaValue call(LuaValue value1, LuaValue value2, LuaValue value3) {
			new Lua_CommandBase(value1.toString(), value2.toString(), value3.checkfunction());
			
			return valueOf(true);
		}
	}
}
