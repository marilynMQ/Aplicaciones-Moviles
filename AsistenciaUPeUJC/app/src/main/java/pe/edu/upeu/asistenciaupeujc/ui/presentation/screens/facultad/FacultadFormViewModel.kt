package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.facultad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Facultad
import pe.edu.upeu.asistenciaupeujc.repository.FacultadRepository
import javax.inject.Inject

@HiltViewModel
class FacultadFormViewModel @Inject constructor(
    private val faculRepo: FacultadRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    fun getFacultad(idX: Long): LiveData<Facultad> {
        return faculRepo.buscarFacultadId(idX)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading


    fun addFacultad(facultad: Facultad){
        viewModelScope.launch (Dispatchers.IO){
            Log.i("REAL", facultad.toString())
            faculRepo.insertarFacultad(facultad)
        }
    }
    fun editFacultad(facultad: Facultad){
        viewModelScope.launch(Dispatchers.IO){
            faculRepo.modificarRemoteFacultad(facultad)
        }
    }
}