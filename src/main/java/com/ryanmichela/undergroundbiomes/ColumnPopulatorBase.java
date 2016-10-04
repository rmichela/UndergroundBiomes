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

/**
 */
public abstract class ColumnPopulatorBase implements ColumnPopulator {
    @Override
    public void decorateColumn(int x, int z, ChunkSnapshot snapshot, Chunk chunk) {
        Material[] soilBlocks = getBiomeSoilBlocks();
        int soilBlockIndex = -1;

        int startY = Math.max(snapshot.getHighestBlockYAt(x, z) - 1, chunk.getWorld().getSeaLevel());

        Material lastMaterial = chunk.getBlock(x, startY + 1, z).getType();

        for (int y = startY; y >=0; y--) {
            Material thisMaterial = chunk.getBlock(x, y, z).getType();

            // Look for an Air->Stone boundary going down
            if (lastMaterial == Material.AIR && thisMaterial == Material.STONE) {
                int lightLevel = snapshot.getBlockSkyLight(x, y+1, z);
                if (lightLevel >= appliesAtMinimumSkyLightLevel()) {
                    soilBlockIndex = soilBlocks.length - 1;
                }
            }

            // Look for a Stone->Anything Else boundary going down
            if (lastMaterial == Material.STONE && thisMaterial != Material.STONE) {
                soilBlockIndex = -1;
            }

            if (soilBlockIndex > -1) {
                chunk.getBlock(x, y, z).setType(soilBlocks[soilBlockIndex]);
                soilBlockIndex--;
            }

            lastMaterial = thisMaterial;
        }
    }

    protected byte appliesAtMinimumSkyLightLevel() {
        return 0;
    }

    protected abstract Material[] getBiomeSoilBlocks();
}
