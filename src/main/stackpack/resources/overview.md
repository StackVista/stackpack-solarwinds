## Overview

The SolarWinds StackPack allows near real time synchronization between SolarWinds Orion (SolarWinds) and StackState. When the integration is enabled, SolarWinds nodes, interfaces and connections will be added to the StackState topology as components and relations.

* Agent V2 connects to the configured SolarWinds API (default via TCP port 17778).
* Nodes, interfaces and connections are retrieved from the SolarWinds instance.
* Agent V2 pushes retrieved data to StackState.
* StackState translates incoming nodes, interfaces and connections into topology components and relations.

