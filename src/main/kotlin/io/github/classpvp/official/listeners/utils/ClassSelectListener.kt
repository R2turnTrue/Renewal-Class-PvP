package io.github.classpvp.official.listeners.utils

import io.github.asr.mafp.message.sendTo
import io.github.asr.mafp.utils.RED
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.classes.pvpClass
import io.github.classpvp.official.utils.ClassSelector
import io.github.classpvp.official.utils.ableClassListMap
import io.github.classpvp.official.utils.battleField
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent

private val classSelectorPage = mutableMapOf<Player, Int>()

class ClassSelectListener : Listener {
    @EventHandler
    fun onClassSelectorOpenEvent(event: PlayerInteractEvent) {
        if (event.action.isRightClick) {
            if (event.item?.type == Material.CLOCK) {
                event.player.openInventory(ClassSelector.selectorGUI(event.player, 1))

                classSelectorPage[event.player] = 1
            }
        }
    }

    @EventHandler
    fun onClassSelectListener(event: InventoryClickEvent) {
        if (event.view.title() == Component.text("Class Selector")) {
            event.isCancelled = true
            if (event.clickedInventory == event.whoClicked.inventory) return

            val player = event.whoClicked as Player
            val page = classSelectorPage[player]!!

            when (event.slot) {
                27 -> {
                    if (page > 1) player.openInventory(ClassSelector.selectorGUI(player, page - 1))
                }

                31 -> {
                    player.pvpClass = ableClassListMap[player]!!.random()
                    player.battleField()
                }

                35 -> {
                    if (page <= (PlayerClass.maxIndex() - 1) / 18)
                        player.openInventory(ClassSelector.selectorGUI(player, page + 1))
                }

                else -> {
                    if (event.slot in 9 until 27) {
                        val clickedClassNumber = (page - 1) * 18 + (event.slot - 9)
                        val pvpClass = PlayerClass.pvpClass(clickedClassNumber)
                        if (!ableClassListMap[player]!!.contains(pvpClass)) {
                            Component.text("${RED}당신은 이 클래스를 해금하지 못했습니다!") sendTo player
                            return
                        }
                        player.pvpClass = pvpClass
                        player.battleField()
                    }
                }
            }
        }
    }
}