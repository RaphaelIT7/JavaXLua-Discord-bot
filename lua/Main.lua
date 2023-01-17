print("Hello World!", _G)
print(discord.Create(""))

discord.RegisterCommand("test2", "a", function(tbl)
	print("LOL", tbl.getMember().isOnlineStatus("ONLINE"))
end)