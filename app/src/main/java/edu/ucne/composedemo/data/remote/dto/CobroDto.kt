package edu.ucne.composedemo.data.remote.dto

import java.sql.Date

data class CobroDto(
     val idCobro: Int,
     val fecha:Date,
     val codigoCliente: Int,
     val monto:Int,
     val observaciones: String

 )