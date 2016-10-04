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

import java.util.Random;

/**
 */
public class MushroomColumnPopulator extends ColumnPopulatorBase {
    private static Random random = new Random();

    public boolean appliesToBiome(Biome biome) {
        return biome == Biome.MUSHROOM_ISLAND || biome == Biome.MUSHROOM_ISLAND_SHORE;
    }

    @Override
    protected Material[] getBiomeSoilBlocks() {
        return new Material[] {Material.DIRT, Material.DIRT, Material.MYCEL};
    }

    @Override
    protected void decorateTopBlock(Block topBlock) {
        super.decorateTopBlock(topBlock);
        int r = random.nextInt(10);
        if (r == 0) {
            topBlock.setType(Material.RED_MUSHROOM);
        }
        if (r == 1) {
            topBlock.setType(Material.BROWN_MUSHROOM);
        }
    }
}
