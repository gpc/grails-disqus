import grails.util.Holders

class DisqusGrailsPlugin {
    // the plugin version
    def version = "0.2-SNAPSHOT"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Grails Plugin Collective"
    def authorEmail = "grails.plugin.collective@gmail.com"
    def title = "Disqus Plugin"
    def documentation = "http://grails.org/plugin/disqus"
    def description = '''\\
Embed Disqus system into your application. 
To simplify the usage of Disqus you can use this plugin. Simple add disqus tag into the pages
where you want to allow users to comment stuff.
'''


    def license = 'APACHE'
    def organization = [name: 'Grails Plugin Collective', url: 'http://github.com/gpc']
    def issueManagement = [system: 'Github Issues', url: 'https://github.com/gpc/grails-disqus/issues']
    def scm = [url: 'https://github.com/gpc/grails-disqus']
    def developers = [
            [name: "Edvinas Bartkus", email: "edvinas@geeks.lt"],
            [name: "Graeme Rocher", email: "grocher@gopivotal.com"]            
    ]


    def doWithSpring = {
      GroovyClassLoader classLoader = new GroovyClassLoader(getClass().getClassLoader())
      ConfigObject defaultConfig
      try {
        defaultConfig = new ConfigSlurper().parse(classLoader.loadClass("DefaultDisqusConfig"))
      } catch(Exception e) {
        throw new RuntimeException("Couldn't load the disqus default settings.")
      }
      ConfigObject config = Holders.config.grails.plugins.disqus
      Holders.config.grails.plugins.disqus = defaultConfig.disqus.merge(config)
    }

}
