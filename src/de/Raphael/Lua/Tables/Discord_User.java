package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ZeroArgFunction;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.User.UserFlag;

public class Discord_User {
	private static User user;
	@SuppressWarnings("static-access")
	public Discord_User(User user) {
		this.user = user;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		/*tbl.set("AVATAR_URL", user.AVATAR_URL);
		tbl.set("BANNER_URL", user.BANNER_URL);
		tbl.set("DEFAULT_ACCENT_COLOR_RAW", user.DEFAULT_ACCENT_COLOR_RAW);
		tbl.set("DEFAULT_AVATAR_URL", user.DEFAULT_AVATAR_URL);*/
		
		tbl.set("isBot", new isBot());
		tbl.set("isSystem", new isSystem());

		tbl.set("getId", new getId());
		tbl.set("getName", new getName());
		tbl.set("getFlags", new getFlags());
		tbl.set("getAsTag", new getAsTag());
		tbl.set("getFlagsRaw", new getFlagsRaw());
		tbl.set("getAvatarId", new getAvatarId());
		tbl.set("getAsMention", new getAsMention());
		tbl.set("getAvatarUrl", new getAvatarUrl());
		tbl.set("getTimeCreated", new getTimeCreated());
		tbl.set("getDiscriminator", new getDiscriminator());
		tbl.set("getDefaultAvatarId", new getDefaultAvatarId());
		tbl.set("getDefaultAvatarUrl", new getDefaultAvatarUrl());
		tbl.set("getEffectiveAvatarUrl", new getEffectiveAvatarUrl());
		
		return tbl;
	}
	
	static class isBot extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.isBot());
		}
	}
	
	static class isSystem extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.isSystem());
		}
	}
	
	
	static class getId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getId());
		}
	}
	
	static class getName extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getName());
		}
	}
	
	static class getAsTag extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getAsTag());
		}
	}
	
	static class getAsMention extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getAsMention());
		}
	}
	
	static class getFlags extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			LuaTable tbl = new LuaTable();
			for (UserFlag uf : user.getFlags()) {
				tbl.set(uf.getName(), uf.getRawValue());
			}

			return tbl;
		}
	}
	
	static class getFlagsRaw extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getFlagsRaw());
		}
	}
	
	static class getTimeCreated extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			LuaTable tbl = new LuaTable();
			tbl.set("year", user.getTimeCreated().getYear());
			tbl.set("month", user.getTimeCreated().getMonth().toString());
			tbl.set("day", user.getTimeCreated().getDayOfMonth());
			tbl.set("hour", user.getTimeCreated().getHour());
			tbl.set("minute", user.getTimeCreated().getMinute());
			tbl.set("second", user.getTimeCreated().getSecond());
			tbl.set("milisecond", user.getTimeCreated().getNano());
	
			return tbl;
		}
	}
	
	static class getDiscriminator extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getDiscriminator());
		}
	}
	
	/*
	 * Avatar stuff
	 */
	
	static class getAvatarId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getAvatarId());
		}
	}
	
	static class getAvatarUrl extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getAvatarUrl());
		}
	}
	
	static class getDefaultAvatarId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getDefaultAvatarId());
		}
	}
	
	static class getDefaultAvatarUrl extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getDefaultAvatarUrl());
		}
	}
	
	static class getEffectiveAvatarUrl extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(user.getEffectiveAvatarUrl());
		}
	}
}
