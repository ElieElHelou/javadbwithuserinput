//import java.io.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int verify(int mode, Info i) {
        int result = 0;

        Connector connect = new Connector();
        Connection connectDB = connect.getConnection();

        String verify;

        if (mode == 1) {
            verify = "SELECT count(1) FROM user WHERE email = '" + i.getRegemail() + "'";
        }
        else if (mode == 2) {
            verify = "SELECT count(1) FROM user WHERE username = '" + i.getRegusername() + "'";
        }
        else {
            verify = "SELECT count(1) FROM user WHERE username = '" + i.getLogusername() +
                    "' AND password = '" + i.getLogpassword() + "'";
        }

        try {
            Statement statement = connectDB.createStatement();
            ResultSet qr = statement.executeQuery(verify);

            while (qr.next()) {
                if (qr.getInt(1) == 1) {
                    result = 1;
                } else {
                    result = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int register(Info i){
        int status = 0;
        Connector connect = new Connector();
        Connection connectDB = connect.getConnection();

        if (verify(1,i) != 0) {
            System.out.println("This email is already in use!");
        }
        else if (verify(2,i) != 0) {
            System.out.println("This username is already in use!");
        }
        else{
            String register = "INSERT INTO user (username, email, password) VALUES " +
                                "('" + i.getRegusername() + "','" + i.getRegemail() + "','" + i.getRegpassword() + "')";
            try{
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(register);
                status = 1;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Info user = new Info ();
        String currinput = "";
        System.out.println("Welcome to A.C.M.E software solutions!");
        
        Scanner sc = new Scanner(System.in);

        while (! currinput.equals ("-quit")){
            System.out.println("""
                To register a new account type '-register' then press enter.
                To login using an existing account type '-signin' then press enter.
                To quit the app at any stage, type '-quit' then press enter.""");
        
            System.out.println("Please enter a command: ");
            currinput = sc.nextLine();
            if (currinput.equals ("-register")) {
                System.out.println("Enter your email: ");
                currinput = sc.nextLine();
                while (currinput.equals("")) {
                    System.out.println("Input empty. Please enter your info:");
                    currinput = sc.nextLine();
                }

                while (currinput.equals("-register") || currinput.equals("-signin")) {
                    System.out.println("Invalid input. Please enter your info:");
                    currinput = sc.nextLine();
                }

                if (currinput.equals("-quit")){
                    break;
                }

                user.setRegemail (currinput);

                System.out.println("Enter your username: ");
                currinput = sc.nextLine();

                while (currinput.equals("")) {
                    System.out.println("Input empty. Please enter your info:");
                    currinput = sc.nextLine();
                }

                while (currinput.equals("-register") || currinput.equals("-signin")) {
                    System.out.println("Invalid input. Please enter your info:");
                    currinput = sc.nextLine();
                }

                if (currinput.equals("-quit")){
                    break;
                }

                user.setRegusername(currinput);
                System.out.println("Enter your password: ");
                currinput = sc.nextLine();
               
                while (currinput.equals ("")) {
                    System.out.println("Input empty. Please enter your info:");
                    currinput = sc.nextLine();
                }

                while (currinput.equals("-register") || currinput.equals("-signin")) {
                    System.out.println("Invalid input. Please enter your info:");
                    currinput = sc.nextLine();
                }

                if (currinput.equals("-quit")){
                    break;
                }

                user.setRegpassword(currinput);
                System.out.println("Registering...");
                if (register (user) == 1){
                    System.out.println("You have been successfully registered! You can now sign in by typing '-signin' or quit by typing '-quit'.");
                }
                else {
                    System.out.println("Registration failed! Please restart the process by typing '-register'.");
                }
            }
            else if (currinput.equals ("-signin")) {
                System.out.println("Enter your username: ");
                currinput = sc.nextLine();
                while (currinput.equals("")) {
                    System.out.println("Input empty. Please enter your info:");
                    currinput = sc.nextLine();
                }

                while (currinput.equals("-register") || currinput.equals("-signin")) {
                    System.out.println("Invalid input. Please enter your info:");
                    currinput = sc.nextLine();
                }

                if (currinput.equals("-quit")){
                    break;
                }

                user.setLogusername(currinput);
                System.out.println("Enter your password: ");
                currinput = sc.nextLine();
                while (currinput.equals ("")) {
                    System.out.println("Input empty. Please enter your info:");
                    currinput = sc.nextLine();
                }

                while (currinput.equals("-register") || currinput.equals("-signin")) {
                    System.out.println("Invalid input. Please enter your info:");
                    currinput = sc.nextLine();
                }

                if (currinput.equals("-quit")){
                    break;
                }

                user.setLogpassword(currinput);
                System.out.println("Signing in...");
                if (verify (0, user) == 1){
                    System.out.println("Welcome to the other side! Once you finish basking in the brilliance of our success, you can return to the main lobby by typing '-signout'.");
                }
                else {
                    System.out.println("Incorrect Username/Password! Please provide your correct credentials after typing '-signin'.");
                }

                while(! currinput.equals("-signout")){
                    currinput = sc.nextLine();
                    System.out.println("<< User Activity >>");
                }
                System.out.println("Signing out...");
            }
            else{
                if (currinput.equals("-quit")){
                    break;
                }

                System.out.println("Please enter a valid command!");
            }
        }

        System.out.println("Closing app...");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ei) {
            ei.printStackTrace();
        }
        sc.close();
        System.exit(0);

    }
}
