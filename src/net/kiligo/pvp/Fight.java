/*    */ package net.kiligo.pvp;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import net.kiligo.main.Game;
/*    */ import net.kiligo.util.ConfigLocations;
/*    */ import net.kiligo.util.RankHandler;
/*    */ import net.kiligo.util.Var;
/*    */ import net.kiligo.util.getTitleHandler;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Fight
/*    */ {
/* 19 */   public static ArrayList<Player> infight = new ArrayList<>();
/* 20 */   public static HashMap<Player, Player> infightwith = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static void startFight(Player p1, Player p2) {
/* 24 */     p1.closeInventory();
/* 25 */     p2.closeInventory();
/*    */     
/* 27 */     if (!Var.getCurrentGame(p1).equalsIgnoreCase("PvP") || !Var.getCurrentGame(p2).equalsIgnoreCase("PvP")) {
/* 28 */       p1.teleport(ConfigLocations.getConfigLocation("Spawn.PvPmiddle", Var.getLoationConfiguration()));
/* 29 */       p2.teleport(ConfigLocations.getConfigLocation("Spawn.PvPmiddle", Var.getLoationConfiguration()));
/*    */     } 
/*    */     
/* 32 */     infight.add(p1);
/* 33 */     infight.add(p2);
/*    */     
/* 35 */     infightwith.put(p1, p2);
/* 36 */     infightwith.put(p2, p1);
/*    */     
/* 38 */     Vector v1 = new Vector();
/* 39 */     v1.multiply(2).setZ(2).setY(1);
/*    */     
/* 41 */     Vector v2 = new Vector();
/* 42 */     v2.multiply(2).setZ(-2).setY(1);
/*    */     
/* 44 */     p1.setVelocity(v1);
/* 45 */     p2.setVelocity(v2);
/*    */     
/* 47 */     Game.setNoFallDamage(p1, 2);
/* 48 */     Game.setNoFallDamage(p2, 2);
/*    */     
/* 50 */     p1.playSound(p1.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
/* 51 */     p2.playSound(p2.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
/*    */     
/* 53 */     p1.sendMessage("");
/* 54 */     p1.sendMessage(String.valueOf(Var.getPvPPr()) + "§dYou are now in a §d§lfight §dwith " + RankHandler.getPrefix(p2) + "§d!");
/* 55 */     p1.sendMessage("");
/*    */     
/* 57 */     getTitleHandler.sendActionBar(p1, "§8➤ §d§lFound a fight!");
/* 58 */     getTitleHandler.sendActionBar(p2, "§8➤ §d§lFound a fight!");
/*    */     
/* 60 */     p2.sendMessage("");
/* 61 */     p2.sendMessage(String.valueOf(Var.getPvPPr()) + "§dYou are now in a §d§lfight §dwith " + RankHandler.getPrefix(p1) + "§d!");
/* 62 */     p2.sendMessage("");
/*    */     
/* 64 */     p1.getInventory().clear();
/* 65 */     p2.getInventory().clear();
/*    */     
/* 67 */     Game.setSoupItems_Norecraft(p1);
/* 68 */     Game.setSoupItems_Norecraft(p2);
/*    */     
/* 70 */     Var.setIngame(p1, true);
/* 71 */     Var.setIngame(p2, true);
/*    */     
/* 73 */     Game.refreshPlayer(p1);
/* 74 */     Game.refreshPlayer(p2);
/*    */     
/* 76 */     for (Player all : Bukkit.getOnlinePlayers()) {
/* 77 */       p1.hidePlayer(all);
/* 78 */       p2.hidePlayer(all);
/*    */     } 
/*    */     
/* 81 */     for (Player all : Bukkit.getOnlinePlayers()) {
/* 82 */       p1.hidePlayer(all);
/* 83 */       p2.hidePlayer(all);
/*    */     } 
/*    */     
/* 86 */     p1.showPlayer(p2);
/* 87 */     p2.showPlayer(p1);
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/pvp/Fight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */