import java.awt.Color;
import java.io.File;

import javax.swing.JOptionPane;

public class Search {
	
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
	
	// search Employee by ID
		public static Employee searchEmployeeById() {
			boolean found = false;

			try {// try to read correct correct from input
					// if any active Employee record search for ID else do nothing
				if ((EmployeeDetails.isSomeoneToDisplay()) {
					currentEmployee = employeeRecord.firstRecord(file, currentByteStart);// look for first record
					int firstId = currentEmployee.getEmployeeId();
					// if ID to search is already displayed do nothing else loop
					// through records
					if ((EmployeeDetails.searchByIdField.getText().trim().equals(idField.getText().trim()))
						found = true;
					else if (EmployeeDetails.searchByIdField.getText().trim().equals(Integer.toString(currentEmployee.getEmployeeId()))) {
						found = true;
						displayRecords(currentEmployee);
					} // end else if
					else {
						currentEmployee = employeeRecord.nextRecord(file, currentByteStart);// look for next record
						// loop until Employee found or until all Employees have
						// been checked
						while (firstId != currentEmployee.getEmployeeId()) {
							// if found break from loop and display Employee details
							// else look for next record
							if (Integer.parseInt(EmployeeDetails.searchByIdField.getText().trim()) == currentEmployee.getEmployeeId()) {
								found = true;
								displayRecords(currentEmployee);
								break;
							} else
								currentEmployee = employeeRecord.nextRecord(file, currentByteStart);// look for next record
						} // end while
					} // end else
						// if Employee not found display message
					if (!found)
						JOptionPane.showMessageDialog(null, "Employee not found!");
				} // end if
			} // end try
			catch (NumberFormatException e) {
				EmployeeDetails.searchByIdField.setBackground(new Color(255, 150, 150));
				JOptionPane.showMessageDialog(null, "Wrong ID format!");
			} // end catch
			EmployeeDetails.searchByIdField.setBackground(Color.WHITE);
			EmployeeDetails.searchByIdField.setText("");
		}// end searchEmployeeByID

		// search Employee by surname
		public static Employee searchEmployeeBySurname() {
			boolean found = false;
			// if any active Employee record search for ID else do nothing
			if (EmployeeDetails.isSomeoneToDisplay()) {
				currentEmployee = employeeRecord.firstRecord(file, currentByteStart);// look for first record
				String firstSurname = currentEmployee.getSurname().trim();
				// if ID to search is already displayed do nothing else loop through
				// records
				if (EmployeeDetails.searchBySurnameField.getText().trim().equalsIgnoreCase(surnameField.getText().trim()))
					found = true;
				else if (EmployeeDetails.searchBySurnameField.getText().trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
					found = true;
					displayRecords(currentEmployee);
				} // end else if
				else {
					currentEmployee = employeeRecord.nextRecord(file, currentByteStart);// look for next record
					// loop until Employee found or until all Employees have been
					// checked
					while (!firstSurname.trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
						// if found break from loop and display Employee details
						// else look for next record
						if (EmployeeDetails.searchBySurnameField.getText().trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
							found = true;
							displayRecords(currentEmployee);
							break;
						} // end if
						else
							currentEmployee = employeeRecord.nextRecord(file, currentByteStart);// look for next record
					} // end while
				} // end else
					// if Employee not found display message
				if (!found)
					JOptionPane.showMessageDialog(null, "Employee not found!");
			} // end if
			EmployeeDetails.searchBySurnameField.setText("");
		}// end searchEmployeeBySurname


}
