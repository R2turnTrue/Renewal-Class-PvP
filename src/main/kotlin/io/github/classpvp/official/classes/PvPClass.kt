package io.github.classpvp.official.classes

import io.github.classpvp.official.utils.Lore
import net.kyori.adventure.text.Component
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect

open class PvPClass {
    lateinit var name: Component
    lateinit var lore: Lore

    lateinit var icon: ItemStack

    var helmet: ItemStack? = null
    var chestplate: ItemStack? = null
    var leggings: ItemStack? = null
    var boots: ItemStack? = null

    var weapons: List<ItemStack>? = null

    var skillListeners: List<Listener> = listOf()
    var potionEffects: List<PotionEffect> = listOf()

    open fun onRegister() {}
}