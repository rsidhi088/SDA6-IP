import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Task {
    String project;
    String taskName;
    String date;
    String status;

    public Task(String project, String taskName, String date, String status) {
        this.project = project;
        this.taskName = taskName;
        this.date = date;
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return project+", "+taskName+", "+date+", "+status;
    }


}
