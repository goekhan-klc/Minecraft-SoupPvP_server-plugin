/*     */ package net.kiligo.commands;
/*     */ 
/*     */ import net.kiligo.main.Game;
/*     */ import net.kiligo.util.RankHandler;
/*     */ import net.kiligo.util.ScoreboardHandler;
/*     */ import net.kiligo.util.Var;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import ru.tehkode.permissions.PermissionGroup;
/*     */ import ru.tehkode.permissions.PermissionManager;
/*     */ import ru.tehkode.permissions.bukkit.PermissionsEx;
/*     */ 
/*     */ public class PermissionSystem
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
/*  20 */     if (!(sender instanceof Player)) {
/*  21 */       sender.sendMessage(String.valueOf(Var.getRankPr()) + "§cDu musst ein Spieler sein, um diese Aktion ausführen zu können!");
/*  22 */       return true;
/*     */     } 
/*  24 */     Player p = (Player)sender;
/*  25 */     PermissionManager api = PermissionsEx.getPermissionManager();
/*  26 */     if (p.hasPermission("soup.ps")) {
/*     */       
/*  28 */       if (args.length == 0) {
/*  29 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps createrank <Rank>");
/*  30 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps delrank <Rank>");
/*  31 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps list");
/*  32 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps setrank <Spieler> <Rank>");
/*  33 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps setprefix <Rank> <Prefix>");
/*  34 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps setsuffix <Rank> <Suffix>");
/*  35 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps addpermissions <Rank> <Permissions>");
/*  36 */         p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Use: §f/ps delpermissions <Rank> <Permissions>");
/*  37 */         return true;
/*     */       } 
/*  39 */       if (args.length == 1) {
/*     */         
/*  41 */         if (args[0].equalsIgnoreCase("list")) {
/*  42 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§fExestierende Ränge:");
/*  43 */           for (PermissionGroup allgroups : api.getGroupList()) {
/*  44 */             p.sendMessage(String.valueOf(Var.getRankPr()) + allgroups.getPrefix().replace("&", "§") + allgroups.getName());
/*     */           }
/*     */         } 
/*  47 */         return true;
/*     */       } 
/*  49 */       if (args.length == 2) {
/*     */         
/*  51 */         if (args[0].equalsIgnoreCase("createrank")) {
/*  52 */           boolean gefunden = false;
/*  53 */           String rank = args[1];
/*  54 */           for (PermissionGroup allgroups : api.getGroupList()) {
/*  55 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/*  56 */               gefunden = true;
/*     */             }
/*     */           } 
/*  59 */           if (gefunden) {
/*  60 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert schon!");
/*  61 */             return true;
/*     */           } 
/*  63 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex group " + rank + " create");
/*  64 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex reload");
/*  65 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Der Rang §f" + rank + " §7wurde erfolgreich erstellt!");
/*     */         } 
/*     */         
/*  68 */         if (args[0].equalsIgnoreCase("delrank")) {
/*  69 */           boolean gefunden = false;
/*  70 */           String rank = args[1];
/*  71 */           for (PermissionGroup allgroups : api.getGroupList()) {
/*  72 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/*  73 */               gefunden = true;
/*     */             }
/*     */           } 
/*  76 */           if (!gefunden) {
/*  77 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert nicht!");
/*  78 */             return true;
/*     */           } 
/*  80 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex group " + rank + " delete");
/*  81 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex reload");
/*  82 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Der Rang §f" + rank + " §7wurde erfolgreich gelöscht!");
/*     */         } 
/*     */       } 
/*  85 */       if (args.length == 3) {
/*     */         
/*  87 */         if (args[0].equalsIgnoreCase("setrank")) {
/*  88 */           boolean gefunden = false;
/*  89 */           String rank = args[2];
/*  90 */           for (PermissionGroup allgroups : api.getGroupList()) {
/*  91 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/*  92 */               gefunden = true;
/*     */             }
/*     */           } 
/*  95 */           if (!gefunden) {
/*  96 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert nicht!");
/*  97 */             return true;
/*     */           } 
/*  99 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + Bukkit.getOfflinePlayer(args[1]).getUniqueId() + " group set " + rank);
/* 100 */           String Text = 
/* 101 */             " \n§c§lSoupPvP §8- §fRank Information \n§7Du hast einen neuen Rang erhalten: §f§n" + 
/*     */             
/* 103 */             rank + "§r \n" + 
/* 104 */             "§aRejoine um die vollen Features zu erhalten! \n";
/*     */           
/* 106 */           Bukkit.getPlayer(args[1]).sendMessage(Text);
/* 107 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Du hast §e" + args[1] + " §7den Rang §b" + rank + " §7gesetzt!");
/*     */           
/* 109 */           if (Bukkit.getPlayer(args[1]) != null) {
/* 110 */             RankHandler.setRanks(Bukkit.getPlayer(args[1]));
/*     */           }
/* 112 */           ScoreboardHandler.setScoreboard(Bukkit.getPlayer(args[1]), "normal");
/* 113 */           Game.setItems(Bukkit.getPlayer(args[1]));
/*     */           
/* 115 */           return true;
/*     */         } 
/*     */         
/* 118 */         if (args[0].equalsIgnoreCase("setprefix")) {
/* 119 */           boolean gefunden = false;
/* 120 */           String rank = args[1];
/* 121 */           for (PermissionGroup allgroups : api.getGroupList()) {
/* 122 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/* 123 */               gefunden = true;
/*     */             }
/*     */           } 
/* 126 */           if (!gefunden) {
/* 127 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert nicht!");
/* 128 */             return true;
/*     */           } 
/* 130 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex group " + rank + " prefix " + args[2]);
/* 131 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Du hast die Prefix von dem Rang §f" + rank + " §7geändert!");
/* 132 */           return true;
/*     */         } 
/*     */         
/* 135 */         if (args[0].equalsIgnoreCase("setsuffix")) {
/* 136 */           boolean gefunden = false;
/* 137 */           String rank = args[1];
/* 138 */           for (PermissionGroup allgroups : api.getGroupList()) {
/* 139 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/* 140 */               gefunden = true;
/*     */             }
/*     */           } 
/* 143 */           if (!gefunden) {
/* 144 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert nicht!");
/* 145 */             return true;
/*     */           } 
/* 147 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex group " + rank + " suffix " + args[2]);
/* 148 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Du hast die Suffix von dem Rang §f" + rank + " §7geändert!");
/* 149 */           return true;
/*     */         } 
/*     */         
/* 152 */         if (args[0].equalsIgnoreCase("addpermissions")) {
/* 153 */           boolean gefunden = false;
/* 154 */           String rank = args[1];
/* 155 */           for (PermissionGroup allgroups : api.getGroupList()) {
/* 156 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/* 157 */               gefunden = true;
/*     */             }
/*     */           } 
/* 160 */           if (!gefunden) {
/* 161 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert nicht!");
/* 162 */             return true;
/*     */           } 
/* 164 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex group " + rank + " add " + args[2]);
/* 165 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Du hast die Permission §f" + args[2] + " §7zu dem Rang §f" + rank + " §7hinzugefügt!");
/* 166 */           return true;
/*     */         } 
/*     */         
/* 169 */         if (args[0].equalsIgnoreCase("delpermissions")) {
/* 170 */           boolean gefunden = false;
/* 171 */           String rank = args[1];
/* 172 */           for (PermissionGroup allgroups : api.getGroupList()) {
/* 173 */             if (allgroups.getName().equalsIgnoreCase(rank)) {
/* 174 */               gefunden = true;
/*     */             }
/*     */           } 
/* 177 */           if (!gefunden) {
/* 178 */             p.sendMessage(String.valueOf(Var.getRankPr()) + "§cDieser Rang exestiert nicht!");
/* 179 */             return true;
/*     */           } 
/* 181 */           Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex group " + rank + " remove " + args[2]);
/* 182 */           p.sendMessage(String.valueOf(Var.getRankPr()) + "§7Du hast die Permission §f" + args[2] + " §7von dem Rang §f" + rank + " §7entfernt!");
/* 183 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 187 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/commands/PermissionSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */