#!/bin/bash
rm target/allure-results/*.xml
rm -f target/site/allure-maven-plugin
appium --nodeconfig NexusOneHome.json -p 4725 -U 192.168.99.101:5555 > debugNexusOneHome.log &
appium --nodeconfig NexusTwoHome.json -p 4726 -U 192.168.99.102:5555 > debugNexusTwoHome.log &
