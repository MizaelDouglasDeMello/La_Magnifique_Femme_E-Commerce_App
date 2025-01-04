package br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.entity.Cart

@Dao // Anotação que define a interface como um DAO
interface CartDao {
    @Query("SELECT * FROM cart WHERE product_id = :productId LIMIT 1") // Consulta para obter um item do carrinho pelo ID do produto
    suspend fun getCartItemByProductId(productId: Int): Cart? // Função suspensa para obter um item do carrinho pelo ID do produto

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Inserção de um item no carrinho, substituindo se houver conflito
    suspend fun insert(cart: Cart) // Função suspensa para inserir um item no carrinho

    @Query("SELECT * FROM cart ORDER BY id DESC") // Consulta para obter todos os itens do carrinho ordenados por ID em ordem decrescente
    fun getAllCart(): LiveData<List<Cart>> // Função para obter todos os itens do carrinho como LiveData

    @Query("UPDATE cart SET product_quantity = :quantity WHERE id = :cartId") // Consulta para atualizar a quantidade de um item no carrinho
    suspend fun updateQuantity(
        cartId: Int,
        quantity: Int
    ) // Função suspensa para atualizar a quantidade de um item no carrinho

    @Query("DELETE FROM cart WHERE id = :id") // Consulta para deletar um item do carrinho pelo ID
    suspend fun deleteById(id: Int) // Função suspensa para deletar um item do carrinho pelo ID

    @Query("DELETE FROM cart") // Consulta para deletar todos os itens do carrinho
    suspend fun deleteAllItems() // Função suspensa para deletar todos os itens do carrinho
}
