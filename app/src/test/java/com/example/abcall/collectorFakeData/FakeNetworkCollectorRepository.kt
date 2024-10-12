package com.example.abcall.collectorFakeData

import com.example.abcall.data.repository.CollectorRepository
import com.example.abcall.data.model.Collector

class FakeNetworkCollectorRepository: CollectorRepository {
    override suspend fun getCollectors(): List<Collector> {
        return CollectorFakeData.collectorsData
    }
}