package edu.ucne.parcial2_anderson.ui.verbos_list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2_anderson.data.remote.dto.VerboDto
import edu.ucne.parcial2_anderson.data.remote.repository.VerboRepository
import javax.inject.Inject

data class VerboListUIState(
    val articulo: List<VerboDto> = emptyList(),
)

@HiltViewModel
class VerboListViewModel @Inject constructor(
    private val apiarticulo: VerboRepository
) : ViewModel() {

}