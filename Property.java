/*
 Class: CMSC203 CRN 25800
 Program: Assignment 4
 Instructor: Prof. Grinberg
 Summary of Description: This class creates a property with a plot to be used in the ManagmentCompany class
 Due Date: 10/25/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student: Andrew Cudd
*/
public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;

	/**
	 * default constructor
	 */
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0;
		plot = new Plot();
	}

	/**
	 * Copy Constructor
	 * 
	 * @param p
	 */
	public Property(Property p) {
		propertyName = p.propertyName;
		city = p.city;
		owner = p.owner;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}

	/**
	 * Constructor with params w/o plot
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}

	/**
	 * constructor with arguments with plot
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}

	/**
	 * returns property name
	 * 
	 * @return propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * sets property name to parameter
	 * 
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * returns city
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * sets city to parameter
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * returns owner
	 * 
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * sets owner to parameter
	 * 
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * returns rent amount
	 * 
	 * @return rentamount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * sets rent amount to parameter
	 * 
	 * @param rentAmount
	 */
	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * returns plot
	 * 
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * creates a plot with the params as arguments
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return plot
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
		return plot;
	}
}
