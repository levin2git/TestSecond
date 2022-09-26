package com.example.testsecond.data

import com.example.testsecond.domain.ShopItem
import com.example.testsecond.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10){
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItemId(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItemId(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id= $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        // copy shopList for can't change List in another place
        return shopList.toList()
    }
}