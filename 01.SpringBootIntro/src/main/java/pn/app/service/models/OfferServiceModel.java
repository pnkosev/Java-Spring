package pn.app.service.models;

import java.math.BigDecimal;

public class OfferServiceModel {

    private String id;

    private BigDecimal apartmentRent;

    private String apartmentType;

    private BigDecimal agencyCommission;

    public BigDecimal getApartmentRent() { return apartmentRent; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public void setApartmentRent(BigDecimal apartmentRent) {
        this.apartmentRent = apartmentRent;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public BigDecimal getAgencyCommission() {
        return agencyCommission;
    }

    public void setAgencyCommission(BigDecimal agencyCommission) {
        this.agencyCommission = agencyCommission;
    }
}
