package generations.gg.generations.core.generationscore.forge.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.pokemon.Species;
import dev.architectury.registry.registries.RegistrySupplier;
import generations.gg.generations.core.generationscore.GenerationsCore;
import generations.gg.generations.core.generationscore.config.LegendKeys;
import generations.gg.generations.core.generationscore.config.SpeciesKey;
import generations.gg.generations.core.generationscore.forge.datagen.generators.recipe.GenerationsRecipeProvider;
import generations.gg.generations.core.generationscore.forge.datagen.generators.recipe.RksRecipeJsonBuilder;
import generations.gg.generations.core.generationscore.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.world.recipe.PokemonIngredient;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RksRecipeProvider extends GenerationsRecipeProvider.Proxied {
    public RksRecipeProvider(PackOutput arg) {
        super(arg);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> exporter) {
        RksRecipeJsonBuilder.create(LegendKeys.MEWTWO, 70)
                .key(LegendKeys.MEWTWO)
                .pattern("XAX")
                .pattern("XBX")
                .pattern("XCX")
                .input('X', GenerationsItems.MEW_FOSSIL.get())
                .input('A', GenerationsItems.DNA_SPLICERS.get())
                .input('B', GenerationsItems.ORB.get())
                .input('C', GenerationsItems.MEW_DNA_FIBER.get())
                .criterion("mew_fossil", InventoryChangeTrigger.TriggerInstance.hasItems(GenerationsItems.MEW_FOSSIL.get()))
                .offerTo(exporter, GenerationsCore.id("mewtwo"));

        RksRecipeJsonBuilder.create(GenerationsItems.WONDER_EGG.get())
                .key(LegendKeys.MANAPHY)
                .pattern("XXX")
                .pattern("ABC")
                .pattern("ZZZ")
                .input('X', GenerationsItems.WATER_GEM.get())
                .input('A', Items.EGG)
                .input('B', GenerationsItems.ORB.get())
                .input('C', Items.HEART_OF_THE_SEA)
                .input('Z', CobblemonItems.MYSTIC_WATER)
                .criterion("heart_of_the_sea", InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEART_OF_THE_SEA))
                .offerTo(exporter, GenerationsCore.id("wonder_egg"));

        RksRecipeJsonBuilder.create(LegendKeys.TYPE_NULL)
                .key(LegendKeys.TYPE_NULL)
                .pattern("DAE")
                .pattern("FBG")
                .pattern("ZCZ")
                .input('A', Items.NETHERITE_CHESTPLATE)
                .input('B', Items.NETHERITE_LEGGINGS)
                .input('C', Items.NETHERITE_BOOTS)
                .input('D', Items.NETHERITE_AXE)
                .input('E', Items.NETHERITE_HELMET)
                .input('F', Items.TOTEM_OF_UNDYING)
                .input('G', GenerationsItems.BUG_MEMORY_DRIVE.get()) //TODO: Replace with memory drive tag
                .input('Z', Items.NETHERITE_BLOCK)
                .criterion("netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
                .offerTo(exporter, GenerationsCore.id("type_null"));

        RksRecipeJsonBuilder.create(GenerationsItems.SOUL_HEART.get())
                .key(LegendKeys.MAGEARNA)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .input('A', GenerationsItems.HEART_SCALE.get())
                .input('B', GenerationsItems.ORB.get())
                .criterion("heart_scale", InventoryChangeTrigger.TriggerInstance.hasItems(GenerationsItems.HEART_SCALE.get()))
                .offerTo(exporter, GenerationsCore.id("soul_heart"));


//        RksRecipeJsonBuilder.create(LegendKeys.MAGEARNA.createProperties(70))
//                .key(LegendKeys.TYPE_NULL)
//                .pattern(" A ")
//                .pattern("CBC")
//                .pattern(" A ")
//                .input('A', Items.NETHERITE_INGOT)
//                .input('B', itemStack)
//                .input('C', Items.IRON_INGOT)
//                .criterion("netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
//                .offerTo(exporter, GenerationsCore.id("type_null"));

        createFossil(GenerationsItems.OLD_AMBER, "aerodactyl", exporter);
        createFossil(GenerationsItems.HELIX_FOSSIL, "omanyte", exporter);
        createFossil(GenerationsItems.DOME_FOSSIL, "kabuto", exporter);
        createFossil(GenerationsItems.ROOT_FOSSIL, "lileep", exporter);
        createFossil(GenerationsItems.CLAW_FOSSIL, "anorith", exporter);
        createFossil(GenerationsItems.SKULL_FOSSIL, "cranidos", exporter);
        createFossil(GenerationsItems.ARMOR_FOSSIL, "shieldon", exporter);
        createFossil(GenerationsItems.COVER_FOSSIL, "tirtouga", exporter);
        createFossil(GenerationsItems.PLUME_FOSSIL, "archen", exporter);
        createFossil(GenerationsItems.JAW_FOSSIL, "tyrunt", exporter);
        createFossil(GenerationsItems.SAIL_FOSSIL, "amaura", exporter);
        createFossil(GenerationsItems.DRAKE_FOSSIL, GenerationsItems.BIRD_FOSSIL, "dracozolt", exporter);
        createFossil(GenerationsItems.DRAKE_FOSSIL, GenerationsItems.FISH_FOSSIL, "dracovish", exporter);
        createFossil(GenerationsItems.DINO_FOSSIL, GenerationsItems.BIRD_FOSSIL, "arctozolt", exporter);
        createFossil(GenerationsItems.DINO_FOSSIL, GenerationsItems.FISH_FOSSIL, "arctovish", exporter);

        createParadoxPast("walkingwake", "suicune", exporter);
        createParadoxPast("greattusk", "donphan", exporter);
        createParadoxPast("screamtail", "jigglypuff", exporter);
        createParadoxPast("brutebonnet", "amoonguss", exporter);
        createParadoxPast("fluttermane", "misdreavus", exporter);
        createParadoxPast("slitherwing", "volcarona", exporter);
        createParadoxPast("sandyshocks", "magneton", exporter);
        createParadoxPast("roaringmoon", "salamence", exporter);
        createParadoxPast("koraidon", "cyclizar", exporter);
        createParadoxPast("gougingfire", "entei", exporter);
        createParadoxPast("ragingbolt", "raikou", exporter);

        createParadoxFuture("ironthreads", "donphan", exporter);
        createParadoxFuture("ironbundle", "delibird", exporter);
        createParadoxFuture("ironhands", "hariyama", exporter);
        createParadoxFuture("ironjugulis", "hydreigon", exporter);
        createParadoxFuture("ironmoth", "volcarona", exporter);
        createParadoxFuture("ironthorns", "tyranitar", exporter);
        createParadoxFuture("ironvaliant", "gallade", exporter);
        createParadoxFuture("miraidon", "cyclizar", exporter);
        createParadoxFuture("ironleaves", "virizion", exporter);
        createParadoxFuture("ironboulder", "terrakion", exporter);
        createParadoxFuture("ironcrown", "cobalion", exporter);
    }

    private void createParadoxPast(String paradoxPokemon, String toBeConverted, Consumer<FinishedRecipe> exporter) {
        createParadox(paradoxPokemon, toBeConverted, exporter, Items.COAL);
    }

    private void createParadoxFuture(String paradoxPokemon, String toBeConverted, Consumer<FinishedRecipe> exporter) {
        createParadox(paradoxPokemon, toBeConverted, exporter, Items.REDSTONE);
    }


    private void createParadox(String name, String toBeConverted, Consumer<FinishedRecipe> exporter, Item item) {
        RksRecipeJsonBuilder.create(name)
                .input('A', new PokemonIngredient(toBeConverted, false))
                .input('B', item)
                .pattern("AB")
                .criterion(BuiltInRegistries.ITEM.getKey(item).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
                .offerTo(exporter, GenerationsCore.id(name));
    }

    private void createFossil(RegistrySupplier<Item> item, String name, Consumer<FinishedRecipe> exporter) {
        RksRecipeJsonBuilder.create(name)
                .pattern("A")
                .input('A', item.get())
                .criterion(item.getId().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                .offerTo(exporter, GenerationsCore.id(name));
    }

    private void createFossil(RegistrySupplier<Item> item, RegistrySupplier<Item> item2, String name, Consumer<FinishedRecipe> exporter) {
        RksRecipeJsonBuilder.create(name)
                .pattern("AB")
                .input('A', item.get())
                .input('B', item2.get())
                .criterion(item.getId().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                .offerTo(exporter, GenerationsCore.id(name));
    }
}
