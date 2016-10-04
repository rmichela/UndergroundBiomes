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

import java.util.Random;

/**
 */
public class GrassColumnPopulator extends ColumnPopulatorBase {
    @Override
    public boolean appliesToBiome(Biome biome) {
        return  biome == Biome.BIRCH_FOREST ||
                biome == Biome.BIRCH_FOREST_HILLS ||
                biome == Biome.EXTREME_HILLS ||
                biome == Biome.EXTREME_HILLS_WITH_TREES ||
                biome == Biome.FOREST ||
                biome == Biome.FOREST_HILLS ||
                biome == Biome.JUNGLE ||
                biome == Biome.JUNGLE_EDGE ||
                biome == Biome.JUNGLE_HILLS ||
                biome == Biome.PLAINS ||
                biome == Biome.ROOFED_FOREST ||
                biome == Biome.SAVANNA ||
                biome == Biome.SAVANNA_ROCK ||
                biome == Biome.SMALLER_EXTREME_HILLS ||
                biome == Biome.TAIGA ||
                biome == Biome.TAIGA_COLD ||
                biome == Biome.TAIGA_COLD_HILLS ||
                biome == Biome.TAIGA_HILLS ||
                biome == Biome.RIVER;
    }

    @Override
    protected byte appliesAtMinimumSkyLightLevel() {
        return 3;
    }

    @Override
    protected Material[] getBiomeSoilBlocks() {
        return new Material[]{Material.DIRT, Material.DIRT, Material.GRASS};
    }
}
