/*    */ package net.kiligo.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import net.kiligo.main.Main;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigLocations
/*    */ {
/*    */   public static void createConfigLocation(Location loc, String path, File file, YamlConfiguration cfg) {
/* 17 */     cfg.set(String.valueOf(path) + ".World", loc.getWorld().getName());
/* 18 */     cfg.set(String.valueOf(path) + ".X", Double.valueOf(loc.getX()));
/* 19 */     cfg.set(String.valueOf(path) + ".Y", Double.valueOf(loc.getY()));
/* 20 */     cfg.set(String.valueOf(path) + ".Z", Double.valueOf(loc.getZ()));
/* 21 */     cfg.set(String.valueOf(path) + ".Yaw", Float.valueOf(loc.getYaw()));
/* 22 */     cfg.set(String.valueOf(path) + ".Pitch", Float.valueOf(loc.getPitch()));
/*    */     try {
/* 24 */       cfg.save(file);
/* 25 */     } catch (IOException e) {
/* 26 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static Location getConfigLocation(String path, YamlConfiguration cfg) {
/* 32 */     if (cfg.getString(path) != null) {
/* 33 */       World w = Bukkit.getWorld(cfg.getString(String.valueOf(path) + ".World"));
/* 34 */       double x = cfg.getDouble(String.valueOf(path) + ".X");
/* 35 */       double y = cfg.getDouble(String.valueOf(path) + ".Y");
/* 36 */       double z = cfg.getDouble(String.valueOf(path) + ".Z");
/* 37 */       float yaw = (float)cfg.getDouble(String.valueOf(path) + ".Yaw");
/* 38 */       float pitch = (float)cfg.getDouble(String.valueOf(path) + ".Pitch");
/* 39 */       return new Location(w, x, y, z, yaw, pitch);
/*    */     } 
/* 41 */     return Main.getInstance().getServer().getWorld("world").getSpawnLocation();
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/ConfigLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */