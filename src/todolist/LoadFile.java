package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadFile
{

    ArrayList<Task> task;


    // Read the data from the csv file that is already saved

    public LoadFile()
    {

        task = readFromCSV("D:Tasklistnew.csv");
    }

    public void LoadFile() throws IOException
    {
        // Iterate over the entire file to list all the tasks saved

        for (Task load:task)
        {
            System.out.println(load);
        }
    }

    public ArrayList<Task> readFromCSV(String fileName)
    {
        ArrayList<Task> tasks = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII))
        {
            String line = br.readLine();

            while (line != null)
            {

                String[] attributes = line.split(",");
                Task tasktoLoad = createTask(attributes);
                tasks.add(tasktoLoad);
                line = br.readLine();
            }

        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tasks;
    }

    // Creates task by splitting every element of the array into seperate String

    private static Task createTask(String[] metadata)
    {
        String project = metadata[0];
        String taskName = metadata[1];
        String date = metadata[2];
        String status = metadata[3];

        return new Task(project, taskName, date, status);
    }

}
