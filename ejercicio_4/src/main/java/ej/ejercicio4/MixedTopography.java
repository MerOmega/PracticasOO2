package ej.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class MixedTopography extends Topography{

    private List<Topography> topographies;

    public MixedTopography(List<Topography> topographies){
        this.topographies = topographies;
    }

    @Override
    public double getProportion() {
        //Calculate the average of the average,
        //https://www.youtube.com/watch?v=lEz7Ey9FCcA
        double totalProportion = topographies.stream()
                .mapToDouble(t -> t instanceof MixedTopography ?
                        ((MixedTopography) t).getProportion() * ((MixedTopography) t).getNumberOfTopographies() :
                        t.getProportion())
                .sum();
        int totalTopographies = topographies.stream()
                .mapToInt(t -> t instanceof MixedTopography ?
                        ((MixedTopography) t).getNumberOfTopographies() :
                        1)
                .sum();
        return totalProportion / totalTopographies;
    }

    public int getNumberOfTopographies() {
        int totalTopographies = 0;
        for (Topography t : topographies) {
            if (t instanceof MixedTopography) {
                // If the current topography is a MixedTopography, recursively calculate its number of topographies
                totalTopographies += ((MixedTopography) t).getNumberOfTopographies();
            } else {
                // If the current topography is not a MixedTopography, add 1 to the total
                totalTopographies++;
            }
        }
        return totalTopographies;
    }
}

