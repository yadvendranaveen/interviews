package com.dm.mesh.storagelayer.whiteHat;

import com.dm.mesh.storagelayer.whiteHat.entity.Booking;
import com.dm.mesh.storagelayer.whiteHat.entity.User;
import com.dm.mesh.storagelayer.whiteHat.entity.Vehicle;
import com.dm.mesh.storagelayer.whiteHat.enums.VehicleType;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yadvendranaveen
 * Date: 2021-06-04
 */

@Slf4j
public class MainApplication {
    //    List Available Vehicles - DONE
//Book a Vehicle: - DONE
//Calculate amount to pay
//Return a vehicle - DONE
//List of rented out vehicles - DONE
//Locate a vehicle -DONE
    public static List<Vehicle> vehicleList = new ArrayList<>();
    public static List<Booking> bookingList = new ArrayList<>();

    public static Vehicle vehicle1;

    public static User user1;

    public static void init() {
        vehicle1 = Vehicle.builder().id(1).vehicleType(VehicleType.SEDAN).parkingSpot(1).build();
        Vehicle vehicle2 = Vehicle.builder().id(2).vehicleType(VehicleType.SUV).parkingSpot(2).build();
        Vehicle vehicle3 = Vehicle.builder().id(3).vehicleType(VehicleType.HATCHBACK).parkingSpot(3).build();
        Vehicle vehicle4 = Vehicle.builder().id(4).vehicleType(VehicleType.SUV).parkingSpot(4).build();

        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);
        vehicleList.add(vehicle3);
        vehicleList.add(vehicle4);

        user1 = User.builder().email("abc").build();
        User user2 = User.builder().email("def").build();

        Booking booking1 = Booking.builder().id(1).user(user1).vehicle(vehicle1).start(LocalDate.of(2021, 5, 21)).end(LocalDate.of(2021, 5, 23)).build();
        Booking booking2 = Booking.builder().id(2).user(user2).vehicle(vehicle2).start(LocalDate.of(2021, 6, 21)).end(LocalDate.of(2021, 6, 23)).build();
        bookingList.add(booking1);
        bookingList.add(booking2);
    }

    public static void main(String[] args) {
        init();
        List<Booking> bookings = getVehicleBookings(vehicle1);

        List<Vehicle> available = listAvailableVehicles(LocalDate.of(2021, 5, 22), LocalDate.of(2021, 5, 23), true);
        List<Vehicle> rented = listAvailableVehicles(LocalDate.of(2021, 5, 22), LocalDate.of(2021, 5, 23), false);
        log.info("done");
    }

    // repositories
    public static List<Booking> getVehicleBookings(Vehicle vehicle) {
        return bookingList.stream().filter(k -> vehicle.equals(k.getVehicle())).collect(Collectors.toList());
    }

    public static boolean isVehicleAvailable(Vehicle vehicle, LocalDate start, LocalDate end) {
        boolean isAvailable = true;
        List<Booking> bookingList = getVehicleBookings(vehicle);
        for (Booking booking : bookingList) {
            if (start.isAfter(booking.getStart()) && start.isBefore(booking.getEnd())) {
                isAvailable = false;
            } else if (end.isAfter(booking.getStart()) && end.isBefore(booking.getEnd())) {
                isAvailable = false;
            }
        }
        return isAvailable;
    }

    public static List<Vehicle> listAvailableVehicles(LocalDate start, LocalDate end, boolean isAvailable) {
        return vehicleList.stream().filter(k -> (isVehicleAvailable(k, start, end) == isAvailable)).collect(Collectors.toList());
    }


    public static void bookVehicle(User user, Vehicle vehicle, LocalDate start, LocalDate end) {
        //check if available
        // insert in bookings list
        Booking booking = Booking.builder().user(user).vehicle(vehicle).start(start).end(end).build();
        bookingList.add(booking);
    }

    public static void returnVehicle(Booking booking) {
        booking.setReturned(true);
    }

    public static Integer locateVehicle(Vehicle vehicle) {
        return vehicle.getParkingSpot();
    }
}

