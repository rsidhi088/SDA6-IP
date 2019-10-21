import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

public class SaveFile {

    public SaveFile() throws IOException {

    }
    public void FileWrite(ArrayList<Task> tasklist) {
        try {
// Creating an object of a file
            File myObj = new File("D:Tasklistnew.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {

            FileWriter myWriter = new FileWriter("D:Tasklistnew.csv", true);
            // Writes this content into the specified file
            System.out.println("File write started");

            for (Task arr:tasklist) {
                myWriter.write(arr + System.lineSeparator());
                System.out.println(arr);
            }

            // Closing is necessary to retrieve the resources allocated

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}