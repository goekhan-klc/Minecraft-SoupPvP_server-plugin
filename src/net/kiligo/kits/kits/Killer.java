/*    */ package net.kiligo.kits.kits;
/*    */ 
/*    */ import net.kiligo.kits.Kit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Killer
/*    */   extends Kit
/*    */ {
/*    */   public Killer() {
/* 12 */     super("Killer", "§7You get a better sword - but lower armor", Material.DIAMOND_AXE, 100, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setItems(Player p) {
/* 18 */     p.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
/* 19 */     p.getInventory().setItem(13, new ItemStack(Material.RED_MUSHROOM, 64));
/* 20 */     p.getInventory().setItem(14, new ItemStack(Material.BROWN_MUSHROOM, 64));
/* 21 */     p.getInventory().setItem(15, new ItemStack(Material.BOWL, 64));
/*    */     
/* 23 */     p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
/* 24 */     p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
/* 25 */     p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
/* 26 */     p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
/*    */     
/* 28 */     for (int i = 0; i < 36; i++) {
/* 29 */       if (p.getInventory().getItem(i) == null)
/* 30 */         p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/kits/kits/Killer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */