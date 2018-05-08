package me.jimmydieng.pixelsonghistory.data.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import me.jimmydieng.pixelsonghistory.data.models.Song
import org.threeten.bp.LocalDateTime


@Dao
interface SongDao {

    companion object {
        const val TABLE_NAME = "Songs"
    }

    /**
     * Get all unique days stored
     */
    @Query("SELECT timeStamp FROM " + SongDao.TABLE_NAME + " GROUP BY strftime('%d', timeStamp / 1000, 'unixepoch')")
    fun getAllUniqueDates(): LiveData<List<LocalDateTime>>

    /**
     * Query all the song information on the device
     */
    @Query("SELECT * FROM " + SongDao.TABLE_NAME)
    fun getAllSongs(): LiveData<List<Song>>

    /**
     * Query all the song information on the device
     */
    @Query("SELECT * FROM " + SongDao.TABLE_NAME + " WHERE timestamp = (SELECT MAX(timestamp) FROM " + SongDao.TABLE_NAME + ")")
    fun getLastSong(): List<Song>

    /**
     * Save a batch of songs
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg songs: Song)
}
