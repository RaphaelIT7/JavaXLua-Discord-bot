package de.Raphael.Lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public class Main_Functions {
	public Main_Functions(Globals LUA) {
		LUA.set("istable", new istable());
		LUA.set("isfunction", new isfunction());
	}
	
	static class istable extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue value) {
			return valueOf(value.istable());
		}
	}
	
	static class isfunction extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue value) {
			return valueOf(value.isfunction());
		}
	}
}
