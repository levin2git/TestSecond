package com.example.testsecond.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}