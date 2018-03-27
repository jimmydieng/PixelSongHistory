package me.jimmydieng.pixelsonghistory.data.database

import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import me.jimmydieng.pixelsonghistory.data.models.Song
import java.util.concurrent.Executor


class SongRepository(val songDao: SongDao,
                     val backgroundExecutor: Executor) {

    fun saveSong(vararg songs: Song) {
        backgroundExecutor.execute({ songDao.save(*songs) })
    }
}
