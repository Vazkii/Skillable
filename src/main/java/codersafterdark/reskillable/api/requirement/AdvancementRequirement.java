package codersafterdark.reskillable.api.requirement;

import codersafterdark.reskillable.api.ReskillableAPI;
import codersafterdark.reskillable.api.data.PlayerData;
import codersafterdark.reskillable.api.data.RequirementHolder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Optional;

public class AdvancementRequirement extends Requirement {
    private ResourceLocation advancementName;

    public AdvancementRequirement(ResourceLocation advancementName) {
        this.advancementName = advancementName;
    }

    @Override
    public boolean achievedByPlayer(EntityPlayer entityPlayer) {
        return Optional.ofNullable(this.getAdvancement())
                .map(advancement -> ReskillableAPI.getInstance().getAdvancementProgress(entityPlayer, advancement))
                .map(AdvancementProgress::isDone)
                .orElse(false);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getToolTip(PlayerData data) {
        Advancement adv = getAdvancement();
        String toolTip = "";
        if (adv != null) {
            toolTip = TextFormatting.GRAY + " - " + TextFormatting.GOLD + I18n.format(
                    "skillable.misc.achievementFormat",
                    adv.getDisplayText()
                            .getUnformattedText()
                            .replaceAll("[\\[\\]]", ""));
        }
        return toolTip;
    }

    public Advancement getAdvancement() {
        return RequirementHolder.getAdvancementList().getAdvancement(advancementName);
    }
}
