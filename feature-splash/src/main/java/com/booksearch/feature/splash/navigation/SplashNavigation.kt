import com.booksearch.core.common.NavigationDestination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.booksearch.feature.splash.SplashRoute

object SplashDestination : NavigationDestination {
    override val route = "splash_route"
    override val destination = "splash_destination"
}

fun NavGraphBuilder.splashGraph(navigateBookSearch: () -> Unit) {
    composable(route = SplashDestination.route) {
        SplashRoute(navigateBookSearch = navigateBookSearch)
    }
}
