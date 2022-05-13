package ge.gogichaishvili.rickmorty.local.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "rick_and_morty_list")
data class RickAndMortyModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val gender: String,
    val image: String,
    val location: String,
    val name: String,
    val species: String,
    val status: String
) : Serializable
