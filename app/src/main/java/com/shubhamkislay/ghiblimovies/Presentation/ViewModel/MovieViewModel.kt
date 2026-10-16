package com.shubhamkislay.ghiblimovies.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import com.shubhamkislay.ghiblimovies.Data.Model.Movies
import com.shubhamkislay.ghiblimovies.Data.Repository.MovieRepo
import com.shubhamkislay.ghiblimovies.Presentation.State.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.shubhamkislay.ghiblimovies.Presentation.Event.Event
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel(
    val movieRepo: MovieRepo
): ViewModel() {


    private val _uiState : MutableStateFlow<UiState<Movies>> = MutableStateFlow(UiState.Idle)
    val uiState: StateFlow<UiState<Movies>> = _uiState.asStateFlow()

    fun parseEvent(event: Event){
        when(event){
            Event.GET_MOVIES -> getMovies()
        }
    }

    fun getMovies(){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val response = movieRepo.getMovies()

            _uiState.value = if(response.isSuccessful){
                UiState.Success(response.body()!!)
            }else{
                UiState.Error(message = "Error getting movies ${response.errorBody().toString()}")
            }
        }
    }







}