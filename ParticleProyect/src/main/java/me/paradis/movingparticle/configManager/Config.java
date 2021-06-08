package me.paradis.movingparticle.configManager;

import me.paradis.movingparticle.MovingParticle;
import me.paradis.movingparticle.debugManager.Debug;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Config {

    public Object get(String s){
        if((MovingParticle.getInstance().getConfig().get(s)) != null){
            return MovingParticle.getInstance().getConfig().get(s);
        } else {
            new Debug().logError("Value in \"" + s + "\" is null");
            return null;
        }
    }

    public void set(String path, Object value){
        try{
            MovingParticle.getInstance().getConfig().set(path, value);
        } catch (Exception e){
            new Debug().logError("Error adding \"" + value + "\" into \"" + path);
        }
    }

    public List getConfigSection(String path, boolean getKeys){
        try{
            Objects.requireNonNull(MovingParticle.getInstance().getConfig().getConfigurationSection(path)).getKeys(getKeys);
        } catch (Exception e){
            new Debug().logError("Error getting configuration section \"\"" + path);
        }
        return null;
    }

    public void save(){
        MovingParticle.getInstance().saveConfig();
    }
}
