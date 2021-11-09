package com.example.mytestapplicationframework.data

import com.example.mytestapplicationframework.data.local.Dao
import com.example.mytestapplicationframework.data.remote.Webservice
import javax.inject.Inject

class Repository @Inject constructor(
    private val dao: Dao,
    private val webservice: Webservice
) {

    fun getEntity(id: String): Entity {
        var entity: Entity = dao.getEntity(id)
        if (entity == null) {
            entity = webservice.getEntity(id)
        }
        return entity
    }

}