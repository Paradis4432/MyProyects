package me.paradis.spiderman;

import org.bukkit.inventory.ItemStack;

public class Config {

    public String getString(String s) {
        if(SpiderMan.getInstance().getConfig().getString(s) != null){
            return SpiderMan.getInstance().getConfig().getString(s);
        }else{
            new DebugManager().logError("String in \"" + s + "\" is null");
            return null;
        }
    }

    public Integer getInt(String s) {
        if((SpiderMan.getInstance().getConfig().get(s)) != null){
            return SpiderMan.getInstance().getConfig().getInt(s);
        }else{
            new DebugManager().logError("Integer in \"" + s + "\" is null");
            return null;
        }
    }

    public ItemStack getItemStack(String s) {
        if(SpiderMan.getInstance().getConfig().getItemStack(s) != null){
            return SpiderMan.getInstance().getConfig().getItemStack(s);
        }else{
            new DebugManager().logError("ItemStack in \"" + s + "\" is null");
            return null;
        }
    }

    public Boolean getBoolean(String s) {
        if(SpiderMan.getInstance().getConfig().get(s) != null){
            return SpiderMan.getInstance().getConfig().getBoolean(s);
        }else{
            new DebugManager().logError("Boolean in \"" + s + "\" is null");
            return null;
        }
    }

    public void set(String path, Object value){
        SpiderMan.getInstance().getConfig().set(path, value);
    }
}
