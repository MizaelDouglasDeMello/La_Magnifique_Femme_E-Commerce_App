package br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.entity.Order

@Dao // Anotação que define a interface como um DAO
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Inserção de um pedido, substituindo se houver conflito
    suspend fun insert(order: Order) // Função suspensa para inserir um pedido

    @Query("SELECT * FROM `order` ORDER BY order_date DESC") // Consulta para obter todos os pedidos ordenados pela data do pedido em ordem decrescente
    fun getAllOrders(): LiveData<List<Order>> // Função para obter todos os pedidos como LiveData

    @Query("SELECT * FROM `order` ORDER BY order_date DESC LIMIT 1") // Consulta para obter o pedido mais recente
    fun getLatestOrder(): LiveData<Order> // Função para obter o pedido mais recente como LiveData

    @Query("DELETE FROM `order` WHERE id = :orderId") // Consulta para deletar um pedido pelo ID
    suspend fun deleteOrderById(orderId: Int) // Função suspensa para deletar um pedido pelo ID

    @Query("DELETE FROM `order`") // Consulta para deletar todos os pedidos
    suspend fun deleteAllOrders() // Função suspensa para deletar todos os pedidos
}
