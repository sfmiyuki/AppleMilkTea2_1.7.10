package mods.defeatedcrow.common.item.magic;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssentialOil extends Item {
	
	@SideOnly(Side.CLIENT)
    private IIcon iconType[];
	
	private static final String[] itemType = new String[] {"apple", "rose", "mint", "yuzu", "clam", "ice", "lavender", "vanilla", "sandalwood"};
	
	public ItemEssentialOil (){
		super ();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);

	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 8);
        return this.iconType[j];
    }
	
	@Override
	public int getMetadata(int par1) {
		return par1;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int meta = par1ItemStack.getItemDamage();
		return meta < 9 ? super.getUnlocalizedName() + "_" + this.itemType[meta] : super.getUnlocalizedName() + "_" + meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
		par3List.add(new ItemStack(this, 1, 2));
		par3List.add(new ItemStack(this, 1, 3));
		par3List.add(new ItemStack(this, 1, 4));
		par3List.add(new ItemStack(this, 1, 5));
		par3List.add(new ItemStack(this, 1, 6));
		par3List.add(new ItemStack(this, 1, 7));
		par3List.add(new ItemStack(this, 1, 8));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister){
		this.iconType = new IIcon[9];

        for (int i = 0; i < 9; ++i)
        {
            this.iconType[i] = par1IconRegister.registerIcon("defeatedcrow:essence_" + itemType[i]);
        }
	}
}
