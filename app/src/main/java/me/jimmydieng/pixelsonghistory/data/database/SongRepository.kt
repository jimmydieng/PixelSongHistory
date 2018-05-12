package me.jimmydieng.pixelsonghistory.data.database

import android.util.Log
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import me.jimmydieng.pixelsonghistory.data.models.Song
import java.util.concurrent.Executor


class SongRepository(private val songDao: SongDao,
                     private val backgroundExecutor: Executor) {

    private val LOG_TAG = SongRepository::class.simpleName

    fun saveSong(song: Song) {
        backgroundExecutor.execute({
            val lastSongs = songDao.getLastSong()
            Log.d(LOG_TAG, "$lastSongs")
            if (lastSongs.isEmpty() || lastSongs[0].songName != song.songName) {
                songDao.save(song)
                Log.d(LOG_TAG, "Saved a song!")
            } else {
                Log.i(LOG_TAG, "Same song as last one saved")
            }
        })
    }
}
