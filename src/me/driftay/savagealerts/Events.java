package me.driftay.savagealerts;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

    private Main main;

    public Events(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Faction UUIDfac = null;
        Player p = e.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(e.getPlayer());
        UUIDfac = fplayer.getFaction();
        if (this.main.getConfig().getBoolean("FactionMessagesEnabled")) {
            if (fplayer.hasFaction()) {
                for (Player fmembers : UUIDfac.getOnlinePlayers()) {
                    fmembers.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("FactionMemberLeftMessage").replace("%player%", p.getName()).replace("%faction%", fplayer.getFaction().getTag())));

                }
            }
        }
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Faction UUIDfac = null;
        Player p = e.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(e.getPlayer());
        UUIDfac = fplayer.getFaction();
        if (this.main.getConfig().getBoolean("FactionMessagesEnabled")) {
            if (fplayer.hasFaction()) {
                for (Player fmembers : UUIDfac.getOnlinePlayers()) {
                    fmembers.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("FactionMemberJoinedMessage").replace("%player%", p.getName()).replace("%faction%", fplayer.getFaction().getTag())));

                }
            }
        }
    }
}
