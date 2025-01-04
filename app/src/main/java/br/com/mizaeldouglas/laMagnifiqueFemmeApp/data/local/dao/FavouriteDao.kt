package br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.entity.Favourite

@Dao // Anotação que define a interface como um DAO
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Inserção de um favorito, substituindo se houver conflito
    suspend fun insert(favorite: Favourite) // Função suspensa para inserir um favorito

    @Query("SELECT * FROM favourite ORDER BY id DESC") // Consulta para obter todos os favoritos ordenados por ID em ordem decrescente
    fun getAllFavourites(): LiveData<List<Favourite>> // Função para obter todos os favoritos como LiveData

    @Query("DELETE FROM favourite WHERE id = :id") // Consulta para deletar um favorito pelo ID
    suspend fun deleteById(id: Int) // Função suspensa para deletar um favorito pelo ID

    @Query("SELECT EXISTS (SELECT 1 FROM favourite WHERE product_id = :productId)") // Consulta para verificar se um produto está favoritado
    fun isProductFavorited(productId: Int): LiveData<Boolean> // Função para verificar se um produto está favoritado como LiveData

    @Query("DELETE FROM favourite") // Consulta para deletar todos os favoritos
    suspend fun deleteAllItems() // Função suspensa para deletar todos os favoritos
}
