package com.glacialrush.map;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import com.glacialrush.cameras.util.Math;

public class SubMap extends MapRenderer
{
	private int sx;
	private int sy;
	private long lms;
	private long tft;
	private MapDisplay display;
	
	public SubMap(int sx, int sy, MapDisplay display)
	{
		this.sx = sx;
		this.sy = sy;
		this.lms = System.currentTimeMillis();
		this.tft = Math.getFrameTime(display.getTargetFrameRate());
		this.display = display;
	}
	
	@Override
	public void render(MapView view, MapCanvas canvas, Player player)
	{
		if(System.currentTimeMillis() - lms < tft)
		{
			return;
		}
		
		display.render(sx, sy, canvas);
		lms = System.currentTimeMillis();
	}
}
