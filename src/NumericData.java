
public class NumericData 
{
	/**
	 * constructor
	 */
	public NumericData()
	{
	}
	
	
	
	/**
	 * function primeNumber(value)
	 * @param value
	 * @return boolean
	 */
	public boolean primeNumber(int value)
	{
		for(int i = 2; i <= value/2; i++)
		{
			if(value % i == 0)
			{
				return true;
			}
		}
		return false;
	}
}
