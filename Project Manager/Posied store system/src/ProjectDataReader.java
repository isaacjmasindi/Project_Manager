import java.sql.*;
import java.util.ArrayList;
/**
 *This class is the class that contains all the information for the project creation
 * Date:2021-05-13
 * @author collin matanda
 * @version 1.0
 *
 *
 */
public class ProjectDataReader {

    //The array list that will store all the project numbers
    static ArrayList<Integer> ProjectNumbers= new ArrayList<>();


    /**
     * this method connects to the library database and display a message if the connecting failed
     * @return The connection to the database
     */
    public static Connection database_connect(){

        //the try and catch will be used to display a message if  connecting  to the database fails
        try {

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisedpms_db?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "Pet123er$"
            );

        }
        catch (Exception ex){

            System.out.print("Connection Failed");

            return null;
        }
    }


    /**
     * This method will be used to get the project numbers list when it is called
     * @return The project numbers list
     */
    public static ArrayList<Integer> ListOFProjects(){
        return  ProjectNumbers;
    }


    /**
     * This method will be used to view all the existing projects from Poisedpms database
     */
    public static void ViewAllProjects(){

        //The try and catch will be used to display an error if a message were to occur
        try {

            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            //all the  values of table project is selected from the database using executeQuery
            results = statement.executeQuery("select * from project");

            //The while loop will be used to print out all the projects in the database
            while (results.next()) {

                System.out.println("\nProject Details\n===============\nProject number: " + results.getInt("Project_number") + "\nProject name: " + results.getString("Project_name") +
                       "\nPhysical Address:" + results.getString("Project_address") +  "\nBuilding type: " + results.getString("Type_of_Building") +
                        "\nERF number: " + results.getInt("ERF_number") + "\nProject Fee: " + results.getDouble("Total_Fee") + "\nPaid Amount: " +
                        results.getDouble("Total_amount_paid") + "\nDeadline: " + results.getDate("Deadline_date")+  "\nCustomer ID: " +  results.getString("Customer_ID") +  "\nContactor ID: " +  results.getString("Contractor_ID") +  "\nArchitect ID: " +  results.getString("Architect_ID") + "\n");
            }

            results.close();

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("\nError has occurred please try again\n");
        }
    }

    /**
     * This method will be used to get specific information from Poisedpms database
     */
    public static void getProjectInfo() {

        //The try and catch will be used to display an error if a message were to occur
        try {

            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            // this  selects the values from the project number and project columns from projects table using the executeQuery
            results = statement.executeQuery("select Project_number,Project_name from Project");

            //print all the column info
            //the project numbers are added into the array list using the wile loop
            while (results.next()) {

                int project_number = results.getInt("project_number");

                ProjectNumbers.add(project_number);

                System.out.println("Project number and project name\n================\nProject number: " + project_number + " \nProject name: " + results.getString("Project_name"));
            }
            results.close();

            statement.close();

            connection.close();
        }
        catch (Exception ex){

            System.out.print("\nError has occurred please try again\n");

        }
    }

    /**
     * This method will be used to get all the projects that are overdue from Poisedpms database
     */
    public static void getOverdueProject() {

        try {
            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            //this  selects the specific columns where the deadline date is less than the current date from the projects table using executeQuery
            results = statement.executeQuery("select project_number,project_name,customer_ID,contractor_id, Architect_id from project  where deadline_date<cast(now() as date)");

            //The value of these columns are then printed to the console
            if (!results.equals(0)) {

                while (results.next()) {

                    System.out.println("Overdue projects\n=================\nProject number: " + results.getInt("project_number") + "\nProject name: " + results.getString("project_name")
                            +"\nCustomer ID: " + results.getString("Customer_ID") + "\nContractor ID: " +results.getString("contractor_ID") + "\nArchitect_ID: " +results.getString("Architect_ID") + "\n");                }

            }
            else{

                System.out.println("\nNo overdue Projects!\n");
            }
            results.close();

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("\nError has occurred please try again\n");
        }
    }


    /**
     * This method will be used to get all projects that are incomplete
     */
    public static void getIncompleteproject() {

        try {
            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results ;

            //this  selects the specific columns where the deadline date is more than the current date from the projects table using executeQuery
            results = statement.executeQuery("select project_number,project_name,customer_ID,contractor_id, Architect_id from project where deadline_date>cast(now() as date)");

            //The value of these columns are then printed to the console
            if (!results.equals(0)) {

                while (results.next()) {

                    System.out.println("Incomplete project projects\n=================\nProject number: " + results.getInt("project_number") + "\nProject name: " + results.getString("project_name")

                            +"\nCustomer ID: " + results.getString("Customer_ID") + "\ncontractor ID: " +results.getString("contractor_ID") + "\nArchitect_ID: " +results.getString("Architect_ID") + "\n");
                }

            }
            else{

                System.out.println("\nNo overdue Projects!\n");
            }

            results.close();

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("\nError has occurred please try again\n");

        }
    }

    /**
     * This method will be used to select a specific projects based on the user's choice
     * @param ProjectNum The project number the user would like to see
     */
    public static void selectProject(int ProjectNum){

        try {

            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            //this  selects the all the values of the specific project the user has entered based on the projectnumber
            results = statement.executeQuery("select * from project where Project_number = "+ProjectNum);

            //All the information is then printed on the console
            while (results.next()) {

                System.out.println("\nProject Details\n===============\nProject number: " + results.getInt("Project_number") + "\nProject name: " + results.getString("Project_name") +
                        "\nPhysical Address:" + results.getString("Project_address") + "\nBuilding type: " + results.getString("Type_of_Building") +
                        "\nERF number: " + results.getInt("ERF_number") + "\nProject Fee: " + results.getDouble("Total_Fee") + "\nPaid Amount: " +
                        results.getDouble("Total_amount_paid") + "\nDeadline: " + results.getDate("Deadline_date")+  "\nCustomer ID: " +  results.getString("Customer_ID") +  "\nContactor ID: " +  results.getString("Contractor_ID") +  "\nArchitect ID: " +  results.getString("Architect_ID") + "\n");
            }

            results.close();

            statement.close();

            connection.close();
        }
        catch (Exception ex){

            System.out.print("\nError has occurred please try again\n");

        }
    }

    /**
     * This method will be used to display the customer info
     * @param projectNumber the number that is used to identify the a specific project
     * @param tableName The name of the table we would like get its info
     */
    public static void customer(int projectNumber, String tableName){

        try {
            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            //this  selects the all the values of from the customer table using the foreign key found in the project table
            results = statement.executeQuery("select * from "+tableName+" inner join project on customer.Customer_id= project.Customer_id where project_number="+projectNumber+"");

            //the information is printed using a while loop
            while(results.next()) {

                System.out.println("\nCustomer Details\n===============\nCustomerID: " + results.getString("Customer_ID") + "\nCustomer Name: " + results.getString("Customer_Name") + "\nCustomer Email: " + results.getString("Customer_email") + "\nCustomer Address: " + results.getString("Customer_Address") + "\nCustomer Telephone: " + results.getString("Customer_telephone"));
            }

            results.close();

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("Error has occurred please try again");

        }
    }

    /**
     * This method will be used to display the contractor info
     * @param projectNumber the number that is used to identify the a specific project
     * @param tableName The name of the table we would like get its info
     */
    public static void contractor(int projectNumber, String tableName){
        try {

            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            //this  selects the all the values of from the contractor table using the foreign key found in the project table
            results = statement.executeQuery("select * from "+tableName+" inner join project on contractor.contractor_id= project.contractor_id where project_number="+projectNumber+"");

            //the information is printed using a while loop
            while(results.next()) {

                System.out.println("\nContractor Details\n===============\nContractorID: " + results.getString("Contractor_ID") + "\nContractor Name: " + results.getString("Contractor_Name") + "\nContractor Email: " + results.getString("Contractor_email") + "\nContractor Address: " + results.getString("Contractor_Address") + "\nContractor Telephone: " + results.getString("Contractor_telephone"));
            }

            results.close();

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("Error has occurred please try again");

        }
    }


    /**
     * This method will be used to display the Architect info
     * @param projectNumber the number that is used to identify the a specific project
     * @param tableName The name of the table we would like get its info
     */
    public static void Architect(int projectNumber, String tableName){
        try {
            //  calls the connection method to connect to the PoisedPMS database

            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            ResultSet results;

            //this  selects the all the values of from the Architect table using the foreign key found in the project table
            results = statement.executeQuery("select * from "+tableName+" inner join project on Architect.Architect_id= project.Architect_id where project_number="+projectNumber+"");

            //the information is printed using a while loop
            while(results.next()) {

                System.out.println("\nArchitect Details\n===============\nArchitectID: " + results.getString("Architect_ID") + "\nArchitect Name: " + results.getString("Architect_Name") + "\nArchitect Email: " + results.getString("Architect_email") + "\nArchitect Address: " + results.getString("Architect_Address") + "\nArchitect Telephone: " + results.getString("Architect_telephone"));
            }
            results.close();

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("Error has occurred please try again");

        }
    }

}
