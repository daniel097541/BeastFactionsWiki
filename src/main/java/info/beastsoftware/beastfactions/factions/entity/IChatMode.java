package info.beastsoftware.beastfactions.factions.entity;

public interface IChatMode {
    IRelation getRelationTalkingTo();

    String getFormat();

    String getPrefix();

    String getSufix();
}
