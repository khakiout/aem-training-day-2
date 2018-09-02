package com.khakiout.training.service.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
    name = "My Training Service Configuration",
    description = "A Demo Service Configuration for this training."
)
public @interface TrainingServiceConfiguration {

    @AttributeDefinition(name = "Pages", description = "Multi Configuration values for pages.")
    String[] getPages();

    @AttributeDefinition(name = "API Key", description = "A secret API key.", type=AttributeType.PASSWORD)
    String getApiKey();

}
