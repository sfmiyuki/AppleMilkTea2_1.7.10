package mods.defeatedcrow.client.gui;

import mods.defeatedcrow.common.tile.appliance.ContainerEvaporator;
import mods.defeatedcrow.common.tile.appliance.TileEvaporator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import org.lwjgl.opengl.GL11;

public class GuiEvaporator extends GuiContainer {
	 
	private TileEvaporator tileentity;
	private TileEvaporator inventory;

	public GuiEvaporator(EntityPlayer player, TileEvaporator par2TileEntity) {
		super(new ContainerEvaporator(player, par2TileEntity));
		this.tileentity = par2TileEntity;
		this.inventory = par2TileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		//インベントリ名の描画
		String s = this.inventory.hasCustomInventoryName() ? this.inventory.getInventoryName() : I18n.format(this.inventory.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		//テクスチャの指定
		//ResourceLocationの第一引数を付け足してドメインを指定することもできる
		//例:new ResourceLocation("sample", "textures/gui/container/furnace.png")
		this.mc.getTextureManager().bindTexture(new ResourceLocation("defeatedcrow", "textures/gui/evaporatorgui.png"));

		//かまど描画処理
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		int i2;
		int i3;
		int i4;

		i1 = this.tileentity.getBurnTimeRemainingScaled(27);
		this.drawTexturedModalRect(k + 11, l + 53 - i1, 176, 43 - i1, 12, i1);

		i2 = this.tileentity.getCookProgressScaled(24);
		this.drawTexturedModalRect(k + 77, l + 18, 176, 0, i2 + 1, 16);
		
		i3 = this.tileentity.getCookProgressScaled(16);
		this.drawTexturedModalRect(k + 57, l + 35, 201, 0, 15, i3);
		
		drawFluid(this.tileentity.productTank.getFluid(), this.tileentity.getFluidAmountScaled(41), k + 141, l + 13, 16, 41);
	}
	
	/**
	 * Original code was made by SpaceToad and the BuildCraft Team. 
	 * */
	private void drawFluid(FluidStack fluid, int level, int x, int y, int width, int height) {
		if (fluid == null || fluid.getFluid() == null) {
			return;
		}
		IIcon icon = fluid.getFluid().getIcon(fluid);
		mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		setGLColorFromInt(fluid.getFluid().getColor(fluid));
		int fullX = width / 16;
		int fullY = height / 16;
		int lastX = width - fullX * 16;
		int lastY = height - fullY * 16;
		int fullLvl = (height - level) / 16;
		int lastLvl = (height - level) - fullLvl * 16;
		for (int i = 0; i < fullX; i++) {
			for (int j = 0; j < fullY; j++) {
				if (j >= fullLvl) {
					drawCutIcon(icon, x + i * 16, y + j * 16, 16, 16, j == fullLvl ? lastLvl : 0);
				}
			}
		}
		for (int i = 0; i < fullX; i++) {
			drawCutIcon(icon, x + i * 16, y + fullY * 16, 16, lastY, fullLvl == fullY ? lastLvl : 0);
		}
		for (int i = 0; i < fullY; i++) {
			if (i >= fullLvl) {
				drawCutIcon(icon, x + fullX * 16, y + i * 16, lastX, 16, i == fullLvl ? lastLvl : 0);
			}
		}
		drawCutIcon(icon, x + fullX * 16, y + fullY * 16, lastX, lastY, fullLvl == fullY ? lastLvl : 0);
	}
	
	public static void setGLColorFromInt(int color) {
		float red = (color >> 16 & 255) / 255.0F;
		float green = (color >> 8 & 255) / 255.0F;
		float blue = (color & 255) / 255.0F;
		GL11.glColor4f(red, green, blue, 1.0F);
	}

	/**
	 * Original code was made by SpaceToad and the BuildCraft Team. 
	 * */
	private void drawCutIcon(IIcon icon, int x, int y, int width, int height, int cut) {
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		tess.addVertexWithUV(x, y + height, zLevel, icon.getMinU(), icon.getInterpolatedV(height));
		tess.addVertexWithUV(x + width, y + height, zLevel, icon.getInterpolatedU(width), icon.getInterpolatedV(height));
		tess.addVertexWithUV(x + width, y + cut, zLevel, icon.getInterpolatedU(width), icon.getInterpolatedV(cut));
		tess.addVertexWithUV(x, y + cut, zLevel, icon.getMinU(), icon.getInterpolatedV(cut));
		tess.draw();
	}

}
