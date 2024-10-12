package com.example.abcall.viewModelTest

import com.example.abcall.albumFakeData.AlbumFakeData
import com.example.abcall.albumFakeData.FakeAlbumRepository
import com.example.abcall.rules.TestDispatcherRule
import com.example.abcall.ui.viewmodel.AlbumUIState
import com.example.abcall.ui.viewmodel.AlbumViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class AlbumViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun getAlbums_verifyUiState_success() =
        runTest {
            val albumViewModel = AlbumViewModel(
                albumRepository = FakeAlbumRepository()
            )
            assertEquals(
                AlbumUIState.Success(AlbumFakeData.albumsData),
                albumViewModel.albumsUiState
            )
        }
}