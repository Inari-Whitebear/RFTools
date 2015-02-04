package com.mcjty.rftools.blocks.dimletconstruction;

import com.mcjty.container.GenericContainerBlock;
import com.mcjty.rftools.RFTools;
import com.mcjty.rftools.blocks.Infusable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class DimletWorkbenchBlock extends GenericContainerBlock implements Infusable {
    private IIcon iconTop;
    private IIcon iconBottom;

    public DimletWorkbenchBlock() {
        super(Material.iron, DimletWorkbenchTileEntity.class);
        setBlockName("dimletWorkbenchBlock");
        setCreativeTab(RFTools.tabRfTools);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean whatIsThis) {
        super.addInformation(itemStack, player, list, whatIsThis);

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            list.add(EnumChatFormatting.WHITE + "With this workbench you can deconstruct dimlets");
            list.add(EnumChatFormatting.WHITE + "into individual parts and also reconstruct new dimlets");
            list.add(EnumChatFormatting.WHITE + "out of these parts.");
            list.add(EnumChatFormatting.YELLOW + "Infusing bonus: increased chance of getting");
            list.add(EnumChatFormatting.YELLOW + "all parts out of the deconstructed dimlet.");
        } else {
            list.add(EnumChatFormatting.WHITE + "Press Shift for more");
        }
    }


    @Override
    public int getGuiID() {
        return 0;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iconTop = iconRegister.registerIcon(RFTools.MODID + ":machineDimletWorkbenchTop");
        iconBottom = iconRegister.registerIcon(RFTools.MODID + ":" + getSideIconName());
        iconSide = iconRegister.registerIcon(RFTools.MODID + ":machineDimletWorkbenchSide");
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (side == ForgeDirection.UP.ordinal()) {
            return iconTop;
        } else if (side == ForgeDirection.DOWN.ordinal()) {
            return iconBottom;
        } else {
            return iconSide;
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == ForgeDirection.UP.ordinal()) {
            return iconTop;
        } else if (side == ForgeDirection.DOWN.ordinal()) {
            return iconBottom;
        } else {
            return iconSide;
        }
    }
}