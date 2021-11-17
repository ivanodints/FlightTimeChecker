package ru.checker.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
public class Ticket {

   static SimpleDateFormat formatForDateNow  = new SimpleDateFormat("hh:mm");


    public String origin;
    @SerializedName("origin_name")
    public String originName;
    public String destination;
    @SerializedName("destination_name")
    public String destinationName;
    @SerializedName("departure_date")
    public String departureDate;
    @SerializedName("departure_time")
    public String departureTime;
    @SerializedName("arrival_date")
    public String arrivalDate;
    @SerializedName("arrival_time")
    public String arrivalTime;
    public String carrier;
    public int stops;
    public BigDecimal price;

}
