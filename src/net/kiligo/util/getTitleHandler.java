/*    */ package net.kiligo.util;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Field;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.minecraft.server.v1_8_R3.IChatBaseComponent;
/*    */ import net.minecraft.server.v1_8_R3.Packet;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
/*    */ import net.minecraft.server.v1_8_R3.PlayerConnection;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class getTitleHandler
/*    */ {
/*    */   public static void sendActionBar(Player p, String nachricht) {
/* 19 */     CraftPlayer cp = (CraftPlayer)p;
/* 20 */     IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + nachricht + "\"}");
/* 21 */     PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
/* 22 */     (cp.getHandle()).playerConnection.sendPacket((Packet)ppoc);
/*    */   }
/*    */   
/*    */   public static void sendTabList(Player player, String header, String footer) {
/* 26 */     if (header == null) {
/* 27 */       header = "";
/*    */     }
/* 29 */     if (footer == null) {
/* 30 */       footer = "";
/*    */     }
/*    */     try {
/* 33 */       Object tabHeader = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + header + "\"}" });
/* 34 */       Object tabFooter = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + footer + "\"}" });
/* 35 */       Constructor<?> titleConstructor = getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[] { getNMSClass("IChatBaseComponent") });
/* 36 */       Object packet = titleConstructor.newInstance(new Object[] { tabHeader });
/* 37 */       Field field = packet.getClass().getDeclaredField("b");
/* 38 */       field.setAccessible(true);
/* 39 */       field.set(packet, tabFooter);
/* 40 */       sendPacket(player, packet);
/*    */     }
/* 42 */     catch (SecurityException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|InstantiationException|NoSuchFieldException ex) {
/*    */       
/* 44 */       ex.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void sendTitle(Player p, Integer einbelnden, Integer anzeigen, Integer ausblenden, String title, String subtitle) {
/* 49 */     PlayerConnection connection = (((CraftPlayer)p).getHandle()).playerConnection;
/*    */     
/* 51 */     PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, einbelnden.intValue(), anzeigen.intValue(), ausblenden.intValue());
/* 52 */     connection.sendPacket((Packet)packetPlayOutTimes);
/* 53 */     if (subtitle != null) {
/* 54 */       subtitle = subtitle.replaceAll("%p%", p.getDisplayName());
/* 55 */       subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
/* 56 */       IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
/* 57 */       PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
/* 58 */       connection.sendPacket((Packet)packetPlayOutSubTitle);
/*    */     } 
/* 60 */     if (title != null) {
/* 61 */       title = title.replaceAll("%p%", p.getDisplayName());
/* 62 */       title = ChatColor.translateAlternateColorCodes('&', title);
/* 63 */       IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
/* 64 */       PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
/* 65 */       connection.sendPacket((Packet)packetPlayOutTitle);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Class<?> getNMSClass(String name) {
/* 77 */     String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
/*    */     
/*    */     try {
/* 80 */       return Class.forName("net.minecraft.server." + version + "." + name);
/*    */     }
/* 82 */     catch (ClassNotFoundException e) {
/*    */       
/* 84 */       e.printStackTrace();
/*    */       
/* 86 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static void sendPacket(Player player, Object packet) {
/*    */     try {
/* 93 */       Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
/* 94 */       Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
/* 95 */       playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
/*    */     }
/* 97 */     catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchFieldException e) {
/*    */       
/* 99 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/getTitleHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */