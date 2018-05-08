package me.jimmydieng.pixelsonghistory.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import org.threeten.bp.LocalDateTime


@Entity(tableName = SongDao.TABLE_NAME,
        primaryKeys = ["timeStamp"])
data class Song(@ColumnInfo(name = "timeStamp") var timeStamp: LocalDateTime = LocalDateTime.now(),
                @ColumnInfo(name = "songName") var songName: String = "",
                @ColumnInfo(name = "lat") var lat: Double = -1.0,
                @ColumnInfo(name = "lon") var lon: Double = -1.0)
