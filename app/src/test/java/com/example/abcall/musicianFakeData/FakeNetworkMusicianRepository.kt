package com.example.abcall.musicianFakeData

import com.example.abcall.data.repository.MusicianRepository
import com.example.abcall.data.model.musician.Musician

class FakeNetworkMusicianRepository: MusicianRepository {
    override suspend fun getMusicians(): List<Musician> {
        return MusicianFakeData.musiciansData
    }
}