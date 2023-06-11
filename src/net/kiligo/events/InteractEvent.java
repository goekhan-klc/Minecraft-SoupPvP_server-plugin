/*     */ package net.kiligo.events;
/*     */ 
/*     */ import net.kiligo.main.Game;
/*     */ import net.kiligo.util.SettingsConfig;
/*     */ import net.kiligo.util.Var;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class InteractEvent
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onInteract(PlayerInteractEvent e) {
/*  22 */     Player p = e.getPlayer();
/*     */     
/*  24 */     if (e.hasItem() && 
/*  25 */       e.getItem() != null && (
/*  26 */       e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && 
/*  27 */       e.getItem().getType().equals(Material.MUSHROOM_SOUP) && 
/*  28 */       p.getHealth() != 20.0D) {
/*  29 */       if (p.getHealth() <= 14.0D) {
/*  30 */         p.setHealth(p.getHealth() + 6.0D);
/*     */       } else {
/*  32 */         p.setHealth(20.0D);
/*     */       } 
/*  34 */       p.setFoodLevel(p.getFoodLevel() + 6);
/*  35 */       p.getItemInHand().setType(Material.BOWL);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     if (e.hasItem() && 
/*  43 */       e.getItem() != null && 
/*  44 */       e.getItem().hasItemMeta() && (
/*  45 */       e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
/*     */       
/*  47 */       if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §bTeleporter")) {
/*  48 */         e.setCancelled(true);
/*  49 */         Game.openCompass(p);
/*     */       } 
/*     */       
/*  52 */       if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §bKits")) {
/*  53 */         e.setCancelled(true);
/*  54 */         Game.openKits(p);
/*     */       } 
/*     */       
/*  57 */       if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §bQueues")) {
/*  58 */         e.setCancelled(true);
/*  59 */         Game.openQueues(p);
/*     */       } 
/*     */       
/*  62 */       if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §bSettings")) {
/*  63 */         e.setCancelled(true);
/*  64 */         Game.openSettings(p);
/*     */       } 
/*     */       
/*  67 */       if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §bSilentmode §8- §coff")) {
/*  68 */         e.setCancelled(true);
/*  69 */         SettingsConfig.setSetting(p, "Silentmode", "1");
/*  70 */         p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/*  71 */         Game.setItems(p);
/*  72 */         p.sendMessage(String.valueOf(Var.getPr()) + "§7Your Silentmode was §aaktivated§7!");
/*  73 */         Game.silentPlayer(p);
/*     */       } 
/*     */       
/*  76 */       if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §bSilentmode §8- §aon")) {
/*  77 */         e.setCancelled(true);
/*  78 */         SettingsConfig.setSetting(p, "Silentmode", "0");
/*  79 */         p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
/*  80 */         Game.setItems(p);
/*  81 */         p.sendMessage(String.valueOf(Var.getPr()) + "§7Your Silentmode was §cdeactivated§7!");
/*  82 */         Game.unsilentPlayer(p);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     if (e.getClickedBlock() != null && 
/*  93 */       e.getClickedBlock().getType().equals(Material.CHEST) && (
/*  94 */       Var.getCurrentGame(p).equals("Feast") || Var.getCurrentGame(p).equals("EarlyHG"))) {
/*  95 */       e.setCancelled(true);
/*  96 */       Inventory inv = Bukkit.createInventory(null, 27, "§cFree Soups");
/*     */       
/*  98 */       for (int i = 0; i < 27; i++) {
/*  99 */         inv.setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
/*     */       }
/*     */       
/* 102 */       p.openInventory(inv);
/* 103 */       p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/InteractEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */