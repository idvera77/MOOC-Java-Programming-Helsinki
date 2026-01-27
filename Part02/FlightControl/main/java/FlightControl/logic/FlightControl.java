package FlightControl.logic;

import java.util.Collection;
import java.util.HashMap;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addAirplane(String id, int capacity) {
        Airplane plane = new Airplane(id, capacity);
        this.airplanes.put(id, plane);
    }

    public void addFlight(String airplaneId, String departureID, String destinationID) {
        Airplane plane = this.airplanes.get(airplaneId);
        Flight flight = new Flight(plane, departureID, destinationID);
        this.flights.put(flight.toString(), flight);
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Airplane getAirplane(String id) {
        return this.airplanes.get(id);
    }
}