package todolist;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;

public class Todo {

    String option;
    public ArrayList<Task> tasklist;

    public Todo() {
        option = new String();
        tasklist = new ArrayList<>();

    }

    public void readInput() {
          try {

            String option = null;
            Scanner input = new Scanner(System.in);

            System.out.println("Please Choose an option");
            System.out.println("(1) Add a task ");
            System.out.println("(2) Update a task ");
            System.out.println("(3) Edit a task ");
            System.out.println("(4) Remove a task");
            System.out.println("(5) List all tasks ");
            System.out.println("(6) List tasks based on Duedate and Project ");
            System.out.println("(0) Exit ");

            // To choose the function to be performed on the tasklist ie.. add,remove,update or list

            do {
                System.out.println("Enter your option below");
                System.out.println("");
                option = input.nextLine();

                switch (option) {
                    case "1":
                        System.out.println("Add a task ");
                        System.out.println("Enter the items to be added");
                        addTask();
                        break;
                    case "2":
                        System.out.println("Update a task");
                        System.out.println("Which task do you want to update?");
                        updateStatus();
                        System.out.println("");
                        break;
                    case "3":
                        System.out.println("Edit a task");
                        System.out.println("Which task do you want to edit?");
                        EditTask();
                        System.out.println("");
                        break;
                    case "4":
                        System.out.println("Remove a task");
                        System.out.println("Which task do you want to remove?");
                        removeTask();
                        System.out.println("");
                        break;
                    case "5":
                        System.out.println("List all tasks");
                        listTask();
                        System.out.println("");
                        break;
                    case "6":
                        System.out.println("List tasks based on project and due date ");
                        listSelect();
                        System.out.println("");
                        break;
                    case "0":
                        System.out.println("Exit ");
                        break;
                    default:
                        System.err.println("Invalid option selected");
                        continue;
                }

            }


            while (Integer.parseInt(option) > 0);
            SaveFile save = null;
            try {
                save = new SaveFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            save.FileWrite(tasklist);

        } catch (Exception e) {
            e.printStackTrace();
            readInput();

       }
    }

    public static void main(String[] args) {

        Todo todo = new Todo();
        todo.readInput();
    }

    // Method to add tasks into the task list one after the other

    public void addTask() {

        Scanner indata = new Scanner(System.in);
        System.out.println("ProjectName");
        String project = indata.nextLine();


        System.out.println("taskName");
        String taskName = indata.nextLine();

        System.out.println("Date");
        String date = indata.nextLine();
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            System.out.println(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Status");
        String status = indata.nextLine();


        Task taskToAdd = new Task(project, taskName, date, status);
        tasklist.add(taskToAdd);

    }

    //Method to list all the tasks available in the tasklist by the use of Iterators

    public void listTask() {
        File f = null;
        Boolean exist = false;

        try {
            f = new File("D:Tasklistnew.csv");
            exist = f.exists();

            if (exist == true) {
                LoadFile load = new LoadFile();
                load.LoadFile();
                tasklist.stream().forEach(elementInList -> System.out.println(elementInList));
            } else {
                tasklist.stream().forEach(elementInList -> System.out.println(elementInList));

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    //Method to update the tasklist.

    public void updateStatus() {
        try {

            Scanner Udata = new Scanner(System.in);
            String searchString = Udata.nextLine();
            ListIterator iterator = tasklist.listIterator();
            System.out.println("Enter the status you want to update");
            Scanner Ndata = new Scanner(System.in);
            String C = Ndata.nextLine();


            //This loop is used to change the status based on Taskname

            while (iterator.hasNext()) {
                Task t = (Task) iterator.next();
                if (t.taskName.equals(searchString)) {
                    t.setStatus(C);
                    System.out.println("Status has been marked as " + C);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void EditTask()
    {
        Scanner Edata = new Scanner(System.in);
        String searchString = Edata.nextLine();
        System.out.println("Enter the field you want to edit");
        Scanner edata = new Scanner(System.in);
        String C = edata.nextLine();
        System.out.println("Enter the new value");
        Scanner Newdata = new Scanner(System.in);
        String D = Edata.nextLine();

        //This loop is used to edit the task details based on Project name
        List<Object> list;
        ListIterator iterator = tasklist.listIterator();

        while (iterator.hasNext())
        {
            Task t = (Task) iterator.next();
            if (t.project.equals(searchString))
            {
                if(t.taskName.equals(C))
                {
                    t.setTaskName(D);
                    System.out.println("Task has been changed to " + D + " from " +C);
                }
                else if(t.date.equals(C))
                {
                    t.setDate(D);
                    System.out.println("Date has been changed to " + D + " from " +C);
                }
            }
        }
    }

    //Method to remove the task from the tasklist

    public void removeTask()
    {
        try
        {
            LoadFile load = new LoadFile();
            load.LoadFile();

            Scanner Udata = new Scanner(System.in);
            String removeString = Udata.nextLine();

            Iterator<Task> it = tasklist.iterator();

            while (it.hasNext())
            {
                Task t = it.next();
                String taskToRemove = t.getTaskName();
                String projectToRemove = t.getProject();

                if (taskToRemove.equals(removeString))
                {
                    it.remove();
                    System.out.println("Task Removed success");
                }

                if (projectToRemove.equals(removeString))
                {
                    it.remove();
                    System.out.println("Project Removed success");
                }


            }

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Method to list the tasks based on project and duedate

    public void listSelect()
    {

        Scanner Ldata = new Scanner(System.in);
        String listString = Ldata.nextLine();

        Iterator<Task> t = tasklist.iterator();

        while (t.hasNext())
        {
            Task taskToList = t.next();

            String projectToList = taskToList.getProject();
            String dateToList = taskToList.getDate();


            if (projectToList.equalsIgnoreCase(listString))
            {

                System.out.println(taskToList);
            }

            else if (dateToList.equalsIgnoreCase(listString))
            {

                System.out.println(taskToList);
            }
        }

        System.out.println("Invalid entry");

    }

}


