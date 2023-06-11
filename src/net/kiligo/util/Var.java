/*     */ package net.kiligo.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ public class Var
/*     */ {
/*  12 */   private static String pr = "§bKiligoDE §f| ";
/*  13 */   private static String rankpr = "§cRank §f| ";
/*  14 */   private static String deathpr = "§cDeath §f| ";
/*  15 */   private static String queuepr = "§bQueue §f| ";
/*  16 */   private static String pvppr = "§aPvP §f| ";
/*     */   
/*  18 */   private static String servername = "KiligoDE";
/*     */   
/*  20 */   private static String np = String.valueOf(getPr()) + "§cYou don't have the permissions to perform this action!";
/*     */ 
/*     */   
/*  23 */   private static File locfile = new File("plugins\\Soup\\locations.yml");
/*  24 */   private static YamlConfiguration loccfg = YamlConfiguration.loadConfiguration(locfile);
/*     */   
/*  26 */   private static ArrayList<String> games = new ArrayList<>();
/*  27 */   private static ArrayList<Player> vanished = new ArrayList<>();
/*  28 */   private static ArrayList<Player> nofalldamage = new ArrayList<>();
/*     */   
/*  30 */   private static HashMap<Player, String> currentgame = new HashMap<>();
/*  31 */   private static HashMap<Player, Boolean> isingame = new HashMap<>();
/*     */   
/*  33 */   private static HashMap<Player, Boolean> isdeathmsg = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static void setDeathMsg(Player p, boolean state) {
/*  37 */     isdeathmsg.put(p, Boolean.valueOf(state));
/*     */   }
/*     */   
/*     */   public static boolean isDeathMsg(Player p) {
/*  41 */     return ((Boolean)isdeathmsg.get(p)).booleanValue();
/*     */   }
/*     */   
/*     */   public static String getServerName() {
/*  45 */     return servername;
/*     */   }
/*     */   
/*     */   public static String getQueuePr() {
/*  49 */     return queuepr;
/*     */   }
/*     */   
/*     */   public static String getPvPPr() {
/*  53 */     return pvppr;
/*     */   }
/*     */   
/*     */   public static void setIngame(Player p, boolean state) {
/*  57 */     isingame.put(p, Boolean.valueOf(state));
/*     */   }
/*     */   
/*     */   public static boolean isIngame(Player p) {
/*  61 */     return ((Boolean)isingame.get(p)).booleanValue();
/*     */   }
/*     */   
/*     */   public static void addNoFallDamage(Player p) {
/*  65 */     nofalldamage.add(p);
/*     */   }
/*     */   
/*     */   public static void removeNoFallDamage(Player p) {
/*  69 */     nofalldamage.remove(p);
/*     */   }
/*     */   
/*     */   public static boolean isNoFallDamage(Player p) {
/*  73 */     if (nofalldamage.contains(p)) return true; 
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public static String getCurrentGame(Player p) {
/*  78 */     return currentgame.get(p);
/*     */   }
/*     */   
/*     */   public static void setCurrentGame(Player p, String game) {
/*  82 */     currentgame.put(p, game);
/*     */   }
/*     */   
/*     */   public static ArrayList<String> getGames() {
/*  86 */     return games;
/*     */   }
/*     */   
/*     */   public static String getRankPr() {
/*  90 */     return rankpr;
/*     */   }
/*     */   
/*     */   public static ArrayList<Player> getVanished() {
/*  94 */     return vanished;
/*     */   }
/*     */   
/*     */   public static File getLoationFile() {
/*  98 */     return locfile;
/*     */   }
/*     */   
/*     */   public static YamlConfiguration getLoationConfiguration() {
/* 102 */     return loccfg;
/*     */   }
/*     */   
/*     */   public static String getPr() {
/* 106 */     return pr;
/*     */   }
/*     */   
/*     */   public static String getNp() {
/* 110 */     return np;
/*     */   }
/*     */   
/*     */   public static String getDeathPr() {
/* 114 */     return deathpr;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String Capitalize(String str) {
/* 119 */     if (str.length() > 1) {
/* 120 */       String cap = String.valueOf(str.substring(0, 1).toUpperCase()) + str.substring(1);
/* 121 */       return cap;
/*     */     } 
/* 123 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/Var.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */