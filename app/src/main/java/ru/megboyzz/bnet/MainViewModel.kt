package ru.megboyzz.bnet

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.megboyzz.bnet.entities.Drug
import ru.megboyzz.bnet.service.DrugsService
import ru.megboyzz.bnet.service.getRetrofit
import java.lang.IllegalArgumentException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val drugs = MutableStateFlow<List<Drug>>(emptyList())
    val isLoading = MutableStateFlow(true)
    val activeDrug = MutableStateFlow<Drug?>(null)

    val baseURL = "http://shans.d2.i-partner.ru/"

    private var service: DrugsService = getRetrofit().create(DrugsService::class.java)

    init {
        updateDrugs()
    }

    fun updateDrugs(){
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.emit(true)
            drugs.emit(service.getListOfDrugs())
            isLoading.emit(false)
        }
    }

    fun searchDrugs(textSearch: String){
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.emit(true)
            drugs.emit(
                service.getListOfDrugs(
                    search = textSearch
                )
            )
            isLoading.emit(false)
        }
    }

    fun setActiveDrug(drug: Drug){
        viewModelScope.launch(Dispatchers.IO) {
            activeDrug.emit(drug)
        }
    }



}


class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(application) as T
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }

}