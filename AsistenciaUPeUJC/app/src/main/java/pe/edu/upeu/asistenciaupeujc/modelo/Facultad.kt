package pe.edu.upeu.asistenciaupeujc.modelo

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "facultad")
data class Facultad(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var nombrefac: String,
    var estado: String,
    var iniciales: String
)


data class FacultadReport(
    var id: Long,
    var nombrefac: String,
    var estado: String,
    var iniciales: String
)
