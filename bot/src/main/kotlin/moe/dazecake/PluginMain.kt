package moe.dazecake

import moe.dazecake.service.KillerService
import net.mamoe.mirai.Bot
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.BotOnlineEvent

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        "moe.dazecake.StopGhost",
        "0.0.1"
    ) {
        name("StopGhost")
        author("DazeCake")
    }
){
    lateinit var ghostkiller: Bot

    override fun onEnable() {
        PluginConfig.reload()
        logger.info("插件成功载入！已经准备好制裁ghost了！")

        GlobalEventChannel.filter {
            it is BotOnlineEvent && it.bot.id == PluginConfig.qq
        }.subscribeOnce<BotOnlineEvent> {
            logger.info("bot已经唤醒")
            ghostkiller = this.bot
            KillerService.start()
            logger.info("服务上线")
        }
    }
}
