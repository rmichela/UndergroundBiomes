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
public class DesertColumnPopulator extends ColumnPopulatorBase {
    private static Random random = new Random();

    @Override
    public boolean appliesToBiome(Biome biome) {
        return  biome == Biome.DESERT ||
                biome == Biome.DESERT_HILLS ||
                biome == Biome.MUTATED_DESERT;
    }

    @Override
    protected Material[] getBiomeSoilBlocks() {
        return new Material[] {Material.SANDSTONE, Material.SAND, Material.SAND, Material.SAND};
    }

    @Override
    protected void decorateTopBlock(Block topBlock) {
        int r = random.nextInt(100);
        if (r == 0) {
            buildCactus(topBlock, 2);
        }
        if (r == 1) {
            buildCactus(topBlock, 3);
        }
    }

    private void buildCactus(Block root, int height) {
        for (int i = 0; i < height; i ++) {
            root.setType(Material.CACTUS);
            root = root.getRelative(BlockFace.UP);
        }
    }
}
