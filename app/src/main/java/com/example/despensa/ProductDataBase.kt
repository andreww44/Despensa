package com.example.despensa

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Producto::class], version = 1)
abstract class ProductDataBase: RoomDatabase() {
    abstract fun productoDao(): ProductoDAO
}
