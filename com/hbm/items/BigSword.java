package com.hbm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BigSword extends ItemSword {
	
	public World worldObj;
	
	public double posX;
    public double posY;
    public double posZ;

	public BigSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

	/*@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer Entityplayer) {

	Vec3 look = Entityplayer.getLookVec();
	MovingObjectPosition Coord = Entityplayer.rayTrace(300, 1);
		EntityLightningBolt Lightning = new EntityLightningBolt(world, 1, 1, 1);
		Lightning.setPosition(Coord.blockX,Coord.blockY,Coord.blockZ);
		if(!Entityplayer.worldObj.isRemote)
		{
			world.spawnEntityInWorld(Lightning);
		}
		Entityplayer.addPotionEffect(new PotionEffect(6, 20, 5));
		itemStack.damageItem(25, Entityplayer);
	return itemStack;
	}*/
}