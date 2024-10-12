package com.example.abcall.musicianFakeData

import com.example.abcall.data.model.musician.Musician
import com.example.abcall.data.network.apiServices.MusicianApiService

class FakeMusicianApiService: MusicianApiService {
    override suspend fun getMusicians(): List<Musician> {
        return MusicianFakeData.musiciansData
    }
}