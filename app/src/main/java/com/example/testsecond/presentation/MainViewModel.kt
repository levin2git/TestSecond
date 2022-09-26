package com.example.testsecond.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testsecond.data.ShopListRepositoryImpl
import com.example.testsecond.domain.DeleteShopItemUseCase
import com.example.testsecond.domain.EditShopItemUseCase
import com.example.testsecond.domain.GetShopListUseCase
import com.example.testsecond.domain.ShopItem

class MainViewModel: ViewModel() {
    // change in next time
    private val repository = ShopListRepositoryImpl


    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList(){
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }

}