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

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 */
public class UBPlugin extends JavaPlugin implements Listener {

    private UBConfig UBConfig;

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
            saveDefaultConfig();
        }
        UBConfig = new UBConfig(getConfig());

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    private void onWorldInit(WorldInitEvent worldInitEvent) {
        String worldName = worldInitEvent.getWorld().getName();
        if (UBConfig.getWorlds().contains(worldName)) {
            getLogger().info("Attaching underground biome populator to world: " + worldName);
            worldInitEvent.getWorld().getPopulators().add(new BiomePopulator(UBConfig));
        }
    }
}
