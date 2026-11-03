package sa.edu.iau.cshj.lab05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sa.edu.iau.cshj.lab05.ui.CourseDetailRoute
import sa.edu.iau.cshj.lab05.ui.CourseListRoute
import sa.edu.iau.cshj.lab05.ui.HomeRoute
import sa.edu.iau.cshj.lab05.ui.theme.Lab05CoursesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lab05CoursesTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeRoute(
                            onCoursesClick = {
                                navController.navigate("courses")
                            }
                        )
                    }

                    composable("courses") {
                        CourseListRoute(
                            onCourseClick = { code ->
                                navController.navigate("detail/$code")
                            }
                        )
                    }

                    composable("detail/{code}") { backStackEntry ->
                        val code = backStackEntry.arguments?.getString("code") ?: ""

                        CourseDetailRoute(
                            code = code,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}