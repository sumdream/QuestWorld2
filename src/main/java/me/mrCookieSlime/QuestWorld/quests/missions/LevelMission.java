package me.mrCookieSlime.QuestWorld.quests.missions;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.material.MaterialData;

import me.mrCookieSlime.QuestWorld.quests.MissionType;
import me.mrCookieSlime.QuestWorld.quests.QuestChecker;
import me.mrCookieSlime.QuestWorld.quests.QuestListener;
import me.mrCookieSlime.QuestWorld.quests.QuestManager;
import me.mrCookieSlime.QuestWorld.quests.QuestMission;

public class LevelMission extends MissionType implements Listener {
	public LevelMission() {
		super("REACH_LEVEL", false, false, false, SubmissionType.INTEGER, new MaterialData(Material.EXP_BOTTLE));
	}
	
	@Override
	protected String formatMissionDisplay(QuestMission instance) {
		return "&7Reach Level " + instance.getAmount();
	}
	
	@EventHandler
	public void onXPChange(final PlayerLevelChangeEvent e) {
		QuestChecker.check(e.getPlayer(), e, "REACH_LEVEL", new QuestListener() {
			
			@Override
			public void onProgressCheck(Player p, QuestManager manager, QuestMission task, Object event) {
				manager.setProgress(task, e.getNewLevel());
			}
		});
	}
}
