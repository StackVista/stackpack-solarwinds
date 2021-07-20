def solarwindsSync = component.synced.find { s ->
    Graph.query({
        it
        .V(s.sync)[0]
        .property('name').value().contains("SolarWinds")
    })
}

def url = solarwindsSync.extTopologyElement.data.details_url
if (url) {
    UI.redirectToURL(url)
}
