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

import org.bukkit.enchantments.Enchantment;

public class EnchantmentNames {
	
	@SuppressWarnings("deprecation")
	public static String getName(Enchantment ench) {
		switch (ench.getId()) {
		
		/* Armor */
		case 0:
			return "Protection";
		case 1:
			return "Fire Protection";
		case 2:
			return "Feather Falling";
		case 3:
			return "Blast Protection";
		case 4:
			return "Projectile Protection";
		case 5:
			return "Respiration";
		case 6:
			return "Aqua Affinity";
		case 7:
			return "Thorns";
		case 8:
			return "Depth Strider";
			
		/* Weapons/Tools */
		case 16:
			return "Sharpness";
		case 17:
			return "Smite";
		case 18:
			return "Bane of Arthropods";
		case 19:
			return "Knockback";
		case 20:
			return "Fire Aspect";
		case 21:
			return "Looting";
		case 32:
			return "Efficiency";
		case 33:
			return "Silk Touch";
		case 34:
			return "Unbreaking";
		case 35:
			return "Fortune";
			
		/* Bow */
		case 48:
			return "Power";
		case 49:
			return "Punch";
		case 50:
			return "Flame";
		case 51:
			return "Infinity";
		case 61:
			return "Luck of the Sea";
			
		/* Fishing */
		case 62:
			return "Lure";				
		default:
			return "Unknown";
		}
	}

}
