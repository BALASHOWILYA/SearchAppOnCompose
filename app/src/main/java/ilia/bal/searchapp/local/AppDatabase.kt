package ilia.bal.searchapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ilia.bal.search.data.local.RecipeDao
import ilia.bal.search.domain.model.Recipe

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "recipe_app_db")
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun getRecipeDao():RecipeDao

}





