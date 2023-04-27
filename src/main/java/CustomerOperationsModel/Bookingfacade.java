package CustomerOperationsModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class Bookingfacade{

    private final String path;

    public Bookingfacade(String path) {
        this.path = path;
    }

    public boolean checkParkingSpace(String spotName) throws IOException {
    	String line = "";
		String[] val = null;
		boolean isExists = false;
		
 		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			while ((line = bfr.readLine())!= null) {
				val = line.split(",");

				List<String> lst = Arrays.asList(val);
				System.out.println(lst);
				System.out.println("spotName:" + lst.get(5));
				
				if (lst.get(5).contains(spotName)) {
					isExists = true;
					String msg = "Spot is occupied";
					System.out.println("is exists = " + isExists + "; " + msg);
					break;
				} else {
					String msg = "Spot is free";
					System.out.println("is exists = " + isExists + "; " + msg);
					isExists = false;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isExists;
	
}
public static void main(String[] args) throws IOException {
    String path = "parking.csv";
    Bookingfacade parkingFacade = new Bookingfacade(path);
    String spotName = "A1";
    boolean isOccupied = parkingFacade.checkParkingSpace(spotName);
    if (isOccupied) {
        System.out.println("The spot " + spotName + " is occupied.");
    } else {
        System.out.println("The spot " + spotName + " is free.");
    }

}}