package io.github.classpvp.official.utils

import io.github.asr.mafp.utils.GREEN
import io.github.asr.mafp.utils.RED
import io.github.classpvp.official.classes.PlayerClass
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import kotlin.math.min

class ClassSelector {
    companion object {
        @JvmStatic
        fun selectorGUI(player: Player, page: Int) : Inventory {
            val inventory = Bukkit.createInventory(null, 36, Component.text("Class Selector"))

            for (index in (0 until 9).plus(27 until 36))
                inventory.setItem((page - 1) * 18 + index, ItemStack(Material.BLACK_STAINED_GLASS_PANE).apply {
                    editMeta {
                        it.displayName(Component.text(" "))
                    }
                })

            for (index in 0 until min(PlayerClass.maxIndex(), 18)) {
                val playerClass = PlayerClass.values()[index]

                val icon = playerClass.pvpClass.icon
                icon.editMeta {
                    it.displayName(playerClass.pvpClass.name)
                    val lore = playerClass.pvpClass.lore.asComponent().toMutableList()
                    if (!ableClassListMap[player]!!.contains(playerClass))
                        lore.add(Component.text("${RED}당신은 이 클래스를 해금하지 못했습니다!"))
                    it.lore(lore)
                    it.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                }

                inventory.setItem((page - 1) * 18 + index + 9, icon)
            }

            if (PlayerClass.maxIndex() > page * 18) {
                inventory.setItem(35, ItemStack(Material.ARROW).apply {
                    editMeta {
                        it.displayName(Component.text("${GREEN}다음 페이지"))
                    }
                })
            }

            if (page > 1) {
                inventory.setItem(27, ItemStack(Material.ARROW).apply {
                    editMeta {
                        it.displayName(Component.text("${GREEN}이전 페이지"))
                    }
                })
            }

            return inventory
        }
    }
}