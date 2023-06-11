/*     */ package net.kiligo.commands;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.kiligo.pvp.Fight;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.kiligo.util.RankHandler;
/*     */ import net.kiligo.util.ScoreboardHandler;
/*     */ import net.kiligo.util.Var;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PvP
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  22 */     if (cmd.getName().equalsIgnoreCase("pvp")) {
/*  23 */       Player p = (Player)sender;
/*  24 */       if (args.length == 0) {
/*  25 */         p.sendMessage(String.valueOf(Var.getPvPPr()) + "§fHelp §8- §b/pvp");
/*  26 */         p.sendMessage(String.valueOf(Var.getPvPPr()) + "§7Use§f: /pvp info");
/*  27 */         p.sendMessage(String.valueOf(Var.getPvPPr()) + "§7Use§f: /pvp enable");
/*  28 */         p.sendMessage(String.valueOf(Var.getPvPPr()) + "§7Use§f: /pvp disable");
/*  29 */         return true;
/*     */       } 
/*     */       
/*  32 */       if (args.length == 1) {
/*  33 */         if (args[0].equalsIgnoreCase("info")) {
/*  34 */           p.sendMessage("");
/*  35 */           p.sendMessage(String.valueOf(Var.getPvPPr()) + "§fInfosite §8- §bPvP");
/*  36 */           if (PvPQueue.isActivated()) {
/*  37 */             p.sendMessage(String.valueOf(Var.getPvPPr()) + "§cQueue Status: §aEnabled");
/*     */           } else {
/*  39 */             p.sendMessage(String.valueOf(Var.getPvPPr()) + "§cQueue Status: §cDisabled");
/*     */           } 
/*  41 */           p.sendMessage(String.valueOf(Var.getPvPPr()) + "§cPlayers in Queue: §b" + PvPQueue.queue.size());
/*  42 */           p.sendMessage(String.valueOf(Var.getPvPPr()) + "§cPlayers in Fight: §b" + Fight.infight.size());
/*  43 */           p.sendMessage(Var.getPvPPr());
/*     */ 
/*     */ 
/*     */           
/*  47 */           p.sendMessage(String.valueOf(Var.getPvPPr()) + "§cQueued Players: ");
/*  48 */           if (PvPQueue.queue.size() != 0) {
/*  49 */             for (int i = 0; i < PvPQueue.queue.size(); i++) {
/*  50 */               p.sendMessage(String.valueOf(Var.getPvPPr()) + "§b" + i + "§b." + " §8- " + RankHandler.getPrefix(PvPQueue.queue.get(i)));
/*     */             }
/*     */           } else {
/*  53 */             p.sendMessage(String.valueOf(Var.getPvPPr()) + "§8» §bThere are no players in the queue!");
/*     */           } 
/*  55 */           p.sendMessage(Var.getPvPPr());
/*     */ 
/*     */ 
/*     */           
/*  59 */           p.sendMessage(String.valueOf(Var.getPvPPr()) + "§cInfight Players: ");
/*  60 */           if (Fight.infight.size() != 0) {
/*  61 */             ArrayList<Player> infight = PvPQueue.getPlayersInFight();
/*     */             
/*  63 */             for (int i = 0; i < infight.size(); i++) {
/*  64 */               p.sendMessage(String.valueOf(Var.getPvPPr()) + "§b" + i + "§b. §8- " + RankHandler.getPrefix(infight.get(i)) + " §d<-> " + 
/*  65 */                   RankHandler.getPrefix((Player)Fight.infightwith.get(infight.get(i))));
/*     */             }
/*     */           } else {
/*     */             
/*  69 */             p.sendMessage(String.valueOf(Var.getPvPPr()) + "§8» §bThere are no players fighting!");
/*     */           } 
/*  71 */           p.sendMessage("");
/*  72 */         } else if (args[0].equalsIgnoreCase("enable")) {
/*  73 */           if (PvPQueue.isActivated()) {
/*  74 */             p.sendMessage(String.valueOf(Var.getQueuePr()) + "§cThe Queue is already activated!");
/*  75 */             return true;
/*     */           } 
/*  77 */           PvPQueue.setActivated(true);
/*  78 */           p.sendMessage(String.valueOf(Var.getQueuePr()) + "§7The Queue has been §aactivated§7!");
/*     */         }
/*  80 */         else if (args[0].equalsIgnoreCase("disable")) {
/*  81 */           if (!PvPQueue.isActivated()) {
/*  82 */             p.sendMessage(String.valueOf(Var.getQueuePr()) + "§cThe Queue is already deactivated!");
/*  83 */             return true;
/*     */           } 
/*  85 */           PvPQueue.setActivated(false);
/*  86 */           p.sendMessage(String.valueOf(Var.getQueuePr()) + "§7The Queue has been §cdeactivated§7!");
/*     */           
/*  88 */           for (Player all : PvPQueue.queue) {
/*  89 */             all.sendMessage(String.valueOf(Var.getQueuePr()) + "§cThe Queue was disabled! You were removed from the Queue..");
/*  90 */             all.playSound(all.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
/*  91 */             ScoreboardHandler.setScoreboard(all, "pvp");
/*     */           } 
/*     */           
/*  94 */           PvPQueue.queue.clear();
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/commands/PvP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */