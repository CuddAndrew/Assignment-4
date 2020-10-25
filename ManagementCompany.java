/*
 Class: CMSC203 CRN 25800
 Program: Assignment 4
 Instructor: Prof. Grinberg
 Summary of Description: a program that creates a property management company where you can add properties to a plot and perform different function
 Due Date: 10/25/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student: Andrew Cudd
*/
public class ManagementCompany {

	private int MAX_WIDTH = 10, MAX_DEPTH = 10, count = 0;
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name, taxID;
	private Property[] properties;
	private Plot plot;

	/**
	 * default constructor
	 */
	public ManagementCompany() {
		properties = new Property[MAX_PROPERTY];
		name = "";
		taxID = "";
		plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
	}

	/**
	 * Copy constructor
	 * 
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		properties = new Property[MAX_PROPERTY];
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
	}

	/**
	 * constructor with params w/o plot
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFeePer
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
	}

	/**
	 * Constructor with params w plot
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFeePer
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * get max property method to return max property
	 * 
	 * @return MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	/**
	 * getPlot method to return the plot
	 * 
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * getName method to return the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * add property method to add a property to the array with a premade property
	 * and return a number based on the result
	 * 
	 * @param property
	 * @return count - 1
	 */
	public int addProperty(Property property) {
		int i;
		for (i = 0; i < count; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}
		if (count == MAX_PROPERTY) {
			return -1;
		}
		if (property == null) {
			return -2;

		}
		if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		} else {
			properties[count] = property;
			count++;
			return count - 1;
		}
	}

	/**
	 * add property method to add a property to the array with arguments w/o plot
	 * and return a number based on the result
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return count - 1
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		// create a property object.
		Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
		// adds the property object to properties array.
		properties[count] = property;
		count++;
		int i;
		for (i = 0; i < count; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}
		if (count == MAX_PROPERTY) {
			return -1;
		}
		if (!this.plot.encompasses(property.getPlot())) {
			// else if()
			return -3;
		} else {
			properties[count] = property;
			count++;
			return count - 1;
		}
	}

	/**
	 * add property method to add a property to the array with arguments w/ plot and
	 * return a number based on the result
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		int i;
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		properties[count] = property;
		for (i = 0; i < count; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}
		if (count == MAX_PROPERTY) {
			return -1;
		} else if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		} else {
			properties[count] = property;
			count++;
			return count - 1;
		}
	}

	/**
	 * A method that adds up all the amounts of rent.
	 * 
	 * @return totalRent
	 */
	public double totalRent() {
		double totalRent = 0.0;
		for (int i = 0; i < count; i++) {
			if (properties[i] != null) {
				totalRent += properties[i].getRentAmount();
			}
		}
		return totalRent;
	}

	/**
	 * finds the property with the highest rent
	 * 
	 * @return maxRentAmount
	 */
	public double maxRentProp() {
		double maxRentAmount = 0.0;
		maxRentAmount = properties[maxPropertyRentIndex()].getRentAmount();
		return maxRentAmount;
	}

	/**
	 * finds the index of the property with the highest rent
	 * 
	 * @return maxRent
	 */
	public int maxPropertyRentIndex() {
		int maxRent = 0;
		for (int i = 0; i < count; i++) {
			if (properties[i] != null) {
				if (properties[maxRent].getRentAmount() < properties[i].getRentAmount()) {
					maxRent = i;
				}
			}
		}
		return maxRent;
	}

	/**
	 * displays the info of the property at the parameter
	 * 
	 * @param i
	 * @return str
	 */
	public String displayPropertyAtIndex(int i) {
		String str = "";
		if (properties[i] != null) {
			str = ("Owner: " + properties[i].getOwner() + "City: " + properties[i].getCity() + "Property Name: "
					+ properties[i].getPropertyName() + "Rent Amount: " + properties[i].getRentAmount() + "Plot: "
					+ properties[i].getPlot());
		}
		return str;
	}

	/**
	 * displays all of the properties
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "";
		System.out.println("List of the properties for Alliance, taxID: " + taxID);
		System.out.println("__________________________________________________");
		for (int i = 0; i < count; i++) {
			if (properties[i] != null)
				str = (" Property Name: " + properties[i].getPropertyName() + "\n" + "  Located in: "
						+ properties[i].getCity() + "\n" + "  Belonging to: " + properties[i].getOwner() + "\n"
						+ "  Rent Amount: " + properties[i].getRentAmount());
		}
		System.out.println("__________________________________________________");
		System.out.println("Total management Fee: " + mgmFeePer);
		System.out.println("Created by: Andrew Cudd");
		return str;
	}
}
