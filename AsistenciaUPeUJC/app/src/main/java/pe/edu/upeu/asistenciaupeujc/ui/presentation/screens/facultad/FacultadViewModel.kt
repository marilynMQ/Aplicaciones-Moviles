package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.facultad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.modelo.Facultad
import pe.edu.upeu.asistenciaupeujc.repository.FacultadRepository
import javax.inject.Inject
@HiltViewModel
class FacultadViewModel @Inject constructor(
    private val faculRepo: FacultadRepository,
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val facul: LiveData<List<Facultad>> by lazy {
        faculRepo.reportarFacultades()
    }
    val isLoading: LiveData<Boolean> get() = _isLoading
    fun addFacultad() {
        if (_isLoading.value == false)
            viewModelScope.launch (Dispatchers.IO) {
                _isLoading.postValue(true)
            }
    }

    fun deleteFacultad(toDelete: Facultad) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("ELIMAR", toDelete.toString())
            faculRepo.deleteFacultad(toDelete);
        }
    }
}