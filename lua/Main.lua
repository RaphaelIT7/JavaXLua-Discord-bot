print("Hello World!", _G)
print(discord.create("MTA2MzYxNjE4Mzk1OTU2MDIzMg.GmOi1a.L2FhoVTRF6uIuuvglqFR5DIyIwHrwCO6qwliLs"))

discord.registercommand("test2", "a", function(tbl)
	print("LOL", tbl.getMember().isOnlineStatus("ONLINE"))
end)