package edu.ucne.composedemo.data.repository

import edu.ucne.composedemo.data.remote.RemoteDataSource
import edu.ucne.composedemo.data.remote.Resource
import edu.ucne.composedemo.data.remote.dto.TicketMetaDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class TicketMetaRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    fun getMetasUsuario(idUsuario: Int): Flow<Resource<List<TicketMetaDto>>> = flow {
        try{
            emit(Resource.Loading())
            val metasUsuario = remoteDataSource.getMetasUsuario(idUsuario)

            emit(Resource.Success(metasUsuario))
        } catch (e: HttpException){
            emit(Resource.Error("Error de internet: ${e.message()}"))
        } catch (e: Exception){
            emit(Resource.Error("Error desconocido: ${e.message}"))
        }
    }

    suspend fun addTicketMeta(ticketMetaDto: TicketMetaDto) = remoteDataSource.addTicketMeta(ticketMetaDto)

    suspend fun deleteTicketMeta(idDetalle: Int) = remoteDataSource.deleteTicketMeta(idDetalle)
}