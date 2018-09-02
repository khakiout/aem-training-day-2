package com.khakiout.training.service.impl;

import com.khakiout.training.service.TrainingService;
import com.khakiout.training.service.config.TrainingServiceConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = TrainingService.class, configurationPolicy=ConfigurationPolicy.OPTIONAL)
@Designate(ocd = TrainingServiceConfiguration.class)
public class TrainingServiceImpl implements TrainingService {

    private final Logger logger = LoggerFactory.getLogger(TrainingServiceImpl.class);

    private TrainingServiceConfiguration configuration;

    @Activate
    public void activate(TrainingServiceConfiguration configuration) {
        logger.info("Activating service.");
        this.configuration = configuration;
    }

    @Override
    public List<String> getData() {
        logger.info("Getting data from configuration.");
        String[] pagesConfig = configuration.getPages();
        if (pagesConfig == null || pagesConfig.length == 0) {
            pagesConfig = new String[1];
            pagesConfig[0] = "Placeholder Page";
        }

        List<String> pages = Arrays.asList(pagesConfig);
        logger.info("Got " + pages.size() + " pages.");

        return pages;
    }
}
