/*    */ package net.kiligo.kits.kits;
/*    */ 
/*    */ import net.kiligo.kits.Kit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Default
/*    */   extends Kit
/*    */ {
/*    */   public Default() {
/* 12 */     super("Default", "§7The default kit with iron tools", Material.IRON_SWORD, 0, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setItems(Player p) {
/* 17 */     p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
/* 18 */     p.getInventory().setItem(13, new ItemStack(Material.RED_MUSHROOM, 64));
/* 19 */     p.getInventory().setItem(14, new ItemStack(Material.BROWN_MUSHROOM, 64));
/* 20 */     p.getInventory().setItem(15, new ItemStack(Material.BOWL, 64));
/*    */     
/* 22 */     p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
/* 23 */     p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
/* 24 */     p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/* 25 */     p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/*    */     
/* 27 */     for (int i = 0; i < 36; i++) {
/* 28 */       if (p.getInventory().getItem(i) == null)
/* 29 */         p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/kits/kits/Default.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */