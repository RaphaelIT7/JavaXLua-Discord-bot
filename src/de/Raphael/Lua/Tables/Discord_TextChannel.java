package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

import de.Raphael.Lua.Main;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Discord_TextChannel {
	private static TextChannel textchannel;
	@SuppressWarnings("static-access")
	public Discord_TextChannel(TextChannel textchannel) {
		this.textchannel = textchannel;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		return tbl;
	}
	
	static class isBot extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue value) {
			long id = 0;
			if (value.istable()) {
				LuaTable tbl = (LuaTable) value;
				if (tbl.get("getId") != null) {
					LuaFunction func = (LuaFunction) tbl.get("getId");
					id = func.call().toint();
				}
			} else if (value.isnumber()) {
				id = value.toint();
			}
			
			@SuppressWarnings("static-access")
			Member mem = (Member) Main.Bot.jda.getUserById(id);
			if (mem != null) {
				return valueOf(textchannel.canTalk(mem));
			}
			
			return valueOf(textchannel.canTalk());
		}
	}
}
