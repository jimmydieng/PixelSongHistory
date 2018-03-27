package me.jimmydieng.pixelsonghistory.dagger

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import dagger.Module
import dagger.Provides
import me.jimmydieng.pixelsonghistory.PixelSongHistoryApplication


@Module
class AppModule(private val application: PixelSongHistoryApplication) {

    @Provides
    fun providesApplication(): Application = application

    @Provides
    fun providesContext(): Context = application

    @Provides
    fun providesPackageManager(): PackageManager = application.packageManager
}
