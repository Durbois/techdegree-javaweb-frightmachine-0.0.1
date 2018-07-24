package com.teamtreehouse.techdegree.hardware;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import com.example.accessory.Horn;
import com.example.accessory.Strobe;

public class FrightMachineTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    private FrightMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = new FrightMachine();
    }

    @Test
    public void whenMotionIsDetectedExpectedPluginsKickOff() throws Exception {
        Horn horn = new Horn();
        Strobe strobe = new Strobe();
        Camera camera = new Camera();
        camera.setNumberOfPhotos(5);

        machine.addAccessory(horn);
        machine.addAccessory(strobe);
        machine.addAccessory(camera);

        machine.simulateMotion();
        assertThat(systemOutRule.getLog(), allOf(containsString("BEEEEEEEP"),
                                                 containsString("Flashing lights"),
                                                 containsString("Photo #5 taken")));
    }
}