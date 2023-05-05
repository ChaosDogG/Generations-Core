package generations.gg.generations.core.generationscore.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;

/**
 * Used for working with Sprite Sheets. Allows for "mapping" coordinates inside the image to something which can be drawn.
 */
public class SubTexture {

    protected final ResourceLocation sheet;
    protected final int u;
    protected final int v;
    protected final int uWidth;
    protected final int vHeight;
    protected final int width;
    protected final int height;
    protected final int sheetScale;

    public SubTexture(int u, int v, int width, int height, ResourceLocation sheet) {
        this(u, v, width, height, sheet, 1024);
    }

    public SubTexture(int u, int v, int width, int height, ResourceLocation sheet, int scale) {
        this.u = u;
        this.v = v;
        this.uWidth = width;
        this.vHeight = height;
        this.width = width;
        this.height = height;
        this.sheet = sheet;
        this.sheetScale = scale;
    }

    public void render(PoseStack stack, int x, int y, boolean centered) {
        renderInner(stack, centered ? x - this.width / 2 : x, y, this.sheetScale, this.sheetScale);
    }

    public void renderStretched(PoseStack stack, int x, int y, float widthMultiplier, float heightMultiplier) {
        RenderSystem.setShaderTexture(0, this.sheet);
        ScreenUtils.drawTexture(stack, x, y, (int) (this.width * widthMultiplier), (int) (this.height * heightMultiplier), this.u, this.v, this.uWidth, this.vHeight, this.sheetScale, this.sheetScale);
    }

    protected void renderInner(PoseStack stack, int x, int y, int texWidth, int texHeight) {
        RenderSystem.setShaderTexture(0, this.sheet);
        ScreenUtils.drawTexture(stack, x, y, this.width, this.height, this.u, this.v, this.uWidth, this.vHeight, texWidth, texHeight);
    }

    public void render(PoseStack stack, int x, int y, int width, int height) {
        RenderSystem.setShaderTexture(0, this.sheet);
        ScreenUtils.drawTexture(stack, x, y, width, height, this.u, this.v, this.uWidth, this.vHeight, this.sheetScale, this.sheetScale);
    }

    public void render(PoseStack stack, int x, int y, int color) {
        render(stack, x, y, width, height, color);
    }

    public void render(PoseStack stack, int x, int y, int width, int height, int color) {
        float startAlpha = (float)(color >> 24 & 0xFF) / 255.0f;
        float startRed = (float)(color >> 16 & 0xFF) / 255.0f;
        float startGreen = (float)(color >> 8 & 0xFF) / 255.0f;
        float startBlue = (float)(color & 0xFF) / 255.0f;

        RenderSystem.setShaderColor(startRed, startGreen, startBlue, startAlpha);
        render(stack, x, y, width, height);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void renderAnchored(PoseStack stack, int x, int y, Anchor anchor) {
        RenderSystem.setShaderTexture(0, this.sheet);
        ScreenUtils.drawAnchoredTexture(stack, x, y, width, height, this.u, this.v, this.uWidth, this.vHeight, this.sheetScale, this.sheetScale, anchor);
    }

    public void renderAnchoredStretched(PoseStack stack, int x, int y, float widthMultiplier, float heightMultiplier, Anchor anchor) {
        RenderSystem.setShaderTexture(0, this.sheet);
        ScreenUtils.drawAnchoredStretchedTexture(stack, x, y, width, height, this.u, this.v, this.uWidth, this.vHeight, this.sheetScale, this.sheetScale, widthMultiplier, heightMultiplier, anchor);
    }

    public static final SubTexture BLANK = new SubTexture(0, 0, 0, 0, null) {
        public void render(PoseStack stack, int x, int y, boolean centered) {}
        public void renderStretched(PoseStack stack, int x, int y, float widthMultiplier, float heightMultiplier) {}
        protected void renderInner(PoseStack stack, int x, int y, int texWidth, int texHeight) {}
        public void renderAnchored(PoseStack stack, int x, int y, Anchor anchor) {}
        public void renderAnchoredStretched(PoseStack stack, int x, int y, float widthMultiplier, float heightMultiplier, Anchor anchor) {}
    };

    public void render(PoseStack poseStack, int x, int y) {
        this.render(poseStack, x, y, false);
    }
}