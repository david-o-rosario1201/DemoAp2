package edu.ucne.composedemo.presentation.meta

sealed interface TicketMetaUiEvent {
    data class SelectedTicketMeta(val idTicket: Int): TicketMetaUiEvent
    data class Save(val idTicket: Int): TicketMetaUiEvent
    data object Delete: TicketMetaUiEvent
}