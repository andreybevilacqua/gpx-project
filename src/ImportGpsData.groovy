def file = new File('../data/fells_loop.gpx')

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

printBasicInfos(gpx)

def markupBuilder = new groovy.xml.StreamingMarkupBuilder()
def xml = markupBuilder.bind {
	route {
		mkp.comment(gpx.name)
		gpx.rte.rtept.each { point ->
			routepoint(timestamp: point.time.toString()) { // timestamp is the attribute from routepoint in xml
				latitude(point.@lat)
				longitude(point.@lon)
			}
		}
	}
}

def outFile = new File('../data/fells_loop_truncated.xml')
outFile.write(xml.toString())

def printBasicInfos(gpx) {
	println gpx.name
	println gpx.desc
	println gpx.@version
	println gpx.@creator
}
