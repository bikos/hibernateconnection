# Quick configuring netbeans to create a hibernate connection with mysql.



Install following before starting
* Maven
* MySQL
* Netbean


Steps
------------------------------------------------
1. Create new project, and from categories, select MAVEN and under projects click JAVA APPLICATION
2. Once the project is created, navigate to PROJECT FILES/ double click the POM.XML
3. Insert the required hibernate dependencies as follow:

  
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>4.3.5.Final</version>
        </dependency>
      
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.6</version>
        </dependency>
  
  Now maven will import all the required hibernate dependencies for the project. 
  
4. Now right click on the SOURCE PACKAGE, then click NEW and then click OTHER. Now under CATEGORIES click on HIBERNATE and from FILE TYPE select 
  HIBERNATE CONFIGURATION WIZARD. Click next until you reach Select Data Source. Select the database connection, for MySQL click on
  NEW DATABSE CONNECTION from DATABASE CONNECTION drop down menu. 
  
5. From the new popup window, select your driver from DRIVER drop dowm menu and select MySQL (Connector /J Driver).
  
6. Click Next
  
7. From this window, provide your credential for MySQL database.. provide the databse name, username and password.
  Click on TEST CONNECTION to verify. After the databse connection is successful, click finish. 
  
  After this is done, we are interested to create the POJOs for the exiting tables from the database. The hard way would be to type
  the whole POJOs for the table, but netbeans can do that for us. But before that, we need to create a reverse-engineered XML which 
  is used to create POJO classes.
  
8. Follow the same as in step 4, but instead of choosing, HIBERNATE CONFIGURATION WIZARD, select HIBERNATE REVERSE ENGINEERING WIZARD.
  Click on next, all the tables from your RDBMS is shown on the left hand side, select all so that they'll move onto the right side, and click finish
  This will create another XML file, remeber that this xml should be together with HIBERNATE.CFG that we created. If HIBERNATE.REVERNG is created at 
  some other directoty, cut and paste it to the directory where configuration xml is located. 
  
  Now we move to creating POJOs for all the tables from our SQL database. 
9. Follow step 4 again, but select HIBERNATE MAPINGS FILES AND POJOS FROM DATABASE.
  
10. Click NEXT and FINISH, this will create the classes for the tables in the database. All the classes will be under your source packages.
  
  The final step is map the class we craeted with the tables on the database:
11. Follow step 4, but select HIBERNATE MAPPING WIZARD. Click on next, and open browse on CLASS TO MAP. Now type the name of the POJO class created,
  and map with its corresponding table from the drop down menu of DATABASE TABLE. 
  
  Once all the tables are mapped, you're good to go. Attached is a simple configuration of the above steps. Once you've set the enviroment you're
  good to work with HIBERNATE and CRITERIA. 
  
  
    

