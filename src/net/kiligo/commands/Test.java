/*    */ package net.kiligo.commands;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.server.v1_8_R3.EntityHuman;
/*    */ import net.minecraft.server.v1_8_R3.EntityLiving;
/*    */ import net.minecraft.server.v1_8_R3.EntityPlayer;
/*    */ import net.minecraft.server.v1_8_R3.MinecraftServer;
/*    */ import net.minecraft.server.v1_8_R3.Packet;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
/*    */ import net.minecraft.server.v1_8_R3.PlayerConnection;
/*    */ import net.minecraft.server.v1_8_R3.PlayerInteractManager;
/*    */ import net.minecraft.server.v1_8_R3.World;
/*    */ import net.minecraft.server.v1_8_R3.WorldServer;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Test
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 33 */     if (cmd.getName().equalsIgnoreCase("npc")) {
/* 34 */       Player p = (Player)sender;
/*    */       
/* 36 */       MinecraftServer nmsServer = ((CraftServer)Bukkit.getServer()).getServer();
/* 37 */       WorldServer nmsWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
/* 38 */       EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, new GameProfile(UUID.randomUUID(), "§cNPC | Test"), new PlayerInteractManager((World)nmsWorld));
/* 39 */       npc.teleportTo(p.getLocation(), false);
/*    */       
/* 41 */       PlayerConnection connection = (((CraftPlayer)sender).getHandle()).playerConnection;
/* 42 */       connection.sendPacket((Packet)new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] { npc }));
/* 43 */       connection.sendPacket((Packet)new PacketPlayOutNamedEntitySpawn((EntityHuman)npc));
/*    */       
/* 45 */       PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[] { ((Entity)npc).getEntityId() });
/* 46 */       PacketPlayOutSpawnEntityLiving packetPlayOutSpawnEntityLiving = new PacketPlayOutSpawnEntityLiving((EntityLiving)npc);
/*    */       
/* 48 */       connection.sendPacket((Packet)packetPlayOutEntityDestroy);
/* 49 */       connection.sendPacket((Packet)packetPlayOutSpawnEntityLiving);
/*    */       
/* 51 */       p.sendMessage("[§cTest] §aNPC wurde erstellt!");
/*    */     } 
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/commands/Test.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */