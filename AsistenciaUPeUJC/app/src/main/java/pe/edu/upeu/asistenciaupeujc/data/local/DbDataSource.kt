package pe.edu.upeu.asistenciaupeujc.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upeu.asistenciaupeujc.data.local.dao.ActividadDao
import pe.edu.upeu.asistenciaupeujc.data.local.dao.FacultadDao
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Facultad

@Database(entities = [Actividad::class, Facultad::class], version = 2)
abstract class DbDataSource:RoomDatabase() {
    abstract fun actividadDao():ActividadDao
    abstract fun facultadDao():FacultadDao

}