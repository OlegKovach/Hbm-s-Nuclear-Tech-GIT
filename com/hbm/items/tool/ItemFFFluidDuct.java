package com.hbm.items.tool;

import com.hbm.blocks.ModBlocks;
import com.hbm.items.ModItems;
import com.hbm.lib.HBMSoundHandler;
import com.hbm.tileentity.conductor.TileEntityFFFluidDuct;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFFFluidDuct extends Item {

	public ItemFFFluidDuct(String s) {
		this.setUnlocalizedName(s);
		this.setRegistryName(s);
		
		ModItems.ALL_ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(tab == this.getCreativeTab() || tab == CreativeTabs.SEARCH){
			FluidRegistry.getRegisteredFluids().values().forEach(f -> {items.add(getStackFromFluid(f));});
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getItemStackDisplayName(ItemStack stack) {
		String s = ("" + I18n.format(this.getUnlocalizedName() + ".name")).trim();
		Fluid f = getFluidFromStack(stack);
		String s1 = null;
		if(f != null)
			s1  = ("" + f.getLocalizedName(new FluidStack(f, 1000)).trim());

        if (s1 != null)
        {
            s = s + " " + s1;
        }

        return s;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(world.getBlockState(pos).getBlock() != Blocks.SNOW_LAYER){
			pos = pos.offset(facing);
			if (!world.isAirBlock(pos))
            {
                return EnumActionResult.FAIL;
            }
		}
		ItemStack stack = player.getHeldItem(hand);
		if (!player.canPlayerEdit(pos, facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            world.setBlockState(pos, ModBlocks.fluid_duct.getDefaultState());
            if(world.getTileEntity(pos) instanceof TileEntityFFFluidDuct) {
            	((TileEntityFFFluidDuct)world.getTileEntity(pos)).setType(getFluidFromStack(stack));;
            }
            stack.shrink(1);
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), HBMSoundHandler.pipePlaced, SoundCategory.PLAYERS, 1.0F, 0.65F + world.rand.nextFloat() * 0.2F);

            return EnumActionResult.SUCCESS;
        }
	}
	
	public static Fluid getFluidFromStack(ItemStack stack){
		if(stack == null || !stack.hasTagCompound() || !stack.getTagCompound().hasKey("fluidType"))
			return null;
		Fluid f = FluidRegistry.getFluid(stack.getTagCompound().getString("fluidType"));
		return f;
	}
	
	public static ItemStack getStackFromFluid(Fluid f, int amount){
		ItemStack stack = new ItemStack(ModItems.ff_fluid_duct, amount, 0);
		if(f == null)
			return stack;
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("fluidType", FluidRegistry.getFluidName(f));
		return stack;
	}
	
	public static ItemStack getStackFromFluid(Fluid f){
		return getStackFromFluid(f, 1);
	}
}