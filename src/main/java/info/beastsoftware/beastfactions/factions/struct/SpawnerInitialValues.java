package info.beastsoftware.beastfactions.factions.struct;

public enum SpawnerInitialValues {


    ZOMBIE(10000),
    CREEPER(400000),
    SKELETON(10000),
    IRON_GOLEM(1000000),
    SPIDER(10000),
    PIG(1000),
    COW(1000),
    VILLAGER(2000000),
    PIG_ZOMBIE(500000),
    ENDERMAN(400000),
    BLAZE(350000);


    private long value;


    SpawnerInitialValues(long value) {
        this.value = value;
    }

    public static SpawnerInitialValues getByName(String name) {
        try {
            return SpawnerInitialValues.valueOf(name);
        } catch (Exception ignored) {
        }
        return null;
    }

    public long getValue() {
        return value;
    }
}
