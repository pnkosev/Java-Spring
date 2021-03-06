package pn.app.service.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pn.app.data.models.Offer;
import pn.app.data.repositories.OfferRepository;
import pn.app.service.models.OfferServiceModel;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    private final ModelMapper modelMapper;

    private final Validator validator;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, Validator validator) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public void create(OfferServiceModel offer) {
        if (this.validator.validate(offer).size() != 0) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        this.offerRepository.save(this.modelMapper.map(offer, Offer.class));
    }

    @Override
    public List<OfferServiceModel> getAll() {
        return this.offerRepository.findAll()
                .stream()
                .map(o -> this.modelMapper.map(o, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferServiceModel findOneByApartmentTypeAndApartmentRent(String type, BigDecimal rent) {
        return this.offerRepository.findByApartmentTypeAndApartmentRentLessThan(type, rent)
                .stream()
                .map(o -> this.modelMapper.map(o, OfferServiceModel.class))
                .filter(o -> {
                    BigDecimal totalRent = o.getApartmentRent().multiply(BigDecimal.valueOf(1).add(o.getAgencyCommission().divide(BigDecimal.valueOf(100))));
                    return rent.compareTo(totalRent) >= 0;
                })
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(OfferServiceModel offerServiceModel) {
        this.offerRepository.delete(this.modelMapper.map(offerServiceModel, Offer.class));
    }
}
