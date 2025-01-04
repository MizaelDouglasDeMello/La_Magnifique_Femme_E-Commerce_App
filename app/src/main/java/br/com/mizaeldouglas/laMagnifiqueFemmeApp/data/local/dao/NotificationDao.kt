package br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mizaeldouglas.laMagnifiqueFemmeApp.data.local.entity.Notification

@Dao // Anotação que define a interface como um DAO
interface NotificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Inserção de uma notificação, substituindo se houver conflito
    suspend fun insert(notification: Notification) // Função suspensa para inserir uma notificação

    @Query("SELECT * FROM notification ORDER BY id DESC") // Consulta para obter todas as notificações ordenadas por ID em ordem decrescente
    fun getAllNotifications(): LiveData<List<Notification>> // Função para obter todas as notificações como LiveData

    @Query("UPDATE notification SET isRead = 1 WHERE id = :notificationId") // Consulta para marcar uma notificação como lida
    suspend fun markAsRead(notificationId: Int) // Função suspensa para marcar uma notificação como lida

    @Query("DELETE FROM notification") // Consulta para deletar todas as notificações
    suspend fun deleteAllNotifications() // Função suspensa para deletar todas as notificações

    @Query("SELECT COUNT(*) FROM notification WHERE isRead = 0") // Consulta para obter a contagem de notificações não lidas
    fun getUnreadNotificationCount(): LiveData<Int> // Função para obter a contagem de notificações não lidas como LiveData
}
