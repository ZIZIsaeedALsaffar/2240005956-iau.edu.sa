package edu.iau.cshj.csc402.csc402lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.csc402lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.csc402lab2.ui.theme.Navy
import edu.iau.cshj.csc402.csc402lab2.ui.theme.ScreenBackground

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {
    val courses = remember {
        listOf(
            Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
            Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
            Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
            Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
            Course("ENG 214", "Technical Writing", 3, "Tue"),
            Course("PHYS 105", "General Physics II", 4, "Sun / Tue"),
            Course("ISLM 101", "Islamic Culture", 2, "Thu")
        )
    }

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
                text = "My Courses",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Task 10 - LazyColumn & data class",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(courses) { course ->
                CourseRow(course = course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(AndroidGreen)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = course.code,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = course.title,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = course.days,
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            }

            Surface(
                color = AndroidGreen.copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "${course.credits} cr",
                    color = Color(0xFF1B5E20),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}