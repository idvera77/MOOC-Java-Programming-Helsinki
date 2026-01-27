package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private String departureAirport;
    private String destinationAirport;

    public Flight(Airplane airplane, String departureAirport, String destinationAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.destinationAirport + ")";
    }
}