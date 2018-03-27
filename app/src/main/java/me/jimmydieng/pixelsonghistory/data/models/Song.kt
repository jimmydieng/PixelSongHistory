package me.jimmydieng.pixelsonghistory.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao


@Entity(tableName = SongDao.TABLE_NAME,
        primaryKeys = ["timeStamp"])
data class Song(@ColumnInfo(name = "timeStamp") var timeStamp: Long = -1L,
                @ColumnInfo(name = "songName") var songName: String = "",
                @ColumnInfo(name = "lat") var lat: Double = -1.0,
                @ColumnInfo(name = "lon") var lon: Double = -1.0)
