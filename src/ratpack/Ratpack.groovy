import com.memcache2.KeyValueHandlers
import com.memcache2.MemcacheModule
import com.memcache2.SearchHandler

import static ratpack.groovy.Groovy.ratpack

ratpack {

	bindings {
		module MemcacheModule
	}

	handlers {
		prefix("data/:key") {
			insert KeyValueHandlers
		}
		get "search/:querystring", new SearchHandler()
	}

}