package de.Raphael.Lua.Tables;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.ClientType;
import net.dv8tion.jda.api.entities.Member;

public class Discord_Member {
	private static Member member;
	@SuppressWarnings("static-access")
	public Discord_Member(Member member) {
		this.member = member;
	}
	
	public LuaTable GetTable() {
		LuaTable tbl = new LuaTable();
		
		tbl.set("isOwner", new isOwner());
		tbl.set("isPending", new isPending());
		tbl.set("isTimedout", new isTimedOut());
		tbl.set("isBoosting", new isBoosting());
		tbl.set("isOnlineStatus", new isOnlineStatus());

		tbl.set("getId", new getId());
		tbl.set("getColor", new getColor());
		tbl.set("getIdLong", new getIdLong());
		tbl.set("getColorRaw", new getColorRaw());
		tbl.set("getNickname", new getNickname());
		tbl.set("getAvatarId", new getAvatarId());
		tbl.set("getAsMention", new getAsMention());
		tbl.set("getAvatarUrl", new getAvatarUrl());
		tbl.set("getActivities", new getActivities());
		tbl.set("getOnlineStatus", new getOnlineStatus());
		tbl.set("getActiveClients", new getActiveClients());
		tbl.set("getEffectiveAvatarUrl", new getEffectiveAvatarUrl());
		
		return tbl;
	}
	
	static class isTimedOut extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.isTimedOut());
		}
	}
	
	static class isPending extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.isPending());
		}
	}
	
	static class isOwner extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.isOwner());
		}
	}
	
	static class isBoosting extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.isBoosting());
		}
	}

	static class isOnlineStatus extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue value) {
			return valueOf(member.getOnlineStatus(ClientType.fromKey(value.toString())).toString());
		}
	}
	
	static class getId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getId());
		}
	}
	
	static class getIdLong extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getIdLong());
		}
	}
	
	static class getGuild extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return new Discord_Guild(member.getGuild()).GetTable();
		}
	}
	
	static class getColor extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getColor().getRGB());
		}
	}
	
	static class getColorRaw extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getColorRaw());
		}
	}
	
	static class getNickname extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getNickname());
		}
	}

	static class getAsMention extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getAsMention());
		}
	}

	static class getAvatarId extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getAvatarId());
		}
	}
	
	static class getAvatarUrl extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getAvatarUrl());
		}
	}
	
	static class getActivities extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			LuaTable tbl = new LuaTable();
			for (Activity activity : member.getActivities()) {
				tbl.set(activity.getName(), "true");
			}

			return tbl;
		}
	}
	
	static class getPermissions extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			LuaTable tbl = new LuaTable();
			for (Permission permission : member.getPermissions()) {
				tbl.set(permission.getName(), "true");
			}

			return tbl;
		}
	}
	
	static class getOnlineStatus extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getOnlineStatus().toString());
		}
	}
	
	static class getActiveClients extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			LuaTable tbl = new LuaTable();
			for (ClientType ct : member.getActiveClients()) {
				tbl.set(ct.toString(), valueOf(true));
			}

			return tbl;
		}
	}
	
	static class getEffectiveAvatarUrl extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			return valueOf(member.getEffectiveAvatarUrl());
		}
	}
}
