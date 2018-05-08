package me.jimmydieng.pixelsonghistory.songlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.jimmydieng.pixelsonghistory.R
import me.jimmydieng.pixelsonghistory.data.models.Song
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import java.util.*


class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val songTitleView: TextView
    private val songTimeStampView: TextView
    private var formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm:ss a")
            .withLocale(Locale.US)
            .withZone(ZoneId.systemDefault())

    init {
        songTitleView = itemView.findViewById(R.id.song_title)
        songTimeStampView = itemView.findViewById(R.id.song_timestamp)
    }

    fun setSong(song: Song) {
        songTitleView.text = song.songName

        songTimeStampView.text = formatter.format(song.timeStamp)
    }
}
