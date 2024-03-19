package project;
/**
* Country class that holds all information given about counties detailed
* in Countries1.csv
*
* @author Daniel Reinecke
* @version 11/16/2023
*/
public class Country
{
	
	/** The name. */
	private String name;
	
	/** The capitol. */
	private String capitol;
	
	/** The population. */
	private String population;
	
	/** The gdp. */
	private String GDP;
	
	/** The area. */
	private String area;
	
	/** The happiness index. */
	private String happinessIndex;
	
	/**
	 * Instantiates a new country.
	 *
	 * @param name the name
	 * @param capitol the capitol
	 * @param population the population
	 * @param GDP the gdp
	 * @param area the area
	 * @param happinessIndex the happiness index
	 */
	public Country(String name, String capitol, String population, String GDP, String area, String happinessIndex)
	{
		this.name = name;
		this.capitol = capitol;
		this.population = population;
		this.GDP = GDP;
		this.area = area;
		this.happinessIndex = happinessIndex;
		
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param s the new name
	 */
	public void setName(String s)
	{
		this.name = s;
	}
	
	/**
	 * Gets the capitol.
	 *
	 * @return the capitol
	 */
	public String getCapitol()
	{
		return this.capitol;
	}
	
	/**
	 * Sets the capitol.
	 *
	 * @param s the new capitol
	 */
	public void setCapitol(String s)
	{
		this.capitol = s;
	}
	
	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	public String getPopulation()
	{
		return this.population;
	}
	
	/**
	 * Sets the population.
	 *
	 * @param s the new population
	 */
	public void setPopulation(String s)
	{
		this.population = s;
	}
	
	/**
	 * Gets the GDP.
	 *
	 * @return the GDP
	 */
	public String getGDP()
	{
		return this.GDP;
	}
	
	/**
	 * Sets the GDP.
	 *
	 * @param s the new GDP
	 */
	public void setGDP(String s)
	{
		this.GDP = s;
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public String getArea()
	{
		return this.area;
	}
	
	/**
	 * Sets the area.
	 *
	 * @param s the new area
	 */
	public void setArea(String s)
	{
		this.area = s;
	}
	
	/**
	 * Gets the sets the happiness index.
	 *
	 * @return the sets the happiness index
	 */
	public String getsetHappinessIndex()
	{
		return this.happinessIndex;
	}
	
	/**
	 * Sets the happiness index.
	 *
	 * @param s the new happiness index
	 */
	public void setHappinessIndex(String s)
	{
		this.happinessIndex = s;
	}
	/**
	 * Prints the country report.
	 *
	 * 
	 */
	public void printContryReport()
	{
		double pop = Double.parseDouble(this.getPopulation());
		double GDP = Double.parseDouble(this.getGDP());
		double area = Double.parseDouble(this.getArea());
		double GDPPC = GDP / pop;
		double APC = area / pop;
		double happy = Double.parseDouble(this.getsetHappinessIndex());
		System.out.printf("%-35s %-16s %-13.3f %-20.6f %-10.3f \n", this.getName(),this.getCapitol() , GDPPC , APC , happy);
	}
}
