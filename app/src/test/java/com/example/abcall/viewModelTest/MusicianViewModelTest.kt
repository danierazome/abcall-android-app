package com.example.abcall.viewModelTest

import com.example.abcall.musicianFakeData.FakeNetworkMusicianRepository
import com.example.abcall.musicianFakeData.MusicianFakeData
import com.example.abcall.rules.TestDispatcherRule
import com.example.abcall.ui.viewmodel.MusicianUIState
import com.example.abcall.ui.viewmodel.MusicianViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class MusicianViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun getMusicians_verifyUiState_success() =
        runTest {
            val musicianViewModel = MusicianViewModel(
                musicianRepository = FakeNetworkMusicianRepository()
            )
            assertEquals(
                MusicianUIState.Success(MusicianFakeData.musiciansData),
                musicianViewModel.musicianUIState
            )
        }
}