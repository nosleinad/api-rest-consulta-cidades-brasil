package com.github.lyllyannyfranca.consultacidadesapi.distances.service;

import com.github.lyllyannyfranca.consultacidadesapi.cities.City;
import com.github.lyllyannyfranca.consultacidadesapi.cities.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    Logger log = LoggerFactory.getLogger(DistanceService.class);
    private final CityRepository cityRepository;

    public DistanceService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(final Long firstCity, final Long secondCity) {
        log.info("nativePostgresInMiles({}, {})", firstCity, secondCity);
        return cityRepository.distanceByPoints(firstCity, secondCity);
    }

    public Double distanceByCubeInMeters(Long firstCity, Long secondCity) {
        log.info("distanceByCubeInMeters({}, {})", firstCity, secondCity);
        final List<City> cities = cityRepository.findAllById(Arrays.asList(firstCity, secondCity));

        Point firstPoint = cities.get(0).getGeolocation();
        Point secondPoint = cities.get(1).getGeolocation();

        return cityRepository.distanceByCube(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
    }
}
