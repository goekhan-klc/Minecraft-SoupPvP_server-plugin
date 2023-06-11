/*     */ package net.kiligo.util;
/*     */ 
/*     */ import net.kiligo.main.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scoreboard.Scoreboard;
/*     */ import ru.tehkode.permissions.PermissionManager;
/*     */ import ru.tehkode.permissions.PermissionUser;
/*     */ import ru.tehkode.permissions.bukkit.PermissionsEx;
/*     */ 
/*     */ public class RankHandler {
/*     */   static Scoreboard sb;
/*     */   
/*     */   public static void setTeams() {
/*  17 */     PermissionManager api = PermissionsEx.getPermissionManager();
/*     */     
/*  19 */     sb = Bukkit.getScoreboardManager().getNewScoreboard();
/*     */     
/*  21 */     sb.registerNewTeam("0001Admin");
/*  22 */     sb.registerNewTeam("0002Dev");
/*  23 */     sb.registerNewTeam("0003Mod");
/*  24 */     sb.registerNewTeam("0004T-Mod");
/*  25 */     sb.registerNewTeam("0005Helper");
/*  26 */     sb.registerNewTeam("0006Builder");
/*  27 */     sb.registerNewTeam("0007VIP");
/*  28 */     sb.registerNewTeam("008Emerald");
/*  29 */     sb.registerNewTeam("009Souper");
/*  30 */     sb.registerNewTeam("010User");
/*     */     
/*  32 */     sb.getTeam("0001Admin").setPrefix(String.valueOf(api.getGroup("Admin").getSuffix().replace("&", "§")) + " " + api.getGroup("Admin").getPrefix().replace("&", "§"));
/*  33 */     sb.getTeam("0002Dev").setPrefix(String.valueOf(api.getGroup("Dev").getSuffix().replace("&", "§")) + " " + api.getGroup("Dev").getPrefix().replace("&", "§"));
/*  34 */     sb.getTeam("0003Mod").setPrefix(String.valueOf(api.getGroup("Mod").getSuffix().replace("&", "§")) + " " + api.getGroup("Mod").getPrefix().replace("&", "§"));
/*  35 */     sb.getTeam("0004T-Mod").setPrefix(String.valueOf(api.getGroup("T-Mod").getSuffix().replace("&", "§")) + " " + api.getGroup("T-Mod").getPrefix().replace("&", "§"));
/*  36 */     sb.getTeam("0005Helper").setPrefix(String.valueOf(api.getGroup("Helper").getSuffix().replace("&", "§")) + " " + api.getGroup("Helper").getPrefix().replace("&", "§"));
/*  37 */     sb.getTeam("0006Builder").setPrefix(String.valueOf(api.getGroup("Builder").getSuffix().replace("&", "§")) + " " + api.getGroup("Builder").getPrefix().replace("&", "§"));
/*  38 */     sb.getTeam("0007VIP").setPrefix(String.valueOf(api.getGroup("VIP").getSuffix().replace("&", "§")) + " " + api.getGroup("VIP").getPrefix().replace("&", "§"));
/*  39 */     sb.getTeam("008Emerald").setPrefix(String.valueOf(api.getGroup("Emerald").getSuffix().replace("&", "§")) + " " + api.getGroup("Emerald").getPrefix().replace("&", "§"));
/*  40 */     sb.getTeam("009Souper").setPrefix(String.valueOf(api.getGroup("Souper").getSuffix().replace("&", "§")) + " " + api.getGroup("Souper").getPrefix().replace("&", "§"));
/*  41 */     sb.getTeam("010User").setPrefix(String.valueOf(api.getGroup("User").getSuffix().replace("&", "§")) + " " + api.getGroup("User").getPrefix().replace("&", "§"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setRanks(Player p) {
/*  47 */     PermissionUser user = PermissionsEx.getUser(p);
/*     */     
/*  49 */     String team = "";
/*     */     
/*  51 */     if (user.inGroup("Admin")) {
/*  52 */       team = "0001Admin";
/*  53 */     } else if (user.inGroup("Dev")) {
/*  54 */       team = "0002Dev";
/*  55 */     } else if (user.inGroup("Mod")) {
/*  56 */       team = "0003Mod";
/*  57 */     } else if (user.inGroup("T-Mod")) {
/*  58 */       team = "0004T-Mod";
/*  59 */     } else if (user.inGroup("Helper")) {
/*  60 */       team = "0005Helper";
/*  61 */     } else if (user.inGroup("Builder")) {
/*  62 */       team = "0006Builder";
/*  63 */     } else if (user.inGroup("VIP")) {
/*  64 */       team = "0007VIP";
/*  65 */     } else if (user.inGroup("Emerald")) {
/*  66 */       team = "008Emerald";
/*  67 */     } else if (user.inGroup("Souper")) {
/*  68 */       team = "009Souper";
/*     */     } else {
/*  70 */       team = "010User";
/*     */     } 
/*     */     
/*  73 */     sb.getTeam(team).addPlayer((OfflinePlayer)p);
/*  74 */     p.setDisplayName(String.valueOf(sb.getTeam(team).getPrefix()) + p.getName());
/*  75 */     p.setCustomName(String.valueOf(sb.getTeam(team).getPrefix()) + p.getName());
/*  76 */     p.setPlayerListName(String.valueOf(sb.getTeam(team).getPrefix()) + p.getName());
/*     */     
/*  78 */     for (Player all : Bukkit.getOnlinePlayers()) {
/*     */       
/*  80 */       Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  84 */               all.setScoreboard(RankHandler.sb);
/*     */             }
/*  86 */           },  10L);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getRankName(Player p) {
/*     */     String name;
/*  93 */     PermissionUser user = PermissionsEx.getUser(p);
/*     */ 
/*     */     
/*  96 */     if (user.inGroup("Admin")) {
/*  97 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Admin").getPrefix().replaceAll("&", "§")) + "Administrator";
/*  98 */     } else if (user.inGroup("Dev")) {
/*  99 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Dev").getPrefix().replaceAll("&", "§")) + "Developer";
/* 100 */     } else if (user.inGroup("Mod")) {
/* 101 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Mod").getPrefix().replaceAll("&", "§")) + "Moderator";
/* 102 */     } else if (user.inGroup("T-Mod")) {
/* 103 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("T-Mod").getPrefix().replaceAll("&", "§")) + "Test-Moderator";
/* 104 */     } else if (user.inGroup("Helper")) {
/* 105 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Helper").getPrefix().replaceAll("&", "§")) + "Helper";
/* 106 */     } else if (user.inGroup("Builder")) {
/* 107 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Builder").getPrefix().replaceAll("&", "§")) + "Builder";
/* 108 */     } else if (user.inGroup("VIP")) {
/* 109 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("VIP").getPrefix().replaceAll("&", "§")) + "VIP";
/* 110 */     } else if (user.inGroup("Emerald")) {
/* 111 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Emerald").getPrefix().replaceAll("&", "§")) + "Emerald";
/* 112 */     } else if (user.inGroup("Souper")) {
/* 113 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Souper").getPrefix().replaceAll("&", "§")) + "Souper";
/*     */     } else {
/* 115 */       name = String.valueOf(PermissionsEx.getPermissionManager().getGroup("User").getPrefix().replaceAll("&", "§")) + "User";
/*     */     } 
/* 117 */     return name;
/*     */   }
/*     */   public static String getPrefix(Player p) {
/*     */     String prefix;
/* 121 */     PermissionUser user = PermissionsEx.getUser(p);
/*     */ 
/*     */     
/* 124 */     if (user.inGroup("Admin")) {
/* 125 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Admin").getPrefix()) + p.getName();
/* 126 */     } else if (user.inGroup("Dev")) {
/* 127 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Dev").getPrefix()) + p.getName();
/* 128 */     } else if (user.inGroup("Mod")) {
/* 129 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Mod").getPrefix()) + p.getName();
/* 130 */     } else if (user.inGroup("T-Mod")) {
/* 131 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("T-Mod").getPrefix()) + p.getName();
/* 132 */     } else if (user.inGroup("Helper")) {
/* 133 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Helper").getPrefix()) + p.getName();
/* 134 */     } else if (user.inGroup("Builder")) {
/* 135 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Builder").getPrefix()) + p.getName();
/* 136 */     } else if (user.inGroup("VIP")) {
/* 137 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Vip").getPrefix()) + p.getName();
/* 138 */     } else if (user.inGroup("Emerald")) {
/* 139 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Emerald").getPrefix()) + p.getName();
/* 140 */     } else if (user.inGroup("Souper")) {
/* 141 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("Souper").getPrefix()) + p.getName();
/*     */     } else {
/* 143 */       prefix = String.valueOf(PermissionsEx.getPermissionManager().getGroup("User").getPrefix()) + p.getName();
/*     */     } 
/* 145 */     String pr = prefix.replaceAll("&", "§");
/* 146 */     return pr;
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/RankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */