/*     */ package net.kiligo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.kiligo.kits.Kit;
/*     */ import net.kiligo.kits.KitManager;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.kiligo.util.SettingsConfig;
/*     */ import net.kiligo.util.Var;
/*     */ import net.kiligo.util.getItemHandler;
/*     */ import net.kiligo.util.getTitleHandler;
/*     */ import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Game
/*     */ {
/*     */   public static void setItems(Player p) {
/*  27 */     ItemStack compass = getItemHandler.getItem(Material.COMPASS, "§7» §bTeleporter", null);
/*  28 */     ItemStack settings = getItemHandler.getItem(Material.REDSTONE_COMPARATOR, "§7» §bSettings", null);
/*  29 */     ItemStack profile = getItemHandler.getHead(p.getName(), "§7» §bProfile", null, 1);
/*  30 */     ItemStack kits = getItemHandler.getItem(Material.CHEST, "§7» §bKits", null);
/*     */     
/*  32 */     ItemStack silentmodeon = getItemHandler.getItem(Material.TNT, "§7» §bSilentmode §8- §aon", null);
/*  33 */     ItemStack silentmodeoff = getItemHandler.getItem(Material.TNT, "§7» §bSilentmode §8- §coff", null);
/*     */     
/*  35 */     p.getInventory().setHelmet(null);
/*  36 */     p.getInventory().setChestplate(null);
/*  37 */     p.getInventory().setLeggings(null);
/*  38 */     p.getInventory().setBoots(null);
/*     */     
/*  40 */     p.getInventory().setItem(0, compass);
/*  41 */     p.getInventory().setItem(1, kits);
/*  42 */     p.getInventory().setItem(8, profile);
/*  43 */     p.getInventory().setItem(7, settings);
/*     */     
/*  45 */     if (p.hasPermission("soup.vip")) {
/*  46 */       if (SettingsConfig.isSettingExists(p, "Silentmode")) {
/*  47 */         if (SettingsConfig.getSetting(p, "Silentmode").equals("1")) {
/*  48 */           p.getInventory().setItem(4, silentmodeon);
/*     */         } else {
/*  50 */           p.getInventory().setItem(4, silentmodeoff);
/*     */         } 
/*     */       } else {
/*  53 */         SettingsConfig.setSetting(p, "Silentmode", "0");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPvPItems(Player p) {
/*  62 */     ItemStack compass = getItemHandler.getItem(Material.COMPASS, "§7» §bTeleporter", null);
/*  63 */     ItemStack queue = getItemHandler.getItem(Material.DIAMOND_SWORD, "§7» §bQueues", null);
/*  64 */     ItemStack settings = getItemHandler.getItem(Material.REDSTONE_COMPARATOR, "§7» §bSettings", null);
/*     */     
/*  66 */     p.getInventory().setItem(0, compass);
/*  67 */     p.getInventory().setItem(4, queue);
/*  68 */     p.getInventory().setItem(8, settings);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void refreshPlayer(Player p) {
/*  74 */     p.setHealth(20.0D);
/*  75 */     p.setFoodLevel(20);
/*  76 */     p.setFireTicks(0);
/*  77 */     p.setGameMode(GameMode.SURVIVAL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSoupItems_Normal(Player p) {
/*  82 */     p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
/*  83 */     p.getInventory().setItem(13, new ItemStack(Material.RED_MUSHROOM, 64));
/*  84 */     p.getInventory().setItem(14, new ItemStack(Material.BROWN_MUSHROOM, 64));
/*  85 */     p.getInventory().setItem(15, new ItemStack(Material.BOWL, 64));
/*     */     
/*  87 */     p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
/*  88 */     p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
/*  89 */     p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/*  90 */     p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/*     */     
/*  92 */     for (int i = 0; i < 36; i++) {
/*  93 */       if (p.getInventory().getItem(i) == null) {
/*  94 */         p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setSoupItems_Noarmor(Player p) {
/* 100 */     p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
/* 101 */     p.getInventory().setItem(13, new ItemStack(Material.RED_MUSHROOM, 64));
/* 102 */     p.getInventory().setItem(14, new ItemStack(Material.BROWN_MUSHROOM, 64));
/* 103 */     p.getInventory().setItem(15, new ItemStack(Material.BOWL, 64));
/*     */     
/* 105 */     for (int i = 0; i < 36; i++) {
/* 106 */       if (p.getInventory().getItem(i) == null) {
/* 107 */         p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSoupItems_Norecraft(Player p) {
/* 114 */     p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
/*     */     
/* 116 */     p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
/* 117 */     p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
/* 118 */     p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/* 119 */     p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/*     */     
/* 121 */     for (int i = 0; i < 36; i++) {
/* 122 */       if (p.getInventory().getItem(i) == null) {
/* 123 */         p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearArmor(Player p) {
/* 130 */     p.getInventory().setHelmet(null);
/* 131 */     p.getInventory().setChestplate(null);
/* 132 */     p.getInventory().setLeggings(null);
/* 133 */     p.getInventory().setBoots(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setNoFallDamage(final Player p, int seconds) {
/* 140 */     Var.addNoFallDamage(p);
/*     */     
/* 142 */     Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.getInstance(), new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 146 */             Var.removeNoFallDamage(p);
/*     */           }
/* 148 */         },  (20 * seconds));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void openCompass(Player p) {
/* 153 */     Inventory inv = Bukkit.createInventory(null, 45, "§cTeleporter");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     inv.setItem(10, getItemHandler.getItem(Material.IRON_CHESTPLATE, "§3EarlyHG", "\n§7Click to teleport to EarlyHG"));
/* 164 */     inv.setItem(3, getItemHandler.getItem(Material.FENCE, "§3Parkour", "\n§7Click to teleport to Parkour"));
/* 165 */     inv.setItem(5, getItemHandler.getItem(Material.WATER_BUCKET, "§3MLG", "\n§7Click to teleport to MLG"));
/* 166 */     inv.setItem(16, getItemHandler.getItem(Material.LAVA_BUCKET, "§3Lavachallenge", "\n§7Click to teleport to Lavachallenge"));
/* 167 */     inv.setItem(22, getItemHandler.getItem(Material.COMPASS, "§3Spawn", "\n§7Click to teleport to Spawn"));
/* 168 */     inv.setItem(28, getItemHandler.getItem(Material.CHEST, "§3Feast", "\n§7Click to teleport to Feast"));
/* 169 */     inv.setItem(39, getItemHandler.getItem(Material.IRON_SWORD, "§3PvP", "\n§7Click to teleport to PvP"));
/*     */ 
/*     */ 
/*     */     
/* 173 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public static void openQueues(Player p) {
/* 177 */     Inventory inv = Bukkit.createInventory(null, 9, "§bQueues");
/*     */     
/* 179 */     int position = 0;
/* 180 */     if (PvPQueue.isQueue(p)) {
/* 181 */       for (int i = 0; i < PvPQueue.queue.size(); i++) {
/* 182 */         if (PvPQueue.queue.get(i) == p) {
/* 183 */           position = i + 1;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 188 */     if (PvPQueue.isQueue(p)) {
/* 189 */       inv.setItem(4, getItemHandler.getItemEnch(Material.IRON_CHESTPLATE, "§cNormal Fight", "§b» §7Players: §f" + PvPQueue.queue.size() + "\n§b» §7Your position: §f" + position + "\n\n§aYou are in this queue", Enchantment.ARROW_INFINITE));
/*     */     }
/* 191 */     else if (PvPQueue.isActivated()) {
/* 192 */       inv.setItem(4, getItemHandler.getItem(Material.IRON_CHESTPLATE, "§cNormal Fight", "§b» §7Players: §f" + PvPQueue.queue.size() + "\n\n§cClick to join"));
/*     */     } else {
/* 194 */       inv.setItem(4, getItemHandler.getItem(Material.IRON_CHESTPLATE, "§cNormal Fight", "§b» §7Players: §f" + PvPQueue.queue.size() + "\n\n§4Not joinable"));
/*     */     } 
/*     */     
/* 197 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public static void openKits(Player p) {
/* 201 */     Inventory inv = Bukkit.createInventory(null, 54, "§bKits");
/*     */     
/* 203 */     for (int i = 0; i < KitManager.getKits().size(); i++) {
/* 204 */       inv.setItem(i, getItemHandler.getItem(((Kit)KitManager.kits.get(i)).getSymbol(), "§7» §b" + ((Kit)KitManager.kits.get(i)).getName(), "§b» " + ((Kit)KitManager.kits.get(i)).getDescription() + "\n\n§b» §7Price: §f" + ((Kit)KitManager.kits.get(i)).getPrice()));
/*     */     }
/*     */     
/* 207 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public static void openSettings(Player p) {
/* 211 */     Inventory inv = Bukkit.createInventory(null, 36, "§bSettings");
/*     */     
/* 213 */     ItemStack on = getItemHandler.getItem(Material.EMERALD, "§aOn", null);
/* 214 */     ItemStack off = getItemHandler.getItem(Material.REDSTONE, "§cOff", null);
/*     */     int i;
/* 216 */     for (i = 0; i < 9; ) { inv.setItem(i, getItemHandler.getGlass(".", 8, 1, null)); i++; }
/* 217 */      for (i = 27; i < 36; ) { inv.setItem(i, getItemHandler.getGlass(".", 8, 1, null)); i++; }
/* 218 */      inv.setItem(4, getItemHandler.getItem(Material.PAPER, "§a§lClick on the Items to change the setting", null));
/*     */ 
/*     */     
/* 221 */     inv.setItem(9, getItemHandler.getItem(Material.REDSTONE_TORCH_ON, "§7» §bDeath messages", "§7§oToggle the global death messages"));
/* 222 */     inv.setItem(10, getItemHandler.getItem(Material.IRON_CHESTPLATE, "§7» §bAuto-PvP", "§7§oJoin the next 1vs1 automatically"));
/* 223 */     inv.setItem(11, getItemHandler.getItem(Material.EYE_OF_ENDER, "§7» §bShow players", "§7§oToggle the player-hider"));
/*     */     
/* 225 */     if (SettingsConfig.getSetting(p, "DeathMSG") != null) {
/* 226 */       if (SettingsConfig.getSetting(p, "DeathMSG").equals("0")) {
/* 227 */         inv.setItem(18, off);
/*     */       } else {
/* 229 */         inv.setItem(18, on);
/*     */       } 
/*     */     } else {
/*     */       
/* 233 */       p.sendMessage(String.valueOf(Var.getPr()) + "§cError while loading your settings.. Please rejoin!");
/*     */     } 
/*     */     
/* 236 */     if (SettingsConfig.getSetting(p, "AutoPvP") != null) {
/* 237 */       if (SettingsConfig.getSetting(p, "AutoPvP").equals("0")) {
/* 238 */         inv.setItem(19, off);
/*     */       } else {
/* 240 */         inv.setItem(19, on);
/*     */       } 
/*     */     } else {
/*     */       
/* 244 */       p.sendMessage(String.valueOf(Var.getPr()) + "§cError while loading your settings.. Please rejoin!");
/*     */     } 
/*     */     
/* 247 */     if (SettingsConfig.getSetting(p, "Hider") != null) {
/* 248 */       if (SettingsConfig.getSetting(p, "Hider").equals("0")) {
/* 249 */         inv.setItem(20, off);
/*     */       } else {
/* 251 */         inv.setItem(20, on);
/*     */       } 
/*     */     } else {
/*     */       
/* 255 */       p.sendMessage(String.valueOf(Var.getPr()) + "§cError while loading your settings.. Please rejoin!");
/*     */     } 
/*     */     
/* 258 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public static void openKitAuswahl(Player p, Kit kit) {
/* 262 */     Inventory inv = Bukkit.createInventory(null, 9, "§fKit: §b" + kit.getName());
/* 263 */     inv.setItem(0, getItemHandler.getItem(kit.getSymbol(), "§f" + kit.getName(), null));
/* 264 */     inv.setItem(3, getItemHandler.getItem(Material.GOLD_NUGGET, "§6Price", "§b» §7" + kit.getPrice()));
/* 265 */     inv.setItem(4, getItemHandler.getItem(Material.PAPER, "§fDescription", "§b» " + kit.getDescription()));
/* 266 */     inv.setItem(7, getItemHandler.getItem(Material.EMERALD, "§aSelect " + kit.getName(), null));
/* 267 */     inv.setItem(8, getItemHandler.getItem(Material.SLIME_BALL, "§cBack to kits", null));
/* 268 */     p.openInventory(inv);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CheckSettings(Player p) {
/* 273 */     if (!SettingsConfig.isSettingExists(p, "DeathMSG")) {
/* 274 */       SettingsConfig.setSetting(p, "DeathMSG", "1");
/*     */     }
/* 276 */     if (!SettingsConfig.isSettingExists(p, "AutoPvP")) {
/* 277 */       SettingsConfig.setSetting(p, "AutoPvP", "1");
/*     */     }
/* 279 */     if (!SettingsConfig.isSettingExists(p, "Hider")) {
/* 280 */       SettingsConfig.setSetting(p, "Hider", "1");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void silentPlayer(Player p) {
/* 285 */     Var.getVanished().add(p);
/*     */     
/* 287 */     for (Player all : Bukkit.getOnlinePlayers()) {
/* 288 */       if (!all.hasPermission("soup.vanish")) {
/* 289 */         all.hidePlayer(p);
/*     */       }
/* 291 */       p.hidePlayer(all);
/*     */     } 
/* 293 */     p.setPlayerListName(String.valueOf(p.getDisplayName()) + " §8» §eSilent");
/*     */   }
/*     */   
/*     */   public static void unsilentPlayer(Player p) {
/* 297 */     Var.getVanished().remove(p);
/* 298 */     for (Player all : Bukkit.getOnlinePlayers()) {
/* 299 */       all.showPlayer(p);
/* 300 */       p.showPlayer(all);
/*     */     } 
/* 302 */     p.setPlayerListName(p.getDisplayName());
/*     */   }
/*     */   
/*     */   public static void setTab(Player p) {
/* 306 */     getTitleHandler.sendTabList(p, "                §b" + Var.getServerName() + "§f.net §8» §eYour Soup Server              \n§fConnected players §8» §4" + Bukkit.getOnlinePlayers().size() + "\n          ", "\n§e" + Var.getServerName() + " §8» §e" + Main.getInstance().getDescription().getVersion() + "\n§3Shop §8» §bshop." + Var.getServerName() + ".com");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void startTabScheduler() {
/* 311 */     Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)Main.getInstance(), new Runnable()
/*     */         {
/*     */           public void run() {
/* 314 */             for (Player all : Bukkit.getOnlinePlayers()) {
/* 315 */               Game.setTab(all);
/*     */             }
/*     */           }
/* 318 */         },  20L, 40L);
/*     */   }
/*     */   
/*     */   public static void HideAllPlayers(Player p) {
/* 322 */     ArrayList<Player> all = new ArrayList<>();
/* 323 */     for (Player a : Bukkit.getOnlinePlayers()) {
/* 324 */       all.add(a);
/*     */     }
/*     */     
/* 327 */     for (int i = 0; i < all.size(); i++) {
/* 328 */       p.hidePlayer(all.get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void ShowAllPlayers(Player p) {
/* 334 */     ArrayList<Player> all = new ArrayList<>();
/* 335 */     for (Player a : Bukkit.getOnlinePlayers()) {
/* 336 */       all.add(a);
/*     */     }
/*     */     
/* 339 */     for (int i = 0; i < all.size(); i++) {
/* 340 */       p.showPlayer(all.get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendRespawn(Player p) {
/* 347 */     PacketPlayInClientCommand packet = new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
/* 348 */     (((CraftPlayer)p).getHandle()).playerConnection.a(packet);
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/main/Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */