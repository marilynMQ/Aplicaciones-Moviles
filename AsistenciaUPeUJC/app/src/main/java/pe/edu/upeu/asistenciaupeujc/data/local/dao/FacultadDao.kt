package pe.edu.upeu.asistenciaupeujc.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Facultad

@Dao
interface FacultadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarFacultad(facultad: Facultad)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarFacultades(facultad: List<Facultad>)

    @Update
    suspend fun modificarFacultad(facultad: Facultad)

    @Delete
    suspend fun eliminarFacultad(facultad: Facultad)

    @Query("select * from facultad")
    fun reportarFacultad():LiveData<List<Facultad>>

    @Query("select * from facultad where id=:idx")
    fun buscarFacultad(idx: Long):LiveData<Facultad>

}