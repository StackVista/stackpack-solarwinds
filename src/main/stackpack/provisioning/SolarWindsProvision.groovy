import groovy.json.JsonSlurper
import com.stackstate.stackpack.ProvisioningScript
import com.stackstate.stackpack.ProvisioningContext
import com.stackstate.stackpack.ProvisioningIO
import com.stackstate.stackpack.Version

class SolarWindsProvision extends ProvisioningScript {
  SolarWindsProvision(ProvisioningContext context) {
    super(context)
  }

  def INTEGRATION_TYPE = "solarwinds"

  @Override
  ProvisioningIO<scala.Unit> install(Map<String, Object> config) {
    def templateArguments = [
      'topicName': topicName(config),
      "instanceId": context().instance().id(),
      'integrationType': INTEGRATION_TYPE,
      'integrationUrl': config.solarwinds_integration_url,
      'instanceName': config.solarwinds_instance_name
    ]
    templateArguments.putAll(config)

    return context().stackPack().importSnapshot("templates/solarwinds.stj", templateArguments) >>
           context().instance().importSnapshot("templates/solarwinds-instance-template.stj", templateArguments)
  }

  @Override
  ProvisioningIO<scala.Unit> upgrade(Map<String, Object> config, Version current) {
    return install(config)
  }

  @Override
  void waitingForData(Map<String, Object> config) {
    context().sts().onDataReceived(topicName(config), {
      context().sts().provisioningComplete()
    })
  }

  private def topicName(Map<String, Object> config) {
    def type = INTEGRATION_TYPE
    def url = config.solarwinds_instance_url
    return context().sts().createTopologyTopicName(type, url)
  }
}
