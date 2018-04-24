package section;

// TODO: base class -> durch richtige Body Klasse ersetzen

import java.util.ArrayList;
import java.lang.reflect.Method;
import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import logging.LogEngine;

public class Body extends Subscriber {

    // Flight Controls01
    private ArrayList<Object> elevators;
    // Flight Controls02
    private ArrayList<Object> rudders;
    // apu_engine_gear_pump
    private ArrayList<Object> apus;
    private ArrayList<Object> gears;
    private ArrayList<Object> hydraulicPumps;
    // doors
    private ArrayList<Object> bulkCargoDoors;
    private ArrayList<Object> crewDoors;
    private ArrayList<Object> emergencyExitDoors;
    private ArrayList<Object> gearDoors;
    // tank_bottle
    private ArrayList<Object> aPUOilTanks;
    private ArrayList<Object> batteries;
    private ArrayList<Object> nitrogenBottles;
    private ArrayList<Object> oxygenBottles;
    private ArrayList<Object> potableWaterTanks;
    private ArrayList<Object> wasteWaterTanks;
    private ArrayList<Object> fireExtinguishers;
    private ArrayList<Object> deIcingSystems;
    // seats
    private ArrayList<Object> firstClassSeats;
    private ArrayList<Object> businessClassSeats;
    private ArrayList<Object> touristClassSeats;
    private ArrayList<Object> crewSeats;
    // sensor01
    private ArrayList<Object> iceDetectorProbes;
    // sensor02
    private ArrayList<Object> fireDetectors;
    private ArrayList<Object> oxygenSensors;
    private ArrayList<Object> shockSensors;
    private ArrayList<Object> stallingSensors;
    private ArrayList<Object> temperatureSensors;
    // sensor03
    private ArrayList<Object> airflowSensors;
    private ArrayList<Object> pitotTubes;
    private ArrayList<Object> radarAltimeters;
    private ArrayList<Object> tCASs;
    private ArrayList<Object> turbulentAirFlowSensors;
    // sensor04
    private ArrayList<Object> cameraPorts;
    private ArrayList<Object> gpsPorts;
    private ArrayList<Object> radarPorts;
    private ArrayList<Object> satComPorts;
    private ArrayList<Object> vhfPorts;
    // light
    private ArrayList<Object> antiCollisionLights;
    private ArrayList<Object> cargoCompartmentLights;
    private ArrayList<Object> landingLights;
    private ArrayList<Object> logoLights;
    private ArrayList<Object> tailNavigationLights;
    private ArrayList<Object> taxiLights;
    private ArrayList<Object> tCASLights;
    // stowage_cargo
    private ArrayList<Object> cargoSystems;
    private ArrayList<Object> stowageNumberFives;
    // cabin
    private ArrayList<Object> airConditionings;
    private ArrayList<Object> kitchens;
    private ArrayList<Object> lavatories;
    private ArrayList<Object> wasteSystems;
    private ArrayList<Object> waterSystems;
    private ArrayList<Object> escapeSlides;
    // management
    private ArrayList<Object> costOptimizers;
    private ArrayList<Object> routeManagements;
    private ArrayList<Object> seatManagements;

    public Body() {
        build();
    }

    public void build() {
        /*
        // Flight Controls01
        elevators = new ArrayList<>();
        //for (int i = 0; i < 4; i++) elevators.add(ElevatorFactory.build());
        // Factory magic 4 (full = +/- 45 degrees, left -; right +)

        // Flight Controls02
        rudders = new ArrayList<>();
        for (int i = 0; i < 2; i++) rudders.add(RudderFactory.build("","",""));

        // apu_engine_gear_pump
        apus = new ArrayList<>();
        for (int i = 0; i < 1; i++) apus.add(APUFactory.build());
        gears = new ArrayList<>();
        for (int i = 0; i < 3; i++) gears.add(GearFactory.build());
        hydraulicPumps = new ArrayList<>();
        for (int i = 0; i < 6; i++) hydraulicPumps.add(HydraulicPumpFactory.build());

        // doors
        bulkCargoDoors = new ArrayList<>();
        // Factory magic 2
        crewDoors = new ArrayList<>();
        // Factory magic 2
        emergencyExitDoors = new ArrayList<>();
        // Factory magic 14
        gearDoors = new ArrayList<>();
        // Factory magic 6 (2 front, 4 gear)

        // tank_bottle
        aPUOilTanks = new ArrayList<>();
        for (int i = 0; i < 2; i++) aPUOilTanks.add(APUOilTankFactory.build());
        batteries = new ArrayList<>();
        for (int i = 0; i < 24; i++) batteries.add(BatteryFactory.build());
        nitrogenBottles = new ArrayList<>();
        for (int i = 0; i < 6; i++) nitrogenBottles.add(NitrogenBottleFactory.build());
        oxygenBottles = new ArrayList<>();
        for (int i = 0; i < 10; i++) oxygenBottles.add(OxygenBottleFactory.build());
        potableWaterTanks = new ArrayList<>();
        for (int i = 0; i < 8; i++) potableWaterTanks.add(PotableWaterTankFactory.build());
        wasteWaterTanks = new ArrayList<>();
        for (int i = 0; i < 4; i++) wasteWaterTanks.add(WasteWaterTankFactory.build());
        fireExtinguishers = new ArrayList<>();
        for (int i = 0; i < 14; i++) fireExtinguishers.add(FireExtinguisherFactory.build());
        deIcingSystems = new ArrayList<>();
        for (int i = 0; i < 2; i++) deIcingSystems.add(DeIcingSystemFactory.build());

        // seats
        firstClassSeats = new ArrayList<>();
        //for (int i = 0; i < 16; i++) firstClassSeats.add(SeatFactory.buildFirstSeat());
        businessClassSeats = new ArrayList<>();
        //for (int i = 0; i < 72; i++) businessClassSeats.add(SeatFactory.buildBusinessSeat());
        touristClassSeats = new ArrayList<>();
        //for (int i = 0; i < 480; i++) touristClassSeats.add(SeatFactory.buildTouristSeat());
        crewSeats = new ArrayList<>();
        //for (int i = 0; i < 14; i++) crewSeats.add(SeatFactory.buildCrewSeat());

        // sensor01
        iceDetectorProbes = new ArrayList<>();
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        // Factory magic 2

        // sensor02
        fireDetectors = new ArrayList<>();
        // Factory magic 14
        oxygenSensors = new ArrayList<>();
        // Factory magic 8
        shockSensors = new ArrayList<>();
        // Factory magic 2
        stallingSensors = new ArrayList<>();
        // Factory magic 2
        temperatureSensors = new ArrayList<>();
        // Factory magic 2

        // sensor03
        airflowSensors = new ArrayList<>();
        airflowSensors.add(AirflowSensorFactory.build());
        airflowSensors.add(AirflowSensorFactory.build());
        pitotTubes = new ArrayList<>();
        pitotTubes.add(PitotTubeFactory.build());
        pitotTubes.add(PitotTubeFactory.build());
        radarAltimeters = new ArrayList<>();
        radarAltimeters.add(RadarAltimeterFactory.build());
        radarAltimeters.add(RadarAltimeterFactory.build());
        tCASs = new ArrayList<>();
        tCASs.add(TCASFactory.build());
        tCASs.add(TCASFactory.build());
        turbulentAirFlowSensors = new ArrayList<>();
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());

        // sensor04
        // Factory magic 2
        cameraPorts = new ArrayList<>();
        for (int cameraIndex = 0;cameraIndex < 2;cameraIndex++)
            cameraPorts.add(CameraFactory.build());
        // Factory magic 2
        gpsPorts = new ArrayList<>();
        for (int gpsIndex = 0;gpsIndex < 2;gpsIndex++)
            gpsPorts.add(GPSFactory.build());
        // Factory magic 2
        radarPorts = new ArrayList<>();
        for (int radarIndex = 0;radarIndex < 2;radarIndex++)
            radarPorts.add(RadarFactory.build());
        // Factory magic 2
        satComPorts = new ArrayList<>();
        for (int satComIndex = 0;satComIndex < 2;satComIndex++)
            satComPorts.add(SatComFactory.build());
        // Factory magic 2
        vhfPorts = new ArrayList<>();
        for (int vhfIndex = 0;vhfIndex < 2;vhfIndex++)
            vhfPorts.add(VHFFactory.build());

        // light
        antiCollisionLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) antiCollisionLights.add(AntiCollisionLightFactory.build());
        cargoCompartmentLights = new ArrayList<>();
        //for (int i = 0; i < 4; i++) cargoCompartmentLights.add(CargoCompartmentLightFactory.build());
        landingLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) landingLights.add(LandingLightFactory.build());
        logoLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) logoLights.add(LogoLightFactory.build());
        tailNavigationLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) tailNavigationLights.add(TailNavigationLightFactory.build());
        taxiLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) taxiLights.add(TaxiLightFactory.build());
        tCASLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) tCASLights.add(TCASLightFactory.build());

        // stowage_cargo
        cargoSystems = new ArrayList<>();
        // Factory magic 2
        stowageNumberFives = new ArrayList<>();
        // Factory magic 1

        // cabin
        airConditionings = new ArrayList<>();
        for(int i = 0; i < 4; i++) airConditionings.add(AirConditioningFactory.build());
        kitchens = new ArrayList<>();
        kitchens.add(KitchenFactory.build("FIRST"));
        kitchens.add(KitchenFactory.build("BUSINESS"));
        kitchens.add(KitchenFactory.build("ECONOMY"));
        kitchens.add(KitchenFactory.build("ECONOMY"));
        lavatories = new ArrayList<>();
        for(int i = 0; i < 8; i++) lavatories.add(LavatoryFactory.build());
        wasteSystems = new ArrayList<>();
        for(int i = 0; i < 10; i++) wasteSystems.add(WasteSystemFactory.build());
        waterSystems = new ArrayList<>();
        for(int i = 0; i < 4; i++) waterSystems.add(WaterSystemFactory.build());
        escapeSlides = new ArrayList<>();
        for(int i = 0; i < 14; i++) escapeSlides.add(EscapeSlideFactory.build());

        // management
        costOptimizers = new ArrayList<>();
        // Factory magic 2
        routeManagements = new ArrayList<>();
        // Factory magic 2
        seatManagements = new ArrayList<>();
        // Factory magic 1
        */
    }

    public void printStatus() {
        try {
            LogEngine.instance.write("--- Body ---");


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

            //PitotTube
            for (Object port : pitotTubes) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("PitotTubePort :" + port.hashCode() + " - " + version);
            }
            //RadarAltimeter
            for (Object port : radarAltimeters) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("RadarAltimeterPort :" + port.hashCode() + " - " + version);
            }
            //TCAS
            for (Object port : tCASs) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("TCASPort :" + port.hashCode() + " - " + version);
            }

            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Object> getElevators() {
        return elevators;
    }

    public ArrayList<Object> getRudders() {
        return rudders;
    }

    public ArrayList<Object> getApus() {
        return apus;
    }

    public ArrayList<Object> getGears() {
        return gears;
    }

    public ArrayList<Object> getHydraulicPumps() {
        return hydraulicPumps;
    }

    public ArrayList<Object> getBulkCargoDoors() {
        return bulkCargoDoors;
    }

    public ArrayList<Object> getCrewDoors() {
        return crewDoors;
    }

    public ArrayList<Object> getEmergencyExitDoors() {
        return emergencyExitDoors;
    }

    public ArrayList<Object> getGearDoors() {
        return gearDoors;
    }

    public ArrayList<Object> getaPUOilTanks() {
        return aPUOilTanks;
    }

    public ArrayList<Object> getBatteries() {
        return batteries;
    }

    public ArrayList<Object> getNitrogenBottles() {
        return nitrogenBottles;
    }

    public ArrayList<Object> getOxygenBottles() {
        return oxygenBottles;
    }

    public ArrayList<Object> getPotableWaterTanks() {
        return potableWaterTanks;
    }

    public ArrayList<Object> getWasteWaterTanks() {
        return wasteWaterTanks;
    }

    public ArrayList<Object> getFireExtinguishers() {
        return fireExtinguishers;
    }

    public ArrayList<Object> getDeIcingSystems() {
        return deIcingSystems;
    }

    public ArrayList<Object> getFirstClassSeats() {
        return firstClassSeats;
    }

    public ArrayList<Object> getBusinessClassSeats() {
        return businessClassSeats;
    }

    public ArrayList<Object> getTouristClassSeats() {
        return touristClassSeats;
    }

    public ArrayList<Object> getCrewSeats() {
        return crewSeats;
    }

    public ArrayList<Object> getIceDetectorProbes() {
        return iceDetectorProbes;
    }

    public ArrayList<Object> getFireDetectors() {
        return fireDetectors;
    }

    public ArrayList<Object> getOxygenSensors() {
        return oxygenSensors;
    }

    public ArrayList<Object> getShockSensors() {
        return shockSensors;
    }

    public ArrayList<Object> getStallingSensors() {
        return stallingSensors;
    }

    public ArrayList<Object> getTemperatureSensors() {
        return temperatureSensors;
    }

    public ArrayList<Object> getAirflowSensors() {
        return airflowSensors;
    }

    public ArrayList<Object> getPitotTubes() {
        return pitotTubes;
    }

    public ArrayList<Object> getRadarAltimeters() {
        return radarAltimeters;
    }

    public ArrayList<Object> gettCASs() {
        return tCASs;
    }

    public ArrayList<Object> getTurbulentAirFlowSensors() {
        return turbulentAirFlowSensors;
    }

    public ArrayList<Object> getCameras() {
        return cameraPorts;
    }

    public ArrayList<Object> getgPSs() {
        return gpsPorts;
    }

    public ArrayList<Object> getRadars() {
        return radarPorts;
    }

    public ArrayList<Object> getSatComs() {
        return satComPorts;
    }

    public ArrayList<Object> getvHFs() {
        return vhfPorts;
    }

    public ArrayList<Object> getAntiCollisionLights() {
        return antiCollisionLights;
    }

    public ArrayList<Object> getCargoCompartmentLights() {
        return cargoCompartmentLights;
    }

    public ArrayList<Object> getLandingLights() {
        return landingLights;
    }

    public ArrayList<Object> getLogoLights() {
        return logoLights;
    }

    public ArrayList<Object> getTailNavigationLights() {
        return tailNavigationLights;
    }

    public ArrayList<Object> getTaxiLights() {
        return taxiLights;
    }

    public ArrayList<Object> gettCASLights() {
        return tCASLights;
    }

    public ArrayList<Object> getCargoSystems() {
        return cargoSystems;
    }

    public ArrayList<Object> getStowageNumberFives() {
        return stowageNumberFives;
    }

    public ArrayList<Object> getAirConditionings() {
        return airConditionings;
    }

    public ArrayList<Object> getKitchens() {
        return kitchens;
    }

    public ArrayList<Object> getLavatories() {
        return lavatories;
    }

    public ArrayList<Object> getWasteSystems() {
        return wasteSystems;
    }

    public ArrayList<Object> getWaterSystems() {
        return waterSystems;
    }

    public ArrayList<Object> getEscapeSlides() {
        return escapeSlides;
    }

    public ArrayList<Object> getCostOptimizers() {
        return costOptimizers;
    }

    public ArrayList<Object> getRouteManagements() {
        return routeManagements;
    }

    public ArrayList<Object> getSeatManagements() {
        return seatManagements;
    }

}
