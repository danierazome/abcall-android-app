package com.example.abcall.bandFakeData

import com.example.abcall.data.model.Band
import com.example.abcall.data.network.apiServices.BandApiService

class FakeBandApiService: BandApiService {

    override suspend fun getBands(): List<Band> {
        return BandFakeData.bandsData
    }
}