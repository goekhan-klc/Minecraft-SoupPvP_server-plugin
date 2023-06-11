/*     */ package net.kiligo.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.bukkit.DyeColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.SkullMeta;
/*     */ import org.bukkit.material.Dye;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class getItemHandler
/*     */ {
/*     */   public static ItemStack getItem(Material material, String name, String lore) {
/*  20 */     ItemStack itemstack = new ItemStack(material);
/*  21 */     ItemMeta meta = itemstack.getItemMeta();
/*  22 */     if (lore != null) {
/*  23 */       if (lore.contains("\n")) {
/*     */         
/*  25 */         ArrayList<String> lorename = new ArrayList<>();
/*  26 */         String[] loresplit = lore.split("\n"); byte b; int i; String[] arrayOfString1;
/*  27 */         for (i = (arrayOfString1 = loresplit).length, b = 0; b < i; ) { String text = arrayOfString1[b];
/*  28 */           lorename.add(text); b++; }
/*     */         
/*  30 */         meta.setLore(lorename);
/*     */       }
/*     */       else {
/*     */         
/*  34 */         meta.setLore(Arrays.asList(new String[] { lore }));
/*     */       } 
/*     */     }
/*  37 */     meta.setDisplayName(name);
/*  38 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*  39 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
/*  40 */     itemstack.setItemMeta(meta);
/*     */     
/*  42 */     return itemstack;
/*     */   }
/*     */   
/*     */   public static ItemStack getItemEnch(Material material, String name, String lore, Enchantment ench) {
/*  46 */     ItemStack itemstack = new ItemStack(material);
/*  47 */     ItemMeta meta = itemstack.getItemMeta();
/*  48 */     if (lore != null) {
/*  49 */       if (lore.contains("\n")) {
/*     */         
/*  51 */         ArrayList<String> lorename = new ArrayList<>();
/*  52 */         String[] loresplit = lore.split("\n"); byte b; int i; String[] arrayOfString1;
/*  53 */         for (i = (arrayOfString1 = loresplit).length, b = 0; b < i; ) { String text = arrayOfString1[b];
/*  54 */           lorename.add(text); b++; }
/*     */         
/*  56 */         meta.setLore(lorename);
/*     */       }
/*     */       else {
/*     */         
/*  60 */         meta.setLore(Arrays.asList(new String[] { lore }));
/*     */       } 
/*     */     }
/*  63 */     meta.setDisplayName(name);
/*  64 */     meta.addEnchant(ench, 1, true);
/*  65 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  66 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*  67 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
/*  68 */     itemstack.setItemMeta(meta);
/*     */     
/*  70 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack getHead(String PlayerName, String name, String lore, int amount) {
/*  76 */     ItemStack itemstack = new ItemStack(Material.SKULL_ITEM, amount, (short)3);
/*  77 */     SkullMeta meta = (SkullMeta)itemstack.getItemMeta();
/*  78 */     if (lore != null) {
/*  79 */       if (lore.contains("\n")) {
/*     */         
/*  81 */         ArrayList<String> lorelist = new ArrayList<>();
/*  82 */         String[] loresplit = lore.split("\n"); byte b; int i; String[] arrayOfString1;
/*  83 */         for (i = (arrayOfString1 = loresplit).length, b = 0; b < i; ) { String text = arrayOfString1[b];
/*  84 */           lorelist.add(text); b++; }
/*     */         
/*  86 */         meta.setLore(lorelist);
/*     */       }
/*     */       else {
/*     */         
/*  90 */         meta.setLore(Arrays.asList(new String[] { lore }));
/*     */       } 
/*     */     }
/*  93 */     meta.setOwner(PlayerName);
/*  94 */     meta.setDisplayName(name);
/*  95 */     itemstack.setItemMeta((ItemMeta)meta);
/*     */     
/*  97 */     return itemstack;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack getGlass(String name, int Color, int amount, List<String> lore) {
/* 102 */     ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, amount, (byte)Color);
/* 103 */     ItemMeta meta = is.getItemMeta();
/* 104 */     meta.setDisplayName(name);
/* 105 */     if (lore != null) {
/* 106 */       meta.setLore(lore);
/*     */     }
/* 108 */     is.setItemMeta(meta);
/* 109 */     return is;
/*     */   }
/*     */   
/*     */   public static ItemStack getDye(String name, DyeColor farbe) {
/* 113 */     Dye dye = new Dye();
/* 114 */     dye.setColor(farbe);
/* 115 */     ItemStack dyeitem = dye.toItemStack(1);
/* 116 */     ItemMeta dyemeta = dyeitem.getItemMeta();
/* 117 */     dyemeta.setDisplayName(name);
/* 118 */     dyemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 119 */     dyeitem.setItemMeta(dyemeta);
/* 120 */     return dyeitem;
/*     */   }
/*     */   
/*     */   public static ItemStack getDyeEnchant(String name, DyeColor farbe, Enchantment ench) {
/* 124 */     Dye dye = new Dye();
/* 125 */     dye.setColor(farbe);
/* 126 */     ItemStack dyeitem = dye.toItemStack(1);
/* 127 */     ItemMeta dyemeta = dyeitem.getItemMeta();
/* 128 */     dyemeta.setDisplayName(name);
/* 129 */     dyemeta.addEnchant(ench, 1, true);
/* 130 */     dyemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 131 */     dyeitem.setItemMeta(dyemeta);
/* 132 */     return dyeitem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack getClay(String name, int Color, int amount, List<String> lore) {
/* 138 */     ItemStack is = new ItemStack(Material.STAINED_CLAY, amount, (byte)Color);
/* 139 */     ItemMeta meta = is.getItemMeta();
/* 140 */     meta.setDisplayName(name);
/* 141 */     if (lore != null) {
/* 142 */       meta.setLore(lore);
/*     */     }
/* 144 */     is.setItemMeta(meta);
/* 145 */     return is;
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/getItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */