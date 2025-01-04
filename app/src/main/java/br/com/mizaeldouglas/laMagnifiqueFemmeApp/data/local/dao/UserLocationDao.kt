package br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.entity.UserLocation

@Dao // Anotação que define a interface como um DAO
interface UserLocationDao {
    @Query("SELECT * FROM userlocation") // Consulta para obter todas as localizações do usuário
    fun getAllUserLocations(): LiveData<List<UserLocation>> // Função para obter todas as localizações do usuário como LiveData

    @Query("SELECT * FROM userlocation WHERE id = :id") // Consulta para obter uma localização do usuário pelo ID
    fun getUserLocationById(id: Int): LiveData<UserLocation> // Função para obter uma localização do usuário pelo ID como LiveData

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Inserção de uma localização do usuário, substituindo se houver conflito
    suspend fun insertUserLocation(userLocation: UserLocation) // Função suspensa para inserir uma localização do usuário

    @Query("DELETE FROM userlocation WHERE id = :id") // Consulta para deletar uma localização do usuário pelo ID
    suspend fun deleteUserLocation(id: Int) // Função suspensa para deletar uma localização do usuário pelo ID

    @Query("DELETE FROM userlocation") // Consulta para deletar todas as localizações do usuário
    suspend fun deleteAllItems() // Função suspensa para deletar todas as localizações do usuário
}
