package edu.iau.cshj.csc402.csc402lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import edu.iau.cshj.csc402.csc402lab2.ui.theme.CSC402Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSC402Lab2Theme {
                StudentIdScreen()
                GreetingCard()
                CourseListScreen()
                TaskTrackerScreen()
            }
        }
    }
}