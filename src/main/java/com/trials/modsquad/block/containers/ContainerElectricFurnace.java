package com.trials.modsquad.block.containers;

import com.trials.modsquad.block.TileEntities.TileElectricFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerElectricFurnace extends Container {

    private TileElectricFurnace furnace;
    private int workTime;
    private int cookTime;

    public ContainerElectricFurnace(InventoryPlayer inv, TileElectricFurnace furnace){
        this.furnace = furnace;
        addSlotToContainer(new SlotFurnaceFuel(furnace, 0, 86, 35)); // Nice and centered :P

        for(int i = 0; i<3; ++i) for(int j = 0; j<9; ++j) addSlotToContainer(new Slot(inv, j+i*9+9, 8+j*18, 84+i*18));
        for(int i = 0; i<9; ++i) addSlotToContainer(new Slot(inv, i, 8+i*18, 142));
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerListener l : listeners) if (workTime != furnace.getField(0)) l.sendProgressBarUpdate(this, 0, furnace.getField(0));

        workTime = furnace.getField(0);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return furnace.isUseableByPlayer(playerIn);
    }
}
