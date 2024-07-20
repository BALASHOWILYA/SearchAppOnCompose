package ilia.bal.search.data.repository

import ilia.bal.search.data.local.RecipeDao
import ilia.bal.search.data.mappers.toDomain
import ilia.bal.search.data.remote.SearchApiService
import ilia.bal.search.domain.model.Recipe
import ilia.bal.search.domain.model.RecipeDetails
import ilia.bal.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepoImpl(
    private val searchApiService: SearchApiService,
    private val recipeDao: RecipeDao
) : SearchRepository {
    override suspend fun getRecipes(s: String): Result<List<Recipe>> {
        return try {
            val response = searchApiService.getRecipes(s)
            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    Result.success(it.toDomain())
                } ?: run { Result.failure(Exception("error occurred")) }
            } else {
                Result.failure(Exception("error occurred"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun insertRecipe(recipe: Recipe) {
        recipeDao.insertRecipe(recipe)
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
       recipeDao.deleteRecipe(recipe)
    }

    override fun getAllRecipes(): Flow<List<Recipe>> {
       return recipeDao.getAllRecipes()
    }



    override suspend fun getRecipeDetails(id: String): Result<RecipeDetails> {
        return try {
            val response = searchApiService.getRecipeDetails(id)
            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    if (it.isNotEmpty()) {
                        Result.success(it.first().toDomain())
                    } else {
                        Result.failure(Exception("error occurred"))
                    }
                } ?: run {
                    Result.failure(Exception("error occurred"))
                }
            } else {
                Result.failure(Exception("error occurred"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }




}