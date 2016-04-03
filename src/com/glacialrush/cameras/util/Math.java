package com.glacialrush.cameras.util;

public class Math
{
	public static int shiftMapSection(int b)
	{
		return b >> 7;
	}
	
	public static int getMapStart(int s)
	{
		return s << 7;
	}
	
	public static int shiftMapEnd(int s)
	{
		return getMapStart(s) + 127;
	}
	
	public static long getFrameTime(int frameRate)
	{
		if(frameRate < 1)
		{
			frameRate = 30;
		}
		
		return (long) ((double) ((1 / frameRate) * 1000.0));
	}
	
	public static int getFrameRate(long frameTime)
	{
		return (int) (1000 / frameTime);
	}
}
