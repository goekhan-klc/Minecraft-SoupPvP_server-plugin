/*    */ package net.kiligo.events;
/*    */ 
/*    */ import net.kiligo.main.Game;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ 
/*    */ public class MoveEvent
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onMove(PlayerMoveEvent e) {
/* 19 */     Player p = e.getPlayer();
/*    */     
/* 21 */     if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.SPONGE)) {
/* 22 */       Vector v = p.getLocation().getDirection();
/* 23 */       v.multiply(1).setY(5);
/* 24 */       p.setVelocity(v);
/* 25 */       p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
/* 26 */       Game.setNoFallDamage(p, 6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/events/MoveEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */