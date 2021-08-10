

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 *This class is the class that allows a user to change information of the projects,view information of the projects and add new projects for
 * Date:2021-05-13
 * @author collin matanda
 * @version 1.0
 *
 *
 */


public class FinaliseProject {

    /**
     *  This method will be used to get information of a person from the user(this information is values of the person class attributes)
     * @param persontype A string containing the the type of person (Customer,Architect,Customer)
     * @return The string values of the person attributes
     */
    public static person getperson(String persontype) {

        boolean correct_id=true;

        String Id_num;

        String new_Id = null;

        //The while loop will be used to check if the id number of the person class is correct
        while(correct_id){

            int id_int;

            try {
                Scanner userinput = new Scanner(System.in);

                System.out.println(persontype);

                System.out.println("\nPlease enter a  ID number : ");

                 Id_num = userinput.nextLine();

                 id_int= Integer.parseInt(Id_num);

                 //the if statement will only be executed if the id number is a positive number
                 if (id_int>0){

                     new_Id= String.valueOf(id_int);

                     correct_id=false;

                 }

                 else{
                     System.out.print("\nID number can not be less than one ");
                 }
            }
            catch (Exception e){

                System.out.print("\nInvalid ID, please try again ");
            }
        }

        Scanner userinput = new Scanner(System.in);

        System.out.println("\nPlease enter a  name : ");

        String name = userinput.nextLine();

        userinput = new Scanner(System.in);

        System.out.println("\nPlease enter a email Address: ");

        String emailaddress = userinput.nextLine();

        userinput = new Scanner(System.in);

        System.out.println("\nPlease enter a phone numbers : ");

        String telnumber = userinput.nextLine();

        userinput = new Scanner(System.in);

        System.out.println("\nPlease enter a Address : ");

        String Address = userinput.nextLine();

        return new person(new_Id,name, emailaddress,telnumber, Address);


    }


    /**
     *  This method will be used to get information of the project from the user(this information is values of the Project class attributes)
     */
    public static void getProject() {
        Scanner userinput = new Scanner(System.in);

        int numberproject = 0;

        int erfnumber = 0;

        double totalfee = 0.0;

        double totalamount = 0.0;

        boolean correctprojectnumber = true;

        boolean correctErfnumber = true;

        boolean correctTotalfee = true;

        boolean correctTotalamount = true;

        boolean Correctdateformat = true;

        String Deadline = "";


        person customer = getperson(" \nPlease enter your details:");

        person architect = getperson("\nPlease enter the Architect's details:");

        person contractor = getperson("\nPlease enter the contractor's details:");

        System.out.println("\nPlease enter the project's details");

        //This while loop will keep asking the user to enter project number once the user enters a correct input the while loop will stop
        //the try and catch will be used to display a message if the user doesn't enter a  integer number
        while (correctprojectnumber) {

            try {

                System.out.println("\nPlease enter the number of the project: ");

                numberproject = Integer.parseInt(userinput.nextLine());

                //the if statement will only be executed if the project number is a positive number
                if (numberproject>0){

                    correctprojectnumber = false;
                }

                else{
                    System.out.print("\nID can not be less than 1, Please try again: ");
                }

            } catch (Exception e) {

                System.out.println(("\nInvalid input,please try again:"));
            }
        }

        userinput = new Scanner(System.in);

        System.out.println("\nPlease enter the name of the project: ");

        String nameproject = userinput.nextLine();

        userinput = new Scanner(System.in);

        System.out.println("\n Please enter the address of the project: ");

        String addressproject = userinput.nextLine();

        //This while loop will keep asking the user to enter erf number once the user enters a correct input the while loop will stop
        //the try and catch will be used to display a message if the user doesn't enter a  integer number
        while (correctErfnumber) {

            try {

                userinput = new Scanner(System.in);

                System.out.println("\nPlease enter the ERF number of the project: ");

                erfnumber = Integer.parseInt(userinput.nextLine());

                //the if statement will only be executed if the erf number is a positive number
                if (erfnumber>0){

                    correctErfnumber = false;
                }

                else{

                    System.out.print("\nERF number can not be less than 1, Please try again: ");
                }
            }
            catch (Exception e) {

                System.out.print("\nInvalid input,Please try again");
            }
        }

        userinput = new Scanner(System.in);

        System.out.println("\nPlease enter the type of the building for the project: ");

        String typebuilding = userinput.nextLine();


        //This while loop will keep asking the user to enter the total fee of the project  once the user enters a correct input the while loop will stop
        //the try and catch will be used to display a message if the user doesn't enter a  double input
        while (correctTotalfee) {

            try {

                userinput = new Scanner(System.in);

                System.out.println("\nPlease enter the total fee of the project: ");

                totalfee = userinput.nextInt();

                correctTotalfee = false;
            }

            catch (Exception e) {

                System.out.print("\nInvalid input,please try again ");
            }
        }

        //This while loop will keep asking the user to enter the total amount paid of the project once the user enters a correct input the while loop will stop
        //the try and catch will be used to display a message if the user doesn't enter a  double input
        while (correctTotalamount) {

            try {
                userinput = new Scanner(System.in);

                System.out.println("\nPlease enter the total amount paid to date: ");

                totalamount = userinput.nextInt();

                //the if statement to end the loop will only be executed if the total fee of the project is more than the total amount paid
                if (totalfee > totalamount) {

                    correctTotalamount = false;
                }

                else {

                    System.out.print("\nYou have entered a number more than the project fee please try again");
                }

            }
            catch (Exception e) {

                System.out.print("\nInvalid input,please try again");
            }
        }

        LocalDate newdate ;

        String deadline2 = null;


        //This while loop will keep asking the user to enter a date of the project in this format yyyy-mm-dd once the user enters a correct input the while loop will stop
        //the try and catch will be used to display a message if the user doesn't enter a  enter a date or correct date format
        while (Correctdateformat) {


            try {

                userinput = new Scanner(System.in);

                System.out.println("\nPlease enter the deadline for the project in this format year-month-day: ");

                Deadline = userinput.nextLine();

                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                newdate = LocalDate.parse(Deadline, dateFormat);

                deadline2 = String.valueOf(newdate);

                Correctdateformat = false;

            }

            catch (Exception ex) {

                System.out.print("\nIncorrect date format,please try again");
            }
        }

        //if the user didn't enter the project name the the project name will be the type of building plus the name of the customer
        if (nameproject.equals("")) {

            nameproject = typebuilding + " " + customer.getName();
        }

        Project Projectdetails = new Project(numberproject, nameproject, addressproject, erfnumber, typebuilding, totalfee, totalamount, deadline2);

        Projectdetails.setCustomer(customer);

        Projectdetails.setArchitect(architect);

        Projectdetails.setContractor(contractor);

        //The project writer class is called and the value of the customer table are written to the customer table in the database
        ProjectDataWriter.PersonWriter(Projectdetails.getCustomer(),"Customer");

        //The project writer class is called and the value of the Contractor table are written to the Contractor table in the database
        ProjectDataWriter.PersonWriter(Projectdetails.getContractor(),"Contractor");

        //The project writer class is called and the value of the Architect table are written to the Architect table in the database
        ProjectDataWriter.PersonWriter(Projectdetails.getArchitect(),"Architect");

        //The project writer class is called and the value of the project table are written to the project table in the database
        ProjectDataWriter.ProjectWriter(numberproject, nameproject, addressproject, typebuilding, erfnumber,totalfee , totalamount,deadline2, Projectdetails.getCustomer().getIDnum(),Projectdetails.getContractor().getIDnum(),Projectdetails.getArchitect().getIDnum());
    }


    //we create this for the connection to the PoisePMS database
    public static Connection database_connect() {

        try {

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisedpms_db?useSSL=false",
                    "root",
                    "Pet123er$"
            );

        }

        catch (Exception ex){

            System.out.print("\nError has occurred please try again");

            return null;
        }
    }

    /**
     *  This method will be used to add projects ,display the projects,change information of the project and close the program once the user is done
     * @param args A string of argurments
     *
     */
    public static void main(String[] args) {


        String choice;

        //the while-do loop will keep displaying the menu to the user until they choose to close it
        do {

            System.out.println("\nPlease choose the options below:\n1-View all the existing projects\n2-Add new objects\n3-Edit existing projects\n4-View incomplete projects\n5-View projects that are overdue\n6-Select a project\n7-Close the program ");

            Scanner input = new Scanner(System.in);

            choice = input.nextLine();

            //if the user selects the 1st option as his choice the all the existing projects will be displayed on the console
            if (choice.equals("1")) {

                //the projects will be displayed by calling the viewallprojects method

                ProjectDataReader.ViewAllProjects();

                System.out.println("\nRedirecting you to main menu.");
            }

            //if the user selects the 2nd option as their choice they be asked to enter information of the new project
            if (choice.equals("2")) {

                //This calls the getproject method that will get the values that make up a project
                getProject();

                System.out.println("\nRedirecting you to main menu.");
            }

            //if the user selects the 3rd option as their choice they will be able to change certain information of a specific project
            if (choice.equals("3")) {

                // The getProjectInfo method is called to get the list of all the project numbers
                ProjectDataReader.getProjectInfo();

                ArrayList<Integer> project_numbers = ProjectDataReader.ListOFProjects();

                int project_id=0;

                boolean correct_id=true;

                //this while loop will run to ask the user to enter a id and check if the id number is valid or if it exists in the list
                while (correct_id){

                    try {

                        System.out.println("\nEnter Project number here: ");

                        Scanner wp = new Scanner(System.in);

                        project_id=wp.nextInt();

                        //This if statement will be executed if the id number is a positive number
                        if (project_id>0){

                            for (int num: project_numbers) {

                                if (project_id == num) {

                                    correct_id=false;

                                }
                            }

                            //this if statement will  executed if id number is not found in the list
                            if (correct_id){

                                System.out.print("\nID does not exist");
                            }
                        }

                        else {System.out.print("\nID can not be less than 1");}
                    }
                    catch (Exception E){

                        System.out.print("\nInvalid ID,please try again");
                    }
                }
                //This selects the project of the given id number by calling the selectProject method
                ProjectDataReader.selectProject(project_id);

                String secondchoice;

                //This while-do loop will keep displaying the second menu
                do {
                    System.out.print("\nPlease choose the action you would like to take with this project\n1.Change the due date of the project\n2.Update the total amount paid\n3.Update the contractor's contact detials\n4.Finalize the project\n5. close the edit");

                    Scanner userchoice = new Scanner(System.in);

                    secondchoice = userchoice.nextLine();

                    //if the user selects the 1st option they will be allowed to change the due date of the project
                    if (secondchoice.equals("1")) {

                        boolean Correctdateformat = true;

                        String Deadline;

                        LocalDate newdate;

                        String deadline2 = null;

                        //This while loop will be used to ask the user to enter a new due date
                        while (Correctdateformat) {

                            //the try-catch will be used to ensure that the user enters a correct date  in a correct format
                            try {

                                Scanner userinput = new Scanner(System.in);

                                System.out.println("\nPlease enter the deadline for the project in this format year-month-day: ");

                                Deadline = userinput.nextLine();

                                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                                newdate = LocalDate.parse(Deadline, dateFormat);

                                deadline2 = String.valueOf(newdate);

                                Correctdateformat = false;

                                //Connects to the database by calling the database_connect() method
                                Connection connection = database_connect();

                                Statement statement = connection.createStatement();

                                //updates the old deadline date with the new one to the project table by using executeUpdate
                                statement.executeUpdate("update project set Deadline_date = '"+deadline2+"' where project_number = "+project_id);

                                System.out.println("\nProject deadline updated.");

                                statement.close();

                                connection.close();
                            }

                            catch (Exception ex) {

                                System.out.print("\nIncorrect date format please try again.");
                            }
                        }

                        System.out.println("\nSaved,redirecting you to main menu.");
                    }

                    //if the user selects the 2nd option then they be allowed to enter a new amount which will added to the total amount paid
                    if (secondchoice.equals("2")) {

                        try {
                            // Connect to the  database by calling database_connect() mthod
                            Connection connection = database_connect();

                            Statement statement = connection.createStatement();

                            ResultSet results;

                            //selects the values from the project table that we are going to use by using executeQuery

                            results = statement.executeQuery("select Total_fee ,Total_amount_paid from Project where Project_number = "+project_id);

                            results.next();

                            //the value of the total fee of the project
                            double total_fee =results.getInt("Total_fee");

                            double total_amount_paid = results.getInt("Total_amount_paid");

                            boolean correct_input=true;

                            double newamount =0.0;

                            //the while loop be used to ask the user to enter an amount and check if the amount is correct
                            while (correct_input) {

                                try {

                                    System.out.println("\nEnter paid amount here: ");

                                    Scanner ans = new Scanner(System.in);

                                     newamount = ans.nextDouble()+total_amount_paid;

                                     //the if statement will be executed if the newamount is more than the total
                                     if (newamount <= total_fee){

                                         correct_input=false;
                                     }

                                     else {

                                         System.out.print("\ninvalid input");
                                     }
                                }

                                catch (Exception E){

                                    System.out.print("\nInvalid Amount");
                                }
                            }

                            statement.executeUpdate("update project set Total_amount_paid = "+newamount+ " where project_number = "+project_id);

                            results.close();

                            statement.close();

                            connection.close();
                        }
                        catch (Exception ex){

                            System.out.print("\nError has occurred please try again");
                        }


                        System.out.println("\nSaved,redirecting you to main menu.\n");
                    }

                    //if the user selects the 3rd option the they will be allowed to change the contact details of the contractor of the project
                    if (secondchoice.equals("3")) {

                        String NewPhoneNumber;

                        System.out.println("\nEnter new Email Address here: ");

                        Scanner userinput = new Scanner(System.in);

                        String NewEmailAddress = userinput.nextLine();

                        System.out.println("\nEnter new telephone number here: ");

                        userinput = new Scanner(System.in);

                        NewPhoneNumber = userinput.nextLine();

                        try {
                            //connects to the database by calling the database_connect() method
                            Connection connection = database_connect();

                            Statement statement = connection.createStatement();

                            ResultSet results;

                            //selects all the values in the contractor table by using executeQuery that is under the project id that the usr has entered
                            results = statement.executeQuery("select * from project inner join Contractor on project.Contractor_ID= Contractor.Contractor_ID where project_number="+project_id+"");

                            results.next();

                            //updates the email and telephone number of the contrator table  that is under the project id that the usr has entered
                            statement.executeUpdate("update contractor set Contractor_email = '"+NewEmailAddress+"', Contractor_telephone = '"+ NewPhoneNumber+"' where contractor_ID ="+results.getInt("Contractor_ID"));

                            System.out.println("\nDetails have been updated.");

                            results.close();

                            statement.close();

                            connection.close();

                        }
                        catch (Exception ex){

                            System.out.print("\nError has occurred please try again");
                        }

                        System.out.println("\nSaved,redirecting you to main menu.");
                    }
                    //if the user selects the fourth option the program will finalize the project
                    if (secondchoice.equals("4")){

                        try {

                            //connects to the database by calling database_connect() method
                            Connection connection = database_connect();

                            Statement statement = connection.createStatement();

                            ResultSet results;

                            //selects the the project where the total fee is equal to the totala mount paid
                            results = statement.executeQuery("select project_number, Total_fee, total_amount_paid from project where Total_fee = total_amount_paid or Total_fee > total_amount_paid and Project_number = " + project_id);

                            //this while loop will run if to displayed the information
                            while (results.next()) {

                                double Total_fee = results.getDouble("Total_fee");

                                double total_amount_paid = results.getDouble("total_amount_paid");

                                double Outstanding = Total_fee - total_amount_paid;

                                //this if statement will be executed if there isnt any outstanding money
                                if (Outstanding==0) {

                                    System.out.println("\nProject: " + results.getInt("project_number") + " Has been finalised.");

                                }

                                else if (Outstanding>0) {

                                    Statement statement1 = connection.createStatement();

                                    ResultSet results1;

                                    //selects the information of the customer table
                                    results1 = statement1.executeQuery("select customer.customer_id, customer.customer_name, customer.customer_telephone, customer.Customer_email, customer.Customer_address, project.project_number, project.project_name, project.total_fee, project.total_amount_paid from customer inner join project on customer.customer_id=project.customer_id where project_number=" + project_id + " and Total_fee > total_amount_paid;");


                                    //this while loop will be used to display the an invoice if there is an outstanding balance and write to the invoice text file
                                    while (results1.next()) {

                                        Total_fee = results1.getDouble("Total_fee");

                                        total_amount_paid = results1.getDouble("total_amount_paid");

                                        Outstanding = Total_fee - total_amount_paid;

                                        System.out.println("\nInvoice\n====================\nProject number: " + results1.getInt("project_number") + "\nCustomer Name: " + results1.getString("customer_Name") +

                                             "\nPhone Number: " + results1.getString("customer_telephone") + "\nPhysical Address:" + results1.getString("customer_address") +

                                             "\nEmailAddress: " + results1.getString("customer_email") + "\nOutstanding amount: R" + Outstanding + "\n");


                                        String invData = "\nProject number: " + results1.getInt("project_number")

                                            + "Customer Name: " + results1.getString("customer_Name")

                                            + "\nPhone Number: " + results1.getString("customer_telephone")

                                            + "\nPhysicalAddress: " + results1.getString("customer_address")

                                            + "\nEmailAddress: " + results1.getString("customer_email")

                                            + "\nOutstanding amount: R" + Outstanding;

                                        //the try and catch will be used to write to the invoice text file

                                        try {

                                            Formatter IF = new Formatter("AllInvoices.txt");


                                            IF.format("%s", invData);


                                            IF.close();
                                        }
                                        catch (Exception e) {

                                        System.out.println("\nInvoice writing failed!");
                                        }
                                    }
                                }
                            }
                            results.close();

                            statement.close();

                            connection.close();
                        }

                        catch (SQLException e) {
                            // We only want to catch a SQLException - anything else is off-limits for now.
                            e.printStackTrace();
                        }
                    }
                    //if the user selects 5 the menu closes
                    if (secondchoice.equals("5")) {

                        System.out.println("\nThank you,Redirecting you to main menu.");
                    }
                }

                while (!secondchoice.equals("5"));

                System.out.println("\nRedirecting you to main menu.");
            }

            //the user selets the 4th option then all the projects that are Incomplete will be displayed on the console
            if (choice.equals("4")) {

                ProjectDataReader.getIncompleteproject();

                System.out.println("\nRedirecting you to main menu.");
            }
            //the user selects the 5th option then all the projects that are overdue will be displayed on the console
            if (choice.equals("5")) {

                ProjectDataReader.getOverdueProject();

                System.out.println("\nRedirecting you to main menu.");
            }

            if (choice.equals("6")){

                ProjectDataReader.getProjectInfo();

                ArrayList<Integer> project_numbers = ProjectDataReader.ListOFProjects();

                int project_id=0;

                boolean correct_id=true;

                while (correct_id){

                    try {

                        System.out.println("\nEnter Project number here: ");

                        Scanner input1 = new Scanner(System.in);

                        project_id=input1.nextInt();

                        //This if statement will be executed if the id number is a positive number
                        if (project_id>0){

                            for (int num: project_numbers) {

                                if (project_id == num) {

                                    correct_id=false;
                                }
                            }

                            //this if statement will  executed if id number is not found in the list
                            if (correct_id){

                                System.out.print("\nID does not exist");

                            }
                        }

                        else {
                            System.out.print("\nID can not be less than 1");
                        }
                    }
                    catch (Exception E){

                        System.out.print("\nInvalid ID,please try again");
                    }
                }
                //This selects the project of the given id number by calling the selectProject method

                ProjectDataReader.selectProject(project_id);

                String option1;

                do {

                    //we make a menu with options
                    System.out.println("\n1- view contractor info\n2- view customer info\n3- view architect info\n4-quit");

                    Scanner userinput = new Scanner(System.in);

                    option1 = userinput.nextLine();

                    //if the user selects the first option it display contractor details
                    if (option1.equals("1")) {

                        ProjectDataReader.contractor(project_id,"contractor");
                    }
                    //if the user selects the second option it display customers details
                    else if (option1.equals("2")){

                        ProjectDataReader.customer(project_id,"Customer");
                    }
                    //if the user selects the third option it display  architect details
                    else if (option1.equals("3")){

                        ProjectDataReader.Architect(project_id,"architect");
                    }
                }
                while (!option1.equals("4"));
            }
        }
        //as long as the first menu hasnt been closed yet information will be written to the file by calling the write to fle method
        while (!choice.equals("7"));
    }
}


