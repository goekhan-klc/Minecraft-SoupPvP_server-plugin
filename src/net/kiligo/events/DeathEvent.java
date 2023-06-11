/*     */ package net.kiligo.events;
/*     */ 
/*     */ import net.kiligo.main.Game;
/*     */ import net.kiligo.main.Main;
/*     */ import net.kiligo.pvp.Fight;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.kiligo.util.ConfigLocations;
/*     */ import net.kiligo.util.RankHandler;
/*     */ import net.kiligo.util.ScoreboardHandler;
/*     */ import net.kiligo.util.SettingsConfig;
/*     */ import net.kiligo.util.Var;
/*     */ import net.kiligo.util.getTitleHandler;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class DeathEvent
/*     */   implements Listener {
/*     */   @EventHandler
/*     */   public void onDeath(PlayerDeathEvent e) {
/*  27 */     Player p = e.getEntity();
/*  28 */     Player k = e.getEntity().getKiller();
/*     */     
/*  30 */     e.setDeathMessage(null);
/*  31 */     e.setKeepInventory(true);
/*     */     
/*  33 */     if (Fight.infight.contains(p)) {
/*  34 */       final Player p1 = p;
/*  35 */       final Player p2 = (Player)Fight.infightwith.get(p);
/*     */       
/*  37 */       for (Player all : Bukkit.getOnlinePlayers()) {
/*  38 */         if (!Fight.infight.contains(all)) {
/*  39 */           all.showPlayer(p1);
/*  40 */           all.showPlayer(p2);
/*     */         } 
/*     */       } 
/*  43 */       Fight.infight.remove(p1);
/*  44 */       Fight.infight.remove(p2);
/*     */       
/*  46 */       Fight.infightwith.remove(p1);
/*  47 */       Fight.infightwith.remove(p2);
/*     */       
/*  49 */       p1.sendMessage("");
/*  50 */       p1.sendMessage(String.valueOf(Var.getPvPPr()) + "§cYou §c§llost §cthe fight against " + RankHandler.getPrefix(p2) + "§c!");
/*  51 */       p1.sendMessage("");
/*     */       
/*  53 */       p1.getInventory().clear();
/*  54 */       Game.clearArmor(p1);
/*  55 */       Game.sendRespawn(p1);
/*  56 */       p1.updateInventory();
/*  57 */       for (Player all : Bukkit.getOnlinePlayers()) p1.showPlayer(all); 
/*  58 */       ScoreboardHandler.setScoreboard(p1, "pvp");
/*     */ 
/*     */       
/*  61 */       p2.sendMessage("");
/*  62 */       p2.sendMessage(String.valueOf(Var.getPvPPr()) + "§aYou §a§lwon §athe fight against " + RankHandler.getPrefix(p1) + "§a!");
/*  63 */       p2.sendMessage("");
/*     */       
/*  65 */       p2.getInventory().clear();
/*  66 */       p2.playSound(p2.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/*  67 */       p2.playSound(p2.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*  68 */       p2.playSound(p2.getLocation(), Sound.FIREWORK_BLAST, 1.0F, 1.0F);
/*  69 */       Game.setPvPItems(p2);
/*  70 */       Game.clearArmor(p2);
/*  71 */       Var.setIngame(p2, false);
/*  72 */       p2.updateInventory();
/*  73 */       for (Player all : Bukkit.getOnlinePlayers()) p2.showPlayer(all); 
/*  74 */       ScoreboardHandler.setScoreboard(p2, "pvp");
/*     */       
/*  76 */       Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  80 */               if (SettingsConfig.getSetting(p1, "AutoPvP").equals("1")) {
/*  81 */                 p1.teleport(ConfigLocations.getConfigLocation("Spawn.PvPmiddle", Var.getLoationConfiguration()));
/*  82 */                 p1.getInventory().clear();
/*  83 */                 Game.setPvPItems(p1);
/*  84 */                 p1.playSound(p1.getLocation(), Sound.WITHER_HURT, 1.0F, 1.0F);
/*  85 */                 PvPQueue.addQueue(p1);
/*  86 */                 p1.sendMessage(String.valueOf(Var.getQueuePr()) + "§dYou were added to the Queue automatically!");
/*  87 */                 getTitleHandler.sendTitle(p1, Integer.valueOf(1), Integer.valueOf(80), Integer.valueOf(20), "§bAuto-PvP", "§7You were added automatically to the PvP-Queue!");
/*  88 */                 ScoreboardHandler.setScoreboard(p1, "pvp");
/*     */               } 
/*     */               
/*  91 */               if (SettingsConfig.getSetting(p2, "AutoPvP").equals("1")) {
/*  92 */                 p2.teleport(ConfigLocations.getConfigLocation("Spawn.PvPmiddle", Var.getLoationConfiguration()));
/*  93 */                 p2.getInventory().clear();
/*  94 */                 Game.setPvPItems(p2);
/*  95 */                 p2.playSound(p2.getLocation(), Sound.WITHER_HURT, 1.0F, 1.0F);
/*  96 */                 PvPQueue.addQueue(p2);
/*  97 */                 p2.sendMessage(String.valueOf(Var.getQueuePr()) + "§dYou were added to the Queue automatically!");
/*  98 */                 getTitleHandler.sendTitle(p2, Integer.valueOf(1), Integer.valueOf(80), Integer.valueOf(20), "§bAuto-PvP", "§7You were added automatically to the PvP-Queue!");
/*  99 */                 ScoreboardHandler.setScoreboard(p2, "pvp");
/*     */               }
/*     */             
/*     */             }
/* 103 */           },80L);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 110 */     Var.setIngame(p, false);
/*     */     
/* 112 */     for (ItemStack is : e.getDrops()) {
/* 113 */       p.getWorld().dropItemNaturally(p.getLocation(), is);
/*     */     }
/*     */ 
/*     */     
/* 117 */     if (k != null) {
/* 118 */       Game.sendRespawn(p);
/* 119 */       for (Player all : Bukkit.getOnlinePlayers()) {
/* 120 */         if (Var.isDeathMsg(all)) {
/* 121 */           all.sendMessage(String.valueOf(Var.getDeathPr()) + RankHandler.getPrefix(p) + " §7was killed by " + RankHandler.getPrefix(k) + "§7!");
/*     */         }
/*     */       } 
/* 124 */       p.sendMessage(String.valueOf(Var.getDeathPr()) + "§cYou were killed by " + RankHandler.getPrefix(k));
/* 125 */       k.sendMessage(String.valueOf(Var.getDeathPr()) + "§eYou killed " + RankHandler.getPrefix(p) + "§e!");
/* 126 */       k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*     */     } else {
/* 128 */       for (Player all : Bukkit.getOnlinePlayers()) {
/* 129 */         if (Var.isDeathMsg(all)) {
/* 130 */           all.sendMessage(String.valueOf(Var.getDeathPr()) + RankHandler.getPrefix(p) + " §7died!");
/*     */         }
/*     */       } 
/* 133 */       p.sendMessage(String.valueOf(Var.getDeathPr()) + "§cYou died!");
/* 134 */       Game.sendRespawn(p);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setPvPItems(Player p2) {}
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onRespawn(PlayerRespawnEvent e) {
/* 144 */     final Player p = e.getPlayer();
/*     */     
/* 146 */     e.setRespawnLocation(ConfigLocations.getConfigLocation("Spawn." + Var.getCurrentGame(p), Var.getLoationConfiguration()));
/* 147 */     getTitleHandler.sendTitle(p, Integer.valueOf(0), Integer.valueOf(60), Integer.valueOf(10), "§4You died!", "");
/* 148 */     p.getInventory().clear();
/* 149 */     Game.setItems(p);
/*     */     
/* 151 */     Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 155 */             ScoreboardHandler.setScoreboard(p, "normal");
/* 156 */             p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 0.0F);
/* 157 */             Game.refreshPlayer(p);
/*     */           }
/* 159 */         },5L);
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/DeathEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */