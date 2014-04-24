package edu.spcollege.titanbank.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DBPerson {
    private int personId = 0;
    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private java.util.Date birthDate = null;
    private String gender = "";
    private String prefixTitle = "";
    private String suffix = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String country = "";
    private String state = "";
    private String postalCode = "";
    private String emailAddress = "";
    private String phone1 = "";
    //
    private Connection conn = null;
    private DBConnect dbconnect;
    private Statement stmt;
    private int returnCode = 0;
    private String sqlStatement = "";
    private ResultSetMetaData md;
    private ResultSet rs;
    private int result = 0;
    private QueryResult queryResult;
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/titanbank";
    private final String dbUserId = "root";
    private final String dbPassword = "sesame";
    //
    private final String mysqlPattern = "yyyy-mm-dd";
    private final SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
  
    // Note: The person id is stored with the userid
    //public Person(int id) throws SQLException, ClassNotFoundException {
    //    this.personId = id;
    //    queryResult = queryPerson(personId);    
    //}

    public int insertPerson(Person person) throws SQLException {
        String mysqlPattern = "yyyy-mm-dd";
        SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
        
        sqlStatement = 
            "insert into person(" 
            + "prefixtitle,lastname,firstname,middlename,birthdate,gender,suffix"
            + ",address1,address2,city,country,state,postalcode"
            + ",emailaddress,phone1"
            + ")"
            + "values("
            + "'" + person.getPrefixTitle() + "'"
            + ",'" + person.getLastName() + "'"
            + ",'" + person.getFirstName() + "'"
            + ",'" + person.getMiddleName() + "'"
            + ",'" + mysqlDateFormat.format(person.getBirthDate()) + "'"
            + ",'" + person.getGender() + "'"
            + ",'" + person.getSuffix() + "'"
            + ",'" + person.getAddress1() + "'"
            + ",'" + person.getAddress2() + "'"
            + ",'" + person.getCity() + "'"
            + ",'" + person.getCountry() + "'"
            + ",'" + person.getState() + "'"
            + ",'" + person.getPostalCode() + "'"
            + ",'" + person.getEmailAddress() + "'"
            + ",'" + person.getPhone1() + "'"    
            + ")";
        
        //DBUpdate dbupdate = new DBUpdate();
        //result = dbupdate.doUpdate(sqlStatement);
                
        // Insert a new row, 
        dbconnect = new DBConnect();     
        if (dbconnect.getConn() != null) {
            try {
                conn = dbconnect.getConn();
                System.out.println("Connected");
                stmt = conn.createStatement();
                System.out.println("Execute: "+sqlStatement);
                returnCode = stmt.executeUpdate(sqlStatement);
                System.out.println("statement close()");
                stmt.close();
                System.out.println("Get last id");
                this.personId = getLastId();
                System.out.println("Last insert id: "+personId);
                conn.close();
            } catch (SQLException sqlex) {
                System.out.println("SQL Exception: "+sqlex);
                sqlex.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to connect to database");
        }
        return personId;
    }

    public void queryPerson(int personId) throws SQLException, ClassNotFoundException {
        System.out.println("queryPerson: " + personId);
        sqlStatement = "select * from person where personid = '" + personId + "'";
        DBQuery dbquery = new DBQuery();
        queryResult = dbquery.doQuery(sqlStatement);
        
        Class.forName(driverClassName);
        try {
            conn = DriverManager.getConnection(dbUrl, dbUserId, dbPassword); 
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlStatement);
            md = rs.getMetaData();
            // Testing 
            //get column names
            //for (int i = 1 ; i <= md.getColumnCount() ; i++) {
            //    queryResult.addColumnName(md.getColumnName(i));
            //}
            // get field values
            while (rs.next()) {
                // Testing
                //for (int i = 1 ; i<=md.getColumnCount() ; i++) {
                //    queryResult.addFieldValue(rs.getString(i));
                //}
                this.personId = rs.getInt("personid");
                this.lastName = rs.getString("lastname");
                this.firstName = rs.getString("firstname");
                this.middleName = rs.getString("middlename");
                this.birthDate = rs.getDate("birthdate");
                this.gender = rs.getString("gender");
                this.suffix = rs.getString("suffix");
                this.prefixTitle = rs.getString("prefixtitle");
                this.address1 = rs.getString("address1");
                this.address2 = rs.getString("address2");
                this.city = rs.getString("city");
                this.country = rs.getString("country");
                this.state = rs.getString("state");
                this.postalCode = rs.getString("postalcode");
                this.emailAddress = rs.getString("emailaddress");
                this.phone1 = rs.getString("phone1");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        // For testing
        //if (QueryResult != null) {
        //    it = queryResult.columnNamesIterator();
        //    while (it.hasNext()) {
        //         System.out.println(it.next()) ;
        //    }
        //    it = queryResult.fieldValuesIterator();
        //    while (it.hasNext()) {
        //         System.out.println(it.next()) ;
        //    }
        //}
        //else {
        //    System.out.println("No rows found!");
        //}
     }
    
    private int getLastId() throws SQLException {
        stmt = conn.createStatement();
        System.out.println("last_insert_id...");
        ResultSet rs = stmt.executeQuery("select last_insert_id() as lastid");
        System.out.println("Execute done");
        //String lastId = rs.getString(1);
        int lastId = 0;
        if (rs.next()) {
            lastId = rs.getInt(1);
        } else {
            System.out.println("Error getting lastId");
        }
        System.out.println("last_insert_id: "+lastId);
        stmt.close();
        rs.close();
        return lastId;
    }
    

    // Getters and Setters
    public int getPersonId() {
	return personId;
    }
    public void setPersonId(int personId) {
	this.personId = personId;
    } 
    
    public String getPrefixTitle() {
	return prefixTitle;
    }
    public void setPrefixTitle(String prefixTitle) {
	this.prefixTitle = prefixTitle;
    } 
    
    public String getLastName() {
	return lastName;
    }
    public void setLastName(String lastName) {
	this.lastName = lastName;
    } 
    
    public String getFirstName() {
	return firstName;
    }     
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getMiddleName() {
	return middleName;
    }
    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public java.util.Date getBirthDate() {
	return birthDate;
    }
    public void setBirthDate(java.util.Date birthDate) {
	this.birthDate = birthDate;
    }
    
    public String getGender() {
	return gender;
    }
    public void setGender(String gender) {
	this.gender = gender;
    }
    
    public String getSuffix() {
	return suffix;
    }
    public void setSuffix(String suffix) {
	this.suffix = suffix;
    }
    
    public String getAddress1() {
	return address1;
    }
    public void setAddress1(String address1) {
	this.address1 = address1;
    }
    
    public String getAddress2() {
	return address2;
    }
    public void setAddress2(String address2) {
	this.address2 = address2;
    }
    
    public String getCity() {
	return city;
    }
    public void setCity(String city) {
	this.city = city;
    }
    
    public String getCountry() {
	return country;
    }
    public void setCountry(String country) {
	this.country = country;
    }
    
    public String getState() {
	return state;
    }
    public void setState(String state) {
	this.state = state;
    }
    
    public String getPostalCode() {
	return postalCode;
    }
    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }
    
    public String getEmailAddress() {
	return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }
    
    public String getPhone1() {
	return phone1;
    }
    public void setPhone1(String phone1) {
	this.phone1 = phone1;
    }

}
