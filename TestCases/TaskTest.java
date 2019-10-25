import org.junit.Test;
import todolist.*;

import static org.junit.Assert.*;

public class TaskTest
{

    @Test
    public void getProject()
    {
        Task task = new Task("IP","coding","1/1/2010","complete");
        task.getProject();
        assertEquals("IP","IP");
    }

    @Test
    public void setProject()
    {
        Task task=new Task("","","","");
        String C = "OP";
        task.setProject(C);
        assertEquals("OP","OP");

    }
}