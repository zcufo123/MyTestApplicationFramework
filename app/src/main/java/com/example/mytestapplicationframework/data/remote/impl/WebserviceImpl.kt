package com.example.mytestapplicationframework.data.remote.impl

import com.example.mytestapplicationframework.data.Entity
import com.example.mytestapplicationframework.data.remote.Webservice
import com.google.gson.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.reflect.Type
import javax.inject.Inject

class WebserviceImpl @Inject constructor(val searchService: SearchService) : Webservice {

    interface SearchService {
        @GET("/data/2.5/find")
        fun getEntity(@Query("id") id: String?): Call<Entity?>?
    }

    class EntityDeserializer : JsonDeserializer<Entity> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type,
            context: JsonDeserializationContext
        ): Entity {
            val root = json.asJsonObject
            val id = root.getAsJsonPrimitive("id").asString
            val name = root.getAsJsonPrimitive("name").asString
            return Entity(id, name)
        }
    }

    override fun getEntity(id: String): Entity? {
        val call = searchService.getEntity(id)
        return call?.execute()?.body()
    }
}