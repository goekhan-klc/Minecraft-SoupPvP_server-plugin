/*    */ package net.kiligo.commands;
/*    */ 
/*    */ import net.kiligo.util.ConfigLocations;
/*    */ import net.kiligo.util.Var;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class setSpawnCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 18 */     if (cmd.getName().equalsIgnoreCase("setspawn")) {
/* 19 */       Player p = (Player)sender;
/* 20 */       if (p.hasPermission("soup.setspawn")) {
/* 21 */         if (args.length == 1) {
/* 22 */           String game = Var.Capitalize(args[0]);
/* 23 */           if (Var.getGames().contains(game)) {
/* 24 */             Location loc = p.getLocation();
/*    */             
/* 26 */             ConfigLocations.createConfigLocation(loc, "Spawn." + game, Var.getLoationFile(), Var.getLoationConfiguration());
/* 27 */             p.sendMessage(String.valueOf(Var.getPr()) + "§7Der Spawn für §a" + game + " §7wurde gesetzt!");
/* 28 */             p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/*    */           } else {
/*    */             
/* 31 */             p.sendMessage(String.valueOf(Var.getPr()) + "§cDieses Spiel exestiert nicht!");
/*    */           } 
/*    */         } else {
/* 34 */           p.sendMessage(String.valueOf(Var.getPr()) + "§7Bitte benutze§f: §8/§fsetspawn <Game>");
/*    */         } 
/*    */       } else {
/* 37 */         p.sendMessage(Var.getNp());
/*    */       } 
/*    */     } 
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/commands/setSpawnCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */