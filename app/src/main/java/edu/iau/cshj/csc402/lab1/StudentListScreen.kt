package edu.iau.cshj.csc402.lab1

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.iau.cshj.csc402.lab1.ui.theme.CSC402Lab3Theme

val sampleStudents = listOf(
    Student("Zainab Alsaffar", "Computer Science", "5.0", "2240005956@iau.edu.sa", "Jubail"),
    Student("Ahmed Al-Qahtani", "Cybersecurity", "4.82", "2220001234@iau.edu.sa", "Khobar"),
    Student("Fatimah Al-Hassan", "Artificial Intelligence", "4.95", "2230009876@iau.edu.sa", "Dammam"),
    Student("Sara Al-Dosari", "Information Technology", "4.65", "2210004321@iau.edu.sa", "Jubail"),
    Student("Mohammed Al-Ghamdi", "Computer Science", "4.75", "2200008765@iau.edu.sa", "Dhahran")
)

@Composable
fun StudentListScreen(
    students: List<Student> = sampleStudents,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Students Directory",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${students.size} Total",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(students) { student ->
                    StudentCard(student = student)
                }
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StudentListScreenPreview() {
    CSC402Lab3Theme {
        StudentListScreen()
    }
}