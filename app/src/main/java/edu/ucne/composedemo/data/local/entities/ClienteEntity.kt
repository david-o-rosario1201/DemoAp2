package edu.ucne.composedemo.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cliente")
data class ClienteEntity(
    @PrimaryKey(autoGenerate = true)
    val codigoCliente: Int? = null,
    val nombres: String = "",
    val empresa: String = "",
    val direccion: String = "",
    val telefono: String = "",
    val celular: String = "",
    val rnc: String = "",
    val tieneIguala: Boolean = false,
    val tipoComprobante: Int? = null


)