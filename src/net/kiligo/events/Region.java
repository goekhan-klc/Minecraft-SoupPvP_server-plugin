/*     */ package net.kiligo.events;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.util.Vector;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;

/*     */ import net.kiligo.kits.KitManager;
/*     */ import net.kiligo.main.Game;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.kiligo.util.ScoreboardHandler;
/*     */ import net.kiligo.util.Var;
/*     */ import net.kiligo.util.getTitleHandler;
/*     */ 
/*     */ 
/*     */ public class Region
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public  void onRegionEnter(RegionEnterEvent e) {
/*  23 */     Player p = e.getPlayer();
/*     */     
/*  25 */     if (Var.getVanished().contains(p)) {
/*  26 */       e.setCancelled(true);
/*  27 */       getTitleHandler.sendActionBar(p, "§8➤ §c§lYour silentmode is activated...");
/*     */       
/*     */       return;
/*     */     } 
/*  31 */     p.closeInventory();
/*     */     
/*  33 */     if (e.getRegion().getId().equals("feast")) {
/*     */       
/*  35 */       Vector v = new Vector();
/*  36 */       v.multiply(2).setZ(-4).setY(1);
/*  37 */       p.setVelocity(v);
/*     */       
/*  39 */       p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*  40 */       p.getInventory().clear();
/*  41 */       KitManager.getCurrentKit(p).setItems(p);
/*  42 */       getTitleHandler.sendTitle(p, Integer.valueOf(0), Integer.valueOf(60), Integer.valueOf(10), "§bFeast", "§3Maximal Teams of §c2 §3players!");
/*  43 */       getTitleHandler.sendActionBar(p, "§8➤ §b§lYour current kit: §c" + KitManager.getCurrentKit(p).getName());
/*  44 */       Var.setCurrentGame(p, "Feast");
/*  45 */       Game.setNoFallDamage(p, 3);
/*  46 */       Var.setIngame(p, true);
/*  47 */       ScoreboardHandler.setScoreboard(p, "kit");
/*     */     } 
/*     */     
/*  50 */     if (e.getRegion().getId().equals("earlyhg")) {
/*  51 */       Vector v = new Vector();
/*  52 */       v.multiply(2).setZ(-4).setY(1);
/*  53 */       p.setVelocity(v);
/*     */       
/*  55 */       p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*  56 */       p.getInventory().clear();
/*  57 */       KitManager.getCurrentKit(p).setItems(p);
/*  58 */       Game.clearArmor(p);
/*  59 */       getTitleHandler.sendTitle(p, Integer.valueOf(0), Integer.valueOf(60), Integer.valueOf(10), "§bEarlyHG", "§3Teams disallowed!");
/*  60 */       getTitleHandler.sendActionBar(p, "§8➤ §b§lYour current kit: §c" + KitManager.getCurrentKit(p).getName());
/*  61 */       Var.setCurrentGame(p, "EarlyHG");
/*  62 */       Game.setNoFallDamage(p, 3);
/*  63 */       Var.setIngame(p, true);
/*  64 */       ScoreboardHandler.setScoreboard(p, "kit");
/*     */     } 
/*     */ 
/*     */     
/*  68 */     if (e.getRegion().getId().equals("pvp")) {
/*  69 */       Vector v = new Vector();
/*  70 */       v.multiply(2).setX(3).setY(1);
/*  71 */       p.setVelocity(v);
/*     */       
/*  73 */       p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*  74 */       p.getInventory().clear();
/*  75 */       Game.clearArmor(p);
/*  76 */       Game.setPvPItems(p);
/*  77 */       Var.setCurrentGame(p, "PvP");
/*  78 */       Game.setNoFallDamage(p, 3);
/*  79 */       getTitleHandler.sendTitle(p, Integer.valueOf(0), Integer.valueOf(60), Integer.valueOf(10), "§bPvP", "§3Play with Random players!");
/*  80 */       PvPQueue.removeQueue(p);
/*  81 */       ScoreboardHandler.setScoreboard(p, "pvp");
/*     */     } 
/*     */     
/*  84 */     if (e.getRegion().getId().equals("lava")) {
/*  85 */       p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*  86 */       p.getInventory().clear();
/*  87 */       Game.setSoupItems_Noarmor(p);
/*  88 */       getTitleHandler.sendTitle(p, Integer.valueOf(0), Integer.valueOf(60), Integer.valueOf(10), "§bLavachallenge", "§3Train your soup skills in lava!");
/*  89 */       Var.setCurrentGame(p, "Lavachallenge");
/*  90 */       Var.setIngame(p, true);
/*  91 */       ScoreboardHandler.setScoreboard(p, "game");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onRegionLeave(RegionLeaveEvent e) {
/* 104 */     Player p = e.getPlayer();
/* 105 */     if (e.getRegion().getId().equals("lava")) {
/* 106 */       p.getInventory().clear();
/* 107 */       Game.setItems(p);
/* 108 */       p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/* 109 */       Game.refreshPlayer(p);
/* 110 */       Var.setCurrentGame(p, "Spawn");
/* 111 */       Var.setIngame(p, false);
/* 112 */       ScoreboardHandler.setScoreboard(p, "normal");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/Region.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */