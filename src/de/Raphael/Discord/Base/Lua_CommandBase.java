package de.Raphael.Discord.Base;

import org.luaj.vm2.LuaFunction;

import de.Raphael.Lua.Main;
import de.Raphael.Lua.Tables.Discord_Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Lua_CommandBase extends CommandBase {
	private static LuaFunction func;
	@SuppressWarnings("static-access")
	public Lua_CommandBase(String name, String description, LuaFunction function) {
		func = function;
		Main.Bot.GetCommandManager().AddCommand(name, description, this);
	}
	
	@Override
	public void Command(SlashCommandInteractionEvent event) {
		func.call(new Discord_Command(event).GetTable());
	}
}
