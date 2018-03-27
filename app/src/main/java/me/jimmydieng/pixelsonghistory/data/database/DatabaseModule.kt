package me.jimmydieng.pixelsonghistory.data.database

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import me.jimmydieng.pixelsonghistory.data.database.PixelSongHistoryDatabase.Companion.DATABASE_NAME
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesChangeLogsDatabase(context: Context): PixelSongHistoryDatabase {
        return Room.databaseBuilder(context, PixelSongHistoryDatabase::class.java, DATABASE_NAME)
                .build()
    }
}
