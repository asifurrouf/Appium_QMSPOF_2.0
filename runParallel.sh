#!/bin/bash
appium --nodeconfig NexusOne.json -p 4725 -U 192.168.99.102:5555 > debugNexusOne.log &
appium --nodeconfig NexusTwo.json -p 4726 -U 192.168.99.103:5555 > debugNexusTwo.log &
