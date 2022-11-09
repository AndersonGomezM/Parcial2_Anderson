package edu.ucne.parcial2_anderson.ui.verbos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2_anderson.data.remote.dto.VerboDto
import edu.ucne.parcial2_anderson.data.remote.repository.VerboRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VerboListUIState(
    val verbo: List<VerboDto> = emptyList(),
)

@HiltViewModel
class VerboListViewModel @Inject constructor(
    private val api: VerboRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(VerboListUIState())
    val uiState: StateFlow<VerboListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(verbo = api.getListVerbos())
            }
        }
    }
}