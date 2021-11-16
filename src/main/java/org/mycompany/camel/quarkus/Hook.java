package org.mycompany.camel.quarkus;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.camel.CamelContext;
import org.apache.camel.component.log.LogComponent;
import org.apache.camel.impl.engine.DefaultShutdownStrategy;
import org.apache.camel.impl.event.CamelContextStartedEvent;
import org.apache.camel.quarkus.core.events.ComponentAddEvent;
import org.apache.camel.support.processor.DefaultExchangeFormatter;
import org.apache.camel.support.processor.DefaultExchangeFormatter.OutputStyle;

@Singleton
public class Hook {

    private static final long DEFAULT_GRACEFUL_TIMEOUT_PERIOD = 20;

    @Inject
    CamelContext camelContext;

    public void onComponentAdded(@Observes ComponentAddEvent event) {
        if (event.getComponent() instanceof LogComponent) {
            LogComponent logComponent = (LogComponent) event.getComponent();

            DefaultExchangeFormatter customFormatter = new DefaultExchangeFormatter();
            customFormatter.setShowExchangePattern(false);
            customFormatter.setShowBodyType(false);
            customFormatter.setStyle(OutputStyle.Default);

            logComponent.setExchangeFormatter(customFormatter);
        }
    }

    public void onCamelContextStarted(@Observes CamelContextStartedEvent event) {
        DefaultShutdownStrategy defaultShutdownStrategy = new DefaultShutdownStrategy();
        defaultShutdownStrategy.setTimeout(DEFAULT_GRACEFUL_TIMEOUT_PERIOD);
        camelContext.setShutdownStrategy(defaultShutdownStrategy);
    }
}
