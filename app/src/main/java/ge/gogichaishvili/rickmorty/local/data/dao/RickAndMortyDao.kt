package ge.gogichaishvili.rickmorty.local.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel

@Dao
interface RickAndMortyDao {

    @Query("SELECT * FROM rick_and_morty_list")
    fun getAllItems(): List<RickAndMortyModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun createAll(result: List<RickAndMortyModel>)
}