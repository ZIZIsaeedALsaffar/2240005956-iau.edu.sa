
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
    val studentName: String = "Student",
    val totalTasks: Int = 0,
    val completedTasks: Int = 0
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
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
    }
}

@Preview(showBackground = true, name = "No tasks completed")
@Composable
private fun PlannerHomePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                studentName = "Student",
                totalTasks = 7,
                completedTasks = 0
            ),
            onCompleteTask = {}
        )
    }
}

@Preview(showBackground = true, name = "All tasks completed")
@Composable
private fun PlannerHomeCompletedPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                studentName = "Student",
                totalTasks = 7,
                completedTasks = 7
            ),
            onCompleteTask = {}
        )
    }
}

@Composable
fun PlannerHomeRoute() {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                studentName = "Student",
                totalTasks = 7,
                completedTasks = 0
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
        }
    )
}
