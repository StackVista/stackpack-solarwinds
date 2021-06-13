// Set some sane defaults.

labels = new ArrayList();
layer = "uncategorized"

labels << "solarwinds-instance:{{instanceName}}"

if(!element.data.containsKey("Streams")) {
    element.data.put("Streams", [])
}

if(!element.data.containsKey("Checks")) {
    element.data.put("Checks", [])
}

if(!element.data.containsKey("layer")) {
    element.data.put('layer', layer)
}

if(!element.data.containsKey("domain")) {
    element.data.put('domain', "SolarWinds")
}

if(!element.data.containsKey("environments")) {
    element.data.put("environments", ["Production"])
}

element.data.put('labels', labels)

element
