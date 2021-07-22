## The SolarWinds StackPack is waiting for your action, please send some topology to StackState

The StackPack has been installed.

Now, you can push data to this StackPack to check if it works.

### Configure

To enable the SolarWinds check and begin collecting data from SolarWinds, add the following configuration to StackState Agent V2:

1.  Edit the Agent integration configuration file `/etc/stackstate-agent/conf.d/solarwinds.d/conf.yaml` to include details of your SolarWinds instance:
    * **url** - the REST API URL, uses HTTPS protocol for communication.
    * **user** - a SolarWinds user with access to the required SolarWinds API endpoints.
    * **password** - use agent secrets management to store passwords outside the configuration file.

    ```text
    init_config:

    instances:
      - url: <instance_name.solarwinds.localdomain>
        username: <instance_username>
        password: <instance_password>
        solarwinds_domain: <instance_domain>
        solarwinds_domain_values:
          - <instance_domain_value_1>
          - <instance_domain_value_2>
          - <instance_domain_value_n>
        min_collection_interval: 30
     ```
2. Set the following filters:
    - **solarwinds_domain** - The name of a SolarWinds custom property that will be used to select nodes from SolarWinds to include in the StackState dataset.
    - **solarwinds_domain_values** - A list of values used by the specified `solarwinds_domain` to select the correct nodes for inclusion. Any node in SolarWinds that has one of these values set will be included in the data collection. Each value in this list will be represented as a separate domain in StackState.
3. Restart the StackState Agent(s) to apply the configuration changes.
4. Once the Agent has restarted, wait for data to be collected from SolarWinds and sent to StackState.

### Status

To check the status of the SolarWinds integration, run the status subcommand and look for SolarWinds under `Running Checks`:

```text
sudo stackstate-agent status
```