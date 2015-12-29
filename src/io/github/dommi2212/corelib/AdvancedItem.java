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

import java.util.Arrays;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/*
* TODO:
* EnchantmentStorageMeta
* FireworkEffectMeta
* * FireworkMeta
*/

public class AdvancedItem {
	
	private ItemStack item;
	
	public AdvancedItem(Material material, String name, int count, int durability) {
		this.item = new ItemStack(material);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		item.setAmount(count);
		item.setDurability((short) durability);
	}
	
	public AdvancedItem(Material material, String name, int count, int durability, String... lore) {	
		this.item = new ItemStack(material);
		item.setAmount(count);
		item.setDurability((short) durability);
		
		ItemMeta meta = item.getItemMeta();	
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);	
	}
	
	public AdvancedItem(Material material, String name, int count, int durability, List<String> lore, WrappedEnchantment... enchs) {	
		this.item = new ItemStack(material);
		item.setAmount(count);
		item.setDurability((short) durability);
		
		ItemMeta meta = item.getItemMeta();	
		meta.setDisplayName(name);
		meta.setLore(lore);
		for(WrappedEnchantment enchantment : enchs) {
			meta.addEnchant(enchantment.getEnchantment(), enchantment.getLevel(), true);
		}
		item.setItemMeta(meta);	
	}
	
	public AdvancedItem(Material material, String name, int count, int durability, WrappedEnchantment... enchs) {	
		this.item = new ItemStack(material);
		item.setAmount(count);
		item.setDurability((short) durability);
		
		ItemMeta meta = item.getItemMeta();	
		meta.setDisplayName(name);
		for(WrappedEnchantment enchantment : enchs) {
			meta.addEnchant(enchantment.getEnchantment(), enchantment.getLevel(), true);
		}
		item.setItemMeta(meta);	
	}
	
	public AdvancedItem(ItemStack item) {
		this.item = item.clone();
	}

	public AdvancedItem setName(String name) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(name);
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setLore(List<String> lore) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setLore(lore);
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setLore(String... lore) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setLore(Arrays.asList(lore));
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem addEnchantments(WrappedEnchantment... enchs) {
		for(WrappedEnchantment ench : enchs) {
			this.item.addUnsafeEnchantment(ench.getEnchantment(), ench.getLevel());
		}
		return this;
	}
	
	public AdvancedItem addEnchantment(Enchantment ench, int level) {
		this.item.addUnsafeEnchantment(ench, level);
		
		return this;
	}
	
	public AdvancedItem addItemFlags(ItemFlag... flags) {
		ItemMeta meta = this.item.getItemMeta();
		meta.addItemFlags(flags);
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem removeItemFlags(ItemFlag... flags) {
		ItemMeta meta = this.item.getItemMeta();
		meta.removeItemFlags(flags);
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setAmount(int amount) {
		this.item.setAmount(amount);
		
		return this;
	}
	
	public AdvancedItem setDurability(short durability) {
		this.item.setDurability(durability);
		
		
		return this;
	}
	
	public AdvancedItem removeEnchantment(Enchantment ench) {
		this.item.removeEnchantment(ench);
		
		return this;
	}
	
	public AdvancedItem removeEnchantment(Enchantment... enchs) {
		for(Enchantment ench : enchs) this.item.removeEnchantment(ench);
		
		return this;
	}
	
	public AdvancedItem setMaterialData(MaterialData data) {
		this.item.setData(data);
		
		return this;
	}
	
	public AdvancedItem setItemMeta(ItemMeta meta) {
		this.item.setItemMeta(meta);
		
		return this;
	}	
	
	public AdvancedItem setUnbreakable(boolean toSet) {
		ItemMeta meta = this.item.getItemMeta();
		meta.spigot().setUnbreakable(toSet);
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setBannerPattern(Pattern pattern) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BannerMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BannerMeta");
		BannerMeta meta = (BannerMeta) itemMeta;
		meta.addPattern(pattern);		
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setBannerBaseColor(DyeColor color) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BannerMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BannerMeta");
		BannerMeta meta = (BannerMeta) itemMeta;
		meta.setBaseColor(color);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setBannerPattern(int i, Pattern pattern) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BannerMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BannerMeta");
		BannerMeta meta = (BannerMeta) itemMeta;
		meta.setPattern(i, pattern);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setBannerPatterns(List<Pattern> patterns) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BannerMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BannerMeta");
		BannerMeta meta = (BannerMeta) itemMeta;
		meta.setPatterns(patterns);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem addBookPage(String... page) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BookMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BookMeta");
		BookMeta meta = (BookMeta) itemMeta;
		meta.addPage(page);
		
		this.item.setItemMeta(meta);
		
		return this;
	}	
	
	public AdvancedItem setBookAuthor(String author) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BookMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BookMeta");
		BookMeta meta = (BookMeta) itemMeta;
		meta.setAuthor(author);
		
		this.item.setItemMeta(meta);
		
		return this;
	}	
	
	public AdvancedItem setBookPage(int index, String page) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BookMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BookMeta");
		BookMeta meta = (BookMeta) itemMeta;
		meta.setPage(index, page);
		
		this.item.setItemMeta(meta);
		
		return this;
	}	
	
	public AdvancedItem setBookPages(List<String> pages) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BookMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BookMeta");
		BookMeta meta = (BookMeta) itemMeta;
		meta.setPages(pages);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setBookPages(String... pages) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BookMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BookMeta");
		BookMeta meta = (BookMeta) itemMeta;
		meta.setPages(pages);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setBookTitle(String title) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof BookMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: BookMeta");
		BookMeta meta = (BookMeta) itemMeta;
		meta.setTitle(title);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setSkullOwner(String owner) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof SkullMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: SkullMeta");
		SkullMeta meta = (SkullMeta) itemMeta;
		meta.setOwner(owner);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setLeatherArmorColor(Color color) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof LeatherArmorMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: LeatherArmorMeta");
		LeatherArmorMeta meta = (LeatherArmorMeta) itemMeta;
		meta.setColor(color);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setMapScaling(boolean scaling) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof MapMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: MapMeta");
		MapMeta meta = (MapMeta) itemMeta;
		meta.setScaling(scaling);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
		
	public AdvancedItem addPotionCustomEffect(PotionEffect effect, boolean overwrite) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof PotionMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: PotionMeta");
		PotionMeta meta = (PotionMeta) itemMeta;
		meta.addCustomEffect(effect, overwrite);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem potionClearCustomEffects() {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof PotionMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: PotionMeta");
		PotionMeta meta = (PotionMeta) itemMeta;
		meta.clearCustomEffects();
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem removePotionCustomEffect(PotionEffectType type) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof PotionMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: PotionMeta");
		PotionMeta meta = (PotionMeta) itemMeta;
		meta.removeCustomEffect(type);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public AdvancedItem setPotionMainEffect(PotionEffectType type) {
		ItemMeta itemMeta = this.item.getItemMeta();
		if(!(itemMeta instanceof PotionMeta)) 
			throw new IllegalArgumentException("Can't invoke method on this AdvancedItem! Required meta: PotionMeta");
		PotionMeta meta = (PotionMeta) itemMeta;
		meta.setMainEffect(type);
		
		this.item.setItemMeta(meta);
		
		return this;
	}
	
	public ItemStack toItem() {
		return item.clone();
	}
	
	public void addToInventory(Inventory inv) {
		inv.addItem(item.clone());
	}
	
	public void addToInventory(Inventory inv, int... slots) {
		for(int i = 0; i < slots.length; i++) inv.setItem(slots[i], item.clone());
	}
	
	public void addToInventoryIndexed(Inventory inv, int begin, int end) {
		for(int i = begin; i < end; i++) {
			inv.setItem(i, item.clone());
		}
	}
}