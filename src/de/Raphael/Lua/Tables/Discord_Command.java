package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ZeroArgFunction;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Discord_Command {
	private static SlashCommandInteractionEvent event;
	@SuppressWarnings("static-access")
	public Discord_Command(SlashCommandInteractionEvent event) {
		this.event = event;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		tbl.set("getId", new getId());
		tbl.set("getIdLong", new getIdLong());
		tbl.set("getName", new getName());
		tbl.set("getUser", new getUser());
		tbl.set("getToken", new getToken());
		tbl.set("getMember", new getMember());
		tbl.set("getTypeRaw", new getTypeRaw());
		tbl.set("getUserLocale", new getUserLocale());
		tbl.set("getTimeCreated", new getTimeCreated());
		tbl.set("getChannelType", new getChannelType());
		tbl.set("getResponseNumber", new getResponseNumber());
		tbl.set("getCommandId", new getCommandId());
		tbl.set("getCommandType", new getCommandType());
		tbl.set("getCommandIdLong", new getCommandIdLong());
		tbl.set("getCommandString", new getCommandString());
		tbl.set("getFullCommandName", new getFullCommandName());
		tbl.set("getSubcommandName", new getSubcommandName());
		tbl.set("getSubcommandGroup", new getSubcommandGroup());
		
		return tbl;
	}
	
	static class getId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getId());
		}
	}
	
	static class getIdLong extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getIdLong());
		}
	}
	
	static class getName extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getName());
		}
	}
	
	static class getUser extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return new Discord_User(event.getUser()).GetTable();
		}
	}
	
	static class getMember extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return new Discord_Member(event.getMember()).GetTable();
		}
	}
	
	static class getToken extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getToken());
		}
	}
	
	static class getTypeRaw extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getTypeRaw());
		}
	}
	
	static class getUserLocale extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getUserLocale().toString());
		}
	}
	
	static class getTimeCreated extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			LuaTable tbl = new LuaTable();
			tbl.set("year", event.getTimeCreated().getYear());
			tbl.set("month", event.getTimeCreated().getMonth().toString());
			tbl.set("day", event.getTimeCreated().getDayOfMonth());
			tbl.set("hour", event.getTimeCreated().getHour());
			tbl.set("minute", event.getTimeCreated().getMinute());
			tbl.set("second", event.getTimeCreated().getSecond());
			tbl.set("milisecond", event.getTimeCreated().getNano());
	
			return tbl;
		}
	}
	
	static class getChannelType extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getChannelType().name());
		}
	}
	
	static class getResponseNumber extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getResponseNumber());
		}
	}
	
	static class getCommandId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getCommandId());
		}
	}
	
	static class getCommandType extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getCommandType().getId());
		}
	}
	
	static class getCommandIdLong extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getCommandIdLong());
		}
	}
	
	static class getCommandString extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getCommandString());
		}
	}

	static class getFullCommandName extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getFullCommandName());
		}
	}

	static class getSubcommandName extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getSubcommandName());
		}
	}
	
	static class getSubcommandGroup extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(event.getSubcommandGroup());
		}
	}
}
