package ej.ejercicio4;


import java.util.Collections;
import java.util.List;

public class MixedTopography extends Topography{

    private List<Topography> topographies;
    private double totalProportion;
    private int totalTopographies;

    public MixedTopography(List<Topography> topographies) {
        this.topographies = topographies;
        this.totalTopographies = 0;
        this.totalProportion = 0;
        for (Topography t : topographies) {
            if (t instanceof MixedTopography) {
                // If the current topography is a MixedTopography, recursively calculate its number of topographies
                totalTopographies += ((MixedTopography) t).getNumberOfTopographies();
                totalProportion += ((MixedTopography) t).getProportion() * ((MixedTopography) t).getNumberOfTopographies();
            } else {
                // If the current topography is not a MixedTopography, add 1 to the total
                totalTopographies++;
                totalProportion += t.getProportion();
            }
        }
    }

    @Override
    public double getProportion() {
        return totalProportion / totalTopographies;
    }

    public int getNumberOfTopographies() {
        return totalTopographies;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MixedTopography)) {
            return false;
        }

        MixedTopography other = (MixedTopography) obj;

        if (this.topographies.size() != other.topographies.size()) {
            return false;
        }

        for (int i = 0; i < this.topographies.size(); i++) {
            if (!this.topographies.get(i).equals(other.topographies.get(i))) {
                return false;
            }
        }

        return true;
    }
}

