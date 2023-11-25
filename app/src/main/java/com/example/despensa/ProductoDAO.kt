package com.example.despensa
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.despensa.Producto

@Dao
interface ProductoDAO {
    @Insert
    suspend fun insertarTienda(tienda: Producto)

    @Query("SELECT * FROM Producto")
    suspend fun obtenerTodasLasTiendas(): List<Producto>
}