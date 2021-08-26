package io.github.natainakata.clayium;

import io.github.natainakata.clayium.util.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
        modid = Clayium.MOD_ID,
        name = Clayium.MOD_NAME,
        version = Clayium.VERSION
)
@Mod.EventBusSubscriber
public class Clayium {

    public static final String MOD_ID = "clayium";
    public static final String MOD_NAME = "Clayium Community Edition";
    public static final String VERSION = "alpha-1.0.0";

    public static CreativeTabs creativetab = new ClayiumTabs();

    @Mod.Instance(MOD_ID)
    public static Clayium INSTANCE;

    @SidedProxy(clientSide = "io.github.natainakata.clayium.client.ClientProxy", serverSide = "io.github.natainakata.clayium.CommonProxy")
    public static CommonProxy PROXY;


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ItemInit.registerItems(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        PROXY.registerItemRenders();
    }


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.load();
        PROXY.registerEventHandlers();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        PROXY.init();
    }


    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }




}
