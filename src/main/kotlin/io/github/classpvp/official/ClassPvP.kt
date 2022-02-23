package io.github.classpvp.official

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

lateinit var plugin: Plugin

class ClassPvP : JavaPlugin() {
    override fun onEnable() {
        plugin = this
    }
}