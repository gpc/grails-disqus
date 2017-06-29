package org.grails.plugins.disqus.disqus

import grails.plugins.Plugin

class DisqusGrailsPlugin extends Plugin {
    def version = "1.0-SNAPSHOT"
    def grailsVersion = "3.2.0 > *"
    def author = "Grails Plugin Collective"
    def authorEmail = "grails.plugin.collective@gmail.com"
    def title = "Disqus Plugin"

    def license = 'APACHE'
    def organization = [name: 'Grails Plugin Collective', url: 'http://github.com/gpc']
    def issueManagement = [system: 'Github Issues', url: 'https://github.com/gpc/grails-disqus/issues']
    def scm = [url: 'https://github.com/gpc/grails-disqus']
    def developers = [
            [name: "Edvinas Bartkus", email: "edvinas@geeks.lt"],
            [name: "Graeme Rocher", email: "grocher@gopivotal.com"],
            [name: "Sudhir Nimavat", email: "sudhir_nimavat@yahoo.com"],
    ]


}
