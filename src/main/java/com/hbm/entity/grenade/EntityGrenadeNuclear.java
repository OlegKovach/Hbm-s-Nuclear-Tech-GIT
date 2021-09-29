package com.hbm.entity.grenade;

import com.hbm.config.BombConfig;
import com.hbm.entity.logic.EntityNukeExplosionMK4;
import com.hbm.explosion.ExplosionParticle;
import com.hbm.explosion.ExplosionParticleB;
import com.hbm.items.ModItems;
import com.hbm.items.weapon.ItemGrenade;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityGrenadeNuclear extends EntityGrenadeBouncyBase
{

    public EntityGrenadeNuclear(World p_i1773_1_)
    {
        super(p_i1773_1_);
    }

    public EntityGrenadeNuclear(World p_i1774_1_, EntityLivingBase p_i1774_2_, EnumHand hand)
    {
        super(p_i1774_1_, p_i1774_2_, hand);
    }

    public EntityGrenadeNuclear(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    @Override
    public void explode() {
    	
        if (!this.world.isRemote)
        {
            this.setDead();
            /*EntityNukeExplosionMK3 entity0 = new EntityNukeExplosionMK3(this.worldObj);
    	    entity0.posX = this.posX;
    	    entity0.posY = this.posY;
    	    entity0.posZ = this.posZ;
    	    entity0.destructionRange = MainRegistry.nukaRadius;
    	    entity0.speed = 25;
    	    entity0.coefficient = 10.0F;*/
    	    	
    	    this.world.spawnEntity(EntityNukeExplosionMK4.statFac(world, BombConfig.nukaRadius, posX, posY, posZ));
        	if(rand.nextInt(100) == 0)
        	{
        		ExplosionParticleB.spawnMush(this.world, (int)this.posX, (int)this.posY, (int)this.posZ);
        	} else {
        		ExplosionParticle.spawnMush(this.world, (int)this.posX, (int)this.posY, (int)this.posZ);
        	}
        }
    }

	@Override
	protected int getMaxTimer() {
		return ItemGrenade.getFuseTicks(ModItems.grenade_nuclear);
	}

	@Override
	protected double getBounceMod() {
		return 0.25D;
	}
}
