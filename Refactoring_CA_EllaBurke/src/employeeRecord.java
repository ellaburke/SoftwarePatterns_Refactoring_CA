import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class employeeRecord {
	
	EmployeeDetails parent;
	// holds current Employee object
	static Employee currentEmployee;
	// hold object start position in file
	private static long currentByteStart = 0;
	// hold object start position in file
	//	private long currentByteStart = 0;
	private static RandomFile application = new RandomFile();
	// hold file name and path for current file in use
	private static File file;
	
	// find byte start in file for first active record
	public static Employee firstRecord(File file, Long currentByteStart) {
		// if any active record in file look for first record
		if (EmployeeDetails.isSomeoneToDisplay()) {
			// open file for reading
			application.openReadFile(file.getAbsolutePath());
			// get byte start in file for first record
			currentByteStart = application.getFirst();
			// assign current Employee to first record in file
			currentEmployee = application.readRecords(currentByteStart);
			application.closeReadFile();// close file for reading
			// if first record is inactive look for next record
			if (currentEmployee.getEmployeeId() == 0)
				currentEmployee = nextRecord(file, currentByteStart);// look for next record
		} // end if
		return currentEmployee;
	}// end firstRecord

	// find byte start in file for previous active record
	public static Employee previousRecord(File file, Long currentByteStart) {
		// if any active record in file look for first record
		if (EmployeeDetails.isSomeoneToDisplay()) {
			// open file for reading
			application.openReadFile(file.getAbsolutePath());
			// get byte start in file for previous record
			currentByteStart = application.getPrevious(currentByteStart);
			// assign current Employee to previous record in file
			currentEmployee = application.readRecords(currentByteStart);
			// loop to previous record until Employee is active - ID is not 0
			while (currentEmployee.getEmployeeId() == 0) {
				// get byte start in file for previous record
				currentByteStart = application.getPrevious(currentByteStart);
				// assign current Employee to previous record in file
				currentEmployee = application.readRecords(currentByteStart);
			} // end while
			application.closeReadFile();// close file for reading
		}
		return currentEmployee;
	}// end previousRecord

	// find byte start in file for next active record
	public static Employee nextRecord(File file, Long currentByteStart) {
		// if any active record in file look for first record
		if (EmployeeDetails.isSomeoneToDisplay()) {
			// open file for reading
			application.openReadFile(file.getAbsolutePath());
			// get byte start in file for next record
			currentByteStart = application.getNext(currentByteStart);
			// assign current Employee to record in file
			currentEmployee = application.readRecords(currentByteStart);
			// loop to previous next until Employee is active - ID is not 0
			while (currentEmployee.getEmployeeId() == 0) {
				// get byte start in file for next record
				currentByteStart = application.getNext(currentByteStart);
				// assign current Employee to next record in file
				currentEmployee = application.readRecords(currentByteStart);
			} // end while
			application.closeReadFile();// close file for reading
		} // end if
		return currentEmployee;
	}// end nextRecord

	// find byte start in file for last active record
	public static Employee lastRecord(File file, Long currentByteStart) {
		// if any active record in file look for first record
		if (EmployeeDetails.isSomeoneToDisplay()) {
			// open file for reading
			application.openReadFile(file.getAbsolutePath());
			// get byte start in file for last record
			currentByteStart = application.getLast();
			// assign current Employee to first record in file
			currentEmployee = application.readRecords(currentByteStart);
			application.closeReadFile();// close file for reading
			// if last record is inactive look for previous record
			if (currentEmployee.getEmployeeId() == 0)
				currentEmployee = previousRecord(file, currentByteStart);// look for previous record
		} // end if
		return currentEmployee;
	}// end lastRecord
	


}
