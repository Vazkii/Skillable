package codersafterdark.reskillable.network;

import codersafterdark.reskillable.lib.LibMisc;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(LibMisc.MOD_ID);
    public static int ID = 0;

    public static void preInit() {
        INSTANCE.registerMessage(MessageDataSync.class, MessageDataSync.class, ID++, Side.CLIENT);
        INSTANCE.registerMessage(MessageDodge.class, MessageDodge.class, ID++, Side.SERVER);
        INSTANCE.registerMessage(MessageLevelUp.class, MessageLevelUp.class, ID++, Side.SERVER);
        INSTANCE.registerMessage(MessageLockedItem.class, MessageLockedItem.class, ID++, Side.CLIENT);
        INSTANCE.registerMessage(MessageUnlockUnlockable.class, MessageUnlockUnlockable.class, ID++, Side.SERVER);
    }
}
