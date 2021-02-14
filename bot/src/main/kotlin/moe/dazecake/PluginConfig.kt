package moe.dazecake

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object PluginConfig : AutoSavePluginConfig("ghostkiller") {
    @ValueDescription("""
        用于工作的BOT的QQ号
    """)
    val qq by value(3421793856L)
}