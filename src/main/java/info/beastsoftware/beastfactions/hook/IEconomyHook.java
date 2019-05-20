package info.beastsoftware.beastfactions.hook;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

public interface IEconomyHook {

    boolean isHooked();

    double getMoney(IFPlayer fPlayer);

    void setMoney(IFPlayer player, double money);

    void takeMoney(IFPlayer player, double money);

    void giveMoney(IFPlayer player, double money);

    void clearMoney(IFPlayer player);

    boolean hasEnoughMoney(IFPlayer player, double money);


}
