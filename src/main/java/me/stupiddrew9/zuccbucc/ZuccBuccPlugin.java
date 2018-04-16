package me.stupiddrew9.zuccbucc;

import org.bukkit.plugin.java.JavaPlugin;

// JavaPlugin is the class that represents a plugin, this class will use all the methods of that class and add some more
public class ZuccBuccPlugin extends JavaPlugin {
	
	///////
	// the object that represents ur plugin
	// since it's static, it always exists & you can't make a new one, you just have to change it
	private static ZuccBuccPlugin plugin;
	// the object that represents ur BuccHandler so that u know where ur putting ur ZuccBuccs
	private static BuccHandler handler;
	
	// method that allows other classes to get the methods that this class has
	// it's static because it doesn't stay with the plugin being disabled or anything, it's always there
	// because it's static, you can access it from wherever
	public static ZuccBuccPlugin getPlugin() {
		return plugin;
	}
	
	// same thing
	public static BuccHandler getHandler() {
		return handler;
	}
	
	// use '@Override' bc it's overriding a method that exists in JavaPlugin
	@Override
	public void onEnable() {
		// make the plugin object equal the current time that its activated
		plugin = this;
		// let the handler make the new list of zuccbuccs and stuff
		handler = new BuccHandler();
		// register the zuccbucc command with a new object representing the ZuccCommand class
		// you can use this "getCommand()" method without showing what class it's in because it's in JavaPlugin, which this class extends
		getCommand("zuccbucc").setExecutor(new ZuccCommand());
	}
	
	@Override
	public void onDisable() {
		// end everything
		handler = null;
		plugin = null;
	}
	
}
