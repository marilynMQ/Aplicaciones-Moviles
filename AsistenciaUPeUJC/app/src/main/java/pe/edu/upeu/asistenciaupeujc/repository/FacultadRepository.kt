package pe.edu.upeu.asistenciaupeujc.repository

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.data.local.dao.FacultadDao
import pe.edu.upeu.asistenciaupeujc.data.remote.RestFacultad
import pe.edu.upeu.asistenciaupeujc.modelo.Facultad
import pe.edu.upeu.asistenciaupeujc.utils.TokenUtils
import javax.inject.Inject

interface FacultadRepository {
    suspend fun deleteFacultad(facultad: Facultad)
    fun reportarFacultades(): LiveData<List<Facultad>>

    fun buscarFacultadId(id: Long): LiveData<Facultad>

    suspend fun insertarFacultad(facultad: Facultad): Boolean

    suspend fun modificarRemoteFacultad(facultad: Facultad): Boolean
}

class FacultadRepositoryImp @Inject constructor(
    private val restFacultad: RestFacultad,
    private val facultadDao: FacultadDao
) : FacultadRepository {
    override suspend fun deleteFacultad(facultad: Facultad) {
        CoroutineScope(Dispatchers.IO).launch {
            restFacultad.deleteFacultad(TokenUtils.TOKEN_CONTENT, facultad.id)
        }
        facultadDao.eliminarFacultad(facultad)
    }

    override fun reportarFacultades(): LiveData<List<Facultad>> {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                delay(3000)
                val data = restFacultad.reportarFacultad(TokenUtils.TOKEN_CONTENT).body()!!
                facultadDao.insertarFacultades(data)
            }
        } catch (e: Exception) {
            Log.i("ERROR", "Error: ${e.message}")
        }
        return facultadDao.reportarFacultad()
    }

    override fun buscarFacultadId(id: Long): LiveData<Facultad> {
        return facultadDao.buscarFacultad(id)
    }

    override suspend fun insertarFacultad(facultad: Facultad): Boolean {
        return restFacultad.insertarFacultad(TokenUtils.TOKEN_CONTENT, facultad).body() != null
    }

    override suspend fun modificarRemoteFacultad(facultad: Facultad): Boolean {
        var dd: Boolean = false
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("VER", TokenUtils.TOKEN_CONTENT)
        }
        return restFacultad.actualizarFacultad(TokenUtils.TOKEN_CONTENT, facultad.id, facultad).body() != null
    }
}
