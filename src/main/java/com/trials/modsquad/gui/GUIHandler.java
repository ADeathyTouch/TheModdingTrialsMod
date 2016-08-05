package com.trials.modsquad.gui;

import com.trials.modsquad.Ref;
import com.trials.modsquad.block.TileEntities.TileFurnaceGenerator;
import com.trials.modsquad.block.TileEntities.TileGrinder;
import com.trials.modsquad.block.containers.ContainerFurnaceGenerator;
import com.trials.modsquad.block.containers.ContainerGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import static com.trials.modsquad.Ref.GUI_ID_FURNACE_GEN;
import static com.trials.modsquad.Ref.GUI_ID_GRINDER;


public class GUIHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity e = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID){
            case GUI_ID_GRINDER:
                return new ContainerGrinder(player.inventory, (TileGrinder) e);
            case GUI_ID_FURNACE_GEN:
                return new ContainerFurnaceGenerator(player.inventory, (TileFurnaceGenerator) e);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity e = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID){
            case GUI_ID_GRINDER:
                return new GUIGrinder(player.inventory, (TileGrinder) e);
            case GUI_ID_FURNACE_GEN:
                return new GUIFurnaceGenerator(player.inventory, (TileFurnaceGenerator) e);
        }
        return null;
    }

}
