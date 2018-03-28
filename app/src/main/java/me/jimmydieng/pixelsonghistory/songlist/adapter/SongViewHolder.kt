package me.jimmydieng.pixelsonghistory.songlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.jimmydieng.pixelsonghistory.R
import me.jimmydieng.pixelsonghistory.data.models.Song
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val songTitleView: TextView
    private val songTimeStampView: TextView
    private val dateFormatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    init {
        songTitleView = itemView.findViewById(R.id.song_title)
        songTimeStampView = itemView.findViewById(R.id.song_timestamp)
    }

    fun setSong(song: Song) {
        songTitleView.text = song.songName
        songTimeStampView.text = dateFormatter.format(Date(song.timeStamp))
    }
}
