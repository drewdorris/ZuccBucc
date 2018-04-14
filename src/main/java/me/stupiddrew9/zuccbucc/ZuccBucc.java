package me.stupiddrew9.zuccbucc;

import java.util.Random;

// a ZuccBucc is an object!!!
// there can be a bunch of the same objects, all with the same values and methods!!!
public class ZuccBucc {
	
	// this just always exists
	// 'final' means that you can't change it, you can only use it
	// you don't need more than one, so it's static
	private static final Random random = new Random();
	
	// string name of the owner
	private String owner;
	// is it cool or not
	private boolean isCool;
	// US dollar value
	// a 'double' has decimals, an 'int' or integer does not
	private double value; // between 0 and 100 randomly in US dollars
	
	// this runs whenever the ZuccBucc is created and an owner is specified
	public ZuccBucc(String owner) {
		this.owner = owner;
		// gets a random integer between 0 and 32
		int randomInteger = random.nextInt(32);
		// it's cool if it's between 20 and 32
		if (randomInteger > 20) {
			isCool = true;
		} else {
			// else it aint
			isCool = false;
		}
		// get a random number between 0 and 10000, like 5678
		int otherRandomInteger = random.nextInt(10000);
		// 5678 will turn into 56.78
		value = ((double) otherRandomInteger / 100);
	}
	
	// gets the player's name of who owns the ZuccBucc
	public String getOwner() {
		return owner;
	}
	
	// gets whether the ZuccBucc is cool or not
	public boolean isItCool() {
		return isCool;
	}
	
	// gets the value of the ZuccBucc in US dollars
	public double getValue() {
		return value;
	}

}
