/**
 *This class is the class that contains all the information for the person creation (Customer,Architect,Customer)
 * Date:2021-05-13
 * @author collin matanda
 * @version 1.0
 *
 *
 */

public class person {
    /**
     * String value for name of a person (Customer,Architect,Customer)
     */
    public String Name;

    /**
     * String value for ID number of the person (Customer,Architect,Customer)
     */
    public  String IDnum;

    /**
     * String value for Telnumber of a person (Customer,Architect,Customer)
     */
    public String Telnumber;

    /**
     * String value for Emailaddress of a person (Customer,Architect,Customer)
     */
    public String Emailaddress;

    /**
     * String value for  Physcialadress of a person (Customer,Architect,Customer)
     */
    public String Physcialadress;

    /**
     * Constructor of the person class
     * @param name A name that belongs to the person (Customer,Architect,Customer)
     * @param emailaddress an email address that belongs to the person (Customer,Architect,Customer)
     * @param telnumber an telnumber that belongs to the person (Customer,Architect,Customer)
     * @param physcialadress an physcialadress that belongs to the person (Customer,Architect,Customer)
     */
    public person(String IDnum,String name,String emailaddress, String telnumber,String physcialadress) {

        this.Name = name;

        this.Telnumber = telnumber;

        this.Physcialadress =physcialadress;

        this.Emailaddress =emailaddress;

        this.IDnum=IDnum;
    }


    /**
     * Gets the ID number the a person (Customer,Architect,Customer)
     * @return The string value of the ID number
     */
    public String getIDnum(){return IDnum;}
    /**
     * Gets the name of the a person (Customer,Architect,Customer)
     * @return The string value of the name
     */
    public String getName(){return Name;}

    /**
     * Gets the telnumber of the person (Customer,Architect,Customer)
     * @return The string value of the telnumber
     */
    public String getTelnumber(){return Telnumber;}

    /**
     * Gets the emailaddress of the person (Customer,Architect,Customer)
     * @return The string value if the emailaddress
     */
    public String getEmailaddress(){return Emailaddress;}

    /**
     * Gets Physcialadress the of the person (Customer,Architect,Customer)
     * @return The string value of the Physcialadress
     */
    public String getPhyscialadress(){return Physcialadress;}


    /**
     * This method toString will be used to displayed each value of each attribute next to a descriptive name
     * @return the string value of the information of the project
     */
    public String toString() {
        String output = "Name: "+ Name;

        output += "\nEmail address: "+ Emailaddress;

        output += "\nPhone numbers: "+ Telnumber;

        output += "\nAddress: "+ Physcialadress;

        return output;
    }
}
