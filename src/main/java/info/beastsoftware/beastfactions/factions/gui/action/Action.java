package info.beastsoftware.beastfactions.factions.gui.action;

public abstract class Action implements IAction {

    protected final boolean dynamic;

    protected Action(boolean dynamic) {
        this.dynamic = dynamic;
    }


    @Override
    public boolean isDynamic() {
        return dynamic;
    }
}
