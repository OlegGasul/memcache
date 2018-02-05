package com.memcache2

import ratpack.handling.Context
import ratpack.handling.InjectionHandler
import static ratpack.jackson.Jackson.json

class SearchHandler extends InjectionHandler {

    void handle(Context ctx, MemcacheService memcacheService) throws Exception {
        ctx.render json(memcacheService.search(ctx.allPathTokens.querystring))
    }

}
