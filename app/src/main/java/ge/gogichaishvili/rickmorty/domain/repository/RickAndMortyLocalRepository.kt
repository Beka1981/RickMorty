package ge.gogichaishvili.rickmorty.domain.repository

import androidx.lifecycle.LiveData
import ge.gogichaishvili.rickmorty.local.data.dao.RickAndMortyDao
import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel

class RickAndMortyLocalRepository(private val rickAndMortyDao: RickAndMortyDao) {

    suspend fun createAll(list: List<RickAndMortyModel>) {
        rickAndMortyDao.createAll(list)
    }

    suspend fun getAllItems() : List<RickAndMortyModel>{
        return rickAndMortyDao.getAllItems()
    }

}