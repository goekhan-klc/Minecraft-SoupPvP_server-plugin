/*    */ package net.kiligo.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class SettingsConfig
/*    */ {
/* 11 */   public static File settingsfile = new File("plugins\\Soup\\settings.yml");
/* 12 */   public static YamlConfiguration settingscfg = YamlConfiguration.loadConfiguration(settingsfile);
/*    */   
/*    */   public SettingsConfig() {
/* 15 */     YamlConfiguration.loadConfiguration(settingsfile);
/* 16 */     if (!settingsfile.exists()) {
/*    */       try {
/* 18 */         settingsfile.createNewFile();
/* 19 */         YamlConfiguration.loadConfiguration(settingsfile);
/* 20 */       } catch (IOException e) {
/* 21 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getSetting(Player p, String path) {
/* 28 */     if (settingscfg.getString(String.valueOf(p.getName()) + "." + path) != null) {
/* 29 */       String set = settingscfg.getString(String.valueOf(p.getName()) + "." + path);
/* 30 */       return set;
/*    */     } 
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setSetting(Player p, String path, String value) {
/* 37 */     if (settingscfg.getConfigurationSection(p.getName()) != null) {
/* 38 */       settingscfg.getConfigurationSection(p.getName()).set(path, value);
/*    */       try {
/* 40 */         settingscfg.save(settingsfile);
/* 41 */       } catch (IOException e) {
/* 42 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/* 45 */       settingscfg.createSection(p.getName());
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isSettingExists(Player p, String path) {
/*    */     try {
/* 51 */       if (settingscfg.getString(String.valueOf(p.getName()) + "." + path) == null) {
/* 52 */         return false;
/*    */       }
/* 54 */     } catch (NullPointerException e) {
/* 55 */       return false;
/*    */     } 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/SettingsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */