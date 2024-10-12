package com.example.abcall.bandFakeData

import com.example.abcall.data.repository.BandRepository
import com.example.abcall.data.model.Band

class FakeNetworkBandRepository: BandRepository {
    override suspend fun getBands(): List<Band> {
        return BandFakeData.bandsData
    }
}