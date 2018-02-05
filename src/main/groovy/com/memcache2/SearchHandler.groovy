package com.memcache2

import ratpack.handling.Context
import ratpack.handling.InjectionHandler

class SearchHandler extends InjectionHandler {

    void handle(Context ctx, MemcacheService memcacheService) throws Exception {
        ctx.request.body.then {
            ctx.render memcacheService.search(it.inputStream.text)
        }
    }

}
