package com.github.lyllyannyfranca.consultacidadesapi.distances;

import com.github.lyllyannyfranca.consultacidadesapi.distances.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/distancias")
public class DistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/por-milhas")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long firstCity,
                                   @RequestParam(name = "to") final Long secondCity) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(firstCity,secondCity));
    }

    @GetMapping("/por-metros")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long firstCity,
                         @RequestParam(name = "to") final Long secondCity) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(firstCity, secondCity));
    }

}
