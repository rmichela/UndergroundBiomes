//    Copyright (C) 2012  Ryan Michela
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.ryanmichela.undergroundbiomes.columnpopulators;

import com.ryanmichela.undergroundbiomes.ColumnPopulatorBase;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Random;

/**
 */
public class GrassColumnPopulator extends ColumnPopulatorBase {
    private static Random random = new Random();

    @Override
    protected byte appliesAtMinimumSkyLightLevel() {
        return 1;
    }

    @Override
    protected Material[] getBiomeSoilBlocks() {
        return new Material[]{Material.DIRT, Material.DIRT, Material.GRASS};
    }

    @Override
    protected void decorateTopBlock(Block topBlock) {
        int r = random.nextInt(20);
        if (r == 0) {
            topBlock.setType(Material.LONG_GRASS);
            topBlock.setData((byte)1);
        }
        if (r == 1) {
            topBlock.setType(Material.LONG_GRASS);
            topBlock.setData((byte)2);
        }
        if (r == 3) {
            topBlock.setType(Material.DOUBLE_PLANT);
            topBlock.setData((byte)2);
            Block doubleTopBlock = topBlock.getRelative(BlockFace.UP);
            doubleTopBlock.setType(Material.DOUBLE_PLANT);
            doubleTopBlock.setData((byte)8);
        }
        if (r == 4) {
            topBlock.setType(Material.DOUBLE_PLANT);
            topBlock.setData((byte)3);
            Block doubleTopBlock = topBlock.getRelative(BlockFace.UP);
            doubleTopBlock.setType(Material.DOUBLE_PLANT);
            doubleTopBlock.setData((byte)8);
        }
        if (r == 5) {
            topBlock.setType(Material.DOUBLE_PLANT);
            topBlock.setData((byte)5);
            Block doubleTopBlock = topBlock.getRelative(BlockFace.UP);
            doubleTopBlock.setType(Material.DOUBLE_PLANT);
            doubleTopBlock.setData((byte)8);
        }
        if (r == 6) {
            topBlock.setType(Material.DOUBLE_PLANT);
            topBlock.setData((byte)4);
            Block doubleTopBlock = topBlock.getRelative(BlockFace.UP);
            doubleTopBlock.setType(Material.DOUBLE_PLANT);
            doubleTopBlock.setData((byte)8);
        }
    }

    @Override
    public boolean appliesToBiome(Biome biome) {
        return  biome == Biome.BIRCH_FOREST ||
                biome == Biome.BIRCH_FOREST_HILLS ||
                biome == Biome.MUTATED_BIRCH_FOREST_HILLS ||
                biome == Biome.MUTATED_BIRCH_FOREST_HILLS ||
                biome == Biome.EXTREME_HILLS ||
                biome == Biome.EXTREME_HILLS_WITH_TREES ||
                biome == Biome.MUTATED_EXTREME_HILLS ||
                biome == Biome.MUTATED_EXTREME_HILLS_WITH_TREES ||
                biome == Biome.FOREST ||
                biome == Biome.FOREST_HILLS ||
                biome == Biome.MUTATED_FOREST ||
                biome == Biome.JUNGLE ||
                biome == Biome.JUNGLE_EDGE ||
                biome == Biome.JUNGLE_HILLS ||
                biome == Biome.MUTATED_JUNGLE ||
                biome == Biome.MUTATED_JUNGLE_EDGE ||
                biome == Biome.PLAINS ||
                biome == Biome.MUTATED_PLAINS ||
                biome == Biome.ROOFED_FOREST ||
                biome == Biome.MUTATED_ROOFED_FOREST ||
                biome == Biome.REDWOOD_TAIGA ||
                biome == Biome.REDWOOD_TAIGA_HILLS ||
                biome == Biome.MUTATED_REDWOOD_TAIGA ||
                biome == Biome.MUTATED_REDWOOD_TAIGA_HILLS ||
                biome == Biome.SAVANNA ||
                biome == Biome.SAVANNA_ROCK ||
                biome == Biome.MUTATED_SAVANNA ||
                biome == Biome.MUTATED_SAVANNA_ROCK ||
                biome == Biome.SMALLER_EXTREME_HILLS ||
                biome == Biome.TAIGA ||
                biome == Biome.TAIGA_COLD ||
                biome == Biome.TAIGA_COLD_HILLS ||
                biome == Biome.TAIGA_HILLS ||
                biome == Biome.MUTATED_TAIGA ||
                biome == Biome.MUTATED_TAIGA_COLD ||
                biome == Biome.RIVER;
    }
}
