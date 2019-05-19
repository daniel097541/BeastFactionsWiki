package com.beastsoftware.beastfactions.factions.struct;

public enum BlocksInitialValues {


    HOPPER(20000),
    BEACON(10000),
    CHEST(100),
    TRAPPED_CHEST(100),
    DIAMOND_BLOCK(2000),
    GOLD_BLOCK(1000);


    private long value;


    BlocksInitialValues(long value) {
        this.value = value;
    }

    public static BlocksInitialValues getByName(String name) {
        try {
            return BlocksInitialValues.valueOf(name);
        } catch (Exception ignored) {

        }

        return null;
    }

    public long getValue() {
        return value;
    }
}
