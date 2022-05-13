package ge.gogichaishvili.rickmorty.network.helpers

import ge.gogichaishvili.rickmorty.network.api.RickAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
     val rickAndMortyApi: RickAndMortyApi = Retrofit.Builder()
         .baseUrl("https://rickandmortyapi.com/api/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(RickAndMortyApi::class.java)
}