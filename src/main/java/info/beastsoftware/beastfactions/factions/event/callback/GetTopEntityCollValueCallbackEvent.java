package info.beastsoftware.beastfactions.factions.event.callback;

import info.beastsoftware.beastfactions.factions.entity.ITopEntityColl;

public class GetTopEntityCollValueCallbackEvent extends CallBackEvent {


    private ITopEntityColl topEntityColl;
    private double value;

    public GetTopEntityCollValueCallbackEvent(ITopEntityColl topEntityColl) {
        this.topEntityColl = topEntityColl;
    }

    public ITopEntityColl getTopEntityColl() {
        return topEntityColl;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
