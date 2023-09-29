package me.patrick.examplemod;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Iterator;
import java.util.List;

public class EntityRegistryHandler
{
    public static void removeCreatureEntitiesFromRegistry()
    {
        for (Biome biome : ForgeRegistries.BIOMES)
        {
            List<Biome.SpawnListEntry> spawnList = biome.getSpawnableList(EnumCreatureType.MONSTER);

            // Use iterator to safely remove elements during iteration
            Iterator<Biome.SpawnListEntry> iterator = spawnList.iterator();
            while (iterator.hasNext())
            {
                iterator.next();
                iterator.remove();
            }

            iterator = biome.getSpawnableList(EnumCreatureType.CREATURE).iterator();
            while (iterator.hasNext())
            {
                iterator.next();
                iterator.remove();
            }

            iterator = biome.getSpawnableList(EnumCreatureType.AMBIENT).iterator();
            while (iterator.hasNext())
            {
                iterator.next();
                iterator.remove();
            }

            iterator = biome.getSpawnableList(EnumCreatureType.WATER_CREATURE).iterator();
            while (iterator.hasNext())
            {
                iterator.next();
                iterator.remove();
            }
        }
    }
}
