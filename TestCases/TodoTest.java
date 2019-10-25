import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import todolist.*;

public class TodoTest
{

    Todo tasks = new Todo();

    @Before

    public void addTask()
    {

        int length = tasks.tasklist.size();
        String project = "IP";
        String taskName = "coding";
        String date = "12/2/2010";
        String status = "Complete";
        Task taskToAdd = new Task(project, taskName, date, status);
        assertEquals(1, length + 1);
    }

    @Test

    public void updateStatus()
    {
        Task task = new Task("", "", "", "");
        String searchString = "Coding";
        String C = "Inprogress";
        if (tasks.equals(searchString)) {
            task.setStatus(C);
        }
        assertEquals("Inprogress", "Inprogress");
    }

    @Test

    public void editTask()
    {
        Task task = new Task("", "", "", "");
        String C = "IP";
        String D = "Coding";
        String E = "Testing";
        if (task.project.equals(C))
        {
            if (task.taskName.equals(C))
            {
                task.setTaskName(D);
            }

            assertEquals("Testing", "Testing");

        }
    }
}
