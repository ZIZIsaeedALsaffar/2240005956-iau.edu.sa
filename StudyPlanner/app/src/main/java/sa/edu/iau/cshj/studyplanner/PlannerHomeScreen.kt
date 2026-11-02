package sa.edu.iau.cshj.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val studentName: String = "Zainab",
    val totalTasks: Int = 0,
    val completedTasks: Int = 0,
    val tasks: List<String> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Hello, ${uiState.studentName}!",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Keep track of your study progress.")

        Text("Total tasks: ${uiState.totalTasks}")

        Text(
            text = "Progress: ${uiState.completedTasks} " +
                    "of ${uiState.totalTasks} done"
        )

        Button(
            onClick = onCompleteTask,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text("Complete a study task")
        }

        Text(
            text = "My Study Tasks",
            style = MaterialTheme.typography.titleLarge
        )

        uiState.tasks.forEach { task ->
            Button(
                onClick = { onTaskClick(task) }
            ) {
                Text(task)
            }
        }
    }
}

@Preview(showBackground = true, name = "No tasks completed")
@Composable
private fun PlannerHomePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                studentName = "Zainab",
                totalTasks = 7,
                completedTasks = 0,
                tasks = listOf(
                    "Complete Lab 5",
                    "Study for CSC 402",
                    "Prepare Project Report"
                )
            ),
            onCompleteTask = {},
            onTaskClick = {}
        )
    }
}

@Preview(showBackground = true, name = "All tasks completed")
@Composable
private fun PlannerHomeCompletedPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                studentName = "Zainab",
                totalTasks = 7,
                completedTasks = 7,
                tasks = listOf(
                    "Complete Lab 5",
                    "Study for CSC 402",
                    "Prepare Project Report"
                )
            ),
            onCompleteTask = {},
            onTaskClick = {}
        )
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                studentName = "Zainab",
                totalTasks = 7,
                completedTasks = 0,
                tasks = listOf(
                    "Complete Lab 5",
                    "Study for CSC 402",
                    "Prepare Project Report",
                    "Review Lecture 1",
                    "Practice Kotlin",
                    "Finish Assignment",
                    "Prepare for Quiz"
                )
            )
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onCompleteTask = {
            if (uiState.completedTasks < uiState.totalTasks) {
                uiState = uiState.copy(
                    completedTasks = uiState.completedTasks + 1
                )
            }
        },
        onTaskClick = onTaskClick
    )
}
