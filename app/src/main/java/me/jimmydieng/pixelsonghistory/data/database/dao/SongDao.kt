package me.jimmydieng.pixelsonghistory.data.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import me.jimmydieng.pixelsonghistory.data.models.Song


@Dao
interface SongDao {

    companion object {
        const val TABLE_NAME = "Songs"
    }

    /**
     * Query all the song information on the device
     */
    @Query("SELECT * FROM " + SongDao.TABLE_NAME + " WHERE songName = :songName")
    fun getAll(songName: String): LiveData<List<Song>>

    /**
     * Save a batch of songs
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg songs: Song)
}
