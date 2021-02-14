package moe.dazecake.service

import moe.dazecake.AbstractPluginManagedService
import moe.dazecake.PluginMain
import net.mamoe.mirai.event.subscribeGroupMessages
import net.mamoe.mirai.message.data.MessageSource.Key.recall
import net.mamoe.mirai.message.data.source
import net.mamoe.mirai.utils.MiraiExperimentalApi

import kotlin.contracts.ExperimentalContracts


object KillerService : AbstractPluginManagedService() {

    override val TAG: String = "KillerService"

    @ExperimentalContracts
    @MiraiExperimentalApi
    override suspend fun main() {
        PluginMain.ghostkiller.eventChannel.subscribeGroupMessages {
            finding(Regex("幽灵")) {
                message.source.recall()
                sender.mute(30)
            }
        }
    }
}

