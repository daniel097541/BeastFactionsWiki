package com.beastsoftware.beastfactions.factions.map;

import com.beastsoftware.beastfactions.factions.entity.IFPlayer;
import com.beastsoftware.beastfactions.factions.entity.IMap;
import com.beastsoftware.beastfactions.factions.util.JSONMessage;

public interface IMapHandler {


    JSONMessage craftMapJSONMessage(IMap map, IFPlayer player, int radius);


}
