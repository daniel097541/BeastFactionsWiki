package info.beastsoftware.beastfactions.hook;

import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;

import java.util.List;

public interface IWorldEditHook {


    List<IFChunk> getSelectedRegionChunks(IFPlayer player);

    boolean isValidSelection(IFPlayer fPlayer);

    boolean hasSelection(IFPlayer player);

}
