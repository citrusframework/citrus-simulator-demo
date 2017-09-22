package com.consol.citrus.simulator.scenarios;

import com.consol.citrus.simulator.scenario.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Christoph Deppisch
 */
@Scenario("GET_USER")
@RequestMapping(value = "/services/rest/v1/user/{username}", method = RequestMethod.GET)
public class GetUserScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner scenario) {
        scenario.echo("Simulator get user scenario");

        scenario
            .http()
            .receive()
            .get();

        scenario
            .http()
            .send()
            .response(HttpStatus.OK)
            .payload(new ClassPathResource("templates/random-user.json"));
    }
}
