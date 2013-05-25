package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class LogUtil
{
	static
	{
		File file = new File("result.log");
		file.delete();
		try
		{
			file.createNewFile();
			System.out.println(file.getAbsolutePath());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void log(int[] arr)
	{
		log(arr, false);
	}
	public static void log(int[] arr, boolean logToFile)
	{
		if(logToFile)
		{
			writeToFile(arr);
		}
		else
		{
			for(int i = 0; i < arr.length; i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
		}
	}
	private static void writeToFile(int[] arr)
	{
		BufferedWriter bwriter = null;
		try
		{
			FileOutputStream fos = new FileOutputStream(new File("result.log"), true);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			bwriter = new BufferedWriter(writer);
			for(int i = 0; i < arr.length; i++)
			{
				bwriter.write(arr[i] + " ");
				if(i % 5000 == 0)
				{
					bwriter.flush();
				}
			}
			bwriter.write("\r\n\r\n====================================================================================================\r\n\r\n");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(bwriter != null)
			{
				try
				{
					bwriter.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}