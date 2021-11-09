package com.example.mytestapplicationframework.data.remote

import com.example.mytestapplicationframework.data.Entity

interface Webservice {
    fun getEntity(id: String): Entity?
}