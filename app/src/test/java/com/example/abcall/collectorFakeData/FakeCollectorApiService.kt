package com.example.abcall.collectorFakeData

import com.example.abcall.data.model.Collector
import com.example.abcall.data.network.apiServices.CollectorApiService

class FakeCollectorApiService: CollectorApiService {
    override suspend fun getCollectors(): List<Collector> {
        return CollectorFakeData.collectorsData
    }
}