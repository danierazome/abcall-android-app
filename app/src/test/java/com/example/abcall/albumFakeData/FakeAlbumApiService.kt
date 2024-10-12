package com.example.abcall.albumFakeData

import com.example.abcall.data.network.apiServices.AlbumApiService
import com.example.abcall.data.network.models.albumNetwork.AlbumNetwork

class FakeAlbumApiService: AlbumApiService {
    override suspend fun getAlbums(): List<AlbumNetwork> {
        return AlbumFakeData.albumsNetworkData
    }

    override suspend fun getDetailedAlbum(id: Int): AlbumNetwork {
        return AlbumFakeData.albumsNetworkData[0]
    }
}