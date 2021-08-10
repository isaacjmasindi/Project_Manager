import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *This class is the class that contains all the information for the project creation
 * Date:2021-05-13
 * @author collin matanda
 * @version 1.0
 *
 *
 */

public class ProjectDataWriter {

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
     * This method will be used to write all the information from the user into the database
     * @param ProjectID The ID of the project which is a primary key
     * @param ProjectName The name of the project
     * @param ProjectAddress The address of the project
     * @param Typeofbuilding The type of building of the project
     * @param ERFnumber The ERF number of the project
     * @param ProjectFee The total fee of the project
     * @param Amount_paid The total amount the customer has paid so far
     * @param DeadLine The deadline of the project
     * @param Customer_ID The customer ID number which is a foreign key
     * @param Contractor_ID The contractor Id number which is a foreign key
     * @param Architect_ID The Architect Id number which is a foreign key
     */
    public static void ProjectWriter(int ProjectID, String ProjectName, String ProjectAddress, String Typeofbuilding,  int  ERFnumber, double ProjectFee, double Amount_paid, String DeadLine, String Customer_ID, String Contractor_ID, String Architect_ID) {
        //The try and catch will be used to display a message if the there is an error with the connection or inserting to the database
        try {
            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            //Each Value is then inserted into the database using executeUpdate
            statement.executeUpdate("INSERT INTO Project VALUES (" +ProjectID + ",'" + ProjectName + "','" + ProjectAddress+ "','" + Typeofbuilding + "'," + ERFnumber + "," + ProjectFee + "," + Amount_paid + ",'" + DeadLine + "','" + Customer_ID + "','" + Contractor_ID + "','" + Architect_ID +"')");

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("\nError\n");
        }
    }

    /**
     * This method will be used to write to the Customer,Architect and Customer tables
     * @param name The  name of the person (Customer,Architect,Customer) value
     * @param tableName The name of the table that it will be writing to
     */
    public static void PersonWriter(person name, String tableName) {
        //The try and catch will be used to display  a message if the connection fails or inserting into the database
        try {
            //  calls the connection method to connect to the PoisedPMS database
            Connection connection = database_connect();

            Statement statement = connection.createStatement();

            //Each Value is then inserted into the database using executeUpdate
            statement.executeUpdate("INSERT INTO "+tableName+" VALUES ("+name.getIDnum()+",'" +name.getName()+"','"+ name.getEmailaddress()+ "','"+name.getPhyscialadress()+"','"+name.getTelnumber()+"')");

            statement.close();

            connection.close();

        }
        catch (Exception ex){

            System.out.print("\nError\n");

        }
    }
}
