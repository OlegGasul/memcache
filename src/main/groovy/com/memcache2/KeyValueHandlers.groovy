package com.memcache2

import ratpack.groovy.handling.GroovyChainAction
import javax.inject.Inject

import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND

class KeyValueHandlers extends GroovyChainAction {

    private final MemcacheService memcacheService

    @Inject
    KeyValueHandlers(MemcacheService memcacheService) {
        this.memcacheService = memcacheService
    }

    @Override
    void execute() throws Exception {
        path { ctx ->
            byMethod {
                get {
                    def value = memcacheService.getValue(ctx.allPathTokens.key)
                    if (value) {
                        ctx.render value
                    } else {
                        ctx.clientError(NOT_FOUND.code())
                    }
                }
                post {
                    ctx.request.body.then {
                        memcacheService.setValue(ctx.allPathTokens.key, it.inputStream.text)
                        ctx.render "OK"
                    }
                }
            }
        }
    }
}
