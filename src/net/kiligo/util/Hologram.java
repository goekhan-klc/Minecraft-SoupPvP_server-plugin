/*    */ package net.kiligo.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import net.minecraft.server.v1_8_R3.EntityArmorStand;
/*    */ import net.minecraft.server.v1_8_R3.EntityLiving;
/*    */ import net.minecraft.server.v1_8_R3.Packet;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
/*    */ import net.minecraft.server.v1_8_R3.World;
/*    */ import net.minecraft.server.v1_8_R3.WorldServer;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Hologram
/*    */ {
/*    */   private Location location;
/*    */   private List<String> lines;
/* 23 */   private double distance_above = -0.27D;
/* 24 */   private List<EntityArmorStand> armorstands = new ArrayList<>();
/*    */   public Hologram(Location loc, String... lines) {
/* 26 */     this.location = loc;
/* 27 */     this.lines = Arrays.asList(lines);
/*    */   }
/*    */   public Hologram(Location loc, List<String> lines) {
/* 30 */     this.location = loc;
/* 31 */     this.lines = lines;
/*    */   }
/*    */   
/*    */   public List<String> getLines() {
/* 35 */     return this.lines;
/*    */   }
/*    */   
/*    */   public Location getLocation() {
/* 39 */     return this.location;
/*    */   }
/*    */   
/*    */   public void send(Player p) {
/* 43 */     double y = getLocation().getY();
/* 44 */     for (int i = 0; i <= this.lines.size() - 1; i++) {
/* 45 */       y += this.distance_above;
/* 46 */       EntityArmorStand eas = getEntityArmorStand(y);
/* 47 */       eas.setCustomName(this.lines.get(i));
/* 48 */       display(p, eas);
/* 49 */       this.armorstands.add(eas);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void destroy(Player p) {
/* 54 */     for (EntityArmorStand eas : this.armorstands) {
/* 55 */       PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { eas.getId() });
/* 56 */       (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void destroy() {
/* 61 */     for (Player p : Bukkit.getOnlinePlayers()) {
/* 62 */       destroy(p);
/*    */     }
/*    */   }
/*    */   
/*    */   public void broadcast() {
/* 67 */     for (Player p : Bukkit.getOnlinePlayers()) {
/* 68 */       send(p);
/*    */     }
/*    */   }
/*    */   
/*    */   public void broadcast(List<Player> players) {
/* 73 */     for (Player p : players) {
/* 74 */       send(p);
/*    */     }
/*    */   }
/*    */   
/*    */   private EntityArmorStand getEntityArmorStand(double y) {
/* 79 */     WorldServer world = ((CraftWorld)getLocation().getWorld()).getHandle();
/* 80 */     EntityArmorStand eas = new EntityArmorStand((World)world);
/* 81 */     eas.setLocation(getLocation().getX(), y, getLocation().getZ(), 0.0F, 0.0F);
/* 82 */     eas.setInvisible(true);
/* 83 */     eas.setGravity(false);
/* 84 */     eas.setCustomNameVisible(true);
/* 85 */     return eas;
/*    */   }
/*    */   
/*    */   private void display(Player p, EntityArmorStand eas) {
/* 89 */     PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)eas);
/* 90 */     (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet);
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/util/Hologram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */