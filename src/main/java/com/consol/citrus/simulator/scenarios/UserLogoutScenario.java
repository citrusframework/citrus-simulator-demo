package com.consol.citrus.simulator.scenarios;

import com.consol.citrus.simulator.scenario.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Christoph Deppisch
 */
@Scenario("USER_LOGOUT")
@RequestMapping(value = "/services/rest/v1/user/logout", method = RequestMethod.GET)
public class UserLogoutScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner scenario) {
        scenario.echo("Simulator logout scenario");

        scenario
            .http()
            .receive()
            .get();

        scenario
            .http()
            .send()
            .response(HttpStatus.OK);
    }
}
