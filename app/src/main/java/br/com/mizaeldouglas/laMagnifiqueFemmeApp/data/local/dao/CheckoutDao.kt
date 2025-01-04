package br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.entity.Checkout


@Dao // Anotação que define a interface como um DAO
interface CheckoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Inserção de um checkout, substituindo se houver conflito
    suspend fun insert(checkout: Checkout) // Função suspensa para inserir um checkout

    @Query("SELECT * FROM checkout") // Consulta para obter todos os checkouts
    fun getAllCheckouts(): LiveData<List<Checkout>> // Função para obter todos os checkouts como LiveData

    @Query("SELECT * FROM checkout ORDER BY checkout_date DESC LIMIT 1") // Consulta para obter o checkout mais recente
    fun getLatestCheckout(): LiveData<Checkout> // Função para obter o checkout mais recente como LiveData

    @Query("UPDATE checkout SET payment_method = :paymentMethod WHERE id = :id") // Consulta para atualizar o método de pagamento de um checkout
    suspend fun updatePaymentMethod(
        id: Int,
        paymentMethod: String
    ) // Função suspensa para atualizar o método de pagamento de um checkout

    @Query("DELETE FROM checkout") // Consulta para deletar todos os checkouts
    suspend fun deleteAllitems() // Função suspensa para deletar todos os checkouts
}
