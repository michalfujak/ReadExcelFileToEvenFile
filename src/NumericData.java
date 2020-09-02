
public class NumericData 
{
	
	/**
	 * constructor
	 */
	public NumericData()
	{
	}
	
	
	/**
	 * function checkNumber(number)
	 * @param number
	 */
	public void checkNumber(int number)
	{
		try
		{
			if(number % 2 == 0)
			{
				// SUDE CISLO - Ignored
				// System.out.print("Sude cislo: " + number + " \n");
			}
			else
			{
				System.out.print("Liche cislo: " + number + "\n");
			}
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
}
