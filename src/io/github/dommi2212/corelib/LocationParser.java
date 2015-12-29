/* This file is part of dommi2212's CoreLib. https://github.com/dommi2212/corelib
 * 
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 dommi2212 (https://github.com/dommi2212/)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.github.dommi2212.corelib;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationParser {
	
	public static String parseString(Location loc) {
		String string = loc.getWorld().getName() + "_" + loc.getX() + "_" + loc.getY() + "_" + loc.getZ();
		if(loc.getYaw() != 0 || loc.getPitch() != 0) {
			string += ("_" + loc.getYaw() + "_" + loc.getPitch());
		}
		
		return string;
	}
	
	public static Location parseLocation(String string) {
		String[] split = string.split("_");
		if(split.length == 4) {
			return new Location(Bukkit.getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
		} else if(split.length == 6) {
			return new Location(Bukkit.getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]));
		} else {
			throw new IllegalArgumentException("Location \"" + string + "\" has an illegal format!");
		}
	}
	
	public static Location parseLocation(World world, String string) {
		String[] split = string.split("_");
		if(split.length == 3) {
			return new Location(world, Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
		} else if(split.length == 5) {
			return new Location(world, Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Float.parseFloat(split[3]), Float.parseFloat(split[4]));
		} else {
			throw new IllegalArgumentException("Location \"" + string + "\" with additional world-argument has an illegal format!");
		}
	}
	
	public static List<Location> parseAllLocations(List<String> strings) {
		List<Location> locations = new ArrayList<Location>();
		for(String string : strings) {
			locations.add(parseLocation(string));
		}
		return locations;
	}
	
	public static List<String> parseAllStrings(List<Location> locations) {
		List<String> strings = new ArrayList<String>();
		for(Location location : locations) {
			strings.add(parseString(location));
		}
		return strings;
	}
	
	public static List<Location> parseAllLocations(World world, List<String> strings) {
		List<Location> locations = new ArrayList<Location>();
		for(String string : strings) {
			locations.add(parseLocation(world, string));
		}
		return locations;
	}
}