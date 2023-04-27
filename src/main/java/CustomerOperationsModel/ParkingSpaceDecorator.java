
package CustomerOperationsModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Interfaces.CSVOps;
//creating interface or abstract class


//component implementation 


//Decorator class implementation

public class ParkingSpaceDecorator {
    private ParkingSpace parkingSpace;
    
    
    public interface ParkingSpace {
        void bookparkingSpace(String userName, String bookingID, String date, String time, String duration,String spotName, String price, String paymentStat, String licenceNum) throws IOException;
    }


    public ParkingSpaceDecorator(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
    
    public class BasicParkingSpace implements ParkingSpace {
        private String path;

        public BasicParkingSpace(String path) {
            this.path = path;
        }


        public void bookparkingSpace(String userName, String bookingID, String date, String time, String duration, String spotName, String price, String paymentStat, String licenceNum) throws IOException {
            File fw = new File(path);
            FileWriter fwt = new FileWriter(fw, true);
            BufferedWriter bfw = new BufferedWriter(fwt);
            PrintWriter pw = new PrintWriter(bfw);

            if (!fw.exists()) {
                fw.createNewFile();
                System.out.println("File exists");
            } else {
                System.out.println("File doesn't exist");
            }

            pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", userName,bookingID,date,time,duration,spotName,price,paymentStat,licenceNum);
            pw.flush();
            pw.close();
        }
    }
    
    public class BasicParkingspace implements ParkingSpace {
        private String path;

        public BasicParkingspace(String path) {
            this.path = path;
        }

        
        public void bookparkingSpace(String userName, String bookingID, String date, String time, String duration, String spotName, String price, String paymentStat, String licenceNum) throws IOException {
            File fw = new File(path);
            FileWriter fwt = new FileWriter(fw, true);
            BufferedWriter bfw = new BufferedWriter(fwt);
            PrintWriter pw = new PrintWriter(bfw);

            if (!fw.exists()) {
                fw.createNewFile();
                System.out.println("File exists");
            } else {
                System.out.println("File doesn't exist");
            }

            pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", userName,bookingID,date,time,duration,spotName,price,paymentStat,licenceNum);
            pw.flush();
            pw.close();
        }
    }


    
    public void bookparkingSpace(String userName, String bookingID, String date, String time, String duration, String spotName, String price, String paymentStat, String licenceNum) throws IOException {
        // Add additional functionality before calling the underlying bookparkingSpace method
        System.out.println("Performing additional actions before booking parking space...");

        // Call the underlying bookparkingSpace method
        parkingSpace.bookparkingSpace(userName, bookingID, date, time, duration, spotName, price, paymentStat, licenceNum);

        // Add additional functionality after calling the underlying bookparkingSpace method
        System.out.println("Performing additional actions after booking parking space...");
    }
    
    public static void main(String[] args) throws IOException {
        //ParkingSpace parkingSpace = new ParkingSpaceDecorator(new BasicParkingSpace("parking.csv"));
        //parkingSpace.bookparkingSpace("John Doe", "1234", "2023-05-01", "12:00", "1 hour", "A1", "$10", "paid", "AB1234");
    }
}



