package codersafterdark.reskillable.skill;

import codersafterdark.reskillable.api.skill.Skill;
import net.minecraft.util.ResourceLocation;

import static codersafterdark.reskillable.lib.LibMisc.MOD_ID;

public class SkillAttack extends Skill {

    public SkillAttack() {
        super(new ResourceLocation(MOD_ID, "attack"), new ResourceLocation("textures/blocks/stonebrick.png"));
    }
}
