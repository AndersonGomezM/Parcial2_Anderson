package edu.ucne.parcial2_anderson.data.remote.repository

import edu.ucne.parcial2_anderson.data.remote.VerboApi
import edu.ucne.parcial2_anderson.data.remote.dto.VerboDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class VerboRepository @Inject constructor(
    private val verbo: VerboApi
) {
    suspend fun getListVerbos(): List<VerboDto> {
        try {
                val api = verbo.GetList()
                return api
        } catch (e: Exception) {
            throw e
        }
    }
}