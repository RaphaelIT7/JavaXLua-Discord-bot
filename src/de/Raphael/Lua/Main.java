package de.Raphael.Lua;

import java.io.File;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.Bit32Lib;
import org.luaj.vm2.lib.CoroutineLib;
import org.luaj.vm2.lib.PackageLib;
import org.luaj.vm2.lib.TableLib;
import org.luaj.vm2.lib.jse.JseBaseLib;
import org.luaj.vm2.lib.jse.JseIoLib;
import org.luaj.vm2.lib.jse.JseMathLib;
import org.luaj.vm2.lib.jse.JseOsLib;
import org.luaj.vm2.lib.jse.JsePlatform;

import de.Raphael.Discord.Manager;
import de.Raphael.Lua.Main_Functions;

public class Main {
	public static Globals LUA;
	public static Manager Bot;
	public static void main(String[] args) {
		LUA = JsePlatform.standardGlobals();
		LUA.load(new JseBaseLib());
		LUA.load(new PackageLib());
		LUA.load(new Bit32Lib());
		LUA.load(new TableLib());
		LUA.load(new CoroutineLib());
		LUA.load(new JseMathLib());
		LUA.load(new JseIoLib());
		LUA.load(new JseOsLib());
		//LUA.set("a", new LuaUserdata(new Object()));
		/*Main_Functions main_functions =*/ new Main_Functions(LUA);
		/*Discord_Functions discord_functions =*/ new Discord_Functions(LUA);
		Lua_LoadFolder("lua");
	}
	
	public static void Lua_LoadFolder(String folder) {
		File[] luafiles = new File(folder).listFiles();
		if (luafiles != null) {
			for(File f : luafiles) {
				LuaValue chunk = LUA.loadfile(f.getPath());
				chunk.call();
			}
		}
	}

}
