import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.easytask.model.Task
import br.com.fiap.easytask.model.TaskViewModel

@Composable
fun TaskItem(task: Task, navController: NavController, taskViewModel: TaskViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("updateTask/${task.id}") }
            .padding(8.dp)
    ) {
        Text(text = task.title)
        Text(text = task.description)
        Text(text = "Due: ${task.dueDate}")
        Text(text = "Status: ${task.status}")

        Button(onClick = { taskViewModel.deleteTask(task.id) }) {
            Text("Delete")
        }
    }
}
