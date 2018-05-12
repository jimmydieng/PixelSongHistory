package me.jimmydieng.pixelsonghistory.songlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.jimmydieng.pixelsonghistory.R
import me.jimmydieng.pixelsonghistory.data.models.Song
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import java.util.*


class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val dayTextView: TextView
    private var formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
            .withLocale(Locale.US)
            .withZone(ZoneId.systemDefault())

    init {
        dayTextView = itemView.findViewById(R.id.day_timestamp)
    }

    fun setDate(date: LocalDate) {
        dayTextView.text = formatter.format(date)
    }
}
