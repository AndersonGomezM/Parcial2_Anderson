package edu.ucne.parcial2_anderson.data.remote

import edu.ucne.parcial2_anderson.data.remote.dto.VerboDto
import retrofit2.Response
import retrofit2.http.*

interface VerboApi {
    @GET("/verbos")
    suspend fun GetList(): List<VerboDto>
}