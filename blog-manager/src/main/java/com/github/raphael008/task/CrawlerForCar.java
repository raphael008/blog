package com.github.raphael008.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CrawlerForCar {

    @Scheduled(cron = "0 0 0/1 * *")
    public void CrawlDefectiveCar() {

    }
}
