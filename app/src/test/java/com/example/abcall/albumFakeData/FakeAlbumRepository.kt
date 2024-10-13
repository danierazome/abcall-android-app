package com.example.abcall.albumFakeData
//
//import com.example.abcall.data.mappers.asUIDetailedModel
//import com.example.abcall.data.mappers.asUIModel
//import com.example.abcall.data.model.album.Album
//import com.example.abcall.data.repository.IAlbumRepository
//import com.example.abcall.data.model.album.DetailedAlbum
//
//class FakeAlbumRepository(): IAlbumRepository {
//    override suspend fun getAlbums(): List<Album> {
//        return AlbumFakeData.albumsNetworkData.map { it.asUIModel() }
//    }
//
//    override suspend fun getDetailedAlbum(id: Int): DetailedAlbum {
//        return AlbumFakeData.albumsNetworkData[0].asUIDetailedModel()
//    }
//}