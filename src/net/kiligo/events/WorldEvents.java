/*     */ package net.kiligo.events;
/*     */ 
/*     */ import net.kiligo.commands.EditMode;
/*     */ import net.kiligo.main.Main;
/*     */ import net.kiligo.pvp.Fight;
/*     */ import net.kiligo.util.Var;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntitySpawnEvent;
/*     */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*     */ import org.bukkit.event.player.PlayerAchievementAwardedEvent;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerPickupItemEvent;
/*     */ import org.bukkit.event.weather.WeatherChangeEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldEvents
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onSpawn(final EntitySpawnEvent e) {
/*  32 */     if (e.getEntity() instanceof org.bukkit.entity.Item || e.getEntity() instanceof org.bukkit.entity.ArmorStand) {
/*  33 */       if (e.getEntity().getType().equals(Material.BOWL)) {
/*  34 */         e.setCancelled(true);
/*     */       }
/*  36 */       Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  40 */               e.getEntity().remove();
/*     */             }
/*  42 */           },  60L);
/*     */     } else {
/*  44 */       e.setCancelled(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onFood(FoodLevelChangeEvent e) {
/*  50 */     e.setCancelled(true);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onWeather(WeatherChangeEvent e) {
/*  55 */     e.setCancelled(true);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onBuild(BlockPlaceEvent e) {
/*  60 */     if (!EditMode.edit.contains(e.getPlayer())) e.setCancelled(true); 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onBreak(BlockBreakEvent e) {
/*  65 */     if (!EditMode.edit.contains(e.getPlayer())) e.setCancelled(true); 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onDrop(PlayerDropItemEvent e) {
/*  70 */     if (EditMode.edit.contains(e.getPlayer())) {
/*  71 */       e.setCancelled(false);
/*     */       
/*     */       return;
/*     */     } 
/*  75 */     if (!Var.isIngame(e.getPlayer())) {
/*  76 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPickup(PlayerPickupItemEvent e) {
/*  83 */     if (EditMode.edit.contains(e.getPlayer())) {
/*  84 */       e.setCancelled(false);
/*     */       
/*     */       return;
/*     */     } 
/*  88 */     if (!Var.isIngame(e.getPlayer())) {
/*  89 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onFall(EntityDamageEvent e) {
/*  98 */     if (e.getEntity() instanceof Player) {
/*  99 */       Player p = (Player)e.getEntity();
/*     */       
/* 101 */       String game = Var.getCurrentGame(p);
/*     */       
/* 103 */       if (game.equalsIgnoreCase("Spawn")) e.setCancelled(true);
/*     */       
/* 105 */       if ((game.equalsIgnoreCase("Feast") || game.equalsIgnoreCase("EarlyHG")) && 
/* 106 */         e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && 
/* 107 */         Var.isNoFallDamage(p)) e.setCancelled(true);
/*     */ 
/*     */ 
/*     */       
/* 111 */       if (game.equalsIgnoreCase("PvP")) {
/* 112 */         if (!Fight.infight.contains(p)) e.setCancelled(true); 
/* 113 */         if (Var.isNoFallDamage(p)) e.setCancelled(true);
/*     */       
/*     */       } 
/* 116 */       if (game.equalsIgnoreCase("Lavachallenge") && 
/* 117 */         !e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) {
/* 118 */         e.setCancelled(true);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerDamage(EntityDamageByEntityEvent e) {
/* 126 */     Player p = (Player)e.getEntity();
/* 127 */     Player damager = (Player)e.getDamager();
/*     */     
/* 129 */     if (Fight.infight.contains(p) && 
/* 130 */       Fight.infightwith.get(p) != damager) e.setCancelled(true);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onArchievement(PlayerAchievementAwardedEvent e) {
/* 137 */     e.setCancelled(true);
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/WorldEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */