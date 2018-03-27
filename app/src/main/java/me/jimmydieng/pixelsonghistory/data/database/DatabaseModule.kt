package me.jimmydieng.pixelsonghistory.data.database

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import me.jimmydieng.pixelsonghistory.data.database.PixelSongHistoryDatabase.Companion.DATABASE_NAME
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesChangeLogsDatabase(context: Context): PixelSongHistoryDatabase {
        return Room.databaseBuilder(context, PixelSongHistoryDatabase::class.java, DATABASE_NAME)
                .build()
    }

    @Provides
    fun providesSongDao(pixelSongHistoryDatabase: PixelSongHistoryDatabase): SongDao {
        return pixelSongHistoryDatabase.songDao()
    }

    @Provides
    fun providesBackgroundExecutor(): Executor = Executors.newSingleThreadScheduledExecutor()

    @Singleton
    @Provides
    fun providesSongRepository(songDao: SongDao, backgroundExecutor: Executor): SongRepository {
        return SongRepository(songDao, backgroundExecutor)
    }
}
