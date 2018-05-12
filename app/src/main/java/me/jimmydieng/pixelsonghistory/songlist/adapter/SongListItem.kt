package me.jimmydieng.pixelsonghistory.songlist.adapter

import me.jimmydieng.pixelsonghistory.data.models.Song
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime


sealed class SongListItem
data class SongItem(val song: Song) : SongListItem()
data class DateItem(val localDate: LocalDate) : SongListItem()
