package com.hbm.blocks;

import com.hbm.lib.RefStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//Testblock zum Rendern/�ndern der visuellen Eigenschaften eines Tiles (Blockes)

//"extends BlockContainer" um ein TileEntity zu erschaffen

public class TestRender extends BlockContainer {
	
	//Y U NO WANTED WORKINGS? NAO U WORKINGS AN I KICK UR ARSE

	//Normaler Matrial-Constructor
	public TestRender(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
	
	//Nicht verf�gbarer Rendertyp, setzt den Switch auf "Default" und erm�glicht einen Customrenderer
	public int getRenderType(){
		return -1;
	}
	
	//Ob der Block transparent ist (Glas, Glowstone, Wasser, etc)
	public boolean isOpaqueCube() {
		return false;
	}
	
	//"Default" beim Switch zum Rendern erm�glicht die Abfrage "renderAsNormalBlock", "true" um es als einen normalen Block rendern zu lassen, "false" f�r einen Customrenderer
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	
	//Erstellen eines TileEntitys
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityTestRender();
	}
	
	//GUI Blocktextur muss f�r Custommodel-Blocke nachtr�glich ge�ndert werden
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		this.blockIcon = iconregister.registerIcon(RefStrings.MODID + ":test_render");
	}
	
	//Setzt die Blockkollisionsbox (xMin, yMin, zMin, xMax, yMax, zMax)
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        float f = 0.0625F;
        this.setBlockBounds(2*f, 0.0F, 2*f, 14*f, 1.0F, 14*f);
    }

}