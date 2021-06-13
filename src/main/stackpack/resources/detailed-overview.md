## Pre-requisites

To set up the SolarWinds integration you will need to have:

* StackState Agent V2 installed on a machine that can connect to both SolarWinds (default via TCP port 17778) and StackState.
* A running SolarWinds instance with a Network Performance Monitor (NPM) module.
* A SolarWinds user with access to the required API endpoints.
    - The lowest access level is sufficient.
    - The user must not have any account limitations set that block access to nodes intended to be retrieved.

### REST API endpoints

The SolarWinds user configured in the StackState Agent V2 must have read access to the SolarWinds API (default for all user accounts). No additional authorization needs to be set for this account in the SolarWinds system.

Refer to the SolarWinds product documentation for details on how to [Manage Orion Web Console user accounts in the Orion Platform \(documentation.solarwinds.com\)](https://documentation.solarwinds.com/en/success_center/orionplatform/content/core-managing-web-accounts-sw1724.htm).

### Data retrieved

#### Events

The SolarWinds check does not retrieve any event data.

#### Metrics

The SolarWinds check does not retrieve any metrics data.

#### Topology

The SolarWinds server can contain different modules suitable for data retrieval by the StackState SolarWinds integration.

* **Network Performance Monitor (NPM) module** - provides information about nodes, interfaces and layer-2 topology information for network devices. Layer-2 topology information for non-network devices is only available when the User Device Tracker (UDT) SolarWinds module is installed.

* **User Device Tracker (UDT) module** - provides layer-2 topology information for non-network devices in the form of MAC-address tables from routers, switches and firewalls. This is added to the data retrieved from NPM, resulting in a complete topology for all SolarWinds nodes.

The SolarWinds check retrieves the following topology data from SolarWinds:

| Data | Description |
| :--- | :--- |
| Components | Nodes and interfaces. In some cases, a SolarWinds node will not show any interfaces in the SolarWinds system. If UDT detects that such a node is connected to a device, a 'ghost' interface will be created in StackState to show the full topology.  |
| Relations | **NPM**: Layer-2 topology information from network devices. **UDT**: Layer-2 topology information connecting generic nodes to network devices |

#### Traces

The SolarWinds check does not retrieve any trace data.
