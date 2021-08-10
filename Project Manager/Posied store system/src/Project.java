

/**
 *This class is the class that contains all the information for the project creation
 * Date:2021-05-13
 * @author collin matanda
 * @version 1.0
 *
 *
 */


public class Project {
    /**
     * integer value for Projectnumber.
     */
    private int Projectnumber;

    /**
     * String value for projectname.
     */
    private String Projectname;
    /**
     * String vale for Typeofbuilding.
     */
    private String Typeofbuilding;

    /**
     * String value for projectaddress
     */
    private String Projectaddress;

    /**
     * integer for erfnumber
     */
    private int Erfnumber;

    /**
     * double value for totalfee
     */
    private double Totalfee;

    /**
     * double value for Totalamountpaid
     */
    private double Totalamountpaid;

    /**
     * String value for DeadlineDate
     */
    private String DeadlineDate;

    /**
     * Person value for Architect
     */
    public person Architect;

    /**
     * Person value for Contractor
     */
    public person Contractor;

    /**
     * person value for customer
     */
    public person Customer;


    /**
     * The constructor of the project class
     *
     * @param projectnumber   A number of which the project will have
     * @param projectname     A name of the project
     * @param projectaddress  A address of which the project will located
     * @param erfnumber       The Erfnumber of the project
     * @param typeofbuilding  The type of building of the project
     * @param totalfee        The total fee of the project
     * @param totalamountpaid The total amount the customer has paid
     * @param deadlineDate    The deadline of the project
     */
    public Project(int projectnumber, String projectname, String projectaddress, int erfnumber, String typeofbuilding, double totalfee, double totalamountpaid, String deadlineDate) {

        this.Projectnumber = projectnumber;

        this.Projectname = projectname;

        this.Projectaddress = projectaddress;

        this.Typeofbuilding = typeofbuilding;

        this.Erfnumber = erfnumber;

        this.Totalfee = totalfee;

        this.Totalamountpaid = totalamountpaid;

        this.DeadlineDate = deadlineDate;


    }


    /**
     * gets the information of the of the contractor of the project
     *
     * @return the person(class) value of the contractor
     */
    public person getContractor() {

        return Contractor;
    }

    /**
     * Sets the contractor of the project
     *
     * @param contractor a person(class) containing the Project's contractor
     */
    public void setContractor(person contractor) {
        this.Contractor = contractor;
    }

    /**
     * sets the customer of the project
     *
     * @param customer a person(class) containing the Project's customer
     */
    public void setCustomer(person customer) {
        this.Customer = customer;
    }

    /**
     * gets the information of the of the customer of the project
     *
     * @return the person(class) value of the customer
     */
    public person getCustomer() {

        return Customer;
    }

    /**
     * sets the architect of the project
     *
     * @param architect a person(class) containing the Project's architect
     */
    public void setArchitect(person architect) {

        this.Architect = architect;
    }

    /**
     * gets the information of the of the architect of the project
     *
     * @return the person(class) value of the architect
     */
    public person getArchitect() {

        return Architect;
    }
}



