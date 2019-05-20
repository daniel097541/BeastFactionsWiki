package info.beastsoftware.beastfactions.factions.entity.impl;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.ICashTopEntity;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CashTopEntity implements ICashTopEntity {

    private long amount;
    private UUID uuid;

    public CashTopEntity(IFPlayer fPlayer, long amount) {
        this.amount = amount;
        this.uuid = fPlayer.getUuid();
    }

    public CashTopEntity(Player player, long amount) {
        this.uuid = player.getUniqueId();
        this.amount = amount;
    }

    @Override
    public long getValue() {
        return amount;
    }

    @Override
    public IFPlayer getOwner() {
        return BeastFactions.getInstance().getInternalApi().getFPlayer(uuid);
    }
}
