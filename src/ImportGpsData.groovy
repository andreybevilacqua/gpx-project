def file = new File('../data/fells_loop.gpx')

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

printBasicInfos(gpx)

gpx.rte.rtept.each {
	println it.@lat
	println it.@lon
	println it.time
}

def printBasicInfos(gpx) {
	println gpx.name
	println gpx.desc
	println gpx.@version
	println gpx.@creator
}
