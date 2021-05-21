package me.paradis.main.locationManager.get;

import me.paradis.main.Main;

public class GetAllLocations {
    /**
     * @return all locations found
     */

    public Integer get() {
        boolean allLocsFound = false;
        int locs = 0;
        while (!allLocsFound) {
            if ((Main.get().getConfig().get("locations." + (locs + 1))) == null) {
                allLocsFound = true;
            } else {
                locs++;
            }
        }
        return locs;
    }
}
