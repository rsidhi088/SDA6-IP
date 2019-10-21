import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadFile {

    ArrayList<Task> task;

    public LoadFile()  {

        task = readFromCSV("D:Tasklistnew.csv");
    }

    public void LoadFile() throws IOException {

        for (Task load:task){
            System.out.println(load);
        }
    }

    public ArrayList<Task> readFromCSV(String fileName)  {
        ArrayList<Task> tasks = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();


            // loop until all lines are read
            while (line != null) {

                String[] attributes = line.split(",");
                Task tasktoLoad = createTask(attributes);
                tasks.add(tasktoLoad);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tasks;
    }



    private static Task createTask(String[] metadata) {
        String project = metadata[0];
        String taskName = metadata[1];
        String date = metadata[2];
        String status = metadata[3];

        // create and return book of this metadata
        return new Task(project, taskName, date, status);
    }

}
