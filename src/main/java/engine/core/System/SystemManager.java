package engine.core.System;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {

    private final List<ISystem> systems;

    public SystemManager() {
        systems = new ArrayList<>();
    }

    public void addSystem(ISystem system) {
        systems.add(system);
    }

    public List<ISystem> getSystems() {
        return systems;
    }

    public void loop() {
        for (ISystem system : systems) {
            system.takeStep();
        }
    }
}
