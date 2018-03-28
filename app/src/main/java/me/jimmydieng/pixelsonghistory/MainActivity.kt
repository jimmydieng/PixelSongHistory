package me.jimmydieng.pixelsonghistory

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import me.jimmydieng.pixelsonghistory.data.database.dao.SongDao
import me.jimmydieng.pixelsonghistory.songlist.adapter.SongsListAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var songDao: SongDao

    override fun onCreate(savedInstanceState: Bundle?) {
        PixelSongHistoryApplication.appComponent(this).inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songAdapter = SongsListAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.songs_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = songAdapter

        songDao.getAll()
                .observe(this, Observer {
                    it?.let{
                        songAdapter.setSongs(it)
                    }
                })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) {
            return super.onOptionsItemSelected(item)
        }

        return when (item.itemId) {
            R.id.ask_notification_permissions_menu -> {
                askForNotificationPermission()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun askForNotificationPermission() {
        startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
    }
}
