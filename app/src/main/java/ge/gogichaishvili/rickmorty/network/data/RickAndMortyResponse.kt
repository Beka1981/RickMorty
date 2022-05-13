package ge.gogichaishvili.rickmorty.network.data

import ge.gogichaishvili.rickmorty.domain.model.RickAndMortyUiModel
import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel

data class RickAndMortyResponse(
    val info: Info,
    val results: List<Result>
) {
    fun toDomainModel(): RickAndMortyUiModel {
        return RickAndMortyUiModel(
            info = info,
            results.map {
                RickAndMortyModel(
                    id = null,
                    gender = it.gender,
                    image = it.image,
                    location = it.location.name,
                    name = it.name,
                    species = it.species,
                    status = it.status
                )
            }
        )
    }
}
