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

package com.ryanmichela.undergroundbiomes;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 */
public abstract class ColumnPopulatorBase implements ColumnPopulator {
    @Override
    public void decorateColumn(int x, int z, ChunkSnapshot snapshot, Chunk chunk) {
        Material[] soilBlocks = getBiomeSoilBlocks();
        int soilBlockIndex = -1;

        int startY = Math.max(snapshot.getHighestBlockYAt(x, z) - 1, chunk.getWorld().getSeaLevel());

        Block lastBlock = chunk.getBlock(x, startY + 1, z);

        for (int y = startY; y >=0; y--) {
            Block thisBlock = chunk.getBlock(x, y, z);

            // Look for an Air->Stone boundary going down
            if (lastBlock.getType() == Material.AIR && thisBlock.getType() == Material.STONE) {
                int lightLevel = snapshot.getBlockSkyLight(x, y+1, z);
                if (lightLevel >= appliesAtMinimumSkyLightLevel()) {
                    decorateTopBlock(lastBlock);
                    soilBlockIndex = soilBlocks.length - 1;
                }
            }

            // Look for a Stone->Anything Else boundary going down
            if (lastBlock.getType() == Material.STONE && thisBlock.getType() != Material.STONE) {
                soilBlockIndex = -1;
            }

            if (soilBlockIndex > -1) {
                chunk.getBlock(x, y, z).setType(soilBlocks[soilBlockIndex]);
                soilBlockIndex--;
            }

            lastBlock = thisBlock;
        }
    }

    protected byte appliesAtMinimumSkyLightLevel() {
        return 0;
    }

    protected void decorateTopBlock(Block topBlock){}

    protected abstract Material[] getBiomeSoilBlocks();
}
