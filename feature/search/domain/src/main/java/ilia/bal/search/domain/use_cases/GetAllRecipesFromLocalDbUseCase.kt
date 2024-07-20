package ilia.bal.search.domain.use_cases

import ilia.bal.search.domain.repository.SearchRepository
import javax.inject.Inject

class GetAllRecipesFromLocalDbUseCase @Inject constructor(private val searchRepository: SearchRepository) {

    operator fun invoke() = searchRepository.getAllRecipes()
}