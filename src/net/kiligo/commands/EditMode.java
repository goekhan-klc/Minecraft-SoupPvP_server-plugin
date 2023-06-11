/*    */ package net.kiligo.commands;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import net.kiligo.main.Game;
/*    */ import net.kiligo.util.Var;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class EditMode
/*    */   implements CommandExecutor
/*    */ {
/* 17 */   public static ArrayList<Player> edit = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 22 */     if (cmd.getName().equalsIgnoreCase("edit")) {
/* 23 */       Player p = (Player)sender;
/* 24 */       if (p.hasPermission("soup.edit")) {
/* 25 */         if (!edit.contains(p)) {
/*    */           
/* 27 */           edit.add(p);
/* 28 */           p.sendMessage(String.valueOf(Var.getPr()) + "§7You §aentered §7the editmode!");
/* 29 */           p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/* 30 */           p.setGameMode(GameMode.CREATIVE);
/* 31 */           p.getInventory().clear();
/*    */         }
/*    */         else {
/*    */           
/* 35 */           edit.remove(p);
/* 36 */           p.sendMessage(String.valueOf(Var.getPr()) + "§7You §cleft §7the editmode!");
/* 37 */           p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/* 38 */           p.setGameMode(GameMode.SURVIVAL);
/* 39 */           p.getInventory().clear();
/* 40 */           Game.setItems(p);
/*    */         } 
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 46 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/commands/EditMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */