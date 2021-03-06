package me.mrCookieSlime.QuestWorld.api;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import me.mrCookieSlime.QuestWorld.api.contract.QuestingAPI;
import me.mrCookieSlime.QuestWorld.api.contract.IFacade;
import me.mrCookieSlime.QuestWorld.api.contract.IMission;
import me.mrCookieSlime.QuestWorld.api.contract.IParty;
import me.mrCookieSlime.QuestWorld.api.contract.IPlayerStatus;
import me.mrCookieSlime.QuestWorld.api.contract.MissionEntry;
import me.mrCookieSlime.QuestWorld.util.Sounds;
import net.milkbowl.vault.economy.Economy;

/**
 * Singleton backed static interface of QuestingAPI.
 * 
 * @see me.mrCookieSlime.QuestWorld.api.contract.QuestingAPI QuestingAPI
 * 
 * @author Erik Zeiger
 */
public final class QuestWorld {
	private static QuestingAPI api = null;
	
	/**
	 * This class is entirely static and cannot be constructed.
	 */
	private QuestWorld() {	
	}
	
	/**
	 * Set the implementing API. This is an internal function and should not be
	 * called directly.
	 * 
	 * @param api The implementation of
	 * {@link me.mrCookieSlime.QuestWorld.api.contract.QuestingAPI QuestingAPI}
	 * 
	 * @throws NullPointerException The supplied implementation was null
	 * @throws UnsupportedOperationException An implementation was already set
	 * and the singleton cannot be redefined
	 */
	public static void setAPI(QuestingAPI api) {
		if(QuestWorld.api != null)
			throw new UnsupportedOperationException("Cannot redefine API singleton");
		
		if(api == null)
			throw new NullPointerException("API cannot be null");
		
		QuestWorld.api = api;
	}
	
	public static final <T extends MissionType> T getMissionType(String typeName) {
		return api.getMissionType(typeName);
	}
	
	public static final Map<String, MissionType> getMissionTypes() {
		return api.getMissionTypes();
	}
	
	public static final MissionViewer getViewer() {
		return api.getViewer();
	}
	
	public static final Optional<Economy> getEconomy() {
		return api.getEconomy();
	}
	
	public static final IFacade getFacade() {
		return api.getFacade();
	}
	
	public static final Sounds getSounds() {
		return api.getSounds();
	}
	
	public static String translate(Translator key, String... replacements) {
		return api.translate(key, replacements);
	}
	
	public static Iterable<MissionEntry> getMissionEntries(MissionType type, OfflinePlayer player) {
		return api.getMissionEntries(type, player);
	}
	
	public static MissionEntry getMissionEntry(IMission mission, OfflinePlayer player) {
		return api.getMissionEntry(mission, player);
	}
	
	public static Plugin getPlugin() {
		return api.getPlugin();
	}
	
	public static IPlayerStatus getPlayerStatus(OfflinePlayer player) {
		return api.getPlayerStatus(player);
	}
	
	public static IPlayerStatus getPlayerStatus(UUID uuid) {
		return api.getPlayerStatus(uuid);
	}
	
	public static IParty getParty(OfflinePlayer player) {
		return api.getParty(player);
	}
	
	public static IParty getParty(UUID uuid) {
		return api.getParty(uuid);
	}
	
	public static IParty createParty(OfflinePlayer player) {
		return api.createParty(player);
	}
	
	public static IParty createParty(UUID uuid) {
		return api.createParty(uuid);
	}
	
	public static void disbandParty(IParty party) {
		api.disbandParty(party);
	}
	
	public static QuestingAPI getAPI() {
		return api;
	}
}
