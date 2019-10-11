import java.util.*;

public class Todo {

    String option;
    private ArrayList<String> tasklist;

    public Todo() {
        option = new String();
        tasklist = new ArrayList<String>();

    }

    public void readInput() {
        String option = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Please Choose an option");
        System.out.println("(1) Add a task ");
        System.out.println("(2) Update a task ");
        System.out.println("(3) Remove a task ");
        System.out.println("(4) List all tasks ");
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
                    AddTask();
                    System.out.println("Control is here");
                    break;
                case "2":
                    System.out.println("Update a task");
                    System.out.println("Which task do you want to update?");
                    updateTask();
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("Remove a task");
                    System.out.println("Which task do you want to remove?");
                    removeTask();
                    System.out.println("");
                    break;
                case "4":
                    System.out.println("List all tasks");
                    ListTask();
                    System.out.println("");
                    break;
                default:
            }
        }
        while (Integer.parseInt(option) > 0);
        System.out.println("Exit");
        // TODO IMPLEMENTATION FOR FOR INVALID OPTIONS AND TO HANDLE EXCEPTIONS

    }


    public static void main(String[] args) {

        Todo todo = new Todo();
        todo.readInput();

    }

    // Method to add tasks into the task list one after the other
    public void AddTask() {

        Scanner indata = new Scanner(System.in);
        System.out.println("ProjectName");
        String projectName = indata.next();
        tasklist.add(projectName);
        System.out.println("taskName");
        String taskName = indata.next();
        tasklist.add(taskName);
        System.out.println("Date");
        String date = indata.next();
        tasklist.add(date);
        System.out.println("Status");
        String status = indata.next();
        tasklist.add(status);

        Task taskToAdd = new Task(projectName, taskName, date, status);

    }

    // Method to list all the tasks available in the tasklist by the use of Iterators

    public void ListTask() {

        List<Object> list;
        ListIterator iterator = tasklist.listIterator();

        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        // Todo Implementation for printing the list one below the other

    }
    //Method to update the tasklist.

    public void updateTask() {
        Scanner Udata = new Scanner(System.in);

        String searchString = Udata.nextLine();

        for (String string : tasklist) {
            if (string.contains(searchString)) {
                for (int i = 0; i < tasklist.size(); ++i) {
                    if (tasklist.get(i).contains(searchString)) {
                        System.out.println("Enter the value to update");
                        Scanner Ndata = new Scanner(System.in);
                        String C = Ndata.nextLine();
                        String newvalue = C;
                        tasklist.set(i, C);
                    }
                }
            }
        }
    }

    //Method to remove the task from the tasklist

    public void removeTask() {

        Scanner Udata = new Scanner(System.in);
        String removeString = Udata.nextLine();

        if (tasklist.contains(removeString)) {
            System.out.println("Removed" + removeString);
            tasklist.remove(removeString);
            System.out.println("Remove success");
            //Todo implementation to remove the entire string of task
        }
    }

    //Method to list the tasks based on project,status and duedate

    public void listSelect(){

        Scanner Ldata = new Scanner(System.in);
        String listString = Ldata.nextLine();
        //Todo Implementation

    }

}
