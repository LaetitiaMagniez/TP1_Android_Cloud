package com.example.tp1_master2_ccm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_master2_ccm.data.repository.MyPokemonRepository
import com.example.tp1_master2_ccm.ui.model.ItemUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class MyPokemonViewModel : ViewModel() {


    val myPokemonList: Flow<List<ItemUi>> get() = _myPokemonList

    private val myPokemonRepository: MyPokemonRepository by lazy { MyPokemonRepository() }


    private val _myPokemonList : Flow<List<ItemUi>>
        get() = myPokemonRepository.selectAllMyPokemon().map { myPokemonEntities ->
            myPokemonEntities.groupBy { it.typeName }
                .flatMap { item ->
                    buildList {
                        add(ItemUi.Header(item.key))
                        addAll(item.value)
                        add(ItemUi.Footer(
                            total = item.value.size
                        ))
                    }
                }
        }

    fun insertMyPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)
            myPokemonRepository.insertAndroidVersion(
                ItemUi.Item("Pokemon $random", " type $random", "generation $random")
            )

        }
    }


    fun deleteAllMyPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            myPokemonRepository.deleteAllAndroidVersion()
        }
    }


}
