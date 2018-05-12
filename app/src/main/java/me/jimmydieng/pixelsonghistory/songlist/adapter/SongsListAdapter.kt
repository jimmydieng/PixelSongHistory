package me.jimmydieng.pixelsonghistory.songlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.jimmydieng.pixelsonghistory.R
import me.jimmydieng.pixelsonghistory.data.models.Song
import org.threeten.bp.LocalDate


class SongsListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DATE_ITEM_TYPE: Int = 1
    private val SONG_ITEM_TYPE: Int = 2

    private val songListItems: MutableList<SongListItem> = mutableListOf()
    private val songHistory: MutableMap<LocalDate, MutableList<Song>> = mutableMapOf()

    fun setSongs(songs: List<Song>) {
        songListItems.clear()
        songHistory.clear()

        songs.forEach({
            val songDate = it.timeStamp.toLocalDate()
            if (songDate !in songHistory) {
                songHistory[songDate] = mutableListOf()
            }
            songHistory[songDate]!!.add(it)
        })

        for ((date, songsForDate) in songHistory) {
            songListItems.add(DateItem(date))
            songsForDate.forEach {
                songListItems.add(SongItem(it))
            }
        }

        // TODO: Rough hack for now
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = songListItems.size

    override fun getItemViewType(position: Int): Int {
        return when (songListItems[position]) {
            is SongItem -> SONG_ITEM_TYPE
            is DateItem -> DATE_ITEM_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            DATE_ITEM_TYPE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.date_list_item, parent, false)
                return DateViewHolder(view)
            }
            SONG_ITEM_TYPE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.song_list_item, parent, false)
                return SongViewHolder(view)
            }
            else -> {
                throw IllegalArgumentException("Unknown Type: $viewType$")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val songListItem = songListItems[position]
        when (holder) {
            is DateViewHolder -> {
                if (songListItem is DateItem) {
                    holder.setDate(songListItem.localDate)
                    return
                }
            }
            is SongViewHolder -> {
                if (songListItem is SongItem) {
                    holder.setSong(songListItem.song)
                    return
                }
            }
        }
        throw IllegalArgumentException("Unknown Type: $songListItem$ with Holder: $holder$")
    }
}
