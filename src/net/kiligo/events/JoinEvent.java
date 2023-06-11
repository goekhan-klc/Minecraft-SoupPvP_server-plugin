/*     */ package net.kiligo.events;
/*     */ 
/*     */ import net.kiligo.kits.KitManager;
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
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class JoinEvent
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  30 */     final Player p = e.getPlayer();
/*     */     
/*  32 */     RankHandler.setRanks(p);
/*     */     
/*  34 */     for (Player all : Var.getVanished()) {
/*  35 */       all.hidePlayer(p);
/*  36 */       p.hidePlayer(all);
/*     */     } 
/*     */     
/*  39 */     for (Player all : Fight.infight) {
/*  40 */       all.hidePlayer(p);
/*     */     }
/*     */     
/*  43 */     Game.setTab(p);
/*     */     
/*  45 */     p.getInventory().clear();
/*  46 */     p.setHealth(20.0D);
/*  47 */     p.setFoodLevel(20);
/*  48 */     p.setFireTicks(0);
/*     */     
/*  50 */     e.setJoinMessage(null);
/*     */     
/*  52 */     Bukkit.broadcastMessage("§a»» §f" + RankHandler.getPrefix(p) + " §7betrat den Server!");
/*     */     
/*  54 */     p.teleport(ConfigLocations.getConfigLocation("Spawn.Spawn", Var.getLoationConfiguration()));
/*  55 */     p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/*     */     
/*  57 */     Game.setItems(p);
/*     */     
/*  59 */     p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 3));
/*  60 */     p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 40, 3));
/*  61 */     Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  65 */             p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1.0F, 1.0F);
/*  66 */             p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.4F);
/*     */           }
/*  68 */         },15L);
/*     */     
/*  70 */     getTitleHandler.sendTitle(p, Integer.valueOf(1), Integer.valueOf(100), Integer.valueOf(20), "§cWillkommen!", "§7Willkommen §f" + p.getName() + " §7auf " + Var.getServerName() + "!");
/*     */     
/*  72 */     Var.setCurrentGame(p, "Spawn");
/*  73 */     KitManager.setCurrentKit(p, KitManager.getKit("Default"));
/*  74 */     Var.setIngame(p, false);
/*     */     
/*  76 */     Game.CheckSettings(p);
/*     */     
/*  78 */     ScoreboardHandler.setScoreboard(p, "normal");
/*     */     
/*  80 */     Game.refreshPlayer(p);
/*     */     
/*  82 */     if (SettingsConfig.getSetting(p, "DeathMSG").equals("1")) {
/*  83 */       Var.setDeathMsg(p, true);
/*     */     } else {
/*  85 */       Var.setDeathMsg(p, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onQuit(PlayerQuitEvent e) {
/* 102 */     Player p = e.getPlayer();
/*     */     
/* 104 */     if (Fight.infightwith.containsKey(p)) {
/* 105 */       Player p1 = p;
/* 106 */       Player p2 = (Player)Fight.infightwith.get(p1);
/*     */       
/* 108 */       for (Player all : Bukkit.getOnlinePlayers()) {
/* 109 */         if (!Fight.infight.contains(all)) {
/* 110 */           all.showPlayer(p2);
/*     */         }
/*     */       } 
/*     */       
/* 114 */       Fight.infight.remove(p2);
/*     */       
/* 116 */       Fight.infightwith.remove(p2);
/*     */       
/* 118 */       p2.sendMessage(String.valueOf(Var.getPvPPr()) + "§aYou §a§lwon §athe fight against " + RankHandler.getPrefix(p1) + "§a! §8(§7opponent left§8)");
/* 119 */       p2.getInventory().clear();
/* 120 */       p2.playSound(p2.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 121 */       p2.playSound(p2.getLocation(), Sound.FIREWORK_BLAST, 1.0F, 1.0F);
/* 122 */       Game.setPvPItems(p2);
/* 123 */       Game.clearArmor(p2);
/* 124 */       p2.updateInventory();
/* 125 */       for (Player all : Bukkit.getOnlinePlayers()) p2.showPlayer(all);
/*     */     
/*     */     } 
/*     */     
/* 129 */     if (PvPQueue.queue.contains(p)) PvPQueue.removeQueue(p);
/*     */     
/* 131 */     e.setQuitMessage(null);
/* 132 */     Bukkit.broadcastMessage("§c«« " + RankHandler.getPrefix(e.getPlayer()) + " §7verließ den Server!");
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/JoinEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */