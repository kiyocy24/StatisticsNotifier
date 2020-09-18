package com.github.kiyocy24.stat_recorder.repository

import com.github.kiyocy24.stat_recorder.entity.db.CustomLog as DBCustomLog
import com.github.kiyocy24.stat_recorder.entity.view.CustomLog as ViewCustomLog
import com.github.kiyocy24.stat_recorder.infrastructure.Database
import java.sql.Connection

class CustomLogRepository(private val conn: Connection) {
    private val db = Database(conn).CustomLog()
    fun insert(viewCustomLog: ViewCustomLog) {
        val dbCustomLog = DBCustomLog(
                userId = viewCustomLog.userId,
                damageDealt = viewCustomLog.damageDealt,
                damageTaken = viewCustomLog.damageTaken,
                deaths = viewCustomLog.deaths,
                mobKills = viewCustomLog.mobKills,
                playerKills = viewCustomLog.playerKills,
                fishCaught = viewCustomLog.fishCaught,
                animalsBred = viewCustomLog.animalsBred,
                leaveGame = viewCustomLog.leaveGame,
                jump = viewCustomLog.jump,
                dropCount = viewCustomLog.dropCount,

                playOneMinute = viewCustomLog.playOneMinute,
                walkOneCm = viewCustomLog.walkOneCm,
                walkOnWaterOneCm = viewCustomLog.walkOnWaterOneCm,
                fallOneCm = viewCustomLog.fallOneCm,
                sneakTime = viewCustomLog.sneakTime,
                climbOneCm = viewCustomLog.climbOneCm,
                flyOneCm = viewCustomLog.flyOneCm,
                walkUnderWaterOneCm = viewCustomLog.walkUnderWaterOneCm,
                minecartOneCm = viewCustomLog.minecartOneCm,
                boatOneCm = viewCustomLog.boatOneCm,
                pigOneCm = viewCustomLog.pigOneCm,
                horseOneCm = viewCustomLog.horseOneCm,
                sprIntOneCm = viewCustomLog.sprIntOneCm,
                crouchOneCm = viewCustomLog.crouchOneCm,
                aviateOneCm = viewCustomLog.aviateOneCm,
                timeSinceDeath = viewCustomLog.timeSinceDeath,
                talkedToVillager = viewCustomLog.talkedToVillager,
                tradedWithVillager = viewCustomLog.tradedWithVillager,
                cakeSlicesEaten = viewCustomLog.cakeSlicesEaten,
                cauldronFilled = viewCustomLog.cauldronFilled,
                cauldronUsed = viewCustomLog.cauldronUsed,
                armorCleaned = viewCustomLog.armorCleaned,
                bannerCleaned = viewCustomLog.bannerCleaned,
                brewingstandInteraction = viewCustomLog.brewingstandInteraction,
                beaconInteraction = viewCustomLog.beaconInteraction,
                dropperInspected = viewCustomLog.dropperInspected,
                hopperInspected = viewCustomLog.hopperInspected,
                dispenserInspected = viewCustomLog.dispenserInspected,
                noteblockPlayed = viewCustomLog.noteblockPlayed,
                noteblockTuned = viewCustomLog.noteblockTuned,
                flowerPotted = viewCustomLog.flowerPotted,
                trappedChestTriggered = viewCustomLog.trappedChestTriggered,
                enderchestOpened = viewCustomLog.enderchestOpened,
                itemEnchanted = viewCustomLog.itemEnchanted,
                recordPlayed = viewCustomLog.recordPlayed,
                furnaceInteraction = viewCustomLog.furnaceInteraction,
                craftingTableInteraction = viewCustomLog.craftingTableInteraction,
                chestOpened = viewCustomLog.chestOpened,
                sleepInBed = viewCustomLog.sleepInBed,
                shulkerBoxOpened = viewCustomLog.shulkerBoxOpened,
                timeSinceRest = viewCustomLog.timeSinceRest,
                swimOneCm = viewCustomLog.swimOneCm,
                damageDealtAbsorbed = viewCustomLog.damageDealtAbsorbed,
                damageDealtResisted = viewCustomLog.damageDealtResisted,
                damageBlockedByShield = viewCustomLog.damageBlockedByShield,
                damageAbsorbed = viewCustomLog.damageAbsorbed,
                damageResisted = viewCustomLog.damageResisted,
                cleanShulkerBox = viewCustomLog.cleanShulkerBox,
                openBarrel = viewCustomLog.openBarrel,
                interactWithBlastFurnace = viewCustomLog.interactWithBlastFurnace,
                interactWithSmoker = viewCustomLog.interactWithSmoker,
                interactWithLectern = viewCustomLog.interactWithLectern,
                interactWithCampfire = viewCustomLog.interactWithCampfire,
                interactWithCartographyTable = viewCustomLog.interactWithCartographyTable,
                interactWithLoom = viewCustomLog.interactWithLoom,
                interactWithStonecutter = viewCustomLog.interactWithStonecutter,
                bellRing = viewCustomLog.bellRing,
                raidTrigger = viewCustomLog.raidTrigger,
                raidWin = viewCustomLog.raidWin,
                interactWithAnvil = viewCustomLog.interactWithAnvil,
                interactWithGrindstone = viewCustomLog.interactWithGrindstone,
                targetHit = viewCustomLog.targetHit,
                interactWithSmithingTable = viewCustomLog.interactWithSmithingTable,
                striderOneCm = viewCustomLog.striderOneCm
        )
        db.insert(dbCustomLog)
    }
}