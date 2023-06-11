/*    */ package net.kiligo.kits.kits;
/*    */ 
/*    */ import net.kiligo.kits.Kit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Tank
/*    */   extends Kit
/*    */ {
/*    */   public Tank() {
/* 12 */     super("Tank", "§7You got better armor but lower weapons", Material.DIAMOND_CHESTPLATE, 200, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setItems(Player p) {
/* 17 */     p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
/* 18 */     p.getInventory().setItem(13, new ItemStack(Material.RED_MUSHROOM, 64));
/* 19 */     p.getInventory().setItem(14, new ItemStack(Material.BROWN_MUSHROOM, 64));
/* 20 */     p.getInventory().setItem(15, new ItemStack(Material.BOWL, 64));
/*    */     
/* 22 */     p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
/* 23 */     p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
/* 24 */     p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
/* 25 */     p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
/*    */     
/* 27 */     for (int i = 0; i < 36; i++) {
/* 28 */       if (p.getInventory().getItem(i) == null)
/* 29 */         p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/kits/kits/Tank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */