package ge.gogichaishvili.rickmorty.network.api

import ge.gogichaishvili.rickmorty.network.data.RickAndMortyResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getRickAndMortyList(): RickAndMortyResponse

}