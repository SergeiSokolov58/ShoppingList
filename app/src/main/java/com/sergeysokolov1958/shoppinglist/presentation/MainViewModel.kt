package com.sergeysokolov1958.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergeysokolov1958.shoppinglist.data.ShopListRepositoryImpl
import com.sergeysokolov1958.shoppinglist.domain.DeleteShopItemUseCase
import com.sergeysokolov1958.shoppinglist.domain.EditShopItemUseCase
import com.sergeysokolov1958.shoppinglist.domain.GetShopListUseCase
import com.sergeysokolov1958.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }

    fun changedEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)

    }

}
