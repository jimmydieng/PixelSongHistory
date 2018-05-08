package me.jimmydieng.pixelsonghistory.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import me.jimmydieng.pixelsonghistory.data.models.LocalDateTimeTypeConverter
import me.jimmydieng.pixelsonghistory.data.models.Song


@Database(
        entities = [(Song::class)],
        version = 1)
@TypeConverters(LocalDateTimeTypeConverter::class)
abstract class PixelSongHistoryDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "PixelSongHistory"
    }

    abstract fun songDao(): SongDao
}
