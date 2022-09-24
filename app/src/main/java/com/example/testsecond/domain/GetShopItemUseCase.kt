package com.example.testsecond.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemId (shopItemId: Int ): ShopItem {
        return shopListRepository.getShopItemId(shopItemId)
    }
}