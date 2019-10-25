package todolist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFile
{

    public SaveFile() throws IOException
    {

    }
    public void FileWrite(ArrayList<Task> tasklist)
    {

        // Creates the file to which the data has to be saved

        try
        {
            File myObj = new File("D:Tasklistnew.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try
        {
            // Writes the contents into the specified file

            FileWriter myWriter = new FileWriter("D:Tasklistnew.csv", true);

            System.out.println("File write started");

            for (Task arr:tasklist)
            {
                myWriter.write(arr + System.lineSeparator());
                System.out.println(arr);
            }

            // Closing is necessary to retrieve the resources allocated

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}