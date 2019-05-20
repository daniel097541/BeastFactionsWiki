package utils;

import info.beastsoftware.beastfactions.factions.entity.IFChunk;
import info.beastsoftware.beastfactions.factions.entity.impl.FChunk;
import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ILocationUtil {

    private static Random random = new Random();

    public static List<Chunk> getChunksAroundLocation(Location location, int radius) {

        List<Chunk> chunks = new ArrayList<>();

        Chunk locChunk = location.getChunk();
        chunks.add(locChunk);

        int finalX = radius + locChunk.getX();
        int finalZ = radius + locChunk.getZ();


        int finalXNegative;
        int finalZNegative;

        finalXNegative = locChunk.getX() - radius;
        finalZNegative = locChunk.getZ() - radius;

        //get chunks in a positive radius
        for (int x = locChunk.getX(); x <= finalX; x++) {
            for (int z = locChunk.getZ(); z <= finalZ; z++) {
                chunks.add(location.getWorld().getChunkAt(x, z));
            }
        }

        //get chunks in a negative radius
        for (int x = finalXNegative; x <= locChunk.getX(); x++) {
            for (int z = finalZNegative; z <= locChunk.getZ(); z++) {
                chunks.add(location.getWorld().getChunkAt(x, z));
            }
        }


        return chunks;
    }


    public static List<Block> getNearbyBlocks(Location location, int radius, Material searchedBlock) {
        List<Block> blocks = new ArrayList<>();
        for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                    Block b = location.getWorld().getBlockAt(x, y, z);
                    if (b.getType().equals(searchedBlock))
                        blocks.add(b);
                }
            }
        }
        return blocks;
    }


    public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<>();
        for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                    Block b = location.getWorld().getBlockAt(x, y, z);
                    blocks.add(b);
                }
            }
        }
        return blocks;
    }


    private static Location getGroundLocation(World world, int x, int z) {
        int y = world.getHighestBlockYAt(x, z);
        return new Location(world, x, y, z);
    }

    public static Location getRandomLocation(World world, int minX, int maxX, int minZ, int maxZ) {


        int x = random.nextInt((maxX - (-maxX)) + 1) + (-maxX);
        int z = random.nextInt((maxZ - (-maxZ)) + 1) + (-maxZ);

        while (x < minX && x > -minX) {
            x = random.nextInt((maxX - (-maxX)) + 1) + (-maxX);
        }

        while (z < minZ && z > -minZ) {
            z = random.nextInt((maxZ - (-maxZ)) + 1) + (-maxZ);
        }

        return getGroundLocation(world, x, z);
    }

    public static boolean isSameLocation(Location location1, Location location2) {
        int x1 = location1.getBlockX();
        int x2 = location2.getBlockX();
        if (x1 != x2) return false;
        int y1 = location1.getBlockY();
        int y2 = location2.getBlockY();
        if (y1 != y2) return false;
        int z1 = location1.getBlockZ();
        int z2 = location2.getBlockZ();
        if (z1 != z2) return false;
        return location1.getWorld().equals(location2.getWorld());
    }


    public static List<Chunk> getChunkSquare(int radius, Location initial) {


        List<Chunk> chunks = new ArrayList<>();

        Chunk initialChunk = initial.getChunk();

        if (radius == 1) {
            radius = 0;
        } else
            radius = radius / 3;

        int initialX = initialChunk.getX() - radius;
        int initialZ = initialChunk.getZ() - radius;

        int finalX = initialChunk.getX() + radius;
        int finalZ = initialChunk.getZ() + radius;


        for (int i = initialX; i <= finalX; i++) {
            for (int j = initialZ; j <= finalZ; j++)
                chunks.add(initial.getWorld().getChunkAt(i, j));
        }


        return chunks;
    }


    public static boolean isOutsideBorder(double x, double z, WorldBorder worldBorder) {
        double size = worldBorder.getSize() / 2;
        double centerX = worldBorder.getCenter().getX();
        double centerZ = worldBorder.getCenter().getZ();
        return centerX - size > x || centerX + size <= x || centerZ - size > z || centerZ + size <= z;
    }


    public static boolean isChunkOutsideBorder(int x, int z, WorldBorder worldBorder) {
        double size = worldBorder.getSize() / 2;
        int chunkSize = (int) (size / 16);
        double centerX = worldBorder.getCenter().getChunk().getChunkSnapshot().getX();
        double centerZ = worldBorder.getCenter().getChunk().getChunkSnapshot().getZ();
        return centerX - chunkSize > x || centerX + chunkSize <= x || centerZ - chunkSize > z || centerZ + chunkSize <= z;
    }


    public static boolean isSameXZ(Location location, Location compare) {

        return location.getBlockZ() == compare.getBlockZ() && location.getBlockX() == compare.getBlockX();

    }


    public static boolean isChunkCorner(Location location) {

        Chunk chunk = location.getChunk();


        Location corner1 = chunk.getBlock(0, 0, 0).getLocation();
        Location corner2 = chunk.getBlock(15, 0, 15).getLocation();
        Location corner3 = chunk.getBlock(0, 0, 15).getLocation();
        Location corner4 = chunk.getBlock(15, 0, 0).getLocation();

        if (isSameXZ(corner1, location)) return true;

        if (isSameXZ(corner2, location)) return true;

        if (isSameXZ(corner3, location)) return true;

        return isSameXZ(corner4, location);

    }


    public static List<IFChunk> getChunksBetween(Location location1, Location location2) {

        List<IFChunk> chunks = new ArrayList<>();

        int xMin;
        int xMax;

        if (location1.getChunk().getX() > location2.getChunk().getX()) {
            xMin = location2.getChunk().getX();
            xMax = location1.getChunk().getX();
        } else {
            xMin = location1.getChunk().getX();
            xMax = location2.getChunk().getX();
        }

        int zMin;
        int zMax;

        if (location1.getChunk().getZ() > location2.getChunk().getZ()) {
            zMin = location2.getChunk().getZ();
            zMax = location1.getChunk().getZ();
        } else {
            zMin = location1.getChunk().getZ();
            zMax = location2.getChunk().getZ();
        }

        for (int x = xMin; x <= xMax; x++) {
            for (int z = zMin; z <= zMax; z++) {
                // chunk
                Chunk chunk = location1.getWorld().getChunkAt(x, z);
                chunks.add(new FChunk(chunk));
            }
        }


        return chunks;
    }




}
