package me.jimmydieng.pixelsonghistory.songlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.jimmydieng.pixelsonghistory.R
import me.jimmydieng.pixelsonghistory.data.models.Song


class SongsListAdapter : RecyclerView.Adapter<SongViewHolder>() {

    private val songs: MutableList<Song> = mutableListOf()

    fun setSongs(songs: List<Song>) {
        this.songs.clear()
        this.songs.addAll(songs)

        // TODO: Rough hack for now
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = songs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_list_item, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.setSong(songs[position])
    }
}
