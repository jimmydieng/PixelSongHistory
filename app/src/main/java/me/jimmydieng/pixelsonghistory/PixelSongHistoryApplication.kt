package me.jimmydieng.pixelsonghistory

import android.app.Application
import android.content.Context
import me.jimmydieng.pixelsonghistory.dagger.AppComponent
import me.jimmydieng.pixelsonghistory.dagger.AppModule
import me.jimmydieng.pixelsonghistory.dagger.DaggerAppComponent


class PixelSongHistoryApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        fun appComponent(context: Context): AppComponent {
            return (context.applicationContext as PixelSongHistoryApplication).appComponent
        }
    }
}
