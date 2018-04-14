package me.stupiddrew9.zuccbucc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class BuccHandler {

	// list of all ZuccBuccs that ever exist ever
	private List<ZuccBucc> zuccBuccs;
	
	// the list of ZuccBuccs is created when this constructor is activated
	// which is done when the plugin is enabled
	public BuccHandler() {
		zuccBuccs = new ArrayList<ZuccBucc>();
	}
	
	// adds a ZuccBucc to the list of ZuccBuccs
	public void addZuccBucc(ZuccBucc zuccBucc) {
		this.zuccBuccs.add(zuccBucc);
	}
	
	// removes a ZuccBucc from the list of ZuccBuccs
	public void removeZuccBucc(ZuccBucc zuccBucc) {
		this.zuccBuccs.remove(zuccBucc);
	}
	
	// gets all the ZuccBuccs that a player owns
	public List<ZuccBucc> getZuccBuccs(Player player) {
		// new list which will contain all the ZuccBuccs the player owns
		List<ZuccBucc> zuccBuccs = new ArrayList<ZuccBucc>();
		// loop through all ZuccBuccs that exist
		for (ZuccBucc zuccBucc : this.zuccBuccs) {
			// if the owner of the ZuccBucc is the player username given
			if (zuccBucc.getOwner().equals(player.getName())) {
				// add it to the list if it is
				zuccBuccs.add(zuccBucc);
			}
		}
		// give back the list of ZuccBuccs that were added, i.e. the ones the player owns
		return zuccBuccs;
	}

}
