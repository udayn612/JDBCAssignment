package com.stackroute.configuration;

import java.sql.*;

public class CrudOperation {
    private Connection con;
    public void displayData() {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student","udayn612","uday");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();


            //execute query
            ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String displayLoginInfo(String name,String password) {

        String sendUsername=null;
        try{

            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student","udayn612","uday");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("Select * from person where UserName = ? and Password=?");
            stmt.setString(1,name);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            //execute query
            //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
            {
                sendUsername=rs.getString(2);
            }
               // System.out.println("ID "+rs.getInt(1)+"  "+rs.getString(2));
            con.close();
            return sendUsername;
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sendUsername;
    }

    public void insertCustomer(String userName,String password) {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student","udayn612","uday");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("insert into person(UserName,Password) values(?,?)");
            stmt.setString(1,userName);
            stmt.setString(2,password);
            stmt.executeUpdate();


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        //PreparedStatement
    }
}
