/*     */ package net.kiligo.events;
/*     */ 
/*     */ import net.kiligo.kits.Kit;
/*     */ import net.kiligo.kits.KitManager;
/*     */ import net.kiligo.main.Game;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.kiligo.util.ConfigLocations;
/*     */ import net.kiligo.util.ScoreboardHandler;
/*     */ import net.kiligo.util.SettingsConfig;
/*     */ import net.kiligo.util.Var;
/*     */ import net.kiligo.util.getItemHandler;
/*     */ import net.kiligo.util.getTitleHandler;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ 
/*     */ public class ClickEvent
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onClick(InventoryClickEvent e) {
/*  27 */     Player p = (Player)e.getWhoClicked();
/*     */     
/*  29 */     if (e.getCurrentItem() != null && 
/*  30 */       e.getCurrentItem().hasItemMeta()) {
/*     */       
/*  32 */       if (e.getInventory().getTitle().equals("§bKits")) {
/*  33 */         e.setCancelled(true);
/*  34 */         for (Kit kits : KitManager.getKits()) {
/*  35 */           if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §b" + kits.getName())) {
/*  36 */             Game.openKitAuswahl(p, kits);
/*  37 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  42 */       if (e.getInventory().getTitle().equals("§bQueues")) {
/*  43 */         e.setCancelled(true);
/*     */         
/*  45 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNormal Fight")) {
/*  46 */           if (PvPQueue.isQueue(p)) {
/*  47 */             PvPQueue.removeQueue(p);
/*  48 */             p.sendMessage(String.valueOf(Var.getQueuePr()) + "§cYou §c§lleft §cthe PvP-Queue!");
/*  49 */             p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
/*  50 */             Game.openQueues(p);
/*  51 */             getTitleHandler.sendActionBar(p, "§8➤ §c§lLeft queue!");
/*  52 */             p.closeInventory();
/*  53 */             ScoreboardHandler.setScoreboard(p, "pvp");
/*     */           }
/*  55 */           else if (PvPQueue.isActivated()) {
/*  56 */             PvPQueue.addQueue(p);
/*  57 */             p.sendMessage(String.valueOf(Var.getQueuePr()) + "§aYou §a§ljoined §athe PvP-Queue!");
/*  58 */             p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
/*  59 */             Game.openQueues(p);
/*  60 */             ScoreboardHandler.setScoreboard(p, "pvp");
/*     */           } else {
/*  62 */             p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 2.0F);
/*  63 */             p.sendMessage(String.valueOf(Var.getQueuePr()) + "§cThe Queue is disabled..");
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  70 */       if (e.getInventory().getTitle().equals("§bSettings")) {
/*  71 */         e.setCancelled(true);
/*     */         
/*  73 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §bDeath messages")) {
/*  74 */           if (SettingsConfig.getSetting(p, "DeathMSG").equals("1")) {
/*  75 */             SettingsConfig.setSetting(p, "DeathMSG", "0");
/*  76 */             Game.openSettings(p);
/*  77 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*  78 */             Var.setDeathMsg(p, false);
/*     */           } else {
/*  80 */             SettingsConfig.setSetting(p, "DeathMSG", "1");
/*  81 */             Game.openSettings(p);
/*  82 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*  83 */             Var.setDeathMsg(p, true);
/*     */           } 
/*     */         }
/*     */         
/*  87 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §bAuto-PvP")) {
/*  88 */           if (SettingsConfig.getSetting(p, "AutoPvP").equals("1")) {
/*  89 */             SettingsConfig.setSetting(p, "AutoPvP", "0");
/*  90 */             Game.openSettings(p);
/*  91 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*     */           } else {
/*  93 */             SettingsConfig.setSetting(p, "AutoPvP", "1");
/*  94 */             Game.openSettings(p);
/*  95 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*     */           } 
/*     */         }
/*     */         
/*  99 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §bShow players")) {
/* 100 */           if (SettingsConfig.getSetting(p, "Hider").equals("1")) {
/* 101 */             SettingsConfig.setSetting(p, "Hider", "0");
/* 102 */             Game.openSettings(p);
/* 103 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/* 104 */             Game.HideAllPlayers(p);
/*     */           } else {
/* 106 */             SettingsConfig.setSetting(p, "Hider", "1");
/* 107 */             Game.openSettings(p);
/* 108 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/* 109 */             Game.ShowAllPlayers(p);
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 116 */       for (Kit kits : KitManager.getKits()) {
/* 117 */         if (e.getInventory().getName().equals("§fKit: §b" + kits.getName())) {
/* 118 */           e.setCancelled(true);
/*     */           
/* 120 */           if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSelect " + kits.getName())) {
/* 121 */             p.closeInventory();
/* 122 */             p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/* 123 */             p.sendMessage(String.valueOf(Var.getPr()) + "§7You have selected the kit §a" + kits.getName() + "§7!");
/* 124 */             KitManager.setCurrentKit(p, kits);
/* 125 */             ScoreboardHandler.setScoreboard(p, "normal");
/*     */           } 
/*     */ 
/*     */           
/* 129 */           if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cBack to kits")) {
/* 130 */             Game.openKits(p);
/* 131 */             p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 138 */       for (String str : Var.getGames()) {
/* 139 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3" + str)) {
/* 140 */           e.setCancelled(true);
/* 141 */           if (PvPQueue.isQueue(p)) {
/* 142 */             Inventory inv = Bukkit.createInventory(null, 9, "§bAre you sure?");
/* 143 */             inv.setItem(2, getItemHandler.getItem(Material.EMERALD, "§aYes - Teleport", null));
/* 144 */             inv.setItem(4, getItemHandler.getItem(Material.PAPER, "§fYou are currently in a queue! Leave the queue?", null));
/* 145 */             inv.setItem(6, getItemHandler.getItem(Material.REDSTONE, "§cNo - Stay", null));
/* 146 */             p.openInventory(inv);
/* 147 */             p.playSound(p.getLocation(), Sound.NOTE_BASS, 1.0F, 2.0F);
/* 148 */             PvPQueue.tempteleport.put(p, str);
/*     */             return;
/*     */           } 
/* 151 */           p.teleport(ConfigLocations.getConfigLocation("Spawn." + str, Var.getLoationConfiguration()));
/* 152 */           p.sendMessage(String.valueOf(Var.getPr()) + "§7You were teleported to §b" + str + "§7!");
/* 153 */           p.getInventory().clear();
/* 154 */           Game.setItems(p);
/* 155 */           ScoreboardHandler.setScoreboard(p, "normal");
/* 156 */           if (str.equals("Spawn")) Var.setCurrentGame(p, "Spawn"); 
/* 157 */           p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 162 */       if (e.getInventory().getTitle().equals("§bAre you sure?")) {
/* 163 */         e.setCancelled(true);
/*     */         
/* 165 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aYes - Teleport")) {
/* 166 */           p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/* 167 */           p.teleport(ConfigLocations.getConfigLocation("Spawn." + (String)PvPQueue.tempteleport.get(p), Var.getLoationConfiguration()));
/* 168 */           p.closeInventory();
/* 169 */           PvPQueue.removeQueue(p);
/* 170 */           p.sendMessage(String.valueOf(Var.getPr()) + "§7You were teleported to §b" + (String)PvPQueue.tempteleport.get(p) + "§7!");
/* 171 */           p.sendMessage(String.valueOf(Var.getQueuePr()) + "§7You were removed from the queue..");
/* 172 */           p.getInventory().clear();
/* 173 */           Game.setItems(p);
/* 174 */           getTitleHandler.sendActionBar(p, "§8➤ §c§lLeft queue!");
/* 175 */           ScoreboardHandler.setScoreboard(p, "normal");
/*     */         } 
/* 177 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNo - Stay")) {
/* 178 */           p.closeInventory();
/* 179 */           p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/ClickEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */