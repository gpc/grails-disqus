package org.grails.plugins.disqus

import grails.core.GrailsApplication

class DisqusTagLib {
	static namespace = "disqus"
	GrailsApplication grailsApplication


	/**
	 * Sets a variable in the pageContext or the specified scope.
	 * The value can be specified directly or can be a bean retrieved from the applicationContext.
	 *
	 * @attr shortname disqus shortname; if not specified value from the config will be used
	 * @attr identifier disqus page identifier
	 * @attr url disqus page url; if not specified current request url will be used
	 * @attr bean OPTIONAL; if identifier is not specified the id property or hascode of the bean will be used
	 */
	Closure comments = { attrs ->
		def settings = grailsApplication.config.grails.plugins.disqus

		if(!settings.enabled) return

		String shortname = attrs['shortname'] ? attrs['shortname'].toString() : settings.shortname
		String title = attrs['title']
		String category = attrs['category']

		if (!shortname) {
			throwTagError "Disqus can't be used because shortname is not configured."
		}

		def identifier
		if (attrs.identifier) {
			identifier = attrs.identifier
		} else if (settings.identifier instanceof Closure) {
			identifier = settings.identifier(attrs.bean)
		} else if (attrs.bean) {
			def bean = attrs.bean
			def name = bean.class.name
			def id = bean.metaClass.properties.find { it.name == "id" } ? bean.id : bean.hashCode()
			identifier = "${name}#${id}"
		}

		def url
		if (attrs.url) {
			url = attrs.url
		} else if (settings.url instanceof Closure) {
			url = settings.url()
		} else {
			url = request.getRequestURL()
		}

		String noscript = settings.noscript
		boolean powered = settings.powered

		out << render(template: "/templates/disqus/disqus", model: [shortname: shortname, identifier: identifier, url: url, title: title, category: category, noscript: noscript, powered: powered])
	}


}
