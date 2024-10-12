package com.example.abcall.viewModelTest

import com.example.abcall.bandFakeData.BandFakeData
import com.example.abcall.bandFakeData.FakeNetworkBandRepository
import com.example.abcall.rules.TestDispatcherRule
import com.example.abcall.ui.viewmodel.BandUIState
import com.example.abcall.ui.viewmodel.BandViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class BandViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun getBands_verifyUiState_success() =
        runTest {
            val bandViewModel = BandViewModel(
                bandRepository = FakeNetworkBandRepository()
            )
            Assert.assertEquals(
                BandUIState.Success(BandFakeData.bandsData),
                bandViewModel.bandUIState
            )
        }
}