package ic2.platform;

import net.minecraft.server.Block;
import net.minecraft.server.EnumToolMaterial;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ItemTool;

public class ItemToolCommon extends ItemTool {
  public ItemToolCommon(int i, int j, EnumToolMaterial enumtoolmaterial, Block[] ablock) {
    super(i, j, enumtoolmaterial, ablock);
  }

  public boolean isFull3D() {
    return false;
  }

  public int getIconFromDamage(int i) {
    return 0;
  }

  public int rarity(ItemStack itemstack) {
    return 0;
  }
}
