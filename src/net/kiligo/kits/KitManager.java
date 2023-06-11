/*    */ package net.kiligo.kits;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import net.kiligo.kits.kits.Default;
/*    */ import net.kiligo.kits.kits.Killer;
/*    */ import net.kiligo.kits.kits.Tank;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KitManager
/*    */ {
/*    */   public static ArrayList<Kit> kits;
/* 15 */   public static HashMap<Player, Kit> currentkit = new HashMap<>();
/*    */   
/*    */   public KitManager() {
/* 18 */     kits = new ArrayList<>();
/*    */     
/* 20 */     addKit((Kit)new Default());
/* 21 */     addKit((Kit)new Killer());
/* 22 */     addKit((Kit)new Tank());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static ArrayList<Kit> getKits() {
/* 28 */     return kits;
/*    */   }
/*    */   
/*    */   public void addKit(Kit kit) {
/* 32 */     kits.add(kit);
/*    */   }
/*    */   
/*    */   public static void setCurrentKit(Player p, Kit kit) {
/* 36 */     currentkit.put(p, kit);
/*    */   }
/*    */   
/*    */   public static Kit getCurrentKit(Player p) {
/* 40 */     return currentkit.get(p);
/*    */   }
/*    */   
/*    */   public static Kit getKit(String kit) {
/* 44 */     for (Kit kits : KitManager.kits) {
/* 45 */       if (kits.getName().equalsIgnoreCase(kit)) {
/* 46 */         return kits;
/*    */       }
/*    */     } 
/* 49 */     System.err.println("[Soup][Kit] Suche > Das Kit " + kit + " wurde nicht gefunden!");
/* 50 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/kits/KitManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */