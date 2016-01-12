package com.hbm.blocks;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DecoBlock extends BlockContainer {

	protected DecoBlock(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityDecoBlock();
	}
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
		int i = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(i == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(i == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(i == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(i == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
		int te = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_);
        float f = 0.0625F;
        
        if(this == ModBlocks.steel_wall)
        {
			switch(te)
			{
			case 4:
            	this.setBlockBounds(14*f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            	break;
			case 2:
            	this.setBlockBounds(0.0F, 0.0F, 14*f, 1.0F, 1.0F, 1.0F);
            	break;
			case 5:
            	this.setBlockBounds(0.0F, 0.0F, 0.0F, 2*f, 1.0F, 1.0F);
            	break;
			case 3:
            	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2*f);
            	break;
			}
        }
        
        if(this == ModBlocks.steel_corner)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        
        if(this == ModBlocks.steel_roof)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1*f, 1.0F);
        }
        
        if(this == ModBlocks.steel_beam)
        {
            this.setBlockBounds(7*f, 0.0F, 7*f, 9*f, 1.0F, 9*f);
        }
        
        if(this == ModBlocks.steel_scaffold)
        {
            this.setBlockBounds(0.0F, 0.0F, 2*f, 1.0F, 1.0F, 14*f);
			switch(te)
			{
			case 4:
	            this.setBlockBounds(2*f, 0.0F, 0.0F, 14*f, 1.0F, 1.0F);
            	break;
			case 2:
	            this.setBlockBounds(0.0F, 0.0F, 2*f, 1.0F, 1.0F, 14*f);
            	break;
			case 5:
	            this.setBlockBounds(2*f, 0.0F, 0.0F, 14*f, 1.0F, 1.0F);
            	break;
			case 3:
	            this.setBlockBounds(0.0F, 0.0F, 2*f, 1.0F, 1.0F, 14*f);
            	break;
			}
        }
        
        //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

}