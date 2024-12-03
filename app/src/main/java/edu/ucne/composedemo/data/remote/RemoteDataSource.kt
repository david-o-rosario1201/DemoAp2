package edu.ucne.composedemo.data.remote

import edu.ucne.composedemo.data.remote.dto.GastoRecurenciaDto
import edu.ucne.composedemo.data.remote.dto.SistemaDto
import edu.ucne.composedemo.data.remote.dto.TicketDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val ticketingApi: TicketingApi

) {
    suspend fun getSistemas() = ticketingApi.getSistemas()

    suspend fun updateSistemas(sistemaDto: SistemaDto) = ticketingApi.updateSistema(sistemaDto)

    suspend fun getCliente(id: Double?) = ticketingApi.getClientes()
    suspend fun getClientes() = ticketingApi.getClientes()

    suspend fun getEquiposAnyDesks() = ticketingApi.getEquiposAnyDesks()

    suspend fun getAnydeskLog(id: Int) = ticketingApi.getAnyDeskLogs(id)

    suspend fun getGastos() = ticketingApi.getGastos()

    suspend fun getCobros() = ticketingApi.getCobro()

    suspend fun getTiposSoportes() = ticketingApi.getTiposSoportes()

    suspend fun getSuplidoresGastos() = ticketingApi.getSuplidoresGastos()
    suspend fun getSuplidorGastos(id: Int) = ticketingApi.getSuplidorGasto(id)

    suspend fun getCxc(idCliente: Int) = ticketingApi.getCxc(idCliente)


    suspend fun getTickets() = ticketingApi.getTickets()
    suspend fun saveTicket(ticketDto: TicketDto) = ticketingApi.saveTicket(ticketDto)
    suspend fun getTicket(idTicket: Double) = ticketingApi.getTicket(idTicket)

    suspend fun getGastosRecurencias() = ticketingApi.getGastosRecurencias()
    suspend fun createGastoRecurencia(gastosRecurenciaDto: GastoRecurenciaDto) = ticketingApi.createGastoRecurencia(gastosRecurenciaDto)
    suspend fun deleteGastoRecurencia(id: Int) = ticketingApi.deleteGastosRecurencia(id)
}