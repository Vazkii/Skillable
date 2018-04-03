package codersafterdark.reskillable.api;

import codersafterdark.reskillable.api.data.PlayerData;
import codersafterdark.reskillable.api.requirement.AdvancementRequirement;
import codersafterdark.reskillable.api.requirement.RequirementRegistry;
import codersafterdark.reskillable.api.requirement.TraitRequirement;
import codersafterdark.reskillable.api.skill.SkillConfig;
import codersafterdark.reskillable.api.unlockable.UnlockableConfig;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Level;

import java.util.Objects;

public class ReskillableAPI {
    private static ReskillableAPI instance;
    private IModAccess modAccess;
    private RequirementRegistry requirementRegistry;

    public ReskillableAPI(IModAccess modAccess) {
        this.modAccess = modAccess;
        this.requirementRegistry = new RequirementRegistry();
        requirementRegistry.addRequirementHandler("adv", input -> new AdvancementRequirement(new ResourceLocation(input)));
        requirementRegistry.addRequirementHandler("trait", input -> new TraitRequirement(new ResourceLocation(input)));
    }

    public static ReskillableAPI getInstance() {
        return Objects.requireNonNull(instance, "Calling Reskillable API Instance before it's creation");
    }

    public static void setInstance(ReskillableAPI reskillableAPI) {
        instance = reskillableAPI;
    }

    public SkillConfig getSkillConfig(ResourceLocation name) {
        return modAccess.getSkillConfig(name);
    }

    public UnlockableConfig getTraitConfig(ResourceLocation name, int cost, String[] defaultRequirements) {
        return modAccess.getUnlockableConfig(name, cost, defaultRequirements);
    }

    public void syncPlayerData(EntityPlayer entityPlayer, PlayerData playerData) {
        modAccess.syncPlayerData(entityPlayer, playerData);
    }

    public AdvancementProgress getAdvancementProgress(EntityPlayer entityPlayer, Advancement advancement) {
        return modAccess.getAdvancementProgress(entityPlayer, advancement);
    }

    public RequirementRegistry getRequirementRegistry() {
        return requirementRegistry;
    }

    public void log(Level warn, String s) {
        modAccess.log(warn, s);
    }
}
