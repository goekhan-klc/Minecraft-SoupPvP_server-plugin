/*    */ package net.kiligo.kits;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class Kit
/*    */ {
/*    */   private String name;
/*    */   private String description;
/*    */   private int price;
/*    */   private boolean premium;
/*    */   private Material symbol;
/*    */   
/*    */   public Kit(String name, String description, Material symbol, int price, boolean premium) {
/* 15 */     this.name = name;
/* 16 */     this.price = price;
/* 17 */     this.premium = premium;
/* 18 */     this.symbol = symbol;
/* 19 */     this.description = description;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setItems(Player p) {}
/*    */ 
/*    */   
/*    */   public String getName() {
/* 28 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 32 */     this.name = name;
/*    */   }
/*    */   
/*    */   public int getPrice() {
/* 36 */     return this.price;
/*    */   }
/*    */   
/*    */   public void setPrice(int price) {
/* 40 */     this.price = price;
/*    */   }
/*    */   
/*    */   public boolean isPremium() {
/* 44 */     return this.premium;
/*    */   }
/*    */   
/*    */   public void setPremium(boolean premium) {
/* 48 */     this.premium = premium;
/*    */   }
/*    */   
/*    */   public Material getSymbol() {
/* 52 */     return this.symbol;
/*    */   }
/*    */   
/*    */   public void setSymbol(Material symbol) {
/* 56 */     this.symbol = symbol;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 60 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 64 */     this.description = description;
/*    */   }
/*    */ }


/* Location:              /Users/goekhan/Dokumente/Minecraft/Soup-Server/plugins/Soup.jar!/net/kiligo/kits/Kit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */