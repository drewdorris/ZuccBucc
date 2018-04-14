package me.stupiddrew9.zuccbucc;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

// this class represents a CommandExecutor and the server will see it as one
public class ZuccCommand implements CommandExecutor {

	// this method is required to exist if it's a CommandExecutor
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		// if console
		if (!(sender instanceof Player)) {
			sender.sendMessage("You Cant Use This In Here DUDE!");
			return false;
		}
		
		// first argument specified
		String argumentOne;
		// try this out instead of 100% doing it, because it could give an error if it doesnt exist
		try {
			// String[] args are the arguments that were provided after the command
			// like "/dab mystats" has one argument, "mystats"
			// arrays start at 0, so the first argument is args[0]
			argumentOne = args[0];
		} catch (Exception e) {
			// if the argument does not exist, scream and return
			player.sendMessage(ChatColor.GRAY + "No You need To Specify An Argument! " + ChatColor.RED + ">:-(");
			return false;
		}
		// now that we have secured that argumentOne is the first argument
		// if the first argument is "buy" (/zuccbucc buy), do stuff
		if (argumentOne.equalsIgnoreCase("buy")) {
			// you'll need to specify an amount, like "/zuccbucc buy 5"
			// so we need to do the same thing with that amount
			// argumentTwo is what is typed
			String argumentTwo;
			// amountOfZuccBuccs is the integer that represents this value
			int amountOfZuccBuccs;
			try {
				argumentTwo = args[1];
				// you can't use a string as a number, so you have to turn the number given into an integer
				// parseInt(string) turns a string into an integer
				amountOfZuccBuccs = Integer.parseInt(argumentTwo);
			} catch (Exception e) {
				// scream and return if doesnt work
				player.sendMessage(ChatColor.GRAY + "No You need To Specify How Many ZuccBuccs! " + ChatColor.RED + ">:-(");
				return false;
			}
			// if the amount given is too much to buy at one time, tell them to stop
			if (amountOfZuccBuccs > 50) {
				player.sendMessage(ChatColor.DARK_RED + "No! You Cant Buy This menay. Grrr...");
				return false;
			}
			// string name of the player
			String owner = player.getName();
			// add the amount of ZuccBuccs specified to the BuccHandler
			// loop through and create a new ZuccBucc each number between 0 and amountOfZuccBuccs
			for (int i = 0; i < amountOfZuccBuccs; i++) {
				ZuccBucc zuccBucc = new ZuccBucc(owner);
				ZuccBuccPlugin.getHandler().addZuccBucc(zuccBucc);
			}
			// congrats
			player.sendMessage(ChatColor.GREEN + "You just bought " + amountOfZuccBuccs + " ZuccBuccs! Nice!");
			return true;
		}
		// check the amount of ZuccBuccs you have, and the value of them
		if (argumentOne.equalsIgnoreCase("amount")) { 
			// get the list of ZuccBuccs that the player owns (method created in BuccHandler)
			List<ZuccBucc> zuccBuccs = ZuccBuccPlugin.getHandler().getZuccBuccs(player);
			// you got that amount of ZuccBuccs total
			player.sendMessage(ChatColor.GRAY + String.valueOf(zuccBuccs.size()) + " ZuccBuccs total!");
			// value of each ZuccBucc is added to this double
			double value = 0;
			// loop through each ZuccBucc you own and add it to the total value
			for (ZuccBucc zuccBucc : zuccBuccs) {
				value = value + zuccBucc.getValue();
			}
			// now that you have the total value, send it to them
			player.sendMessage(ChatColor.GRAY + "Your ZuccBuccs are valued at " + String.valueOf(value) + "!");
			return true;
		}
		return false;
	}

}
