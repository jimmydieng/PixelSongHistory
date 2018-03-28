package me.jimmydieng.pixelsonghistory.data.database

import android.util.Log
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import me.jimmydieng.pixelsonghistory.data.models.Song
import java.util.concurrent.Executor


class SongRepository(val songDao: SongDao,
                     val backgroundExecutor: Executor) {

    fun saveSong(song: Song) {
        backgroundExecutor.execute({
            val lastSongs = songDao.getLastSong()
            Log.d("SongRepository", "$lastSongs")
            if (lastSongs.isEmpty() || lastSongs.get(0).songName != song.songName) {
                songDao.save(song)
                Log.d("SongRepository", "Saved a song!")
            } else {
                Log.d("SongRepository", "Same song as last one saved")
            }
        })
    }
}
