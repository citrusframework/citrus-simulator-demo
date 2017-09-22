package com.consol.citrus.simulator.scenarios;

import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.simulator.scenario.*;
import org.springframework.http.HttpStatus;

/**
 * @author Christoph Deppisch
 */
@Scenario("DEFAULT_SCENARIO")
public class DefaultScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner designer) {
        designer.send()
                .message(new HttpMessage("No scenario found for this request")
                        .status(HttpStatus.NOT_FOUND));
    }
}
