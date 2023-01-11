package com.monopoco.arcade.util;

import com.monopoco.arcade.entity.Product;
import com.monopoco.arcade.modal.ProductDTO;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapperUtil {

    public static ProductDTO productMapper(Product product, ModelMapper modelMapper) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setDiscountModeName(product.getDiscountMode().getDiscountMode());
        productDTO.setInventoryStatus(product.getInventory().getType());
        Map<String, String> additionalInfo = new HashMap<>();
        additionalInfo.put(product.getAdditionalInfoTitle1().getTitle(), product.getAdditionalInfoDescription1());
        additionalInfo.put(product.getAdditionalInfoTitle2().getTitle(), product.getAdditionalInfoDescription2());
        additionalInfo.put(product.getAdditionalInfoTitle3().getTitle(), product.getAdditionalInfoDescription3());
        productDTO.setAdditionalInfo(additionalInfo);
        Set<byte[]> images = new HashSet<>();
        product.getImages().forEach(image -> {
            images.add(image.getImageData());
        });
        productDTO.setImageSet(images);
        Set<String> categories = new HashSet<>();
        product.getCategories().forEach(category -> {
            categories.add(category.getCategoryName());
        });

        productDTO.setCategoriesName(categories);
        return productDTO;
    }

}
