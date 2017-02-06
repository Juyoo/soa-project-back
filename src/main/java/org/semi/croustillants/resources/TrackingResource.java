package org.semi.croustillants.resources;

import org.semi.croustillants.model.isheep.Shipping;
import org.semi.croustillants.services.delegator.isheep.ISheepTrackingService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by raymo on 06/02/2017.
 */
@RestController
@RequestMapping(value = "/tracking")
public class TrackingResource {

    private final ISheepTrackingService trackingService;

    @Inject
    public TrackingResource(final ISheepTrackingService trackingService) {
        this.trackingService = trackingService;
    }


    @RequestMapping(value = "/{shippingId}", method = GET, produces = APPLICATION_JSON)
    public Shipping.Tracking register(@PathVariable("shippingId") final String shippingId) {
        return trackingService.trackingStatus(shippingId);
    }

}
