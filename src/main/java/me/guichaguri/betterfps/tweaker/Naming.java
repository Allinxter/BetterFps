package me.guichaguri.betterfps.tweaker;

/**
 * @author Guilherme Chaguri
 */
public class Naming {

    public static final ObfuscationName M_StaticBlock = new ObfuscationName("<clinit>", null, "()V");
    public static final ObfuscationName M_Constructor = new ObfuscationName("<init>", null, "()V");

    public static final ObfuscationName C_Minecraft = new ObfuscationName("net.minecraft.client.Minecraft", "bsu");
    public static final ObfuscationName C_KeyBinding = new ObfuscationName("net.minecraft.client.settings.KeyBinding", "bsr");
    public static final ObfuscationName C_World = new ObfuscationName("net.minecraft.world.World", null); //TODO obfuscated
    public static final ObfuscationName C_EntityPlayer = new ObfuscationName("net.minecraft.entity.player.EntityPlayer", "ahd");
    public static final ObfuscationName C_MathHelper = new ObfuscationName("net.minecraft.util.MathHelper", "uv");
    public static final ObfuscationName C_PrimedTNT = new ObfuscationName("net.minecraft.entity.item.EntityTNTPrimed", null); //TODO obfuscated
    public static final ObfuscationName C_ClientBrandRetriever = new ObfuscationName("net.minecraft.client.ClientBrandRetriever", null);
    public static final ObfuscationName C_GuiOptions = new ObfuscationName("net.minecraft.client.gui.GuiOptions", null); //TODO obfuscated
    public static final ObfuscationName C_WorldClient = new ObfuscationName("net.minecraft.client.multiplayer.WorldClient", null); // TODO obfuscated
    public static final ObfuscationName C_IntegratedServer = new ObfuscationName("net.minecraft.server.integrated.IntegratedServer", null); // TODO obfuscated
    public static final ObfuscationName C_DedicatedServer = new ObfuscationName("net.minecraft.server.dedicated.DedicatedServer", null); // TODO obfuscated

    public static final ObfuscationName M_startGame = new ObfuscationName("startGame", "aj", "()V"); // Minecraft
    public static final ObfuscationName M_onTick = new ObfuscationName("onTick", "a", "(I)V"); // KeyBinding
    public static final ObfuscationName M_sin = new ObfuscationName("sin", "a", "(F)F"); // MathHelper
    public static final ObfuscationName M_cos = new ObfuscationName("cos", "b", "(F)F"); // MathHelper
    public static final ObfuscationName M_tick = new ObfuscationName("tick", null, "()V"); //TODO obfuscated // World
    public static final ObfuscationName M_onUpdate = new ObfuscationName("onUpdate", "s_", "()V"); // Entity
    public static final ObfuscationName M_getClientModName = new ObfuscationName("getClientModName", null, "()Ljava/lang/String;"); // ClientBrandRetriever
    public static final ObfuscationName M_freeMemory = new ObfuscationName("freeMemory", null, "()V"); // TODO obfuscated // Minecraft
    public static final ObfuscationName M_initGui = new ObfuscationName("initGui", null, "()V"); // TODO obfuscated // GuiScreen
    public static final ObfuscationName M_startServer = new ObfuscationName("startServer", null, "()Z"); // TODO obfuscated // MinecraftServer

    public static final ObfuscationName F_memoryReserve = new ObfuscationName("memoryReserve", null, "[B"); // TODO obfuscated // Minecraft

    public static class ObfuscationName {
        private String deob;
        private String deobRepl;
        private String ob;
        private String obRepl;

        // Only used for methods and fields
        private String desc;

        public ObfuscationName(String deob, String ob) {
            this.deob = deob;
            this.deobRepl = deob.replaceAll("\\.", "/");
            if(ob == null) ob = deob;
            this.ob = ob;
            this.obRepl = ob.replaceAll("\\.", "/");
        }

        public ObfuscationName(String deob, String ob, String desc) {
            this(deob, ob);
            this.desc = desc;
        }

        // Used to check names
        public boolean is(String name) {
            if(name.equals(deob)) return true;
            if(name.equals(ob)) return true;
            return false;
        }

        // Used to check class names inside ASM
        public boolean isASM(String name) {
            if(name.equals(deobRepl)) return true;
            if(name.equals(obRepl)) return true;
            return false;
        }

        // Used to check names and desc
        public boolean is(String name, String desc) {
            if((this.desc.equals(desc)) && (is(name))) {
                return true;
            }
            return false;
        }

    }

}
