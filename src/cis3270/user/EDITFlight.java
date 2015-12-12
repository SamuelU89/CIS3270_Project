package cis3270.user;

import java.sql.*;
import cis3270.database.dbModify;

public abstract class EDITFlight implements dbModify {
	
	//Could not find original Flight Package we menioned before
		
		private int idFlight;
		private int idPlane;
		private String flightFrom;
		private String flightTo;
		private int flightDeparture;
		private int flightArrival;
	
		public User() {
			
	}
		
		public User(int idFlight, int idPlane, String flightFrom, String flightTo, int flightDeparture, int flightArrival) {
			
			setIdFlight(idFlight);
			setIdPlane(idPlane);
			setFlightFrom(flightFrom);
			setFlightTo(flightTo);
			setFlightDeparture(flightDeparture);
			serFlightArrival(flightArrival);
			
		}
		
		public void setIdFlight(int idFlight) {
			
			this.idFlight = idFlight;
			
		}
		
		public int getIdFlight() {
			
			return idFlight;
			
		}
		
		public void setIdPlane(int idPlane) {
			
			this.idPlane = idPlane;
			
		}
		
		public int getIdPlane() {
			
			return idPlane;
		}
		
		public void setFlightFrom(String flightFrom) {
			
			this.flightFrom = flightFrom;
		}
		
		public String getFlightFrom() {
			
			return flightFrom;
		}
		
		public void setFlightTo(String flightTo) {
			
			this.flightTo = flightTo;
		}
		
		public String getFlightTo() {
			
			return flightTo;
		}
		
		public void setFlightDeparture(int flightDeparture) {
			
			this.flightDeparture = flightDeparture;
		}
		
		public int getFlightDeparture() {
			
			return flightDeparture;
		}
		
		public void setFlightArrival(int flightArrival) {
			
			this.flightArrival = flightArrival;
		}
		
		public int getFlightArrival() {
			
			return flightArrival;
		}
		
}
