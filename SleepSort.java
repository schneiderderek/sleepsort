import java.util.Random; 

class sleepEl extends Thread
{
	private int wait; 
	public sleepEl(int wait)
	{
		this.wait = wait; 
	}
	public void run() 
	{
		try
		{
			sleep(10*wait);
		}
		catch(InterruptedException e)
		{
			System.out.println("Something went wrong");
		}
		System.out.print("|" + wait + "|");
	}
}

public class SleepSort
{
	public static void main (String [] args)
	{
		int[] arr = new int[30] ;
		Random rand = new Random()	;

		for(int a=0; a<arr.length; a++)
		{
			arr[a] = rand.nextInt(100) ;
		}
		printSorted(arr);
		
		
		try
		{
			Thread.sleep(1000);
			System.out.println("\nDone");
		}
		catch(InterruptedException e)
		{
			System.out.println("Something went wrong");
		}

	}
	public static void printSorted(int[] marray)
	{
		for(int a=0; a<marray.length; a++)
		{
			new sleepEl(marray[a]).start();
		}
	}
}
