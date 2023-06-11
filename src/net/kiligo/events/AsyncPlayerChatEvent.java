/*    */ package net.kiligo.events;
/*    */ 
/*    */ import net.kiligo.util.RankHandler;
/*    */ import net.kiligo.util.Var;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ 
/*    */ public class AsyncPlayerChatEvent
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onChat(org.bukkit.event.player.AsyncPlayerChatEvent e) {
/* 15 */     e.setCancelled(true);
/* 16 */     if (!Var.getVanished().contains(e.getPlayer())) {
/* 17 */       Bukkit.broadcastMessage(String.valueOf(RankHandler.getPrefix(e.getPlayer())) + " §8» §7" + e.getMessage());
/*    */     } else {
/* 19 */       e.getPlayer().sendMessage("§aChat §f| §7Your silentmode is currently activated..");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/AsyncPlayerChatEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */