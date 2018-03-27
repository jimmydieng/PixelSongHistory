package me.jimmydieng.pixelsonghistory.dagger

import dagger.Component
import me.jimmydieng.pixelsonghistory.MainActivity
import me.jimmydieng.pixelsonghistory.data.database.DatabaseModule


@Component(
        modules = [
            AppModule::class,
            DatabaseModule::class
        ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}
