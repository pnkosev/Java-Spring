package pn.app.service.models;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OfferServiceModel {

    private String id;

    @NotNull
    @DecimalMin("0.0001")
    private BigDecimal apartmentRent;

    @NotNull
    @NotEmpty
    private String apartmentType;

    @NotNull
    @DecimalMin("0")
    @DecimalMax("100")
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
