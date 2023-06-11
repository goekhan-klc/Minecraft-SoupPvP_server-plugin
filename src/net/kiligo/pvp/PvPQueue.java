/*     */ package net.kiligo.pvp;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import net.kiligo.main.Main;
/*     */ import net.kiligo.util.ScoreboardHandler;
/*     */ import net.kiligo.util.Var;
/*     */ import net.kiligo.util.getTitleHandler;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ public class PvPQueue
/*     */ {
/*  16 */   public static ArrayList<Player> queue = new ArrayList<>();
/*     */   
/*  18 */   public static HashMap<Player, String> tempteleport = new HashMap<>();
/*     */   
/*     */   private static boolean isactivated = true;
/*     */   
/*     */   public static void addQueue(Player p) {
/*  23 */     queue.add(p);
/*     */   }
/*     */   
/*     */   public static void removeQueue(Player p) {
/*  27 */     queue.remove(p);
/*     */   }
/*     */   
/*     */   public static boolean isQueue(Player p) {
/*  31 */     if (queue.contains(p)) return true; 
/*  32 */     return false;
/*     */   }
/*     */   
/*     */   public static void setActivated(boolean b) {
/*  36 */     isactivated = b;
/*     */   }
/*     */   
/*     */   public static boolean isActivated() {
/*  40 */     return isactivated;
/*     */   }
/*     */   
/*     */   public static ArrayList<Player> getPlayersInFight() {
/*  44 */     ArrayList<Player> players = new ArrayList<>();
/*     */     
/*  46 */     for (int i = 0; i < Fight.infight.size() / 2; i++) {
/*  47 */       players.add(Fight.infight.get(i));
/*  48 */       i++;
/*     */     } 
/*     */     
/*  51 */     return players;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void startQueueCounter() {
/*  56 */     Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  60 */             if (PvPQueue.isactivated && 
/*  61 */               PvPQueue.queue.size() >= 2) {
/*  62 */               Player p1 = PvPQueue.queue.get(0);
/*  63 */               Player p2 = PvPQueue.queue.get(1);
/*     */ 
/*     */               
/*  66 */               p1.sendMessage(String.valueOf(Var.getQueuePr()) + "§7Removing you from the queue..");
/*  67 */               p2.sendMessage(String.valueOf(Var.getQueuePr()) + "§7Removing you from the queue..");
/*     */               
/*  69 */               Fight.startFight(p1, p2);
/*     */               
/*  71 */               PvPQueue.queue.remove(p1);
/*  72 */               PvPQueue.queue.remove(p2);
/*     */               
/*  74 */               ScoreboardHandler.setScoreboard(p1, "pvp");
/*  75 */               ScoreboardHandler.setScoreboard(p2, "pvp");
/*     */             
/*     */             }
/*     */           
/*     */           }
/*  80 */         },20L, 40L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void startQueueUtils() {
/*  85 */     Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)Main.getInstance(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  89 */             if (PvPQueue.queue.size() != 0) {
/*  90 */               for (Player queue : PvPQueue.queue) {
/*  91 */                 int position = 0;
/*  92 */                 for (int i = 0; i < PvPQueue.queue.size(); i++) {
/*  93 */                   if (PvPQueue.queue.get(i) == queue) {
/*  94 */                     position = i + 1;
/*     */                   }
/*     */                 } 
/*     */                 
/*  98 */                 getTitleHandler.sendActionBar(queue, "§8➤ §2§lCurrently in queue §8[§c§l§n" + position + "§f/§c§l§n" + PvPQueue.queue.size() + "§8]");
/*     */               } 
/*     */             }
/*     */           }
/* 102 */         },20L, 20L);
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/pvp/PvPQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */