package ge.gogichaishvili.rickmorty.domain.model

import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel
import ge.gogichaishvili.rickmorty.network.data.Info

data class RickAndMortyUiModel(
    val info: Info,
    val results: List<RickAndMortyModel>
)
