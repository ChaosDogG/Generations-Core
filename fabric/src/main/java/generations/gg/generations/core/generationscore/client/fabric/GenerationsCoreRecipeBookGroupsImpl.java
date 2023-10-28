package generations.gg.generations.core.generationscore.client.fabric;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class GenerationsCoreRecipeBookGroupsImpl {
    public static Supplier<RecipeBookCategories> getRecipBookCategories(String name, Supplier<ItemStack> itemStack) {
        return () -> ClassTinkerers.getEnum(RecipeBookCategories.class, name);
    }
}
