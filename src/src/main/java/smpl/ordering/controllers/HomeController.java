package smpl.ordering.controllers;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import smpl.ordering.MongoDBProperties;
import smpl.ordering.OrderingServiceProperties;
import smpl.ordering.PropertyHelper;
import smpl.ordering.Utility;

import java.util.Properties;

@Controller
@RequestMapping("/")
public class HomeController
{
    @Autowired
    private OrderingServiceProperties orderingServiceProperties;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getStatus() throws Exception
    {
        try
        {
            if (orderingServiceProperties != null)
            {
                String message = "PUMRP API is Running...";

                return new ResponseEntity<>(message, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        catch (Exception exc)
        {
            // Don't cache the client -- it's relying on thread-local storage.
            TelemetryClient client = Utility.getTelemetryClient();
            if (client != null) client.trackException(exc);
            return new ResponseEntity<>(exc.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
