package ge.gogichaishvili.rickmorty.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ge.gogichaishvili.rickmorty.domain.repository.RickAndMortyLocalRepository
import ge.gogichaishvili.rickmorty.domain.repository.RickAndMortyRepository
import ge.gogichaishvili.rickmorty.local.data.database.RickAndMortyDataBase
import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RickAndMortyViewModel(application: Application) : AndroidViewModel(application) {

    private val rickAndMortyListMutableLiveData = MutableLiveData<List<RickAndMortyModel>>()
    private val rickAndMortyRepository = RickAndMortyRepository.getInstance()

    private val repository: RickAndMortyLocalRepository

    init {

        val dao = RickAndMortyDataBase.getDatabase(application).getRickAndMortyDao()
        repository = RickAndMortyLocalRepository(dao)

        getRickAndMortyList()

    }

    fun getRickAndMortyListMutableLiveData(): LiveData<List<RickAndMortyModel>> {
        return rickAndMortyListMutableLiveData
    }

    private fun getRickAndMortyList() {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            try {
                val result = rickAndMortyRepository.getRickAndMortyList().toDomainModel().results
                rickAndMortyListMutableLiveData.postValue(
                    result
                )
                createAll(result)
            } catch (e: Exception) {
                getAllItems()
            }
        }
    }

    private fun createAll(list: List<RickAndMortyModel>) = viewModelScope.launch(Dispatchers.IO) {
        repository.createAll(list)
    }

    private fun getAllItems() = viewModelScope.launch(Dispatchers.IO) {
        val result = repository.getAllItems()
        if (result.isNotEmpty()) {
            rickAndMortyListMutableLiveData.postValue(
                result
            )
        } else {
            println("Please check internet connection!")
        }
    }

}


