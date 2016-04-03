package com.glacialrush.map;

import org.bukkit.map.MapCanvas;

import com.glacialrush.cameras.util.Math;

public class MapDisplay
{
	private int width;
	private int height;
	private byte[][] rasterized;
	private int targetFrameRate;
	
	public MapDisplay(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.rasterized = new byte[width][height];
	}
	
	public void render(int x, int y, MapCanvas canvas)
	{
		int ax = 0;
		int ay = 0;
		
		for(int i = Math.getMapStart(x); i < Math.shiftMapEnd(x) + 1; i++)
		{
			ax++;
			
			for(int j = Math.getMapStart(y); j < Math.shiftMapEnd(y) + 1; j++)
			{
				ay++;
				
				canvas.setPixel(ax, ay, rasterized[i][j]);
			}
		}
	}
	
	public void clear(byte c)
	{
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				rasterized[i][j] = c;
			}
		}
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getTargetFrameRate()
	{
		return targetFrameRate;
	}
}
