## Prerequisites

To set up the SolarWinds integration you will need to have:

* [StackState Agent V2](/#/stackpacks/stackstate-agent-v2/) installed on a machine that can connect to both SolarWinds (default via TCP port 17778) and StackState.
* A running SolarWinds instance with correctly configured Network Performance Monitor (NPM) and User Device Tracker (UDT) modules. For details see the section **Data Retrieved** > **Topology** in the [SolarWinds StackPack documentation \(docs.stackstate.com\)](https://l.stackstate.com/ui-solarwinds-stackpack-docs).
* A SolarWinds user with access to the required API endpoints.
  - The lowest access level is sufficient.
  - The user must not have any account limitations set that block access to nodes intended to be retrieved.
* A SolarWinds administrator needs to be available to add custom node properties.
* To see relations between components, a layer 3 network device is required.
* To support component actions from StackState, the SolarWinds server needs to be accessible from the StackState user's browser.

For full details of the SolarWinds integration, including the data retrieved and available actions, see the [SolarWinds StackPack documentation \(docs.stackstate.com\)](https://l.stackstate.com/ui-solarwinds-stackpack-docs).
