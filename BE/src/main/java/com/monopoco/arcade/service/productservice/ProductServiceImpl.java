package com.monopoco.arcade.service.productservice;

import com.monopoco.arcade.entity.AdditionalInfoTitle;
import com.monopoco.arcade.entity.Category;
import com.monopoco.arcade.entity.DiscountMode;
import com.monopoco.arcade.entity.Inventory;
import com.monopoco.arcade.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AdditionalInfoTitleRepository additionalInfoTitleRepository;

    @Autowired
    private DiscountModeRepository discountModeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String saveCategory(String categoryName) {
        Category category = new Category(categoryName.toUpperCase(),categoryName, null, null);
        Category categorySaved = categoryRepository.save(category);
        if (categorySaved != null) {
            return categorySaved.getId();
        } else {
            return "Fail to save new category";
        }
    }

    @Override
    public String saveAdditionalInfoTitle(String title) {
        AdditionalInfoTitle additionalInfoTitle = new AdditionalInfoTitle(title.toUpperCase(), title);
        AdditionalInfoTitle additionalInfoTitleSaved = additionalInfoTitleRepository.save(additionalInfoTitle);
        return additionalInfoTitleSaved.getId();
    }

    @Override
    public String saveDiscountMode(String mode) {
        DiscountMode discountMode = new DiscountMode(mode.toUpperCase(), mode, null);
        DiscountMode discountModeSaved = discountModeRepository.save(discountMode);
        return discountModeSaved.getId();
    }

    @Override
    public String saveInventory(String inventory) {
        Inventory inventoryE = new Inventory(inventory.toUpperCase(), inventory, null);
        Inventory inventorySaved = inventoryRepository.save(inventoryE);

        return inventorySaved.getId();
    }
}
