package section;

// TODO: base class -> durch richtige Wing Klasse ersetzen

import event.Subscriber;
import logging.LogEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class Wing extends Subscriber {
    private int wingIndex;


    // Flight Controls01
    private ArrayList<Object> droopNoses;
    private ArrayList<Object> flaps;
    private ArrayList<Object> slats;
    // Flight Controls02
    private ArrayList<Object> leftAilerons;
    private ArrayList<Object> rightAilerons;
    private ArrayList<Object> spoilers;
    // apu_engine_gear_pump
    private ArrayList<Object> engines;
    private ArrayList<Object> hydraulicPumps;
    // tank_bottle
    private ArrayList<Object> engineOilTanks;
    private ArrayList<Object> fuelTanks;
    private ArrayList<Object> deIcingSystems;
    // sensor01
    private ArrayList<Object> exhaustGasTemperatureSensors;
    private ArrayList<Object> fuelFlowSensors;
    private ArrayList<Object> fuelSensors;
    private ArrayList<Object> iceDetectorProbes;
    // sensor02
    private ArrayList<Object> fireDetectors;
    private ArrayList<Object> shockSensors;
    private ArrayList<Object> stallingSensors;
    private ArrayList<Object> temperatureSensors;
    // sensor03
    private ArrayList<Object> airflowSensors;
    private ArrayList<Object> turbulentAirFlowSensors;
    // sensor04
    private ArrayList<Object> cameraPorts;
    // light
    private ArrayList<Object> landingLights;
    private ArrayList<Object> leftNavigationLights;
    private ArrayList<Object> rightNavigationLights;

    public Wing(int wingIndex) {
        this.wingIndex = wingIndex;

        build();
        printStatus();
    }

    public ArrayList<Object> getDroopNoses()
    {
        return droopNoses;
    }

    public ArrayList<Object> getFlaps()
    {
        return flaps;
    }

    public ArrayList<Object> getSlats()
    {
        return slats;
    }

    public ArrayList<Object> getLeftAilerons()
    {
        return leftAilerons;
    }

    public ArrayList<Object> getRightAilerons()
    {
        return rightAilerons;
    }

    public ArrayList<Object> getSpoilers()
    {
        return spoilers;
    }

    public ArrayList<Object> getEngines()
    {
        return engines;
    }

    public ArrayList<Object> getHydraulicPumps()
    {
        return hydraulicPumps;
    }

    public ArrayList<Object> getEngineOilTanks()
    {
        return engineOilTanks;
    }

    public ArrayList<Object> getFuelTanks()
    {
        return fuelTanks;
    }

    public ArrayList<Object> getDeIcingSystems()
    {
        return deIcingSystems;
    }

    public ArrayList<Object> getExhaustGasTemperatureSensors()
    {
        return exhaustGasTemperatureSensors;
    }

    public ArrayList<Object> getFuelFlowSensors()
    {
        return fuelFlowSensors;
    }

    public ArrayList<Object> getFuelSensors()
    {
        return fuelSensors;
    }

    public ArrayList<Object> getIceDetectorProbes()
    {
        return iceDetectorProbes;
    }

    public ArrayList<Object> getFireDetectors()
    {
        return fireDetectors;
    }

    public ArrayList<Object> getShockSensors()
    {
        return shockSensors;
    }

    public ArrayList<Object> getStallingSensors()
    {
        return stallingSensors;
    }

    public ArrayList<Object> getTemperatureSensors()
    {
        return temperatureSensors;
    }

    public ArrayList<Object> getAirflowSensors()
    {
        return airflowSensors;
    }

    public ArrayList<Object> getTurbulentAirFlowSensors()
    {
        return turbulentAirFlowSensors;
    }

    public ArrayList<Object> getCameras()
    {
        return cameraPorts;
    }

    public ArrayList<Object> getLandingLights()
    {
        return landingLights;
    }

    public ArrayList<Object> getLeftNavigationLights()
    {
        return leftNavigationLights;
    }

    public ArrayList<Object> getRightNavigationLights()
    {
        return rightNavigationLights;
    }


    public void build() {
        /*
        // Flight Controls01
        droopNoses = new ArrayList<>();
        //for (int i = 0; i < 2; i++) droopNoses.add(DroopNoseFactory.build());
        flaps = new ArrayList<>();
        //for (int i = 0; i < 2; i++) flaps.add(FlapFactory.build());
        slats = new ArrayList<>();
        //for (int i = 0; i < 6; i++) slats.add(SlapFactory.build());

        // Flight Controls02
        leftAilerons = new ArrayList<>();
        for (int i = 0; i < 3; i++) leftAilerons.add(LeftAileronFactory.build("", "", ""));
        rightAilerons = new ArrayList<>();
        for (int i = 0; i < 3; i++) rightAilerons.add(RightAileronFactory.build("", "", ""));
        spoilers = new ArrayList<>();
        for (int i = 0; i < 8; i++) spoilers.add(SpoilerFactory.build("", "", ""));

        // apu_engine_gear_pump
        engines = new ArrayList<>();
        for (int i = 0; i < 2; i++) engines.add(EngineFactory.build());
        hydraulicPumps = new ArrayList<>();
        for (int i = 0; i < 4; i++) hydraulicPumps.add(HydraulicPumpFactory.build());

        // tank_bottle
        engineOilTanks = new ArrayList<>();
        for (int i = 0; i < 4; i++) engineOilTanks.add(EngineOilTankFactory.build());
        fuelTanks = new ArrayList<>();
        for (int i = 0; i < 3; i++) fuelTanks.add(FuelTankFactory.build());
        deIcingSystems = new ArrayList<>();
        for (int i = 0; i < 2; i++) deIcingSystems.add(DeIcingSystemFactory.build());

        // sensor01
        exhaustGasTemperatureSensors = new ArrayList<>();
        for (int i = 0; i < 4; i++) exhaustGasTemperatureSensors.add(ExhaustGasTemperatureSensorFactory.build());
        fuelFlowSensors = new ArrayList<>();
        for (int i = 0; i < 6; i++) fuelFlowSensors.add(FuelFlowSensorFactory.build());
        fuelSensors = new ArrayList<>();
        for (int i = 0; i < 6; i++) fuelSensors.add(FuelSensorFactory.build());

        iceDetectorProbes = new ArrayList<>();
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        iceDetectorProbes.add(IceDetectorProbeFactory.build());

        // sensor02
        fireDetectors = new ArrayList<>();
        // Factory magic 4
        shockSensors = new ArrayList<>();
        // Factory magic 2
        stallingSensors = new ArrayList<>();
        // Factory magic 2
        temperatureSensors = new ArrayList<>();
        // Factory magic 4

        // sensor03
        airflowSensors = new ArrayList<>();
        airflowSensors.add(AirflowSensorFactory.build());
        airflowSensors.add(AirflowSensorFactory.build());
        turbulentAirFlowSensors = new ArrayList<>();
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());

        // sensor04
        //Factory magic 1
        cameraPorts = new ArrayList<>();
        cameraPorts.add(CameraFactory.build());

        // light
        landingLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) landingLights.add(LandingLightFactory.build());
        leftNavigationLights = new ArrayList<>();
        //for (int i = 0; i < 1; i++) leftNavigationLights.add(LeftNavigationLightFactory.build());
        // Factory magic 1, LightType = red, Position = port
        rightNavigationLights = new ArrayList<>();
        //for (int i = 0; i < 1; i++) rightNavigationLights.add(RightNavigationLightFactory.build());
        // Factory magic 1, LightType = green, Position = starboard
        */
    }

    public void printStatus() {
        try {
            LogEngine.instance.write(wingIndex == 0 ? "--- left Wing ---" : "--- right Wing ---");

            //Engine
            for (int enginesIndex = 0; enginesIndex < 2; enginesIndex++){
                Method engineVersionMethod = engines.get(enginesIndex).getClass().getDeclaredMethod("version");
                String engineVersion = (String) engineVersionMethod.invoke(engines.get(enginesIndex));
                LogEngine.instance.write("enginePort : " + engines.get(enginesIndex).hashCode() + " - " + engineVersion);
            }

            //Hydraulic Pump
            for (int hydraulicPumpIndex = 0; hydraulicPumpIndex < 4; hydraulicPumpIndex++){
                Method hydraulicPumpVersionMethod = hydraulicPumps.get(hydraulicPumpIndex).getClass().getDeclaredMethod("version");
                String hydraulicPumpVersion = (String) hydraulicPumpVersionMethod.invoke(hydraulicPumps.get(hydraulicPumpIndex));
                LogEngine.instance.write("hydraulicPumpPort : " + hydraulicPumps.get(hydraulicPumpIndex).hashCode() + " - " + hydraulicPumpVersion);
            }

            //AirflowSensor
            for (Object port : airflowSensors) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("AirflowSensorPort :" + port.hashCode() + " - " + version);
            }

            //TurbulentAirFlowSensor
            for (Object port : turbulentAirFlowSensors) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("TurbulentAirflowSensorPort :" + port.hashCode() + " - " + version);
            }

            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
