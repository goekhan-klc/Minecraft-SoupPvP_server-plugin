/*     */ package net.kiligo.main;
/*     */ 
/*     */ import com.onarandombox.MultiverseCore.MultiverseCore;
/*     */ import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
/*     */ import java.util.ArrayList;
/*     */ import net.kiligo.commands.EditMode;
/*     */ import net.kiligo.commands.PermissionSystem;
/*     */ import net.kiligo.commands.PvP;
/*     */ import net.kiligo.commands.Test;
/*     */ import net.kiligo.commands.setSpawnCommand;
/*     */ import net.kiligo.events.AsyncPlayerChatEvent;
/*     */ import net.kiligo.events.ClickEvent;
/*     */ import net.kiligo.events.DeathEvent;
/*     */ import net.kiligo.events.InteractEvent;
/*     */ import net.kiligo.events.JoinEvent;
/*     */ import net.kiligo.events.MoveEvent;
/*     */ import net.kiligo.events.Region;
/*     */ import net.kiligo.events.WorldEvents;
/*     */ import net.kiligo.pvp.PvPQueue;
/*     */ import net.kiligo.util.RankHandler;
/*     */ import net.kiligo.util.Var;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends JavaPlugin
/*     */ {
/*     */   private static Main instance;
/*     */   
/*     */   public void onEnable() {
/*  40 */     instance = this;
/*     */     
/*  42 */     Bukkit.getPluginManager().registerEvents((Listener)new JoinEvent(), (Plugin)this);
/*  43 */     Bukkit.getPluginManager().registerEvents((Listener)new WorldEvents(), (Plugin)this);
/*  44 */     Bukkit.getPluginManager().registerEvents((Listener)new InteractEvent(), (Plugin)this);
/*  45 */     Bukkit.getPluginManager().registerEvents((Listener)new AsyncPlayerChatEvent(), (Plugin)this);
/*  46 */     Bukkit.getPluginManager().registerEvents((Listener)new ClickEvent(), (Plugin)this);
/*  47 */     Bukkit.getPluginManager().registerEvents((Listener)new Region(), (Plugin)this);
/*  48 */     Bukkit.getPluginManager().registerEvents((Listener)new DeathEvent(), (Plugin)this);
/*  49 */     Bukkit.getPluginManager().registerEvents((Listener)new MoveEvent(), (Plugin)this);
/*     */     
/*  51 */     getCommand("setspawn").setExecutor((CommandExecutor)new setSpawnCommand());
/*  52 */     getCommand("ps").setExecutor((CommandExecutor)new PermissionSystem());
/*  53 */     getCommand("edit").setExecutor((CommandExecutor)new EditMode());
/*  54 */     getCommand("pvp").setExecutor((CommandExecutor)new PvP());
/*  55 */     getCommand("npc").setExecutor((CommandExecutor)new Test());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     RankHandler.setTeams();
/*     */     
/*  62 */     ArrayList<String> games = Var.getGames();
/*  63 */     games.add("Feast");
/*  64 */     games.add("EarlyHG");
/*  65 */     games.add("Parkour");
/*  66 */     games.add("MLG");
/*  67 */     games.add("Lavachallenge");
/*  68 */     games.add("Spawn");
/*  69 */     games.add("PvP");
/*  70 */     games.add("PvPmiddle");
/*     */     
/*  72 */     for (int i = 0; i > Bukkit.getWorlds().size(); i++) {
/*  73 */       for (Entity e : ((World)Bukkit.getWorlds().get(i)).getEntities()) {
/*  74 */         if (!(e instanceof org.bukkit.entity.Player)) {
/*  75 */           LivingEntity e1 = (LivingEntity)e;
/*  76 */           e1.damage(100.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  81 */     Game.startTabScheduler();
/*  82 */     PvPQueue.startQueueCounter();
/*  83 */     PvPQueue.startQueueUtils();
/*     */     
/*  85 */     System.out.println("[Soup] Plugin erfolgreich geladen!");
/*     */   }
/*     */   
/*     */   private WorldGuardPlugin getWorldGuard() {
/*  89 */     Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
/*     */     
/*  91 */     if ((((plugin == null) ? 1 : 0) | ((plugin instanceof WorldGuardPlugin) ? 0 : 1)) != 0) {
/*  92 */       return null;
/*     */     }
/*     */     
/*  95 */     return (WorldGuardPlugin)plugin;
/*     */   }
/*     */   
/*     */   private MultiverseCore getMultiverse() {
/*  99 */     Plugin plugin = getServer().getPluginManager().getPlugin("MultiverseCore");
/*     */     
/* 101 */     if (plugin == null || !(plugin instanceof MultiverseCore)) {
/* 102 */       return null;
/*     */     }
/*     */     
/* 105 */     return (MultiverseCore)plugin;
/*     */   }
/*     */   
/*     */   public static Main getInstance() {
/* 109 */     return instance;
/*     */   }
/*     */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/main/Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */