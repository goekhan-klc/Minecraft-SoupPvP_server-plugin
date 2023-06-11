/*     */ package net.kiligo.util;
/*     */ 
/*     */ import net.kiligo.kits.KitManager;
/*     */ import net.kiligo.pvp.Fight;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
/*     */ import net.minecraft.server.v1_8_R3.Packet;
/*     */ import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
/*     */ import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
/*     */ import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
/*     */ import net.minecraft.server.v1_8_R3.Scoreboard;
/*     */ import net.minecraft.server.v1_8_R3.ScoreboardObjective;
/*     */ import net.minecraft.server.v1_8_R3.ScoreboardScore;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.scoreboard.DisplaySlot;
/*     */ import org.bukkit.scoreboard.Objective;
/*     *
/*     */ 
/*     */ 
/*     */ public class ScoreboardHandler
/*     */ {
/*     */   public static void setScoreboard(Player p, String board) {
/*     */     try {
/*  26 */       if (board.equals("normal")) {
/*     */         
/*  28 */         Scoreboard sb = new Scoreboard();
/*     */         
/*  30 */         ScoreboardObjective obj = sb.registerObjective("ad", IScoreboardCriteria.b);
/*  31 */         obj.setDisplayName("§8➤ §b" + Var.getServerName());
/*     */         
/*  33 */         PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
/*  34 */         PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
/*     */         
/*  36 */         PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
/*  37 */         sendPacket(p, (Packet)removePacket);
/*  38 */         sendPacket(p, (Packet)createPacket);
/*  39 */         sendPacket(p, (Packet)display);
/*     */         
/*  41 */         ScoreboardScore a1 = new ScoreboardScore(sb, obj, "               ");
/*  42 */         a1.setScore(14);
/*  43 */         PacketPlayOutScoreboardScore p1 = new PacketPlayOutScoreboardScore(a1);
/*  44 */         sendPacket(p, (Packet)p1);
/*     */         
/*  46 */         ScoreboardScore a2 = new ScoreboardScore(sb, obj, "§d➲ §7Rank:");
/*  47 */         a2.setScore(13);
/*  48 */         PacketPlayOutScoreboardScore p2 = new PacketPlayOutScoreboardScore(a2);
/*  49 */         sendPacket(p, (Packet)p2);
/*     */         
/*  51 */         ScoreboardScore a3 = new ScoreboardScore(sb, obj, " §8» " + RankHandler.getRankName(p));
/*  52 */         a3.setScore(12);
/*  53 */         PacketPlayOutScoreboardScore p3 = new PacketPlayOutScoreboardScore(a3);
/*  54 */         sendPacket(p, (Packet)p3);
/*     */         
/*  56 */         ScoreboardScore a4 = new ScoreboardScore(sb, obj, "  ");
/*  57 */         a4.setScore(11);
/*  58 */         PacketPlayOutScoreboardScore p4 = new PacketPlayOutScoreboardScore(a4);
/*  59 */         sendPacket(p, (Packet)p4);
/*     */         
/*  61 */         ScoreboardScore a5 = new ScoreboardScore(sb, obj, "§e✦  §7Your Coins:");
/*  62 */         a5.setScore(10);
/*  63 */         PacketPlayOutScoreboardScore p5 = new PacketPlayOutScoreboardScore(a5);
/*  64 */         sendPacket(p, (Packet)p5);
/*     */         
/*  66 */         ScoreboardScore a6 = new ScoreboardScore(sb, obj, " §8» §e-/-");
/*  67 */         a6.setScore(9);
/*  68 */         PacketPlayOutScoreboardScore p6 = new PacketPlayOutScoreboardScore(a6);
/*  69 */         sendPacket(p, (Packet)p6);
/*     */         
/*  71 */         ScoreboardScore a7 = new ScoreboardScore(sb, obj, "   ");
/*  72 */         a7.setScore(8);
/*  73 */         PacketPlayOutScoreboardScore p7 = new PacketPlayOutScoreboardScore(a7);
/*  74 */         sendPacket(p, (Packet)p7);
/*     */         
/*  76 */         ScoreboardScore a8 = new ScoreboardScore(sb, obj, "§c➤ §7Current Kit:");
/*  77 */         a8.setScore(7);
/*  78 */         PacketPlayOutScoreboardScore p8 = new PacketPlayOutScoreboardScore(a8);
/*  79 */         sendPacket(p, (Packet)p8);
/*     */         
/*  81 */         ScoreboardScore a9 = new ScoreboardScore(sb, obj, " §8» §c" + KitManager.getCurrentKit(p).getName());
/*  82 */         a9.setScore(6);
/*  83 */         PacketPlayOutScoreboardScore p9 = new PacketPlayOutScoreboardScore(a9);
/*  84 */         sendPacket(p, (Packet)p9);
/*     */         
/*  86 */         ScoreboardScore a10 = new ScoreboardScore(sb, obj, "§8§m--------------");
/*  87 */         a10.setScore(5);
/*  88 */         PacketPlayOutScoreboardScore p10 = new PacketPlayOutScoreboardScore(a10);
/*  89 */         sendPacket(p, (Packet)p10);
/*     */         
/*  91 */         ScoreboardScore a11 = new ScoreboardScore(sb, obj, "§f● §7Web/Voice:");
/*  92 */         a11.setScore(4);
/*  93 */         PacketPlayOutScoreboardScore p11 = new PacketPlayOutScoreboardScore(a11);
/*  94 */         sendPacket(p, (Packet)p11);
/*     */         
/*  96 */         ScoreboardScore a12 = new ScoreboardScore(sb, obj, " §8» §fts." + Var.getServerName() + ".de");
/*  97 */         a12.setScore(3);
/*  98 */         PacketPlayOutScoreboardScore p12 = new PacketPlayOutScoreboardScore(a12);
/*  99 */         sendPacket(p, (Packet)p12);
/*     */       }
/* 101 */       else if (board.equalsIgnoreCase("game")) {
/*     */         
/* 103 */         Scoreboard sb = new Scoreboard();
/*     */         
/* 105 */         ScoreboardObjective obj = sb.registerObjective("ad", IScoreboardCriteria.b);
/* 106 */         obj.setDisplayName("§8➤ §b" + Var.getServerName());
/*     */         
/* 108 */         PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
/* 109 */         PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
/*     */         
/* 111 */         PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
/* 112 */         sendPacket(p, (Packet)removePacket);
/* 113 */         sendPacket(p, (Packet)createPacket);
/* 114 */         sendPacket(p, (Packet)display);
/*     */         
/* 116 */         ScoreboardScore a1 = new ScoreboardScore(sb, obj, "               ");
/* 117 */         a1.setScore(5);
/* 118 */         PacketPlayOutScoreboardScore p1 = new PacketPlayOutScoreboardScore(a1);
/* 119 */         sendPacket(p, (Packet)p1);
/*     */         
/* 121 */         ScoreboardScore a2 = new ScoreboardScore(sb, obj, "§a✦ §7Game:");
/* 122 */         a2.setScore(4);
/* 123 */         PacketPlayOutScoreboardScore p2 = new PacketPlayOutScoreboardScore(a2);
/* 124 */         sendPacket(p, (Packet)p2);
/*     */         
/* 126 */         ScoreboardScore a3 = new ScoreboardScore(sb, obj, " §8» §a" + Var.getCurrentGame(p));
/* 127 */         a3.setScore(3);
/* 128 */         PacketPlayOutScoreboardScore p3 = new PacketPlayOutScoreboardScore(a3);
/* 129 */         sendPacket(p, (Packet)p3);
/*     */         
/* 131 */         ScoreboardScore a10 = new ScoreboardScore(sb, obj, "§8§m--------------");
/* 132 */         a10.setScore(2);
/* 133 */         PacketPlayOutScoreboardScore p10 = new PacketPlayOutScoreboardScore(a10);
/* 134 */         sendPacket(p, (Packet)p10);
/*     */         
/* 136 */         ScoreboardScore a11 = new ScoreboardScore(sb, obj, "§f● §7Web/Voice:");
/* 137 */         a11.setScore(1);
/* 138 */         PacketPlayOutScoreboardScore p11 = new PacketPlayOutScoreboardScore(a11);
/* 139 */         sendPacket(p, (Packet)p11);
/*     */         
/* 141 */         ScoreboardScore a12 = new ScoreboardScore(sb, obj, " §8» §fts." + Var.getServerName() + ".de");
/* 142 */         a12.setScore(0);
/* 143 */         PacketPlayOutScoreboardScore p12 = new PacketPlayOutScoreboardScore(a12);
/* 144 */         sendPacket(p, (Packet)p12);
/*     */       }
/* 146 */       else if (board.equalsIgnoreCase("kit")) {
/*     */         
/* 148 */         Scoreboard sb = new Scoreboard();
/*     */         
/* 150 */         ScoreboardObjective obj = sb.registerObjective("ad", IScoreboardCriteria.b);
/* 151 */         obj.setDisplayName("§8➤ §b" + Var.getServerName());
/*     */         
/* 153 */         PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
/* 154 */         PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
/* 155 */         PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
/*     */         
/* 157 */         sendPacket(p, (Packet)removePacket);
/* 158 */         sendPacket(p, (Packet)createPacket);
/* 159 */         sendPacket(p, (Packet)display);
/*     */         
/* 161 */         ScoreboardScore a1 = new ScoreboardScore(sb, obj, "               ");
/* 162 */         a1.setScore(8);
/* 163 */         PacketPlayOutScoreboardScore p1 = new PacketPlayOutScoreboardScore(a1);
/* 164 */         sendPacket(p, (Packet)p1);
/*     */         
/* 166 */         ScoreboardScore a2 = new ScoreboardScore(sb, obj, "§a✦ §7Game:");
/* 167 */         a2.setScore(7);
/* 168 */         PacketPlayOutScoreboardScore p2 = new PacketPlayOutScoreboardScore(a2);
/* 169 */         sendPacket(p, (Packet)p2);
/*     */         
/* 171 */         ScoreboardScore a3 = new ScoreboardScore(sb, obj, " §8» §a" + Var.getCurrentGame(p));
/* 172 */         a3.setScore(6);
/* 173 */         PacketPlayOutScoreboardScore p3 = new PacketPlayOutScoreboardScore(a3);
/* 174 */         sendPacket(p, (Packet)p3);
/*     */         
/* 176 */         ScoreboardScore a4 = new ScoreboardScore(sb, obj, "  ");
/* 177 */         a4.setScore(5);
/* 178 */         PacketPlayOutScoreboardScore p4 = new PacketPlayOutScoreboardScore(a4);
/* 179 */         sendPacket(p, (Packet)p4);
/*     */         
/* 181 */         ScoreboardScore a8 = new ScoreboardScore(sb, obj, "§c➤ §7Current Kit:");
/* 182 */         a8.setScore(4);
/* 183 */         PacketPlayOutScoreboardScore p8 = new PacketPlayOutScoreboardScore(a8);
/* 184 */         sendPacket(p, (Packet)p8);
/*     */         
/* 186 */         ScoreboardScore a9 = new ScoreboardScore(sb, obj, " §8» §c" + KitManager.getCurrentKit(p).getName());
/* 187 */         a9.setScore(3);
/* 188 */         PacketPlayOutScoreboardScore p9 = new PacketPlayOutScoreboardScore(a9);
/* 189 */         sendPacket(p, (Packet)p9);
/*     */         
/* 191 */         ScoreboardScore a10 = new ScoreboardScore(sb, obj, "§8§m--------------");
/* 192 */         a10.setScore(2);
/* 193 */         PacketPlayOutScoreboardScore p10 = new PacketPlayOutScoreboardScore(a10);
/* 194 */         sendPacket(p, (Packet)p10);
/*     */         
/* 196 */         ScoreboardScore a11 = new ScoreboardScore(sb, obj, "§f● §7Web/Voice:");
/* 197 */         a11.setScore(1);
/* 198 */         PacketPlayOutScoreboardScore p11 = new PacketPlayOutScoreboardScore(a11);
/* 199 */         sendPacket(p, (Packet)p11);
/*     */         
/* 201 */         ScoreboardScore a12 = new ScoreboardScore(sb, obj, " §8» §fts." + Var.getServerName() + ".de");
/* 202 */         a12.setScore(0);
/* 203 */         PacketPlayOutScoreboardScore p12 = new PacketPlayOutScoreboardScore(a12);
/* 204 */         sendPacket(p, (Packet)p12);
/*     */       }
/* 206 */       else if (board.equalsIgnoreCase("pvp")) {
/*     */         
/* 208 */         Scoreboard sb = new Scoreboard();
/*     */         
/* 210 */         ScoreboardObjective obj = sb.registerObjective("ad", IScoreboardCriteria.b);
/* 211 */         obj.setDisplayName("§8➤ §b" + Var.getServerName());
/*     */         
/* 213 */         PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
/* 214 */         PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
/*     */         
/* 216 */         PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
/* 217 */         sendPacket(p, (Packet)removePacket);
/* 218 */         sendPacket(p, (Packet)createPacket);
/* 219 */         sendPacket(p, (Packet)display);
/*     */         
/* 221 */         ScoreboardScore a1 = new ScoreboardScore(sb, obj, "               ");
/* 222 */         a1.setScore(8);
/* 223 */         PacketPlayOutScoreboardScore p1 = new PacketPlayOutScoreboardScore(a1);
/* 224 */         sendPacket(p, (Packet)p1);
/*     */         
/* 226 */         ScoreboardScore a2 = new ScoreboardScore(sb, obj, "§a✦ §7Game:");
/* 227 */         a2.setScore(7);
/* 228 */         PacketPlayOutScoreboardScore p2 = new PacketPlayOutScoreboardScore(a2);
/* 229 */         sendPacket(p, (Packet)p2);
/*     */         
/* 231 */         ScoreboardScore a3 = new ScoreboardScore(sb, obj, " §8» §a" + Var.getCurrentGame(p));
/* 232 */         a3.setScore(6);
/* 233 */         PacketPlayOutScoreboardScore p3 = new PacketPlayOutScoreboardScore(a3);
/* 234 */         sendPacket(p, (Packet)p3);
/*     */         
/* 236 */         ScoreboardScore a4 = new ScoreboardScore(sb, obj, "  ");
/* 237 */         a4.setScore(5);
/* 238 */         PacketPlayOutScoreboardScore p4 = new PacketPlayOutScoreboardScore(a4);
/* 239 */         sendPacket(p, (Packet)p4);
/*     */         
/* 241 */         ScoreboardScore a10 = new ScoreboardScore(sb, obj, "§8§m--------------");
/* 242 */         a10.setScore(2);
/* 243 */         PacketPlayOutScoreboardScore p10 = new PacketPlayOutScoreboardScore(a10);
/* 244 */         sendPacket(p, (Packet)p10);
/*     */         
/* 246 */         ScoreboardScore a11 = new ScoreboardScore(sb, obj, "§f● §7Web/Voice:");
/* 247 */         a11.setScore(1);
/* 248 */         PacketPlayOutScoreboardScore p11 = new PacketPlayOutScoreboardScore(a11);
/* 249 */         sendPacket(p, (Packet)p11);
/*     */         
/* 251 */         ScoreboardScore a12 = new ScoreboardScore(sb, obj, " §8» §fts." + Var.getServerName() + ".de");
/* 252 */         a12.setScore(0);
/* 253 */         PacketPlayOutScoreboardScore p12 = new PacketPlayOutScoreboardScore(a12);
/* 254 */         sendPacket(p, (Packet)p12);
/* 255 */         if (Fight.infight.contains(p)) {
/*     */           
/* 257 */           ScoreboardScore a5 = new ScoreboardScore(sb, obj, "§d➟ §fIn Fight against " + RankHandler.getPrefix((Player)Fight.infightwith.get(p)));
/* 258 */           a5.setScore(3);
/* 259 */           PacketPlayOutScoreboardScore p5 = new PacketPlayOutScoreboardScore(a5);
/* 260 */           sendPacket(p, (Packet)p5);
/*     */           return;
/*     */         } 
/* 263 */         if (PvPQueue.isQueue(p))
/*     */         {
/* 265 */           ScoreboardScore a5 = new ScoreboardScore(sb, obj, "§d➟ §7Queue:");
/* 266 */           a5.setScore(4);
/* 267 */           PacketPlayOutScoreboardScore p5 = new PacketPlayOutScoreboardScore(a5);
/* 268 */           sendPacket(p, (Packet)p5);
/*     */           
/* 270 */           ScoreboardScore a6 = new ScoreboardScore(sb, obj, " §8» §aYes");
/* 271 */           a6.setScore(3);
/* 272 */           PacketPlayOutScoreboardScore p6 = new PacketPlayOutScoreboardScore(a6);
/* 273 */           sendPacket(p, (Packet)p6);
/*     */         }
/* 275 */         else if (!PvPQueue.isQueue(p))
/*     */         {
/* 277 */           ScoreboardScore a5 = new ScoreboardScore(sb, obj, "§d➟ §7Queue:");
/* 278 */           a5.setScore(4);
/* 279 */           PacketPlayOutScoreboardScore p5 = new PacketPlayOutScoreboardScore(a5);
/* 280 */           sendPacket(p, (Packet)p5);
/*     */           
/* 282 */           ScoreboardScore a6 = new ScoreboardScore(sb, obj, " §8» §cNo");
/* 283 */           a6.setScore(3);
/* 284 */           PacketPlayOutScoreboardScore p6 = new PacketPlayOutScoreboardScore(a6);
/* 285 */           sendPacket(p, (Packet)p6);
/*     */         }
/*     */       
/*     */       } 
/* 289 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearScoreboard(Player p) {
/* 294 */     Scoreboard sb = (Scoreboard)Bukkit.getScoreboardManager().getNewScoreboard();
/* 295 */     Objective ob = (Objective)sb.getObjective("adasd");
/* 296 */     ob.setDisplaySlot(DisplaySlot.SIDEBAR);
/* 297 */     ob.setDisplayName("");
/* 298 */     sb.setDisplaySlot(1, (ScoreboardObjective)ob);
/*     */     
/* 300 */     p.setScoreboard((org.bukkit.scoreboard.Scoreboard)sb);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void sendPacket(Player p, Packet packet) {
/* 305 */     (((CraftPlayer)p).getHandle()).playerConnection.sendPacket(packet);
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/ScoreboardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */