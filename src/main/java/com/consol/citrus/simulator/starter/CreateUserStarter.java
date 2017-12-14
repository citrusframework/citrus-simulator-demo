package com.consol.citrus.simulator.starter;

import com.consol.citrus.simulator.exception.SimulatorException;
import com.consol.citrus.simulator.model.ScenarioParameter;
import com.consol.citrus.simulator.model.ScenarioParameterBuilder;
import com.consol.citrus.simulator.scenario.*;
import com.consol.citrus.util.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Christoph Deppisch
 */
@Starter("CREATE_USER_STARTER")
public class CreateUserStarter extends AbstractScenarioStarter {

    private String requestUrl = "http:localhost:8088/services/rest/v1/user";

    @Override
    public void run(ScenarioDesigner scenario) {
        scenario.http()
                .client(requestUrl)
                .send()
                .post()
                .payload("${user}");

        scenario.http()
                .client(requestUrl)
                .receive()
                .response(HttpStatus.OK);
    }

    @Override
    public List<ScenarioParameter> getScenarioParameters() {
        List<ScenarioParameter> scenarioParameter = new ArrayList<>();

        try {
            scenarioParameter.add(new ScenarioParameterBuilder()
                    .name("user")
                    .label("User")
                    .required()
                    .textarea()
                    .value(FileUtils.readToString(new ClassPathResource("templates/random-user.json")))
                    .build());
        } catch (IOException e) {
            throw new SimulatorException("Error reading file resource", e);
        }

        return scenarioParameter;
    }
}
