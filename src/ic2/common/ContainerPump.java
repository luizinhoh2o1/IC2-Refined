package ic2.common;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.ICrafting;
import net.minecraft.server.Slot;

public class ContainerPump extends ContainerIC2 {
  public TileEntityPump tileEntity;
  public short pumpCharge = -1;
  public int energy = -1;

  public ContainerPump(EntityHuman entityhuman, TileEntityPump tileentitypump) {
    super(entityhuman, tileentitypump);
    this.tileEntity = tileentitypump;
    this.a(new SlotCustom(tileentitypump, new Object[]{Ic2Items.cell}, 0, 62, 17));
    this.a(new SlotDischarge(tileentitypump, tileentitypump.tier, 1, 62, 53));

    int j;
    for (j = 0; j < 3; ++j) {
      for (int k = 0; k < 9; ++k) {
        this.a(new Slot(entityhuman.inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
      }
    }

    for (j = 0; j < 9; ++j) {
      this.a(new Slot(entityhuman.inventory, j, 8 + j * 18, 142));
    }

  }

  public void a() {
    super.a();

    for (int i = 0; i < this.listeners.size(); ++i) {
      ICrafting icrafting = (ICrafting) this.listeners.get(i);
      if (this.pumpCharge != this.tileEntity.pumpCharge) {
        icrafting.setContainerData(this, 0, this.tileEntity.pumpCharge);
      }

      if (this.energy != this.tileEntity.energy) {
        icrafting.setContainerData(this, 1, this.tileEntity.energy & '\uffff');
        icrafting.setContainerData(this, 2, this.tileEntity.energy >>> 16);
      }
    }

    this.pumpCharge = this.tileEntity.pumpCharge;
    this.energy = this.tileEntity.energy;
  }

  public void updateProgressBar(int i, int j) {
    switch (i) {
      case 0:
        this.tileEntity.pumpCharge = (short) j;
        break;
      case 1:
        this.tileEntity.energy = this.tileEntity.energy & -65536 | j;
        break;
      case 2:
        this.tileEntity.energy = this.tileEntity.energy & '\uffff' | j << 16;
    }

  }

  public boolean b(EntityHuman entityhuman) {
    return this.tileEntity.a(entityhuman);
  }

  public int guiInventorySize() {
    return 2;
  }

  public int getInput() {
    return 1;
  }
}
