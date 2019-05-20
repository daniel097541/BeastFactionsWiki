package info.beastsoftware.beastfactions.factions.map;

import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IMap;
import info.beastsoftware.beastfactions.factions.util.JSONMessage;

public interface IMapHandler {


    JSONMessage craftMapJSONMessage(IMap map, IFPlayer player, int radius);


}
