import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> listOfEachLine = new ArrayList<>();

        try {
            File myObj = new File("input1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // add each line to my list
                listOfEachLine.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Check if the file exists!");
            e.printStackTrace();
        }

        // Create a list of the object Schedule Employee
        List<ScheduleEmployee> scheduleEmployeeList = new ArrayList<>();
        // scheduleEmployeeList.add(new ScheduleEmployee("Carla", "10-12"));

        for (String line : listOfEachLine){
            String[] nameAndSchedule = line.split("="); // split returns an array
            String name = nameAndSchedule[0];
            String schedule = nameAndSchedule[1];
            ScheduleEmployee scheduleEmployee = new ScheduleEmployee(name, schedule); // Create a new object each loop
            scheduleEmployeeList.add(scheduleEmployee); // Add Object to the Schedule Employee List
        }

        for(ScheduleEmployee scheduleEmployee: scheduleEmployeeList){ // Verify functionality of Schedule Employee List
            System.out.println(scheduleEmployee.getName());
            System.out.println(scheduleEmployee.getSchedule());
        }
    }
}
