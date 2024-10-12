package com.example.abcall.networkTest

import com.example.abcall.collectorFakeData.CollectorFakeData
import com.example.abcall.collectorFakeData.FakeCollectorApiService
import com.example.abcall.data.repository.NetworkCollectorRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkCollectorRepositoryTest {

    @Test
    fun networkCollectorRepository_getCollectors() =
        runTest {
            val repository = NetworkCollectorRepository(
                collectorApiService = FakeCollectorApiService()
            )
            assertEquals(CollectorFakeData.collectorsData, repository.getCollectors())
        }
}