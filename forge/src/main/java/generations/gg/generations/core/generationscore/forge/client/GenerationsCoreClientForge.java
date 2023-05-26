package generations.gg.generations.core.generationscore.forge.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import generations.gg.generations.core.generationscore.client.GenerationsCoreClient;
import generations.gg.generations.core.generationscore.client.render.block.entity.*;
import generations.gg.generations.core.generationscore.client.render.entity.GenerationsBoatRenderer;
import generations.gg.generations.core.generationscore.client.render.entity.SittableEntityRenderer;
import generations.gg.generations.core.generationscore.client.render.entity.TieredFishingHookRenderer;
import generations.gg.generations.core.generationscore.world.entity.GenerationsEntities;
import generations.gg.generations.core.generationscore.world.level.block.entities.GenerationsBlockEntities;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.function.Consumer;

/**
 * This class is used to initialize the Forge client side of the mod.
 * @see ClientLifecycleEvent#CLIENT_SETUP
 * @see GenerationsCoreClient
 * @author J.T. McQuigg, WaterPicker
 */
public class GenerationsCoreClientForge {
    public static void init(IEventBus eventBus) {
        eventBus.addListener((Consumer<EntityRenderersEvent.RegisterRenderers>) event -> {
            GenerationsCoreClient.registerBlockEntityRenderers(event::registerBlockEntityRenderer);
            GenerationsCoreClient.registerEntityRenderers(event::registerEntityRenderer);
        });
        eventBus.addListener((Consumer<EntityRenderersEvent.RegisterLayerDefinitions>) event -> GenerationsCoreClient.registerLayerDefinitions(event::registerLayerDefinition));

        ClientLifecycleEvent.CLIENT_SETUP.register(minecraft -> {
            GenerationsCoreClient.onInitialize(minecraft);
            ForgeConfig.CLIENT.alwaysSetupTerrainOffThread.set(true); // Performance improvement
            ForgeConfig.CLIENT.experimentalForgeLightPipelineEnabled.set(true); // Use Experimental Forge Light Pipeline
        });
    }
}
