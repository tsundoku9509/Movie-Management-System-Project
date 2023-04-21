/**
 * 
 */
package projmays.beans;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Austin Mays - ajmays CIS175 - Spring 2023 04/07/2023
 */
@Entity
@Table(name = "employee_schedule")
@Embeddable
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "assigned_work")
	private int assignedTheater;
	@Column(name = "dates_assigned")
	private LocalTime dateWorking;
	@Column(name = "hours")
	private double hours;

	public Employee() {
		super();
	}

	public Employee(String fName) {
		super();
		this.firstName = fName;
	}

	public Employee(String fName, String lName) {
		super();
		this.firstName = fName;
		this.lastName = lName;
	}

	public Employee(String fName, String lName, int assigned) {
		super();
		this.firstName = fName;
		this.lastName = lName;
		this.assignedTheater = assigned;
	}

	public Employee(String fName, String lName, int assigned, LocalTime dateWorking) {
		super();
		this.firstName = fName;
		this.lastName = lName;
		this.assignedTheater = assigned;
		this.dateWorking = dateWorking;
	}

	public Employee(String fName, String lName, int assigned, LocalTime dateWorking, double hours) {
		super();
		this.firstName = fName;
		this.lastName = lName;
		this.assignedTheater = assigned;
		this.dateWorking = dateWorking;
		this.hours = hours;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAssignedWork() {
		return assignedTheater;
	}

	public void setAssignedWork(int assignedTheater) {
		this.assignedTheater = assignedTheater;
		BusiestTheater busy = new BusiestTheater();
		busy.setBusiestTheaterNum(assignedTheater);
	}

	public LocalTime getDateWorking() {
		return dateWorking;
	}

	public void setDateWorking(LocalTime dateWorking) {
		this.dateWorking = dateWorking;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "First Name :" + this.firstName + " | Last Name: " + this.lastName + " | Assigned Theater Number: "
				+ this.assignedTheater + " | Dates Assigned: " + this.dateWorking + " | Hours Assigned: " + this.hours
				+ ".";
	}

}
