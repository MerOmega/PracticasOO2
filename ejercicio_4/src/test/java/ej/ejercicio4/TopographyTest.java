package ej.ejercicio4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TopographyTest {

    @Test
    void testProporcion(){
        Topography waterTopo = new WaterTopography();
        Topography waterTopo1 = new WaterTopography();
        Topography landTopo = new EarthTopography();
        Topography mixedTopo1 = new MixedTopography(Arrays.asList(waterTopo, landTopo));
        Topography mixedTopo2 = new MixedTopography(Arrays.asList(mixedTopo1, waterTopo, waterTopo));

        assertEquals(0.75,mixedTopo2.getProportion());


    }

    @Test
    void testEquals(){
        Topography waterTopo = new WaterTopography();
        Topography waterTopo1 = new WaterTopography();
        Topography landTopo = new EarthTopography();
        Topography mixedTopo1 = new MixedTopography(Arrays.asList(waterTopo, landTopo));
        Topography mixedTopo2 = new MixedTopography(Arrays.asList(mixedTopo1, waterTopo, landTopo));
        Topography mixedTopo3 = new MixedTopography(Arrays.asList(mixedTopo1, landTopo, waterTopo));

        assertTrue(waterTopo.equals(waterTopo1));
        assertFalse(mixedTopo2.equals(mixedTopo3));
    }
}
