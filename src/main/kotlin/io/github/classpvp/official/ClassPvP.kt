package io.github.classpvp.official

import io.github.asr.mafp.server.registerListeners
import io.github.classpvp.official.command.ClassPvPCommand
import io.github.classpvp.official.command.CommandTabComplete
import io.github.classpvp.official.listeners.pvp.BucketClassListener
import io.github.classpvp.official.listeners.pvp.PlayerDeathListener
import io.github.classpvp.official.listeners.utils.*
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

lateinit var plugin: Plugin

class ClassPvP : JavaPlugin() {
    override fun onEnable() {
        plugin = this

        registerListeners(ServerMotdListener(), PlayerJoinListener())

        registerListeners(ClassSelectListener())

        registerListeners(PlayerDeathListener(), BucketClassListener())
        registerListeners(BlockBreakListener(), DroppedItemListener(), BlockFormListener())

        server.getPluginCommand("class")!!.apply {
            setExecutor(ClassPvPCommand())
            tabCompleter = CommandTabComplete()
        }
    }
}