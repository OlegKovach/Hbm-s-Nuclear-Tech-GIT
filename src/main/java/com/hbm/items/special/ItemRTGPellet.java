package com.hbm.items.special;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemRTGPellet extends ItemRadioactive {

	public ItemRTGPellet(float radiation, String s) {
		super(radiation, s);
	}
	
	private static final String[] facts = new String[] {
			"One gram of Pu-238 costs $8,000.",
			"One gram of Pu-238 produces just under half a Watt of decay heat.",
			"The typical plutonium RTG contains close to eight kilograms of Pu-238.",
			"Pu-238's half life is 87.7 years.",
			"A plutonium RTG was used to power the New Horizons probe that visited Pluto in 2015.",
			"Po-210 can also be used for RTGs as it generates 140 W/g of decay heat due to its 138 day half life.",
			"Pa-231 is an isotope of protactinium that easily fissions, but it isn't quite fissile.",
			"Muons generated by matter-antimatter reactions can trigger nuclear fusion reactions at room temperature.",
			"Roughly 20% of U-235 nuclei will fail to fission when hit by a neutron. They become U-236 nuclei instead.",
			"Thorium reactors are really uranium reactors that convert thorium into U-233.",
			"Natural uranium consists of 99.284% U-238, 0.711% U-235, and 0.0055% U-234.",
			"Most nuclear reactors use uranium that has been enriched to 3-5% U-235.",
			"Uranium-based nuclear weapons require uranium enriched to at least 85-90% U-235.",
			"Depleted uranium is uranium that has had most of its U-235 removed. It is effectively pure U-238.",
			"In the 1920s, uranium was considered a useless byproduct of the production of radium.",
			"The Manhattan Project referred to refined natural uranium as tuballoy, enriched uranium as oralloy, and depleted uranium as depletalloy."
	};
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(!world.isRemote) {
			player.sendMessage(new TextComponentString(facts[world.rand.nextInt(facts.length)]).setStyle(new Style().setColor(TextFormatting.YELLOW)));
			world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
		}
		return super.onItemRightClick(world, player, hand);
	}

}
