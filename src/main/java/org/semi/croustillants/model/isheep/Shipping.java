package org.semi.croustillants.model.isheep;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raymo on 05/02/2017.
 */
public class Shipping {

    private Long id;

    private Name recipientName;

    private Address recipientAddress;

    private Parcel parcel;

    private Float price;

    private List<Tracking> trackings = new ArrayList<>();

    public Shipping() {
    }

    public Shipping(final Name recipientName, final Address recipientAddress, final Parcel parcel) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.parcel = parcel;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Name getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(final Name recipientName) {
        this.recipientName = recipientName;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(final Address recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Parcel getParcel() {
        return this.parcel;
    }

    public void setParcel(final Parcel parcel) {
        this.parcel = parcel;
    }

    public Float getPrice() {
        if (price == null) {
            return null;
        }
        return BigDecimal.valueOf(price).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public void setPrice(final Float price) {
        this.price = BigDecimal.valueOf(price).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public List<Tracking> getTrackings() {
        return trackings;
    }

    public void setTrackings(final List<Tracking> trackings) {
        this.trackings = trackings;
    }

    public void addTrackingToList(final Tracking tracking) {
        if (tracking == null) {
            throw new NullPointerException("tracking can't be null");
        }

        trackings.add(tracking);
    }

    public static class Parcel {

        private Long id;

        private Float width;

        private Float height;

        private Float depth;

        private Float weight;

        public Parcel() {
        }

        public Parcel(final Float width, final Float height, final Float depth, final Float weight) {
            this.width = width;
            this.height = height;
            this.depth = depth;
            this.weight = weight;
        }

        public Long getId() {
            return id;
        }

        public void setId(final Long id) {
            this.id = id;
        }

        public Float getWidth() {
            return width;
        }

        public void setWidth(final Float width) {
            this.width = width;
        }

        public Float getHeight() {
            return height;
        }

        public void setHeight(final Float height) {
            this.height = height;
        }

        public Float getDepth() {
            return depth;
        }

        public void setDepth(final Float depth) {
            this.depth = depth;
        }

        public Float getWeight() {
            return weight;
        }

        public void setWeight(final Float weight) {
            this.weight = weight;
        }
    }

    public static class Tracking {

        private Long id;

        private Date eventDate;

        private String event;

        public Tracking() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getEventDate() {
            return eventDate;
        }

        public void setEventDate(Date eventDate) {
            this.eventDate = eventDate;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }
    }

    public static class Name {

        private String firstname;

        private String lastname;

        public Name() {
        }

        public Name(final String firstname, final String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(final String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(final String lastname) {
            this.lastname = lastname;
        }
    }

    public static class Address {

        private String streetNumber;

        private String street;

        private String zip;

        private String city;

        public Address() {

        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(final String streetNumber) {
            this.streetNumber = streetNumber;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(final String street) {
            this.street = street;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(final String zip) {
            this.zip = zip;
        }

        public String getCity() {
            return city;
        }

        public void setCity(final String city) {
            this.city = city;
        }
    }
}

