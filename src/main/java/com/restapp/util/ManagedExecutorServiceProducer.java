package com.restapp.util;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Produces;

/**
 * Created by tadasyan.
 */
public class ManagedExecutorServiceProducer {

    @Produces
    @Resource(lookup = "java:jboss/ee/concurrency/executor/async")
    private ManagedExecutorService executorService;
}
