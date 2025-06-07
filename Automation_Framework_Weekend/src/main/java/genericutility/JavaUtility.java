package genericutility;

import java.time.LocalDateTime;
import java.util.Random;
/**
 * @author Arpitha
 */
public class JavaUtility 
{
	/**
	 * This method is used to capture current system date and time and replace : with -
	 * @return System date and time
	 */
	public String getSystemTime()
	{
		return LocalDateTime.now().toString().replace(":","-");
	}
	/**
	 * this method will return random numbers within 100
	 * @return random numbers
	 */
	public int getRandom()
	{
		Random ran = new Random();
		return ran.nextInt(100); //gives random number with 100
	}

}
