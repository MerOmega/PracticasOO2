package ej.ejercicio4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TopographyTest {

    @Test
    void test(){
        Topography waterTopo = new WaterTopography();
        Topography landTopo = new EarthTopography();
        Topography mixedTopo1 = new MixedTopography(Arrays.asList(waterTopo, landTopo));
        Topography mixedTopo2 = new MixedTopography(Arrays.asList(mixedTopo1, waterTopo, waterTopo));


        System.out.println(mixedTopo2.getProportion()); // prints 0.5
    }
}
