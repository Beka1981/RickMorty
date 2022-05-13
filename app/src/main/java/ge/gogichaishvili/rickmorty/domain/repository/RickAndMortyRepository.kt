package ge.gogichaishvili.rickmorty.domain.repository

import ge.gogichaishvili.rickmorty.network.data.RickAndMortyResponse
import ge.gogichaishvili.rickmorty.network.helpers.RetrofitHelper

class RickAndMortyRepository {

    suspend fun getRickAndMortyList(): RickAndMortyResponse {
        return RetrofitHelper.rickAndMortyApi.getRickAndMortyList()
    }

    companion object {
        private var instance: RickAndMortyRepository? = null
        fun getInstance(): RickAndMortyRepository {
            return if (instance != null) {
                instance!!
            } else {
                instance = RickAndMortyRepository()
                instance!!
            }
        }
    }
}