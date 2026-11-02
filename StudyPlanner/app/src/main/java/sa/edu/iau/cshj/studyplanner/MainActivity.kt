package sa.edu.iau.cshj.studyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme
import sa.edu.iau.cshj.studyplanner.StudyPlannerApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            StudyPlannerTheme {
                StudyPlannerApp()
            }
        }
    }
}
