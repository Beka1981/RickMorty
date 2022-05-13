package ge.gogichaishvili.rickmorty.local.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ge.gogichaishvili.rickmorty.local.data.dao.RickAndMortyDao
import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel

const val DATABASE_VERSION = 1

@Database(entities = [RickAndMortyModel::class], version = DATABASE_VERSION, exportSchema = false)
abstract class RickAndMortyDataBase : RoomDatabase() {

    abstract fun getRickAndMortyDao(): RickAndMortyDao

    companion object {
        @Volatile
        private var INSTANCE: RickAndMortyDataBase? = null
        fun getDatabase(context: Context): RickAndMortyDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val newInstance =
                    Room.databaseBuilder(context, RickAndMortyDataBase::class.java, "rick_and_morty_database")
                        .build()
                INSTANCE = newInstance
                return newInstance
            }
        }
    }
}