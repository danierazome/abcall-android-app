package com.example.abcall.viewModelTest

import com.example.abcall.collectorFakeData.CollectorFakeData
import com.example.abcall.collectorFakeData.FakeNetworkCollectorRepository
import com.example.abcall.rules.TestDispatcherRule
import com.example.abcall.ui.viewmodel.CollectorUIState
import com.example.abcall.ui.viewmodel.CollectorViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class CollectorViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun getCollectors_verifyUiState_success() =
        runTest {
            val collectorViewModel = CollectorViewModel(
                collectorRepository = FakeNetworkCollectorRepository()
            )
            assertEquals(
                CollectorUIState.Success(CollectorFakeData.collectorsData),
                collectorViewModel.collectorUiState
            )
        }
}