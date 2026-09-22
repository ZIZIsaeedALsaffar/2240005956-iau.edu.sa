package edu.iau.cshj.csc402.csc402lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.csc402lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.csc402lab2.ui.theme.Navy
import edu.iau.cshj.csc402.csc402lab2.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TaskTrackerScreen(modifier: Modifier = Modifier) {
    val tasks = remember {
        mutableStateListOf(
            TeamTask(1, "Create GitHub repository", "Fatimah", isDone = true),
            TeamTask(2, "Write project proposal", "Omar", isDone = true),
            TeamTask(3, "Design the login screen", "Noura", isDone = false),
            TeamTask(4, "Set up Android Studio", "Yousef", isDone = false)
        )
    }

    val doneCount = tasks.count { it.isDone }
    val openCount = tasks.count { !it.isDone }
    val totalCount = tasks.size

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(vertical = 16.dp, horizontal = 20.dp)
        ) {
            Text(
                text = "Team Task Tracker",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Task 11 - Challenge",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Navy),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SummaryStat(count = doneCount, label = "Done")
                SummaryStat(count = openCount, label = "Open")
                SummaryStat(count = totalCount, label = "Total")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(tasks, key = { _, task -> task.id }) { index, task ->
                TaskRow(
                    task = task,
                    onToggle = {
                        tasks[index] = task.copy(isDone = !task.isDone)
                    }
                )
            }
        }

        Button(
            onClick = {
                val nextId = (tasks.maxOfOrNull { it.id } ?: 0) + 1
                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "Noura Al-Harbi" // Change to your name
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .height(48.dp)
        ) {
            Text(
                text = "+ Add task",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SummaryStat(count: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            color = Color.LightGray,
            fontSize = 11.sp
        )
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { onToggle() },
                colors = CheckboxDefaults.colors(
                    checkedColor = AndroidGreen,
                    uncheckedColor = Color.Gray
                )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = task.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (task.isDone) Color.Gray else Color.Black,
                    textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                )
                Text(
                    text = task.owner,
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskTrackerScreenPreview() {
    TaskTrackerScreen()
}