package me.mrCookieSlime.QuestWorld.api;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.QuestWorld.api.interfaces.IMission;

public class UnknownMission extends MissionType {
	
	private static Map<String, UnknownMission> cache = new HashMap<>();
	public static UnknownMission get(String name) {
		//throw new NullPointerException("Tried to fetch mission type: " + name + " that doesn't exist!");
		UnknownMission result = cache.get(name);
		if(result == null) {
			result = new UnknownMission(name);
			cache.put(name, result);
		}
		
		return result;
	}

	private UnknownMission(String name) {
		super(name, false, false, new ItemStack(Material.BARRIER));
	}

	@Override
	protected String userInstanceDescription(IMission instance) {
		return "Unknown mission type: " + getName() + "! Contact an admin!";
	}

	@Override
	public ItemStack userDisplayItem(IMission instance) {
		return getSelectorItem().clone();
	}
}
