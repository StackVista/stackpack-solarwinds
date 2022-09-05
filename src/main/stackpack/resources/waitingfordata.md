## The StackState SolarWinds StackPack is waiting for data

To begin collecting data from SolarWinds, add the following configuration to StackState Agent V2:

1. Edit the Agent integration configuration file `/etc/stackstate-agent/conf.d/solarwinds.d/conf.yaml` to include details of your SolarWinds instance and set the required filters:
    * **url** - the REST API URL, uses HTTPS protocol for communication. This should be a hostname or IP, it should not include the prefix `https://`.
    * **user** - a SolarWinds user with access to the required SolarWinds API endpoints.
    * **password** - password for the specified `user`. Use [secrets management](https://l.stackstate.com/ui-stackpack-secrets-management) to store passwords outside of the configuration file.
    * **solarwinds_domain** - The name of a SolarWinds custom property that will be used to select nodes from SolarWinds to include in the StackState dataset.
    * **solarwinds_domain_values** - A list of values used by the SolarWinds custom property specified in `solarwinds_domain`. Used to select the correct nodes for inclusion. Any node in SolarWinds that has one of these values set will be included in the data collection. Each value in this list will be represented as a separate domain in StackState.
    ```text
    init_config:

    instances:
      - url: <instance_name.solarwinds.localdomain>
        username: <instance_username>
        password: <instance_password>
        solarwinds_domain: <instance_domain>  # A SolarWinds custom property
        solarwinds_domain_values:  # A list of values used by the solarwinds_domain
          - <instance_domain_value_1>
          - <instance_domain_value_2>
          - <instance_domain_value_n>
        # min_collection_interval: 30  # use in place of collection_interval for Agent v2.14.x or earlier
        collection_interval: 30
     ```
2. [Restart the StackState Agent\(s\)](https://l.stackstate.com/ui-stackpack-restart-agent) to apply the configuration changes.
3. Once the Agent has restarted, wait for data to be collected from SolarWinds and sent to StackState.

### Troubleshooting

Troubleshooting steps for any known issues can be found in the [StackState support knowledge base](https://l.stackstate.com/ui-solarwinds-support-kb).

TEST

## The StackState SolarWinds StackPack is installed

Congratulations! The StackState SolarWinds StackPack is configured correctly. Data is being received.

### What's next?

Topology from SolarWinds can be found in the following view:

* **SolarWinds - {{configurationConfig.solarwinds_instance_name}}**

### Change the StackState Agent SolarWinds check configuration

Refer to the StackState docs for details on [how to change configuration of the StackState Agent SolarWinds check](https://l.stackstate.com/ui-solarwinds-configure-check) that collects data from SolarWinds.

### Troubleshooting

Troubleshooting steps for any known issues can be found in the [StackState support Knowledge base](https://l.stackstate.com/ui-solarwinds-support-kb).

### Uninstall the SolarWinds StackPack

The SolarWinds StackPack can be uninstalled by clicking the **UNINSTALL** button. This will remove all SolarWinds specific configuration in StackState.