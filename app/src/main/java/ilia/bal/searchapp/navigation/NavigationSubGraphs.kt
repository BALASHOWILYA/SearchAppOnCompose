package ilia.bal.searchapp.navigation

import ilia.bal.media_player.navigation.MediaPlayerFeatureAPi
import ilia.bal.search.navigation.SearchFeatureApi

data class NavigationSubGraphs(
    val searchFeatureApi: SearchFeatureApi,
    val mediaPlayerApi:MediaPlayerFeatureAPi
)
