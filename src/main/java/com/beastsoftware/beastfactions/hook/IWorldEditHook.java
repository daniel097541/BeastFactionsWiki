package com.beastsoftware.beastfactions.hook;

import com.beastsoftware.beastfactions.factions.entity.IFChunk;
import com.beastsoftware.beastfactions.factions.entity.IFPlayer;

import java.util.List;

public interface IWorldEditHook {


    List<IFChunk> getSelectedRegionChunks(IFPlayer player);

    boolean isValidSelection(IFPlayer fPlayer);

    boolean hasSelection(IFPlayer player);

}
